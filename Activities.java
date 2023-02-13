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
         * If intern makes a vehicle sparkiling earn a bonus based on type of vehicle
         */
        
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
        return fncd;
    }

    public static FNCD selling(FNCD fncd) {

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
