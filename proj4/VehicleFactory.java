public class VehicleFactory {
    public Vehicle makeVehicle(String vType) {
        Vehicle newVehicle = null;

        if (vType.equals("Car")) {
            return new Car();
        }
        else 
            if (vType.equals("Performance")){
                return new Performance();
            
        }
        else 
            if (vType.equals("Motorcycle")){
                return new Motorcycle();
            }
        else 
            if (vType.equals("Monster")){
                return new Monster();
            }
        else
            if (vType.equals("Pickup")){
                return new Pickup();
            }
        else 
            if (vType.equals("Electric")){
                return new Electric();
            }
        else 
            if (vType.equals("Super")){
                return new Super();
            }
        else
            if (vType.equals("F1")){
                return new F1();
            }
        else
            if (vType.equals("Hyper")){
                return new Hyper();
            }
    }
}