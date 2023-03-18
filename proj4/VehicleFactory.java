import java.security.PublicKey;

import javax.lang.model.util.ElementScanner6;

public class VehicleFactory {
    public static Vehicle makeVehicle(Enums.VehicleType vType) {
        /* 
        Vehicle newVehicle = null;
        switch (vType){
        case Car:
            return new Car();
        case Motorcyclce:
            return new Motorcyclce();
        case Monster:
            return new Monster();
        case Electric:
            return new Electric();
        case F1:
            return new F1();
        case Hyper:
            return new Hyper();
        case Performance:
            return new Performance();
        case Super:
            return new Super();
        case Pickup:
            return new Pickup();
        default:
            throw new IllegalArgumentException("Invalid Vehicle Type");
            */
    
    Vehicle newVehicle = null;
    if (vType == Enums.VehicleType.Car){
        newVehicle = new Car();
        return newVehicle;
    }
    else if (vType == Enums.VehicleType.Motorcyclce){
        newVehicle = new Motorcyclce();
        return newVehicle;
    }
    else if (vType == Enums.VehicleType.Monster){
        newVehicle = new Monster();
        return newVehicle;
    }
     else if (vType == Enums.VehicleType.Pickup){
        newVehicle = new Pickup();
        return newVehicle;
    }
     else if (vType == Enums.VehicleType.Electric){
        newVehicle = new Electric();
        return newVehicle;
    }
     else if (vType == Enums.VehicleType.F1){
        newVehicle = new F1();
        return newVehicle;
    }
     else if (vType == Enums.VehicleType.Supercar){
        newVehicle = new Supercar();
        return newVehicle;
    }
     else if (vType == Enums.VehicleType.Hyper){
        newVehicle = new Hyper();
        return newVehicle;
    }
     else if (vType == Enums.VehicleType.Performance){
        newVehicle = new Performance();
        return newVehicle;
    }
    else{
        System.out.println("No vehicles to purchase");
        return null;
    }
    
   
    }
}
