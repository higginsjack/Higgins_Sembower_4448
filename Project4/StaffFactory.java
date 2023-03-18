
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

}
