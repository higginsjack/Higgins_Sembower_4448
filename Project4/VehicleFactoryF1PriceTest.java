import org.junit.Test;

public class VehicleFactoryF1PriceTest{
    @Test
    public void testVehicleFactoryF1Price(){
        Vehicle i = VehicleFactory.makeVehicle(Enums.VehicleType.F1);
        if (i.cost >= 100000 && i.cost <=200000 ){
            assert(true);
            System.out.println(i.cost);
        }
    }
}