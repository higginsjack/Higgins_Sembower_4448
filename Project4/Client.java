// https://www.javatpoint.com/java-get-current-date#:~:text=Get%20Current%20Date%20%26%20Time%3A%20java.time.Clock,current%20date%20and%20time%20both.
// https://www.w3schools.com/java/java_user_input.asp
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;

public class Client {
    FNCD[] fncds = new FNCD[2];
    FNCD fncd;
    // Command askNameCom = new askNameCommand(selectSalesPerson());
    Command nullCom = new NullCommand();
    // Command askTimeCom = new askTimeCommand();
    // Command invenCom = new inventoryCommand(fncd);
    ArrayList<Command> commands = new ArrayList<>();
    // commands.add(nullCom);
    // Invoker invoker = new Invoker();

    public Client(FNCD f, FNCD f2){
        f.hciSales = selectSalesPerson(f);
        f2.hciSales= selectSalesPerson(f2);
        fncds[0]=f;
        fncds[1]=f2;
        fncd = f;
    }

    public Salesperson selectSalesPerson(FNCD f){
        ArrayList<Staff> salespeople = Staff.getStaffByType(f.staff, Enums.StaffType.Salesperson);
        int randomSeller = Utility.rndFromRange(0,salespeople.size()-1);
        Salesperson seller = (Salesperson) salespeople.get(randomSeller);
        return seller;
    }
    
    
    public FNCD runSim(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        Scanner obj2 = new Scanner(System.in);
        System.out.println("Buyer Simulation Begin");
        System.out.println("Type 'h' for Commands list: ()");
        String direction = "";
        int c=1;

        while(c==1) {
            direction = myObj.nextLine();  // Read user input
            commands.add(nullCom);
            switch(direction) {
                case "h":
                    System.out.println("1: Select FNCD");
                    System.out.println("2: SalesPerson Name");
                    System.out.println("3: Ask what time it is");
                    System.out.println("4: Ask for store inventory");
                    System.out.println("5: Ask salesperson to buy item");
                    System.out.println("6: Ask for different SalesPerson");
                    System.out.println("e: End simulation");
                    System.out.println("h: Get commands list");
                    break;
                case "1":
                    break;
                case "2":
                    Command askNameCom = new askNameCommand(fncd);
                    commands.add(askNameCom);
                    break;
                case "3":
                    Command askTimeCom = new askTimeCommand();
                    commands.add(askTimeCom);
                    break;
                case "4":
                    Command invenCom = new inventoryCommand(fncd);
                    commands.add(invenCom);
                    break;
                case "5":
                    System.out.println("Which item would you like");
                    buyCommand b = new buyCommand(fncd, obj2.nextLine());
                    commands.add(b);
                    break;
                case "6":
                    commands.add(new askNewSalesPersonCommand(fncd));
                    break;
                case "e":
                    c=0;
                    break;
                default:
                    System.out.println("Unknown command. Type 'h' for list of commands");
                    break;
            }
            for (int j = 0; j < commands.size(); j++) {
                commands.get(j).execute();
                commands.remove(j);
            }
        }
        return fncd;
    }
}
