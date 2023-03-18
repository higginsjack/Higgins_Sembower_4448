import org.junit.Test;

public class StaffFactoryTestTypeMechanic{
    @Test
    public void testStaffFactoryTypeMechanic(){
        Staff i = StaffFactory.makeVehicle(Enums.StaffType.Mechanic);
        if (i.type == Enums.StaffType.Mechanic){
            assert(true);
            System.out.println(i.type);
        }
    }
}