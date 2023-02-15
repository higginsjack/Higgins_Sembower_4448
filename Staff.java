import java.util.*;


abstract class Staff {
    private int id;
    private int bonus;
    private int salary;
    private int daysWorked;
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

    public int getBonus(){
        return this.bonus;
    }

    public void setBonus(int i){
        this.bonus = i;
    }

    public void setId(){
        this.id = FNCD.createID();
    }

    public int getId(){
        return this.id;
    }

}

class SalesPeople extends Staff {

    public SalesPeople(int i, int s) {
        super(i, s);
        //TODO Auto-generated constructor stub
        this.setSalary(40000);
    }


}

class Mechanics extends Staff {

    public Mechanics(int i, int s) {
        super(i, s);
        //TODO Auto-generated constructor stub
        this.setSalary(20000);
    }

}

class Interns extends Staff {

    public Interns(int i, int s) {
        super(i, s);
        //TODO Auto-generated constructor stub
        this.setSalary(1000);
    }

}


