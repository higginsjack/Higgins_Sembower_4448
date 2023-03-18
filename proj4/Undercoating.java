public class Undercoating extends carAddOn {
    Vehicle vehicle;
    public Undercoating(Vehicle v){
        vehicle = v;
    }
    @Override
    public double getSalesPrice() {
        return vehicle.getSalesPrice() * 1.05;
    }
    
}