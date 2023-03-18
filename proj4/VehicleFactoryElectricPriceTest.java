import org.junit.Test;

public class VehicleFactoryElectricPriceTest{
    @Test
    public void testVehicleFactoryElectricPrice(){
        Vehicle i = VehicleFactory.makeVehicle(Enums.VehicleType.Electric);
        if (i.cost >= 300000 && i.cost <=500000 ){
            assert(true);
            System.out.println(i.cost);
        }
    }
}