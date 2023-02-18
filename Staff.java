import java.util.*;

abstract class Staff {
    //polymorphism - interns , salespeople, and mechanics all have same attributes/methods allowing for intern promotion
    private int id; // Identity: this is a unique identifier for an object
    private double bonus;
    private int salary;
    private int daysWorked;
    private int moneyMade;
    public Staff(int i, int s) {
        this.id = i;
        this.bonus = 0;
        this.salary = s;
        this.daysWorked = 0;
    }

    public int getSalary(){
        return this.salary;
    }

    public void setSalary(int i){
        this.salary = i;
    }

    public int getDaysWorked(){
        return this.daysWorked;
    }

    public void setDaysWorked(){
        this.daysWorked += 1;
    }

    public void setNewDaysWorked(int x) {
        this.daysWorked = x;
    }

    public void setNewId(int y) {
        this.id = y;
    }

    public void setNewMoneyMade(int z) {
        this.moneyMade = z;
    }

    public double getBonus(){
        return this.bonus;
    }

    public void addBonus(double i){
        this.bonus += i;
    }

    public void setId(){
        this.id = FNCD.createID();
    }

    public int getId(){
        return this.id;
    }

    public void setMoneyMade(Staff s)
    {
        this.moneyMade += Math.round(this.getSalary()/365);
    }

    public int getMoneyMade(){
        return this.moneyMade;
    }

    public static int Raffle() {

        Random ladyLuck = new Random(); // create Random object ladyLuck
        int answer = ladyLuck.nextInt(10) + 1;
        return answer;
    
    }
}

class SalesPeople extends Staff {

    public SalesPeople(int i, int s) {
        super(FNCD.createID(), s);
        //TODO Auto-generated constructor stub
        this.setSalary(50000);
    }


}

class Mechanics extends Staff {

    public Mechanics(int i, int s) {
        super(FNCD.createID(), s);
        //TODO Auto-generated constructor stub
        this.setSalary(40000);
    }

}

class Interns extends Staff {

    public Interns(int i, int s) {
        super(FNCD.createID(), s);
        //TODO Auto-generated constructor stub
        this.setSalary(20000);
    }

}
