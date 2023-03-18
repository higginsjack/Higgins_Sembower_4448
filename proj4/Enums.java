// All the enums for the program in one spot
// I much prefer enums to magic numbers or constants

// Normally, I would do each enum in a file, but
// I found this nice suggestion for doing all the enums in one spot/file
// https://stackoverflow.com/questions/10017729/multiple-enum-classes-in-one-java-file
public class Enums {
    public enum daysOfTheWeek {Mon, Tue, Wed, Thur, Fri, Sat, Sun}
    public enum Condition {Broken, Used, LikeNew}
    public enum VehicleType {Performance, Car, Pickup, Electric, Motorcyclce, Monster, Hyper, F1, Supercar}
    public enum StaffType {Salesperson, Mechanic, Driver, Intern}
    public enum washingStrategy {Chemical, ElbowGrease, Detailed}
    public enum Cleanliness {Clean, Dirty, Sparkling}
    public enum BuyerType {JustLooking, WantsOne, NeedsOne}
    // public enum RaceCars =  
    //     for (int i = 0; i < VehicleType.size(); i++)
    //     {
    //         if (VehicleType != Car && VehicleType != Electric){
    //             RaceCars[i] = VehicleType[i];
    //     }
   //checking to see if they were added to the racecars enum!! System.out.println(RaceCars);
}