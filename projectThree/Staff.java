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
}