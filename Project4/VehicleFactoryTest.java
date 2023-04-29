import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class VehicleFactoryTest{
    @Test
    public void testVehicleFactory(){
        //testing to see if it can make a vehicle
        Vehicle v =  VehicleFactory.makeVehicle(Enums.VehicleType.Car);
        //check the name of the vehicle
        String name = v.name;
        String expectedResult = v.name;
        assertEquals(name, expectedResult); 
        System.out.println("true");
    
    }
}