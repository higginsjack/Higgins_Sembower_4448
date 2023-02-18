import java.util.Random;
import java.util.ArrayList;
public class Activities {
    public static FNCD opening(FNCD fncd) {

        /*
         * Check if there are 3 salespeople, 3 mechanics, 3 interns
         * If not 3 interns hire more interns
         * 
         * Check if there are 4 of each type of vehicle in inventory
         * If not add additional vehicles by buying them and reducing budget
         */
        if(fncd.getDaySales() != 0) {
            fncd.updateDaySales(-fncd.getDaySales());
        }
        boolean checkStaff = false;
        int numInterns = 0; int numMechanics = 0; int  numSalesPeople = 0;

        ArrayList<Staff> s = fncd.getStaff();
        for(int x = 0; x<(fncd.getStaff().size()); x++) {
            if(fncd.getStaff().get(x) instanceof Interns){
                numInterns++;
            }
            else if (fncd.getStaff().get(x) instanceof Mechanics){
                numMechanics++;
            }
            else if (fncd.getStaff().get(x) instanceof SalesPeople){
                numSalesPeople++;
            }
        }
        while(numInterns < 3){
            s.add(new Interns(FNCD.createID(), 1000));
            numInterns++;
        }

        if (numInterns == 3 && numMechanics == 3 && numSalesPeople == 3){
            checkStaff = true;
        }

        //ArrayList<Vehicle> v = fncd.getVehicles();
        int numPickup = 0;
        int numPerformance = 0;
        int numCar = 0;
        boolean inventoryNum = false;
        for(int x = 0; x<(fncd.getVehicles().size()); x++) {
            if(fncd.getVehicles().get(x) instanceof Pickup){
                numPickup++;
            }
            else if(fncd.getVehicles().get(x) instanceof PerformanceCar){
                numPerformance++;
            }
            else if(fncd.getVehicles().get(x) instanceof Car){
                numCar++;
            }
        }

        if (numPickup == 4 && numPerformance == 4 && numCar == 4){
            inventoryNum = true;
        }
        else{
            ArrayList<Vehicle> vs = fncd.getVehicles();
            while(numPickup < 4) {
                Pickup p = new Pickup();
                vs.add(p);
                fncd.updateBudget(-p.getCost());
                numPickup++;
            }
            while(numCar < 4) {
                Car p = new Car();
                vs.add(p);
                fncd.updateBudget(-p.getCost());
                numCar++;
            }
            while(numPerformance < 4) {
                PerformanceCar p = new PerformanceCar();
                vs.add(p);
                fncd.updateBudget(-p.getCost());
                numPerformance++;
            }
            fncd.setVehicles(vs);
        }
        return fncd;
 
    }

    public static FNCD washing(FNCD fncd) {

        /*
         * Interns can wash 2 vehicles a day
         * Start with dirty then move on to clean
         * Washing dirty vehicles has 80% chance of becoming clean, 10% chance of becoming sparkling
         * Washing clean vehicle has a 5% chance of becoming dirty, 30% chance of becoming sparkling
         * If intern makes a vehicle sparkling earn a bonus based on type of vehicle
         */
        //Test
        //print vehicles
        System.out.println("Washing...");
        int vehiclesCleaned = 0;
        boolean success = false;
        for(int x = 0; x<(fncd.getStaff().size()); x++) {
            vehiclesCleaned = 0;
            if(fncd.getStaff().get(x) instanceof Interns){
                int i = 0;
                while(i < fncd.getVehicles().size() && vehiclesCleaned < 2) {
                    success = false;
                    if(fncd.getVehicles().get(i).getCleanliness() == "Dirty") {
                        success = fncd.getVehicles().get(i).increaseCleanliness();
                        vehiclesCleaned++;
                        if(fncd.getVehicles().get(i).getCleanliness() == "Sparkling"){
                            System.out.println("Intern " + fncd.getStaff().get(x).getId() + " made vehicle id " + fncd.getVehicles().get(i).getId() + "sparkling and received bonus of " + fncd.getVehicles().get(i).getWashBonus());
                            fncd.getStaff().get(x).addBonus(fncd.getVehicles().get(i).getWashBonus());
                            fncd.updateBudget(-fncd.getVehicles().get(i).getWashBonus());
                        }
                    }
                    i++;
                }
                int j = 0;
                while(j < fncd.getVehicles().size() && vehiclesCleaned <2) {
                    success = false;
                    if(fncd.getVehicles().get(j).getCleanliness() == "Clean") {
                        success = fncd.getVehicles().get(j).increaseCleanliness();
                        vehiclesCleaned++;
                        if(fncd.getVehicles().get(j).getCleanliness() == "Sparkling") {
                            System.out.println("Intern " + fncd.getStaff().get(x).getId() + " made vehicle id " + fncd.getVehicles().get(j).getId() + "sparkling and received bonus of " + fncd.getVehicles().get(j).getWashBonus());
                            fncd.getStaff().get(x).addBonus(fncd.getVehicles().get(j).getWashBonus());
                            fncd.updateBudget(-fncd.getVehicles().get(j).getWashBonus());
                        }
                    }
                    j++;
                }
            }
        }
        
        return fncd;
    }

