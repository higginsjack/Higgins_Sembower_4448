import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Begin simulation");
        Vehicle v = new Vehicle(0, "car");
        Staff p = new Staff(1, 10000);

        ArrayList<Vehicle> vehicles =  new ArrayList<Vehicle>();
        vehicles.add(v);
        ArrayList<Staff> staff = new ArrayList<Staff>();
        staff.add(p);

        FNCD fncd = new FNCD(250000, staff, vehicles);

        System.out.println("Begin tests:");
        fncd.updateBudget(-1000);
        System.out.println("Updated budget " + fncd.getBudget());
        System.out.println(fncd.getBankruptcies());

        // Main
        fncd = Activities.opening(fncd);
        fncd = Activities.washing(fncd);
        fncd = Activities.repairing(fncd);
        fncd = Activities.selling(fncd);
        fncd = Activities.ending(fncd);
    }
}
