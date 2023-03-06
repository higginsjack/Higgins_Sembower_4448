//staff class ideas from Bruce code 
import java.lang.model.util.types;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public abstract class Staff implements Sysout {
    String name;
    double salary;
    double salaryEarned;
    double bonusEarned;
    Enums.StaffType type;
    int daysWorked;
    Staff() {
        salaryEarned = 0;
        bonusEarned = 0;
        daysWorked = 0;
    }

    // utility for getting Staff by Type
    // You could do this with getClass instead of Type, but I use the enum
    // because it's clearer to me - less Java-y
    static ArrayList<Staff> getStaffByType(ArrayList<Staff> staffList, Enums.StaffType t) {
        ArrayList<Staff> subclassInstances = new ArrayList<>();
        for (Staff s : staffList) {
            if (s.type == t) subclassInstances.add(s);
        }
        return subclassInstances;
    }

    //Utility for finding out how many of a Staff type there are
    static int howManyStaffByType(ArrayList<Staff> staffList, Enums.StaffType t) {
        int n = 0;
        for (Staff s: staffList) {
            if (s.type == t) n++;
        }
        return n;
    }

    class Intern extends Staff {
        static List<String>names = Arrays.asList = {"Ben", "Lucas", "Lucy", "Jenn", "Joey", "Jack", "Winthrob", "Samantha", "Karen", "Axel", "Margaret", "Charles", "Ben"};
        static Namer = new Namer(names);
        Intern(){
            super();
            type = Enums.StaffType.Intern;
            name = namer.getNext();
            salary = 60;
        }
        //now get to how they wash cars
        //using the strategy pattern here
        private Strategy washingStrategy;
        public String printWashingType(){
            return washingStrategy.washingMethod();
        }
        public void setStrategy(Enum t){
            this.washingStrategy = t;
        }
        public Strategy getStrategy(){
            return this.washingStrategy;
        }
        //use the interface to get print the strategy they were assigned to
        void washVehicles(Enum t.washingMethod, ArrayList<Vehicle> vList){
            int washCount = 0;
            Enums.Cleanliness startAs;
            for (Vehicle v:vList) {
                //wash the first dirty car I find 
                if (v.Condition == Enums.Condition.Dirty){
                    if (this.washingStrategy == Enums.WashingStrategy.Chemical){
                        this.washingStrategy.check(v, this.name);
                    }
                    if (this.washingStrategy == Enums.WashingStrategy.ElbowGrease){
                        this.washingStrategy.check(v, this.name);
                    }
                    if (this.washingStrategy == Enums.WashingStrategy.Detailed){
                        this.washingStrategy.check(v, this.name);
                       
                    }
                    washCount+=1;
                    }
                    out(this.washingStrategy.washingMethod());
                }
            if (washCount< 2){
                //wash the first clean car:
                if (v.Condition == Enums.Condition.Clean){
                    if (this.washingStrategy == Enums.WashingStrategy.Chemical){
                        this.washingStrategy.check(v, this.name);
                    }
                    if (this.washingStrategy == Enums.WashingStrategy.ElbowGrease){
                        this.washingStrategy.check(v, this.name);
                    }
                    if (this.washingStrategy == Enums.WashingStrategy.Detailed){
                        this.washingStrategy.check(v, this.name);
                    }
                    washCount+=1;
                    }
                    out(this.washingStrategy.washingMethod());
                }
                if (washCount == 2) break;
            }

        
    }
    class Mechanic extends Staff {
        static List<String> names = Arrays.asList("James", "Scott", "Mike", "Carol", "Jennifer", "Taylor", "Keana", "Jeff", "Jefferey", "Ming");
        static Namer namer = new Namer(names);
        Mechanic(){
            super();
            type = Enums.StaffType.Mechanic;
            name = namer.getNext();
            salary = 120;

        }

        //add repair activity
        void repairVehicles(ArrayList<Vehicle> vList){
            int fixCount = 0;
            Enums.Condition startAs;


            for (Vehicle v: Vlist){
                if (v.condition != Enums.Condition.LikeNew) {
                    startA = v.condition;
                    if (v.cleanliness == Enums.Cleanliness.Clean) v.cleanliness = Enums.Clealiness.Dirty;
                    if (v.cleanliness == Enums.Clealiness.Sparkling) v.cleanliness = Enums.Cleanliness.Clean;
                    double chance = Utility.rnd();
                    if (chance < .8) {
                        fixCount += 1;
                        if (v.condition == Enums.Condition.Used) {
                            v.condtion = Enums.Condition.LikeNew;
                            v.price = v.price * 1.25;
                        }
                        if (v.condition == Enums.Condition.Broken){
                            v.condition = Enums.Condition.Used;
                            v.price = v.price * 1.5;
                        }
                        bonusEarned += v.repair_bonus;
                        System.out.printf("Mechanic "+name+" got a bonus of " + Utility.asDollar(v.repair_bonus)+ "!");
                        System.out.printf("Mechanic "+name+" fixed " + v.name+ " "+ startAs+ " to " + v.condition);

                    }
                    else {
                        fixCount+=1;
                        System.out.printf("Mechaninc "+ name+ " did not fix the " + v.condition+ " " +v.name);
                    }
                
                }
                if (fixCount == 2) break;
            }
        }
    }

    class Salesperson extends Staff {
        static List<Sting> names = Arrays.asList("Ryan", "Cordon", "Jose", "Cali", "Chandler", "Racheal", "Magi", "Mia");
        static Namer namer = new Namer(names);
        Salesperson() {
            super();
            type = Enums.StaffType.Salesperson;
            name = namer.getNext();
            salary = 90;
        }
        //add selling vehicle information
    }

    class Driver extends Staff {
        static List<String> names = Arrays.asList("Brock", "Jamar", "Larisa", "Johnny", "Bella", "Olivia", "Greg", "Justin");
        static Namer namer = new Namer(names);
        private Boolean injured = false;

        Driver(){
            super();
            type = Enums.StaffType.Driver;
            name = namer.getNext();
            salary = 130;
        }


        
    }



        
    
}