    public static FNCD repairing(FNCD fncd) {
        /*
         * Each mechanic can fix two vehicles per day
         * Broken vehicles -> used
         * Used vehicles -> like new
         * Mechanics have 80% chance of fixing vehicle
         * Fixed vehicles go down one class of cleanliness
         * 
         * Broken -> Used = 50% sales price increase
         * Used -> like new = 25% sales price increased
         * 
         * Mechanics receive bonus for each successful repair based on type of vehicle
         */
        System.out.println("Repairing...");
        int vehiclesFixed = 0;
        boolean success = false;
        for(int x = 0; x<(fncd.getStaff().size()); x++) {
            vehiclesFixed = 0;
            if(fncd.getStaff().get(x) instanceof Mechanics){
                int i = 0;
                while(i < fncd.getVehicles().size() && vehiclesFixed < 2) {
                    success = false;
                    if(fncd.getVehicles().get(i).getCondition() == "Broken") {
                        success = fncd.getVehicles().get(i).fix();
                        fncd.getVehicles().get(i).decreaseCleanliness();
                        vehiclesFixed++;
                    }
                    else if(fncd.getVehicles().get(i).getCondition() == "Used") {
                        success = fncd.getVehicles().get(i).fix();
                        fncd.getVehicles().get(i).decreaseCleanliness();
                        vehiclesFixed++;
                    }
                    if(success){
                        System.out.println("Mechanic " + fncd.getStaff().get(x).getId() + " fixed car and received bonus of " + fncd.getVehicles().get(i).getRepairBonus());
                        fncd.getStaff().get(x).addBonus(fncd.getVehicles().get(i).getRepairBonus());
                        fncd.updateBudget(-fncd.getVehicles().get(i).getRepairBonus());
                    }
                    i++;
                }
            }
        }
        return fncd;
    }

