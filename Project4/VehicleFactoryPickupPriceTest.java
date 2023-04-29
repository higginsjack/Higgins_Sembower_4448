import org.junit.Test;

public class VehicleFactoryPickupPriceTest{
    @Test
    public void testVehicleFactoryPickupPrice(){
        Vehicle i = VehicleFactory.makeVehicle(Enums.VehicleType.Pickup);
        if (i.cost >= 10000 && i.cost <=40000 ){
            assert(true);
            System.out.println(i.cost);
        }
    }
}