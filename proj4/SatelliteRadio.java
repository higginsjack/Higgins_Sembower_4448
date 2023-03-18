public class SatelliteRadio extends carAddOn {
    Vehicle vehicle;
    public SatelliteRadio(Vehicle v){
        vehicle = v;
    }
    @Override
    public double getSalesPrice() {
        return vehicle.getSalesPrice() * 1.05;
    }
    
}