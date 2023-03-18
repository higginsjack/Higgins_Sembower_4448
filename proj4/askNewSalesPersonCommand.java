import java.util.ArrayList;
import java.util.Scanner;

public class askNewSalesPersonCommand implements Command {
    FNCD fncd;
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        System.out.println("Sales People:");
        Staff q;
        ArrayList<Staff> salespeople = Staff.getStaffByType(fncd.staff, Enums.StaffType.Salesperson);
        for(int y = 0; y < salespeople.size(); y++) {
            q = salespeople.get(y);
            System.out.println(q.name);
        }
        System.out.println("Which Sales Person would you like:");
        Scanner scan = new Scanner(System.in);
        String p = scan.nextLine();

        int found =0;
        for(int i = 0; i < fncd.staff.size(); i++) {
            if(fncd.staff.get(i).name.equals(p)) {
                found=1;
                fncd.hciSales = (Salesperson) fncd.staff.get(i);
                System.out.println("Your Sales Person is now " + fncd.hciSales.name);
            }
        }
        if(found ==0) {
            System.out.println("Salesperson " + p + " not found");
        }
    }
    
    public askNewSalesPersonCommand(FNCD f) {
        this.fncd=f;
    }

}