    public static FNCD selling(FNCD fncd, String day) {

        /*
         * On week days 0-5 buyers arrive to buy vehicle, on weekends 2-8 buyers arrive
         * Buyers are randomly initialized as 3 types of people
         *      Chances of buying: Just looking (10%), Wants one (40%), Needs one (70%)
         *      Additionally they will randomly want a type of vehicle
         * 
         * Salesperson will try to sell most expensive vehicle of type buyer wants
         *      broken vehicles cannot be sold
         *      Chance of sale increased by 10% if vehicle is like new
         *      Chance of sale increased by 10% if vehicle is sparkling
         *      If no vehicles of buyers choice are available, sales person will
         *      try to sell most expensive vehicle at -20% chance of sale
         * 
         * If buyer buys vehicle they will give the FNCD the sales price, salesperson gets bonus
         * FNCD stores list of sold vehicles
         */
        //  Initialize Buyers with chances
        System.out.println("Selling...");
        Random r = new Random();
        int numBuyers;
        if(day == "Saturday") {
            numBuyers = r.nextInt(7) + 2;
        }
        else{
            numBuyers = r.nextInt(6);
        }
        double[] buyChance = new double[numBuyers];
        String[] typeLooking = new String[numBuyers];

        int[] chances = {10, 40, 70};
        String[] types = {"Pickup", "Car", "Performance Car"};

        for(int i = 0; i < numBuyers; i++) {
            buyChance[i] = chances[r.nextInt(3)];
            typeLooking[i] = types[r.nextInt(3)];
        }

        //  Find salespeople
        int[] salesPersonLocations = new int[3];
        int j = 0;
        int iter = 0;
        while(j < fncd.getStaff().size() && iter < 3) {
            if(fncd.getStaff().get(j) instanceof SalesPeople){
                salesPersonLocations[iter] = j;
            }
            j++;
        }
        //  Selling Vehicles
        double chance;
        int sellVehiclePosition;
        double vehiclePrice;

        for(int z = 0; z < numBuyers; z++) {
            sellVehiclePosition = -1;
            vehiclePrice = 0;
            // fncd.getStaff().get(salesPersonLocation[r.nextInt(3)]); //salesPerson
            //  Find most expensive car pf correct type
            for(int p = 0; p < fncd.getVehicles().size(); p++) {
                if(fncd.getVehicles().get(p).getCost() * 2 > vehiclePrice && fncd.getVehicles().get(p).getType() == typeLooking[z] && fncd.getVehicles().get(p).getCondition() != "Broken"){
                    sellVehiclePosition = p;
                    vehiclePrice = fncd.getVehicles().get(p).getCost();
                }
            }
            if(vehiclePrice == 0) { //  Finds vehicle not of correct type
                for(int p = 0; p < fncd.getVehicles().size(); p++) {
                    if(fncd.getVehicles().get(p).getCost() * 2 > vehiclePrice && fncd.getVehicles().get(p).getCondition() != "Broken"){
                        sellVehiclePosition = p;
                        vehiclePrice = fncd.getVehicles().get(p).getCost();
                    }
                }                        
            }
            // Vehicle is found. Now we compute chance of buying vehicle
            chance = buyChance[z];
            if(fncd.getVehicles().get(sellVehiclePosition).getCondition() == "Like New"){
                chance += 10;
            }
            if(fncd.getVehicles().get(sellVehiclePosition).getCleanliness() == "Sparkling"){
                chance += 10;
            }
            if(fncd.getVehicles().get(sellVehiclePosition).getType() != typeLooking[z]){
                chance -= 20;
            }
            // System.out.println("CHANCE OF PURCHASE: " + chance);
            // Finally we have vehicle, cost, seller
            if(r.nextInt(100) < chance) {
                int salesPersonLocation = r.nextInt(3);
                double b = fncd.getVehicles().get(sellVehiclePosition).getSalesBonus();
                System.out.println("Vehicle purchased! VehicleID: " + fncd.getVehicles().get(sellVehiclePosition).getId() + ". Salesperson ID: " + fncd.getStaff().get(salesPersonLocations[salesPersonLocation]).getId() + " bonus: " + b); //delete

                fncd.getStaff().get(salesPersonLocations[salesPersonLocation]).addBonus(b); //salesPerson
                fncd.sellVehicle(fncd.getVehicles().get(sellVehiclePosition));
                // fncd.updateBudget(fncd.getVehicles().get(sellVehiclePosition).getCost() * 2);
                // ArrayList<Vehicle> vs = fncd.getVehicles();
                // vs.remove(fncd.getVehicles().get(sellVehiclePosition));
                // fncd.setVehicles(vs);
            }
        }
        return fncd;
    }

