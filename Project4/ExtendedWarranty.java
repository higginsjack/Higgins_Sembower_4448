public class ExtendedWarranty extends carAddOn {
    Vehicle vehicle;
    public ExtendedWarranty(Vehicle v){
        vehicle = v;
    }
    @Override
    public double getSalesPrice() {
        return vehicle.getSalesPrice() * 1.2;
    }
    
}