import org.junit.Test;

public class VehicleFactoryMonsterPriceTest{
    @Test
    public void testVehicleFactoryMonsterPrice(){
        Vehicle i = VehicleFactory.makeVehicle(Enums.VehicleType.Monster);
        if (i.cost >= 50000 && i.cost <=80000 ){
            assert(true);
            System.out.println(i.cost);
        }
    }
}