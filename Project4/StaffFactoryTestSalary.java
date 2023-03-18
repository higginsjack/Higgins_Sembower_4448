import org.junit.Test;

public class StaffFactoryTestSalary{
    @Test
    public void testStaffFactory(){
        Staff i = StaffFactory.makeVehicle(Enums.StaffType.Driver);
        if (i.salary == 0){
            assert(true);
            System.out.println(i.salary);
        }
    }
}