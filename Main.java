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

        //Activities test
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

        // printStaff(fncd.getStaff());
        System.out.println("fncd budget: " + fncd.getBudget());
        printVehicles(fncd.getVehicles());

        // fncd = Activities.washing(fncd);
        // fncd = Activities.repairing(fncd);
        fncd = Activities.selling(fncd, "Monday");

        // printStaff(fncd.getStaff());
        System.out.println("fncd budget: " + fncd.getBudget());
        printVehicles(fncd.getVehicles());

        // Main
        // ArrayList<Vehicle> vehicles =  new ArrayList<Vehicle>();
        // ArrayList<Staff> staff = new ArrayList<Staff>();

        // FNCD fncd = new FNCD(500000, staff, vehicles);
        // int length = 30;
        // int days_passed = 0;
        // String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        // //need to pass day into methods
        // while(days_passed < length) {
        //     String d = days[days_passed % 7];
        // System.out.println("Day: " + days_passed + " " + d);
        //     if(d != "Sunday") {
        //         fncd = Activities.opening(fncd);
        //         fncd = Activities.washing(fncd);
        //         fncd = Activities.repairing(fncd);
        //         fncd = Activities.selling(fncd, d);
        //         fncd = Activities.ending(fncd);
        //     }
        //     days_passed++;
        // }
    }
    public static void printVehicles(ArrayList<Vehicle> v){
        for(int x = 0; x < v.size(); x++) {
            System.out.println(v.get(x).getId());
            System.out.println(v.get(x).getCleanliness());
            System.out.println(v.get(x).getCondition());
            System.out.println(v.get(x).getType());
            System.out.println();
        }
    }
    public static void printStaff(ArrayList<Staff> s){
        for(int x = 0; x < s.size(); x++) {
            System.out.println(s.get(x).getId());
            System.out.println(s.get(x).getBonus());
            System.out.println(s.get(x).getSalary());
            System.out.println();
        }
    }
}
