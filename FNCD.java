import java.util.ArrayList;

class FNCD {
    private float budget;
    private int bankruptcies;
    private ArrayList<Staff> staff;
    private ArrayList<Vehicle> vehicles;

    public FNCD(int b, ArrayList<Staff> s, ArrayList<Vehicle> v) {
        this.budget = b;
        this.bankruptcies = 0;
        this.staff = s;
        this.vehicles = v;
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
}