    public static FNCD ending(FNCD fncd) {
        /*
            * Give all staff members their daily salary pay
            * 10% each staff type might quit
            *      If intern quits just remove them
            *      If mechanic/salesperson quite remove them and promote intern
            *      Remove promoted intern from intern group
            * Produce tabular report of:
            *      Staff members with total days worked, total normal pay, bonus pay, working/quit
            *      Inventory: list of all vehicles with all information
            *      Operating budget, total sales
            */




        int chance = Staff.Raffle();
        ArrayList<Staff> s = fncd.getStaff();

        // paying the staff their daily amount from salary
        for(int i = 0; i < s.size(); i++){
            if (s.get(i) instanceof Interns){ //check to see if they're an intern or not, same for the instances below
                s.get(i).setMoneyMade(s.get(i));
                fncd.updateBudget(s.get(i).getMoneyMade());
            }
            else if (s.get(i) instanceof Mechanics){
                s.get(i).setMoneyMade(s.get(i));
                fncd.updateBudget(s.get(i).getMoneyMade());
            }
            else if (s.get(i) instanceof SalesPeople){
                s.get(i).setMoneyMade(s.get(i));
                fncd.updateBudget(s.get(i).getMoneyMade());
            }
        }

        // for (int x = 0; x < s.size(); x++){
        //     if(fncd.getStaff().get(x) instanceof Interns){
        //         if (chance == 1){
        //             fncd.staffUpdate(fncd.getStaff().get(x));
        //         }
        //     }
        //     else  if(fncd.getStaff().get(x) instanceof Mechanics){
        //         if (chance == 1){
        //             fncd.staffUpdate(fncd.getStaff().get(x));
        //         }
        //     }
        //     else  if(fncd.getStaff().get(x) instanceof SalesPeople){
        //         if (chance == 1){
        //             fncd.staffUpdate(fncd.getStaff().get(x));
        //         }
        //     }
        //     fncd.Fomatter(fncd.getStaff().get(x));
        // }
        System.out.println("Staff");
        System.out.printf("| %15s | %15s | %15s | %15s | %15s | %15s\n", "Id" ,"Salary", "Money Made", "Days Worked", "Bonus Pay", "Working");
        Staff q;
        for(int y = 0; y < fncd.getStaff().size(); y++) {
            q = fncd.getStaff().get(y);
            System.out.printf("| %15s | %15s | %15s | %15s | %15s | %15s\n", q.getId(), q.getSalary(), q.getMoneyMade(), q.getDaysWorked(), q.getBonus(), "Yes");
        }
        for(int y = 0; y < fncd.getDeparted().size(); y++) {
            q = fncd.getStaff().get(y);
            System.out.printf("| %15s | %15s | %15s | %15s | %15s | %15s\n", q.getId(), q.getSalary(), q.getMoneyMade(), q.getDaysWorked(), q.getBonus(), "No");
        }
        
        // Inventory Print
        // System.out.printf("| %-15s | %-8s | %-4s |%-4s | %-4s | %-4s| %n", "Random type", "numRands", "Min", "Max", "Mean", "Stdev");
        Vehicle v;
        System.out.println("Inventory");
        System.out.printf("| %-5s | %-10s | %10s | %15s | %15s | %5s\n", "ID", "Cost", "Sale Price", "Condition", "Cleanliness", "Sold?");
        for(int i = 0; i < fncd.getVehicles().size(); i++) {
            v = fncd.getVehicles().get(i);
            System.out.printf("| %-5s | %-10s | %10s | %15s | %15s | %5s\n",v.getId(), v.getCost(), v.getSalesPrice(), v.getCondition(), v.getCleanliness(), "No");
        }
        for(int i = 0; i < fncd.getSoldVehicles().size(); i++) {
            v = fncd.getVehicles().get(i);
            System.out.printf("| %-5d | %-10s | %10s | %15s | %15s | %5s\n",v.getId(), v.getCost(), v.getSalesPrice(), v.getCondition(), v.getCleanliness(), "Yes");
        }
        System.out.println("Operating budget: " +  fncd.getBudget() + " -|- Total Sales $: " + fncd.getDaySales() + " -|- Bankruptcies: " + fncd.getBankruptcies());
        return fncd;
    }
}
