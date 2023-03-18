import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class StaffFactoryTest{
    @Test
    public void testStaffFactory(){
        //testing to see if it can make a vehicle
        Staff i =  StaffFactory.makeVehicle(Enums.StaffType.Intern);
        String iname = i.name;
        String iexpectedResult = i.name;
        Staff d = StaffFactory.makeVehicle(Enums.StaffType.Driver);
        String dname = i.name;
        String dexpectedResult = i.name;
        //check the name of the vehicle
     
        assertEquals(iname, iexpectedResult);
        assertEquals(dname, dexpectedResult); 
        System.out.println(i.name);
        System.out.println(d.name);
    
    }
}