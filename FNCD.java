import java.util.ArrayList;
import java.util.Formatter;  

class FNCD {
    private double budget;
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
        updateBudget(v.getCost() * 2);
    }
    
    public void staffUpdate(Staff s) {
        this.departedStaff.add(s);
        this.staff.remove(s);
    }

    public String working(ArrayList<Staff> s){
        String working ="";
        ArrayList<Staff> container = this.getDeparted();
        for (int i =0; i < s.size(); i++){
            if (container.contains(s)){
                working = "no";
            }
            else{
                working = "yes";
            }
        }

        return working;
    }

    public void Fomatter(Staff s){  
        ArrayList<Staff> j = getStaff();
        Formatter fmt = new Formatter();  
        fmt.format("%15s %15s %15s %15s %15s %15s\n", "Salary", "Money Made", "Days Worked", "Bonus Pay", "Working or Quit");  
         
        {  
        fmt.format("%14s %14s %14s %14s %14s\n",s.getSalary(), s.getMoneyMade(), s.getDaysWorked(), s.getBonus(), working(j));  //need to check if they're working or not or if they departed.
        }  
        System.out.println(fmt);  
        }  
}