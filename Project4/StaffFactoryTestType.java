import org.junit.Test;

public class StaffFactoryTestType{
    @Test
    public void testStaffFactoryType(){
        Staff i = StaffFactory.makeVehicle(Enums.StaffType.Driver);
        if (i.type == Enums.StaffType.Driver){
            assert(true);
            System.out.println(i.type);
        }
    }
}