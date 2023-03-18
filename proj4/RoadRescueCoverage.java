public class RoadRescueCoverage extends carAddOn {
    Vehicle vehicle;
    public RoadRescueCoverage(Vehicle v){
        vehicle = v;
    }
    @Override
    public double getSalesPrice() {
        return vehicle.getSalesPrice() * 1.02;
    }
    
}