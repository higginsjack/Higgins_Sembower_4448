import org.junit.Test;

public class VehicleFactoryHyperPriceTest{
    @Test
    public void testVehicleFactoryHyperPrice(){
        Vehicle i = VehicleFactory.makeVehicle(Enums.VehicleType.Hyper);
        if (i.cost >= 100000 && i.cost <=200000 ){
            assert(true);
            System.out.println(i.cost);
        }
    }
}