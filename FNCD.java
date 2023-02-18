import java.util.ArrayList;
import java.util.Formatter;  


class FNCD {
    private double budget;
    private int bankruptcies;
    private ArrayList<Staff> staff;
    private ArrayList<Staff> departedStaff;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Vehicle> soldVehicles;
    private double daySales;
    private static int idCounter = 0;


    public FNCD(int b, ArrayList<Staff> s, ArrayList<Vehicle> v) {
        this.budget = b;
        this.bankruptcies = 0;
        this.staff = s;
        this.vehicles = v;
        this.soldVehicles = new ArrayList<Vehicle>();
        this.departedStaff = new ArrayList<Staff>();
        this.daySales = 0;
    }
    public double getDaySales(){
        return this.daySales;
    }
    public void updateDaySales(double a){
        this.daySales += a;
    }
    public static int createID(){
        return idCounter++;
    }

    public double getBudget(){
        return this.budget;
    }

    public void updateBudget(double amount) {
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

    public ArrayList<Staff> getDeparted(){
        return this.departedStaff;
    }

    public ArrayList<Staff> getStaff() {
        return this.staff;
    }

    public void sellVehicle(Vehicle v) {
        this.soldVehicles.add(v);
        this.vehicles.remove(v);
        updateDaySales(v.getCost() * 2);
        updateBudget(v.getCost() * 2);
    }
    public ArrayList<Vehicle> getSoldVehicles() {
        return this.soldVehicles;
    }
    
    public void staffUpdate(Staff s) {
        this.departedStaff.add(s);
        this.staff.remove(s);
    }

    public void InternUpdate(Staff s){
        this.staff.remove(s);
    }

    public boolean working(Staff s){
        /*String working ="yes";
        ArrayList<Staff> container = this.getDeparted();
        for (int i = 0; i < s.size(); i++){
            if (container.contains(s)){
                working = "no";
            }
        }

        return working;
        */

        boolean stillWorking = false;;
        ArrayList<Staff> container = getStaff();
        for (int i = 0; i < container.size(); i++){
            if (!container.contains(s)){
                stillWorking= false;
            }
            else if (container.contains(s)) {
                stillWorking = true;
            }

        }
       return stillWorking;

    }

    public void internToMechanicOrSales(Staff s){
        if (s instanceof Mechanics || s instanceof SalesPeople){
           staffUpdate(s);
           staff.add(s);

        }

    }

    public void Fomatter(Staff s){
        ArrayList<Staff> j = getStaff();
        Formatter fmt = new Formatter();
        fmt.format("%15s %15s %15s %15s %15s %15s\n", "Id" ,"Salary", "Money Made", "Days Worked", "Bonus Pay", "Working");
        for (Staff x : getStaff()){
        fmt.format(" %14s %14s %14s %14s %14s %14s\n",x.getId() ,x.getSalary(), x.getMoneyMade(), x.getDaysWorked(), x.getBonus(), working(x));  //need to check if they're working or not or if they departed.
        }
        System.out.println(fmt);
    }


    public void promoter(Staff s){

        if (getStaff().contains(s) && s instanceof Interns){
            InternUpdate(s);
        }
        else if (getStaff().contains(s) && s instanceof Mechanics || s instanceof SalesPeople){
            internToMechanicOrSales(s);

        }

    }
}
