import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Vehicle tests
        // System.out.println("Performance Car tests");
        // PerformanceCar c = new PerformanceCar();
        // System.out.println(c.getCondition());
        // System.out.println(c.getCost());
        // System.out.println(c.getId());

        // System.out.println("Car tests");
        // Car b = new Car();
        // System.out.println(b.getCondition());
        // System.out.println(b.getCost());
        // System.out.println(b.getId());

        // System.out.println("Pickup tests");
        // Pickup a= new Pickup();
        // System.out.println(a.getCondition());
        // System.out.println(a.getCost());
        // System.out.println(a.getId());


        //FNCD tests

        // System.out.println("Begin simulation");
        // Vehicle v = new PerformanceCar();
        // Staff p = new Staff(1, 10000);

        // ArrayList<Vehicle> vehicles =  new ArrayList<Vehicle>();
        // vehicles.add(v);
        // ArrayList<Staff> staff = new ArrayList<Staff>();
        // staff.add(p);

        // FNCD fncd = new FNCD(250000, staff, vehicles);

        // System.out.println("Begin tests:");
        // fncd.updateBudget(-1000);
        // System.out.println("Updated budget " + fncd.getBudget());
        // System.out.println(fncd.getBankruptcies());

        // Main
        ArrayList<Vehicle> vehicles =  new ArrayList<Vehicle>();
        ArrayList<Staff> staff = new ArrayList<Staff>();
        for(int x = 0; x < 4; x++) {
            vehicles.add(new PerformanceCar());
            vehicles.add(new Car());
            vehicles.add(new Pickup());
        }
        for(int z = 0; z < 3; z++) {
            staff.add(new SalesPeople(0, FNCD.createID()));
            staff.add(new Mechanics(0, FNCD.createID()));
            staff.add(new Interns(0, FNCD.createID()));
        }

        FNCD fncd = new FNCD(250000, staff, vehicles);
        int length = 30;
        int days_passed = 0;
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        //need to pass day into methods
        while(days_passed < length) {
            String d = days[days_passed % 7];
            if(d != "Sunday") {
                fncd = Activities.opening(fncd);
                fncd = Activities.washing(fncd);
                fncd = Activities.repairing(fncd);
                fncd = Activities.selling(fncd, d);
                fncd = Activities.ending(fncd);
            }
            days_passed++;
        }
    }
}
