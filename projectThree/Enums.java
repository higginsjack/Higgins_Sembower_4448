//ENUM FILE FOR PROJECT 3 Idea from BRUCE

public class Enums {
    public enum daysOfTheWeek {Mon, Tue, Wed, Thur, Fri, Sat, Sun}
    public enum Condition {Broken, Used, LikeNew}
    public enum VehicleType {Performance, Car, Pickup, Electric, Motorcylce, Monster}
    public enum StaffType {Salesperson, Mechanic, Driver, Intern}
    public enum Cleanliness {Clean, Dirty, Sparkling}
    public enum BuyerType {JustLooking, WantsOne, NeedsOne}
    public enum washingStrategy {Chemical, ElbowGrease, Detailed}
    public enum RaceCars =  
        for (int i = 0; i < VehicleType.size(); i++)
        {
            if (VehicleType != Car && VehicleType != Electric){
                RaceCars[i] = VehicleType[i];
            }
   //checking to see if they were added to the racecars enum!! System.out.println(RaceCars);
}