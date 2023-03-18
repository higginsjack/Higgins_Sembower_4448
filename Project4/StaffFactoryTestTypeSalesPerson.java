import org.junit.Test;

public class StaffFactoryTestTypeSalesPerson{
    @Test
    public void testStaffFactoryTypeSalesPerson(){
        Staff i = StaffFactory.makeVehicle(Enums.StaffType.Salesperson);
        if (i.type == Enums.StaffType.Salesperson){
            assert(true);
            System.out.println(i.type);
        }
    }
}