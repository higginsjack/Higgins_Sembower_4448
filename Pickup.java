import java.util.Random;
public class Pickup extends Vehicle{
    Pickup() {
        //(int id, String type, float repairBonus, float washBonus, float cost)
        //id = FNCD.
        super(FNCD.createID(), "Pickup", 250, 150, initializeCost(), 1000);
    }
    public static float initializeCost(){
        Random r = new Random();
        int low = 10000;
        int high = 40000;
        int result = r.nextInt(high-low) + low;
        float cost = (float) result;
        return cost;
    }
}
