import org.junit.Test;

public class VehicleFactoryMotorcyclcePriceTest{
    @Test
    public void testVehicleFactoryMotorcyclcePrice(){
        Vehicle i = VehicleFactory.makeVehicle(Enums.VehicleType.Motorcyclce);
        if (i.cost >= 10000 && i.cost <=20000 ){
            assert(true);
            System.out.println(i.cost);
        }
    }
}