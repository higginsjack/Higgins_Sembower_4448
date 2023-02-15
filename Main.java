import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PerformanceCar c = new PerformanceCar();
        System.out.println(c.getCondition());
        System.out.println(c.getCost());
        System.out.println(c.getId());
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

        // // Main
        // int length = 30;
        // int days_passed = 0;
        // String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        // //need to pass day into methods
        // while(days_passed < length) {
        //     String d = days[days_passed % 7];
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
    public static void vehicleTest(){
        PerformanceCar c = new PerformanceCar();
        System.out.println(c.getCondition());
    }
}
