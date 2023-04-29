import org.junit.Test;

public class VehicleFactoryPerformancePriceTest{
    @Test
    public void testVehicleFactoryPerformancePrice(){
        Vehicle i = VehicleFactory.makeVehicle(Enums.VehicleType.Performance);
        if (i.cost >= 20000 && i.cost <=40000 ){
            assert(true);
            System.out.println(i.cost);
        }
    }
}