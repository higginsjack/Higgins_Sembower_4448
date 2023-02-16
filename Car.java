import java.util.Random;
public class Car extends Vehicle{
    Car() {
        //(int id, String type, float repairBonus, float washBonus, float cost)
        //id = FNCD.
        super(FNCD.createID(), "Car", 250, 100, initializeCost(), 500);
    }
    public static float initializeCost(){
        Random r = new Random();
        int low = 10000;
        int high = 20000;
        int result = r.nextInt(high-low) + low;
        float cost = (float) result;
        return cost;
    }
}
