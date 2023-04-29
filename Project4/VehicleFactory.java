<<<<<<< HEAD
=======
//factory for the Vehicles!

>>>>>>> 479af53ec27bd467ded915b9793bc4bfe7340724
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
<<<<<<< HEAD
        case Super:
            return new Super();
        case Pickup:
            return new Pickup();
=======
        case Pickup:
            return new Pickup();
        case Super:
            return new Super();
>>>>>>> 479af53ec27bd467ded915b9793bc4bfe7340724
        default:
            throw new IllegalArgumentException("Invalid Vehicle Type");
    }
}
<<<<<<< HEAD
}
=======
}
>>>>>>> 479af53ec27bd467ded915b9793bc4bfe7340724
