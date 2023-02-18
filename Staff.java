import java.util.*;


abstract class Staff {
    private int id;
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

    public void setDaysWorked(int i){
        this.daysWorked += i;
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
