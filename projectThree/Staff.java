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
        Driver(){
            super();
            type = Enums.StaffType.Driver;
            name = namer.getNext();
            salary = 130;
        }
        //add driving actibity (race day)
    }



        
    
}