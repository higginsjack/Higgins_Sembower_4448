import java.util.Random;

public class PerformanceCar extends Vehicle {

    PerformanceCar() {
        //(int id, String type, float repairBonus, float washBonus, float cost)
        //id = FNCD.
        super(FNCD.createID(), "PerformanceCar", 500, 200, initializeCost(), 1000);
    }
    public static float initializeCost(){
        Random r = new Random();
        int low = 20000;
        int high = 40000;
        int result = r.nextInt(high-low) + low;
        float cost = (float) result;
        return cost;
    }
}
