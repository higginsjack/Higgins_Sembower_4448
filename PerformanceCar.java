import java.util.Random;

public class PerformanceCar extends Vehicle {

    private int id;
    private String type;
    private float repairBonus;
    private float salesBonus;
    private float washBonus;
    private float cost;
    private float salesPrice;
    private String condition;
    private String cleanliness;

    PerformanceCar() {
        // super();
        //FNCD.createID()
        this.id = 0;
        this.type = "PerformanceCar";
        Random r = new Random();
        int low = 20000;
        int high = 40000;
        int result = r.nextInt(high-low) + low;
        this.cost = (float) result;
        this.salesPrice = (float) result * 2;

        this.salesBonus = 2000;
        this.repairBonus = 2000;
        this.washBonus = 200;

        String[] a = initializeCleanlinessCondition();
        this.condition = a[0];
        this.cleanliness = a[1];
    }
}
