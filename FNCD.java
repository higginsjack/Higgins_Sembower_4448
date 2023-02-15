import java.util.ArrayList;

class FNCD {
    private float budget;
    private int bankruptcies;
    private ArrayList<Staff> staff;
    private ArrayList<Staff> departedStaff;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Vehicle> soldVehicles;
    private static int idCounter = 0;


    public FNCD(int b, ArrayList<Staff> s, ArrayList<Vehicle> v) {
        this.budget = b;
        this.bankruptcies = 0;
        this.staff = s;
        this.vehicles = v;
        this.soldVehicles = new ArrayList<Vehicle>();
    }


    public static int createID(){
        return idCounter++;
    }

    public float getBudget(){
        return this.budget;
    }

    public void updateBudget(int amount) {
        this.budget = this.budget + amount;
    }

    public ArrayList<Vehicle> getVehicles(){
        return this.vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> v) {
        this.vehicles = v;
    }

    public void bankruptcy() {
        System.out.println("Bankruptcy!");
        this.bankruptcies++;
    }

    public int getBankruptcies(){
        return this.bankruptcies;
    }

    public void setStaff(ArrayList<Staff> s) {
        this.staff = s;
    } 

    public ArrayList<Staff> getStaff() {
        return this.staff;
    }

    public void sellVehicle(Vehicle v) {
        this.soldVehicles.add(v);
        this.vehicles.remove(v);
        // updateBudget(v.sellPrice);
    }
    
    public void staffUpdate(Staff s) {
        this.departedStaff.add(s);
        this.staff.remove(s);
    }
}
