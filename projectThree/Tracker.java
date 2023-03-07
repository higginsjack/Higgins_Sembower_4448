public class Tracker implements Observer{
    private double staffMoney;
    private int day;
    private double budget = 100000;

    public void update(String msg) {
        // TODO Auto-generated method stub
        // System.out.println(msg);

        if(msg.substring(0, 1).equals("s")) {
            // System.out.println("STAFF");
            this.staffMoney = this.staffMoney + Double.parseDouble(msg.substring(5));
        }
        else if(msg.substring(0, 1).equals("b")) {
            // print budeget and what is being aded to it HERE BOI
            // System.out.println("Budget: "+ this.budget + "  Adding " + Double.parseDouble(msg.substring(6)));
            this.budget = this.budget + Double.parseDouble(msg.substring(6));
        }
        else{
            this.day++;
        }
        // if(this.day == 30) {
        // }
        // throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    public void reportOut(String msg){
        System.out.println();
        System.out.println("Day: " + this.day + " | Staff Money Made: " + Utility.asDollar(this.staffMoney) + " | FNCD Money Made: " + Utility.asDollar(this.budget)); //hack, update
    }
}
