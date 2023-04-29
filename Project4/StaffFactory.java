<<<<<<< HEAD
=======

>>>>>>> 479af53ec27bd467ded915b9793bc4bfe7340724
//Factory pattern for the staff!
public class StaffFactory {
    public static Staff makeVehicle(Enums.StaffType sType) {
        Staff newStaff = null;
        switch (sType){
        case Salesperson:
            return new Salesperson();
        case Intern:
            return new Intern();
        case Mechanic:
            return new Mechanic();
        case Driver:
            return new Driver();
        default:
            throw new IllegalArgumentException("Invalid Staff Type");
    }
}

<<<<<<< HEAD
}
=======
}
>>>>>>> 479af53ec27bd467ded915b9793bc4bfe7340724
