import java.util.Random;
public class Activities {
    public static FNCD opening(FNCD fncd) {

        /*
         * Check if there are 3 salespeople, 3 mechanics, 3 interns
         * If not 3 interns hire more interns
         * 
         * Check if there are 4 of each type of vehicle in inventory
         * If not add additional vehicles by buying them and reducing budget
         */

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
                    }
                    i++;
                }
                int j = 0;
                while(j < fncd.getVehicles().size() && vehiclesCleaned <2) {
                    success = false;
                    if(fncd.getVehicles().get(i).getCleanliness() == "Clean") {
                        fncd.getVehicles().get(i).increaseCleanliness();
                        vehiclesCleaned++;
                        if(success){
                            fncd.getStaff().get(x).addBonus(fncd.getVehicles().get(j).getWashBonus());
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
                        fncd.getStaff().get(x).addBonus(fncd.getVehicles().get(i).getRepairBonus());
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
        Random r = new Random();
        int numBuyers;
        if(day == "Saturday") {
            numBuyers = r.nextInt(6) + 2;
        }
        else{
            numBuyers = r.nextInt(5);
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
            // Finally we have vehicle, cost, seller
            if(r.nextInt(100) < chance) {
                double b = fncd.getVehicles().get(sellVehiclePosition).getSalesBonus();
                fncd.getStaff().get(salesPersonLocations[r.nextInt(3)]).addBonus(b); //salesPerson
                fncd.updateBudget(fncd.getVehicles().get(sellVehiclePosition).getCost() * 2);
                // fncd.setVehicles(fncd.getVehicles().remove(fncd.getVehicles().get(sellVehiclePosition)));
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

        return fncd;
    }
}
