import java.util.Random;
public class Car extends Vehicle{
    Car() {
        //(int id, String type, float repairBonus, float washBonus, float cost)
        //id = FNCD.
        super(0, "Car", 1000, 1000, initializeCost());
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
