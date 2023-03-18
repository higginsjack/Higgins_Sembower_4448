import java.util.ArrayList;
import java.util.Collections;
// import java.util.concurrent.Flow.Subscriber;
import java.util.List;

// This represents the FNCD business and things they would control
public class FNCD implements Subject {
    ArrayList<Observer> observers;
    ArrayList<Staff> staff;  // folks working
    ArrayList<Staff> departedStaff;   // folks that left
    ArrayList<Vehicle> inventory;   // vehicles at the FNCD
    ArrayList<Vehicle> soldVehicles;   // vehicles the buyers bought
    Salesperson hciSales; //human computer interactive salesperson
    private double budget;   // big money pil
    String name;
    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);        
    }

    @Override
    public void notifyObserver(Observer obs, String msg) {
        if(observers.get(0) == obs){
            observers.get(0).update(msg);
        }
        else{
            observers.get(1).update(msg);
        }
    }

    @Override
    public void unregisterObserver(Observer obs) {
        for(int i = 0; i < observers.size(); i++){
            if(observers.get(i) == obs){
                observers.remove(i);
            }
        }  
    }

    FNCD(String n) {
        name=n;
        staff = new ArrayList<>();
        departedStaff = new ArrayList<>();
        inventory = new ArrayList<>();
        soldVehicles = new ArrayList<>();
        budget = 100000;  // I changed this just to see additions to the budget happen
        observers = new ArrayList<Observer>();
        hciSales=null;
        registerObserver(new Tracker());
    }
    double getBudget() {
        return budget;    // I'm keeping this private to be on the safe side
    }
    void moneyIn(double cash) {  // Nothing special about taking money in yet
        notifyObserver(observers.get(0), "budget"+(cash));
        budget += cash;
    }
    void moneyOut(double cash) {   // I check for budget overruns on every payout
        // notifyObserver(observers.get(0), "budget"+(-cash));
        budget -= cash;
        // notifyObserver(observers.get(0), "b"+250000);
        if (budget<0) {
            budget += 250000;
            notifyObserver(observers.get(0), "budget"+250000);
            notifyObserver(observers.get(1), "***Budget overrun*** Added $250K, budget now: " + Utility.asDollar(budget));
        }
    }

    // Here's where I process daily activities
    // I debated about moving the individual activities out to an Activity class
    // It would make the normal day less of a monster maybe, eh...

    void closedDay(Enums.daysOfTheWeek day) {   // Nothing really special abthis.observer.update closed days
        Logger l = new Logger();
        registerObserver(l);
        notifyObserver(l, "Sorry, FNCD " + this.name +" is closed on "+ day);
        notifyObserver(observers.get(0), "day");
        // notifyObserver(observers.get(0), null);
        // Logger.increaseDay();
        if(Logger.getday() == 30) {
            unregisterObserver(observers.get(0));
        }
        observers.get(0).reportOut("");
        unregisterObserver(l);
    }

    void raceDay(Enums.daysOfTheWeek day) {  
        // Nothing really special about closed days
        Logger l = new Logger();
        registerObserver(l);
        ArrayList<Integer> positions = getRaceCars();
        Collections.shuffle(positions);
        ArrayList<Integer> places = new ArrayList<>();
        for(int n = 1; n < 21; n++) {
            places.add(n);
        }
        Collections.shuffle(places);

        ArrayList<Staff> drivers = Staff.getStaffByType(staff, Enums.StaffType.Driver);
        int iterator = 0;
        String msg = "";
        for (int x = 0; x < drivers.size(); x++) {
            msg="";
            Staff s = drivers.get(x);
            Driver i = (Driver) s;
            Vehicle v = i.race(inventory.get(positions.get(iterator)), places.get(iterator));
            msg+= "Driver " + i.name + " raced.";
            if(places.get(iterator) < 4) {
                moneyOut(2000);
                observers.get(0).update("staff" + 2000);
                msg += " They placed " + places.get(iterator)+ " and won! This is win #" + i.wins + "They received bonus of $2000.00";
                v.wins++;
            }
            else if (places.get(iterator) > 14){
                if(i.getInjured()) {
                    msg += " They placed " + places.get(iterator)+ ". They got injured!";
                }
                else{
                    msg += " They placed " + places.get(iterator)+ ". They were not injured";
                }
            }
            else{
                msg += " They placed " + places.get(iterator)+ ".";
            }
            observers.get(1).update(msg);
            // observers.get(0).update("staff" + b);
            // moneyOut(b); //will take bonus money off of budget
            iterator++;
        }
        notifyObserver(observers.get(0), "day");
        // notifyObserver(observers.get(0), null);
        // Logger.increaseDay();
        if(Logger.getday() == 30) {
            unregisterObserver(observers.get(0));
        }
        observers.get(0).reportOut("");
        unregisterObserver(l);

    }

    // void normalDay(Enums.daysOfTheWeek day) {  // On a normal day, we do all the activities
    void opening(Enums.daysOfTheWeek day) {
        Logger l = new Logger();
        registerObserver(l);
        // opening
        notifyObserver(l, "The FNCD " + this.name +" is opening...");
        hireNewStaff();    // hire up to 3 of each staff type
        updateInventory();  // buy up to 4 of each type
    }
    void washing(Enums.daysOfTheWeek day) {
        // washing - tell the interns to do the washing up
        Logger l= (Logger) observers.get(1);
        notifyObserver(l, "The FNCD " + this.name +" interns are washing...");
        ArrayList<Staff> interns = Staff.getStaffByType(staff, Enums.StaffType.Intern);
        for (Staff s:interns) {
            Intern i = (Intern) s;
            double b = i.washVehicles(inventory, (Logger)observers.get(1));
            observers.get(0).update("staff" + b);
            moneyOut(b); //will take bonus money off of budget
        }
    }

    void repairing(Enums.daysOfTheWeek day) {
        Logger l= (Logger) observers.get(1);
        // repairing - tell the mechanics to do their repairing
        notifyObserver(l, "The FNCD " + this.name +" mechanics are repairing...");
        ArrayList<Staff> mechanics = Staff.getStaffByType(staff, Enums.StaffType.Mechanic);
        for (Staff s:mechanics) {
            Mechanic m = (Mechanic) s;
            double b = m.repairVehicles(inventory, l);
            observers.get(0).update("staff" + b);
            moneyOut(b); //will take bonus money off of budget
        }
    }
    void selling(Enums.daysOfTheWeek day) {
        // selling
        Logger l= (Logger) observers.get(1);
        notifyObserver(observers.get(1), "The FNCD " + this.name +" salespeople are selling...");
        ArrayList<Buyer> buyers = getBuyers(day);
        ArrayList<Staff> salespeople = Staff.getStaffByType(staff, Enums.StaffType.Salesperson);
        // tell a random salesperson to sell each buyer a car - may get bonus
        for(Buyer b: buyers) {
            notifyObserver(observers.get(1), "Buyer "+b.name+" wants a "+b.preference+" ("+b.type+")");
            int randomSeller = Utility.rndFromRange(0,salespeople.size()-1);
            Salesperson seller = (Salesperson) salespeople.get(randomSeller);
            Vehicle vSold = seller.sellVehicle(b, inventory, l);
            // What the FNCD needs to do if a car is sold - change budget and inventory
            if (vSold != null) {
                moneyOut(vSold.sale_bonus);
                observers.get(0).update("staff"+vSold.sale_bonus);
                soldVehicles.add(vSold);
                moneyIn(vSold.price);
                inventory.removeIf ( n -> n.name == vSold.name);
            }
        }
    }
    void ending(Enums.daysOfTheWeek day) {
        // ending
        // pay all the staff their salaries
        Logger l = (Logger) observers.get(1);
        payStaff();
        // anyone quitting? replace with an intern (if not an intern)
        checkForQuitters(l);
        // daily report
        // reportOut();
        notifyObserver(observers.get(0), "day");
        observers.get(0).reportOut("");
        unregisterObserver(observers.get(1));
        // Logger.increaseDay();
        if(Logger.getday() == 30) {
            unregisterObserver(observers.get(0));
        }
    }

    // generate buyers
    ArrayList<Buyer> getBuyers(Enums.daysOfTheWeek day) {
        // 0 to 5 buyers arrive (2-8 on Fri/Sat)
        int buyerMin = 0;  //normal Mon-Thur
        int buyerMax = 5;
        if (day == Enums.daysOfTheWeek.Fri || day == Enums.daysOfTheWeek.Sat) {
            buyerMin = 2;
            buyerMax = 8;
        }
        ArrayList<Buyer> buyers = new ArrayList<Buyer>();
        int buyerCount = Utility.rndFromRange(buyerMin,buyerMax);
        for (int i=1; i<=buyerCount; ++i) buyers.add(new Buyer());
        notifyObserver(observers.get(1), "The FNCD " + this.name +" has "+buyerCount+" buyers today...");
        return buyers;
    }

    // see if we need any new hires
    void hireNewStaff() {
        final int numberInStaff = 3;
        for (Enums.StaffType t : Enums.StaffType.values()) {
            int typeInList = Staff.howManyStaffByType(staff, t);
            int need = numberInStaff - typeInList;
            for (int i = 1; i<=need; ++i) addStaff(t);
        }
    }

    // adding staff
    // smells like we need a factory or something...
    void addStaff(Enums.StaffType t) {
        Staff newStaff = StaffFactory.makeVehicle(t);
        Strategy d = new Detailed();
        notifyObserver(observers.get(1), "Hired a new "+newStaff.type+" named "+ newStaff.name);
        staff.add(newStaff);
    }

    // see if we need any vehicles
    void updateInventory() {
        int n = 0;
        for (Vehicle v: inventory) {
            if (v.type == Enums.VehicleType.Super) n++;
        }
        System.out.println("Vehicles of Super type: " + n);
        final int numberInInventory = 6;
        for (Enums.VehicleType t : Enums.VehicleType.values()) {
            int typeInList = Vehicle.howManyVehiclesByType(inventory, t);
            int need = numberInInventory - typeInList;
            for (int i = 1; i<=need; ++i) addVehicle(t);
        }

    }

    // add a vehicle of a type to the inventory
    void addVehicle(Enums.VehicleType t) {
        Vehicle v = VehicleFactory.makeVehicle(t);
        moneyOut(v.cost);  // pay for the vehicle
        notifyObserver(observers.get(1), "Bought "+v.name+", a "+v.cleanliness+" "+v.condition+" "+v.type+" for "+Utility.asDollar(v.cost));
        inventory.add(v);
    }

    ArrayList<Integer> getRaceCars(){
        ArrayList<Integer> raceCars = new ArrayList<>();
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).condition != Enums.Condition.Broken && inventory.get(i).type != Enums.VehicleType.Electric && inventory.get(i).type != Enums.VehicleType.Car) {
                raceCars.add(i);
            }
        }
        return raceCars;
    }

    // pay salary to staff and update days worked
    void payStaff() {
        for (Staff s: staff) {
            moneyOut(s.salary);  // money comes from the FNCD
            notifyObserver(observers.get(0), "staff"+s.salary);
            s.salaryEarned += s.salary;  // they get paid
            s.daysWorked += 1; // they worked another day
        }
    }

    // Huh - no one wants to quit my FNCD!
    // I left this as an exercise to the reader...
    void checkForQuitters(Logger l) {
        // notifyObserver(observers.get(1), "No-one on the staff is leaving!");
        // I would check the percentages here
        // Move quitters to the departedStaff list
        // If an intern quits, you're good
        // If a mechanic or a salesperson quits
        // Remove an intern from the staff and use their properties to
        // create the new mechanic or salesperson

        // for(Buyer b: buyers) {
        //     notifyObserver(l, "Buyer "+b.name+" wants a "+b.preference+" ("+b.type+")");
        //     int randomSeller = Utility.rndFromRange(0,salespeople.size()-1);
        //     Salesperson seller = (Salesperson) salespeople.get(randomSeller);
        //     Vehicle vSold = seller.sellVehicle(b, inventory, l);
        //     // What the FNCD needs to do if a car is sold - change budget and inventory
        //     if (vSold != null) {
        //         moneyOut(vSold.sale_bonus);
        //         observers.get(0).update("staff"+vSold.sale_bonus);
        //         soldVehicles.add(vSold);
        //         moneyIn(vSold.price);
        //         inventory.removeIf ( n -> n.name == vSold.name);
        //     }
        // }
        int chance = Utility.rndFromRange(1,100);
        ArrayList<Staff> interns = Staff.getStaffByType(staff, Enums.StaffType.Intern);
        ArrayList<Staff> drivers = Staff.getStaffByType(staff, Enums.StaffType.Driver);
        ArrayList<Staff> mechanics = Staff.getStaffByType(staff, Enums.StaffType.Mechanic);
        ArrayList<Staff> salesPeople = Staff.getStaffByType(staff, Enums.StaffType.Salesperson);
        
        // inventory.removeIf ( n -> n.name == vSold.name);

        if(chance < 11) {
            int randomIntern = Utility.rndFromRange(0,interns.size()-1);
            Intern intern = (Intern) interns.get(randomIntern);
            departedStaff.add(intern);
            staff.removeIf ( n -> n.name == intern.name);
            l.update("Intern: " + intern.name + " has left FNCD " + this.name +".");
        }
        chance = Utility.rndFromRange(1,100);
        if(chance < 11) {
            int randomMechanic = Utility.rndFromRange(0,mechanics.size()-1);
            Mechanic mechanic = (Mechanic) mechanics.get(randomMechanic);
            departedStaff.add(mechanic);
            staff.removeIf ( n -> n.name == mechanic.name);

            int randomIntern = Utility.rndFromRange(0,interns.size()-1);
            Intern intern = (Intern) interns.get(randomIntern);
            departedStaff.add(intern);
            Mechanic mech2 = new Mechanic(); // add promtion method
            mech2.promotion(intern);
            staff.removeIf ( n -> n.name == mech2.name);
            staff.add(mech2);
            l.update("Mecahnic: " + mechanic.name + " has left FNCD " + this.name +".");
            l.update("Intern: " + intern.name + " has been promoted to mechanic");
        }
        chance = Utility.rndFromRange(1,100);
        if(chance < 11) {
            int randomSales = Utility.rndFromRange(0,salesPeople.size()-1);
            Salesperson sales = (Salesperson) salesPeople.get(randomSales);
            departedStaff.add(sales);
            staff.removeIf ( n -> n.name == sales.name);

            int randomIntern = Utility.rndFromRange(0,interns.size()-1);
            Intern intern = (Intern) interns.get(randomIntern);
            departedStaff.add(intern);
            Salesperson sales2 = new Salesperson();
            sales2.promotion(intern);
            staff.removeIf ( n -> n.name == sales2.name);
            staff.add(sales2);
            l.update("Salesperson: " + sales.name + " has left FNCD " + this.name +".");
            l.update("Intern: " + intern.name + " has been promoted to mechanic");
        }
        for(int i = 0; i < drivers.size(); i++) {
            Driver driver = (Driver) drivers.get(i);
            if(driver.getInjured()) {
                departedStaff.add(driver);
                staff.removeIf ( n -> n.name == driver.name);
                l.update("Driver: " + driver.name + " has left FNCD " + this.name +".");
            }
        }
    }

    void reportOut() {
        // We're all good here, how are you?
        // Quick little summary of happenings, you could do better

        notifyObserver(observers.get(1), "Vehicles in inventory "+inventory.size());
        notifyObserver(observers.get(1), "Vehicles sold count "+soldVehicles.size());
        notifyObserver(observers.get(1), "Money in the budget "+ Utility.asDollar(getBudget()));
        notifyObserver(observers.get(1), "That's it for the day.");
    }
}
