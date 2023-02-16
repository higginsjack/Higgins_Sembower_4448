import java.util.Random;
abstract class Vehicle {
    private int id;
    private String type;
    private double repairBonus;
    private double salesBonus;
    private double washBonus;
    private double cost;
    private double salesPrice;
    private String condition;
    private String cleanliness;

    Vehicle(int id, String type, double repairBonus, double washBonus, double cost, double salesBonus) {
        this.id=id;
        this.type=type;
        this.salesBonus = 
        this.repairBonus=repairBonus;
        this.washBonus=washBonus;
        this.cost=cost;
        this.salesPrice = cost * 2;
        String[] arr = initializeCleanlinessCondition();
        this.condition = arr[0];
        this.cleanliness =arr[1];
        if(this.condition == "Broken") {
            this.cost = cost / 2;
            this.salesPrice = cost / 2;
        }
    }

    public String getType(){
        return this.type;
    }
    public int getId(){
        return this.id;
    }
    public double getRepairBonus(){
        return this.repairBonus;
    }
    public double getSalesBonus() {
        return this.salesBonus;
    }
    public double getWashBonus() {
        return this.washBonus;
    }
    public double getCost(){
        return this.cost;
    }
    public double getSalesPrice(){
        return this.salesPrice;
    }
    public String getCondition() {
        return this.condition;
    }
    public String getCleanliness(){
        return this.cleanliness;
    }

    public Boolean increaseCleanliness(){
        Random r = new Random();
        int high = 100;
        int result = r.nextInt(high);
        if(this.cleanliness == "Dirty"){
            if(result < 10) { //10% chance of dirty
                this.cleanliness = "Sparkling";
                return true;
            }
            else if(result < 90) { //80% chance of clean
                this.cleanliness = "Clean";
                return true;
            }
        }
        else if (this.cleanliness == "Clean") {
            if(result < 5) {
                this.cleanliness = "Dirty";
                return true;
            }
            else if (result < 35) {
                this.cleanliness = "Sparkling";
                return true;
            }
        }
        return false; // if cleaning fails false is returned
    }
    public Boolean fix(){
        System.out.println(this.id + " : " + this.condition);
        Random r = new Random();
        int result = r.nextInt(100);
        if(result < 80) {
            if(this.condition == "Broken") {
                this.condition = "Used";
                this.cost = this.cost *1.5;
                this.salesPrice = this.salesPrice*1.5;
                return true;
            }
            else if(this.condition == "Used") {
                this.condition = "Like New";
                this.cost = this.cost *1.25;
                this.salesPrice = this.salesPrice*1.25;
                return true;
            }
        }
        return false;
    }
    public void decreaseCleanliness(){
        if(this.cleanliness == "Sparkling"){
            this.cleanliness = "Clean";
        }
        else if(this.cleanliness == "Clean") {
            this.cleanliness = "Dirty";
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
