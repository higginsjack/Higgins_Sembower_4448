public class askNameCommand implements Command{
    // Salesperson seller;
    FNCD fncd;
    @Override
    public void execute() {
        System.out.println("Seller name is " + this.fncd.hciSales.name);
    }

    public askNameCommand(FNCD f) {
        this.fncd =f;
    }
}