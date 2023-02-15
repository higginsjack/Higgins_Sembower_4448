import java.util.Random;
abstract class Vehicle {
    private int id;
    private String type;
    private float repairBonus;
    private float salesBonus;
    private float washBonus;
    private float cost;
    private String condition;
    private String cleanliness;

    // Vehicle() {
    //     this.id = 0;
    //     this.type = "Null";
    //     this.repairBonus = 0;
    //     this.salesBonus = 0;
    //     this.washBonus = 0;
    //     this.cost = 0;
    //     this.condition="Null";
    //     this.cleanliness="Null";
    // }

    public String getType(){
        return this.type;
    }
    public int getId(){
        return this.id;
    }
    public float getRepairBonus(){
        return this.repairBonus;
    }
    public float getSalesBonus() {
        return this.salesBonus;
    }
    public float getWashBonus() {
        return this.washBonus;
    }
    public float getCost(){
        return this.cost;
    }
    public String getCondition() {
        return this.condition;
    }
    public String getCleanliness(){
        return this.cleanliness;
    }

    public void increaseCleanliness(){
        Random r = new Random();
        int high = 100;
        int result = r.nextInt(high);
        if(this.cleanliness == "Dirty"){
            if(result < 10) { //10% chance of dirty
                this.cleanliness = "Sparkling";
            }
            else if(result < 90) { //80% chance of clean
                this.cleanliness = "Clean";
            }
        }
        else if (this.cleanliness == "Clean") {
            if(result < 5) {
                this.cleanliness = "Dirty";
            }
            else if (result < 35) {
                this.cleanliness = "Sparkling";
            }
        }
    }
    public static String[] initializeCleanlinessCondition(){
        Random r = new Random();
        int con = r.nextInt(3);
        String condition;
        String cleanliness;

        if(con == 0) {
            condition = "Like New";
        }
        else if(con == 1) {
            condition  = "Used";
        }
        else{
            condition = "Broken";
        }
        int cle = r.nextInt(100);
        if(cle < 5) {
            cleanliness = "Sparkling";
        }
        else if(cle < 40) {
            cleanliness = "Clean";
        }
        else{
            cleanliness = "Dirty";
        }
        String[] arr = {condition, cleanliness};
        return arr;

    }
}
