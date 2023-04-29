import org.junit.Test;

public class VehicleFactorySuperPriceTest{
    @Test
    public void testVehicleFactorySuperPrice(){
        Vehicle i = VehicleFactory.makeVehicle(Enums.VehicleType.Super);
        if (i.cost >= 80000 && i.cost <=90000 ){
            assert(true);
            System.out.println(i.cost);
        }
    }
}