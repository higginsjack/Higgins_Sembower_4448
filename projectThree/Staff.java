// import javax.lang.model.util.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public abstract class Staff{
    String name;
    ArrayList<Observer> observers;
    double salary;  // daily salary
    double salaryEarned;
    double bonusEarned;
    Enums.StaffType type;
    int daysWorked;
    Staff() {
        salaryEarned = 0;
        bonusEarned = 0;
        daysWorked = 0;
    }

    // utility for getting Staff by Type
    // You could do this with getClass instead of Type, but I use the enum
    // because it's clearer to me - less Java-y
    static ArrayList<Staff> getStaffByType(ArrayList<Staff> staffList, Enums.StaffType t) {
        ArrayList<Staff> subclassInstances = new ArrayList<>();
        for (Staff s : staffList) {
            if (s.type == t) subclassInstances.add(s);
        }
        return subclassInstances;
    }

    //Utility for finding out how many of a Staff type there are
    static int howManyStaffByType(ArrayList<Staff> staffList, Enums.StaffType t) {
        int n = 0;
        for (Staff s: staffList) {
            if (s.type == t) n++;
        }
        return n;
    }
}

class Intern extends Staff {
    static List<String>names = Arrays.asList("Ben", "Lucas", "Lucy", "Jenn", "Joey", "Jack", "Winthrob", "Samantha", "Karen", "Axel", "Margaret", "Charles", "Ben");
    static Namer namer = new Namer(names);
    private Strategy washingStrategy;
    Intern(){
        super();
        type = Enums.StaffType.Intern;
        name = namer.getNext();
        salary = 60;
        int r = Utility.rndFromRange(1,3);
        if(r == 0){
            Detailed d = new Detailed();
            this.washingStrategy = d;
        }
        else if(r==1) {
            Chemical c = new Chemical();
            this.washingStrategy = c;
        }
        else{
            ElbowGrease e = new ElbowGrease();
            this.washingStrategy = e;
        }
    }
    //now get to how they wash cars
    //using the strategy pattern here
    public String printWashingType(){
        return washingStrategy.washingMethod();
    }
    public void setStrategy(Strategy t){
        this.washingStrategy = t;
    }
    public Strategy getStrategy(){
        return this.washingStrategy;
    }
    //use the interface to get print the strategy they were assigned to
    double washVehicles(ArrayList<Vehicle> vList, Logger l){
        int washCount = 0;
        int bonusDay = 0;
        // Enums.Cleanliness startAs;
        for (Vehicle v:vList) {
            //wash the first dirty car I find 
            if (v.cleanliness == Enums.Cleanliness.Dirty){
                l.update(this.washingStrategy.washingMethod());
                if (this.washingStrategy.washingMethod() == "Washing with elbow grease!"){
                    v = this.getStrategy().check(v);
                    if(v.cleanliness == Enums.Cleanliness.Sparkling) {
                        bonusEarned += v.wash_bonus;
                        bonusDay += v.wash_bonus;
                        l.update("Intern "+name+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
                    }
                }
                else if (this.washingStrategy.washingMethod() == "Washing with detailed!"){
                    v = this.getStrategy().check(v);
                    if(v.cleanliness == Enums.Cleanliness.Sparkling) {
                        bonusEarned += v.wash_bonus;
                        bonusDay += v.wash_bonus;
                        l.update("Intern "+name+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
                    }
                }
                else {
                    v = this.getStrategy().check(v);
                    if(v.cleanliness == Enums.Cleanliness.Sparkling) {
                        bonusEarned += v.wash_bonus;
                        bonusDay += v.wash_bonus;
                        l.update("Intern "+name+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
                    }
                }
                washCount+=1;
            }
            if(washCount ==2) {
                break;
            }
        }
        // cleanliness might not get updated - check before after of vehicles
        if (washCount< 2){
            l.update(this.washingStrategy.washingMethod());
            for (Vehicle v:vList) {
                //wash the first clean car:
                if (v.cleanliness == Enums.Cleanliness.Clean){
                    if (this.washingStrategy.washingMethod() == "Washing with elbow grease!"){
                        v = this.getStrategy().check(v);
                        if(v.cleanliness == Enums.Cleanliness.Sparkling) {
                            bonusEarned += v.wash_bonus;
                            bonusDay += v.wash_bonus;
                            l.update("Intern "+name+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
                        }
                    }
                    else if (this.washingStrategy.washingMethod() == "Washing with detailed!"){
                        v = this.getStrategy().check(v);
                        if(v.cleanliness == Enums.Cleanliness.Sparkling) {
                            bonusEarned += v.wash_bonus;
                            bonusDay += v.wash_bonus;
                            l.update("Intern "+name+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
                        }
                        // out(this.washingStrategy.washingMethod());
                    }
                    else {
                        v = this.washingStrategy.check(v);
                        if(v.cleanliness == Enums.Cleanliness.Sparkling) {
                            bonusEarned += v.wash_bonus;
                            bonusDay += v.wash_bonus;
                            l.update("Intern "+name+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
                        }
                        // out(this.washingStrategy.washingMethod());
                    }
                    washCount+=1;
                    }
                if(washCount ==2) {
                    return bonusDay;
                }
            }
        }
        return bonusDay;
    }    
}

class Mechanic extends Staff {
    static List<String> names = Arrays.asList("James", "Scotty", "Spock", "Uhura");
    static Namer namer = new Namer(names);
    Mechanic() {
        super();
        type = Enums.StaffType.Mechanic;
        name = namer.getNext();  // every new mechanic gets a new name
        salary = 120; // daily salary
    }

    // how Mechanics repair Vehicles - not as complicated as the Wash thing above
    // returns bonus to take off of budget
    double repairVehicles(ArrayList<Vehicle> vList, Logger l) {
        int fixCount = 0;
        double bonusDay = 0;
        Enums.Condition startAs;
        // I'm just grabbing the first Vehicle I find - would be easy to randomly pick one
        for (Vehicle v: vList) {
            if (v.condition != Enums.Condition.LikeNew) {
                startAs = v.condition;
                if (v.cleanliness == Enums.Cleanliness.Clean) v.cleanliness = Enums.Cleanliness.Dirty;
                if (v.cleanliness == Enums.Cleanliness.Sparkling) v.cleanliness = Enums.Cleanliness.Clean;
                double chance = Utility.rnd();
                if (chance < .8) {
                    fixCount += 1;
                    if (v.condition == Enums.Condition.Used) {
                        v.condition = Enums.Condition.LikeNew;
                        v.price = v.price * 1.25;  // 25% increase for Used to Like New
                    }
                    if (v.condition == Enums.Condition.Broken) {
                        v.condition = Enums.Condition.Used;
                        v.price = v.price * 1.5;  // 50% increase for Broken to Used
                    }
                    bonusEarned += v.repair_bonus;
                    bonusDay += v.repair_bonus;
                    l.update("Mechanic "+name+" got a bonus of "+Utility.asDollar(v.repair_bonus)+"!");
                    l.update("Mechanic "+name+" fixed "+v.name+" "+startAs+" to "+v.condition);
                }
                else {
                    fixCount += 1;   // I'm saying a failed repair still took up a fix attempt
                    l.update("Mechanic "+name+" did not fix the "+v.condition+" "+v.name);
                }
            }
            if (fixCount==2) break;
        }
        return bonusDay;
    }
}


class Driver extends Staff {
    static List<String> names = Arrays.asList("Brock", "Jamar", "Larisa", "Johnny", "Bella", "Olivia", "Greg", "Justin");
    static Namer namer = new Namer(names);
    // private Boolean injured = false;
    Driver(){
        super();
        type = Enums.StaffType.Driver;
        name = namer.getNext();
        salary = 130;
    }
    //add driving actibity (race day)
}

class Salesperson extends Staff {
    static List<String> names = Arrays.asList("Rachel","Monica","Phoebe","Chandler","Ross","Joey");
    static Namer namer = new Namer(names);
    Salesperson() {
        super();
        type = Enums.StaffType.Salesperson;
        name = namer.getNext();  // every new salesperson gets a new name
        salary = 90; // daily salary
    }

    // Someone is asking this Salesperson to sell to this Buyer
    // We'll return any car we sell for the FNCD to keep track of (null if no sale)
    Vehicle sellVehicle(Buyer b, ArrayList<Vehicle> vList, Logger l) {
        // buyer type determines initial purchase chance
        double saleChance = .7; // needs one
        if (b.type == Enums.BuyerType.WantsOne) saleChance = .4;
        if (b.type == Enums.BuyerType.JustLooking) saleChance = .1;
        // find the most expensive vehicle of the type the buyer wants that isn't broken
        // sales chance +10% if Like New, + 10% if Sparkling
        // if no vehicles of type, find remaining most expensive vehicle and sell at -20%
        ArrayList<Vehicle> desiredList = Vehicle.getVehiclesByType(vList, b.preference);
        Vehicle v;
        v = getMostExpensiveNotBroken(desiredList);  // could be null
        if (v == null) {
            // no unbroken cars of preferred type
            saleChance -= .2;
            v = getMostExpensiveNotBroken(vList);  // could still be null
        }
        if (v == null) {
            l.update("Salesperson "+name+" has no car for buyer "+b.name);
            return null;
        }
        else { //sell this car!
            if (v.condition == Enums.Condition.LikeNew) saleChance += .1;
            if (v.cleanliness == Enums.Cleanliness.Sparkling) saleChance += .1;
            double chance = Utility.rnd();
            if (chance<=saleChance) {  // sold!
                bonusEarned += v.sale_bonus;
                String msg = "Buyer "+b.name+" bought "+v.cleanliness+" "+v.condition+" "+v.name;
                //add addons
                l.update("Buyer "+b.name+" is buying! Salesperson "+name+" gets a bonus of "+Utility.asDollar(v.sale_bonus)+"!");
                l.update("ORIGINAL PRICE: " + v.getSalesPrice());//DELETE
                int addonChance = Utility.rndFromRange(1, 100);
                if(addonChance < 21) {
                    msg += " With addon Extended Warranty.";
                    // l.update("Buyer "+b.name+" decided to add Extended Warranty, Old Price: " + v.getSalesPrice());
                    v = new ExtendedWarranty(v);
                    // l.update("New Price: " + v.getSalesPrice());
                }
                addonChance = Utility.rndFromRange(1, 100);
                if(addonChance < 11) {
                    msg += " With addon Undercoating.";
                    v = new Undercoating(v);
                }
                addonChance = Utility.rndFromRange(1, 100);
                if(addonChance < 6) {
                    msg += " With addon Road Rescue Coverage.";
                    v = new RoadRescueCoverage(v);
                }
                addonChance = Utility.rndFromRange(1, 100);
                if(addonChance < 41) {
                    msg += " With addon Satellite Radio.";
                    v = new SatelliteRadio(v);
                }
                l.update(msg + " Price: "+Utility.asDollar(v.getSalesPrice()));
                return v;
            }
            else {  // no sale!
                l.update("Buyer "+b.name+" decided not to buy.");
                return null;
            }
        }
    }

    // Little helper for finding most expensive and not broken in a list of vehicles
    // Used twice by salespeople
    Vehicle getMostExpensiveNotBroken(ArrayList<Vehicle> vList) {
        double highPrice = 0;
        int selected = -1;
        for (int index=0;index<vList.size();++index) {
            Vehicle v = vList.get(index);
            if (v.price>highPrice) {
                if (v.condition != Enums.Condition.Broken) {
                    selected = index;
                    highPrice = v.price;
                }
            }
        }
        if (selected == -1) return null;
        else return vList.get(selected);
    }
}
