public class VehicleFactory {
    public Vehicle makeVehicle(Enums.VehicleType vType) {
        Vehicle newVehicle = null;

        if (vType == Car)) {
            return new Car();
        }
        else 
            if (vType == Performance){
                return new Performance();
            
        }
        else 
            if (vType == Motorcycle){
                return new Motorcycle();
            }
        else 
            if (vType == Monster){
                return new Monster();
            }
        else
            if (vType == Pickup){
                return new Pickup();
            }
        else 
            if (vType == Electric){
                return new Electric();
            }
        else 
            if (vType == Super){
                return new Super();
            }
        else
            if (vType == F1){
                return new F1();
            }
        else
            if (vType == Hyper){
                return new Hyper();
            }
        else {System.out.println("please enter a valid vehicle type");}
    }
}