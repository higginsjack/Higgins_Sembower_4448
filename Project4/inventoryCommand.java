public class inventoryCommand implements Command {
    FNCD fncd;
    @Override
    public void execute() {
        Vehicle v;
        System.out.println("Inventory");
        System.out.printf("| %-5s | %-10s | %10s | %15s | %15s \n", "Name", "Cost", "Sale Price", "Condition", "Cleanliness");
        for(int i = 0; i < fncd.inventory.size(); i++) {
            v = fncd.inventory.get(i);
            System.out.printf("| %-20s | %-10s | %10s | %15s | %15s \n",v.name, Utility.asDollar(v.cost), Utility.asDollar(v.price), v.condition, v.cleanliness);
        }
    }

    public inventoryCommand(FNCD f) {
        this.fncd=f;
    }
    
}
