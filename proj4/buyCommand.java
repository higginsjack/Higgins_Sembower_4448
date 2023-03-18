import java.util.ArrayList;
import java.util.Scanner;

public class buyCommand implements Command{
    FNCD fncd;
    String item;
    @Override
    public void execute() {
        ArrayList<Vehicle> vs = fncd.inventory;
        // Vehicle v;
        int bought=0;
        System.out.println(item + " | Length: " + item.length());
        System.out.println(fncd.inventory.get(0).name + " | Length: " + fncd.inventory.get(0).name.length());
        for (int i = 0; i < vs.size(); i++) {
            if(vs.get(i).name.equals(item)) {
                bought=1;
                Vehicle v=vs.get(i);
                String msg = "You bought "+v.cleanliness+" "+v.condition+" "+v.name;
                System.out.println("What addons would you like? Type numbers without spaces. 1: Extended Warranty. 2: Undercoating. 3: Road Rescue Coverage. 4:Satellite radio.");
                Scanner obj = new Scanner(System.in);
                String addons = obj.nextLine();
                if(addons.contains("1")) {
                    msg += " With addon Extended Warranty.";
                    v = new ExtendedWarranty(v);
                }
                // addonChance = Utility.rndFromRange(1, 100);
                if(addons.contains("2")) {
                    msg += " With addon Undercoating.";
                }
                if(addons.contains("3")) {
                    v = new RoadRescueCoverage(v);
                }
                if(addons.contains("4")) {
                    msg += " With addon Satellite Radio.";
                    v = new SatelliteRadio(v);
                }
                System.out.println(msg + " Price: "+Utility.asDollar(v.getSalesPrice()));
                fncd.inventory.remove(v);
                fncd.hciSales.bonusEarned+=v.sale_bonus;
                fncd.moneyOut(v.sale_bonus);
            }
        }
        if(bought==0) {
            System.out.println(item + " is not a valid name of a vehicle. Please check inventory then type it correctly.");
        }
    }
    public buyCommand(FNCD f, String i) {
        this.fncd=f;
        this.item=i;
    }
    
}
