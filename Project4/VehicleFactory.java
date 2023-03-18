public class VehicleFactory {
    public static Vehicle makeVehicle(Enums.VehicleType vType) {
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
    }
}
}