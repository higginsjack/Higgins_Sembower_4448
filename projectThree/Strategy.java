public interface Strategy {
    String washingMethod();
    Vehicle check(Vehicle v);
 
}
 
class Chemical implements Strategy{
    public String washingMethod(){
        return "Washing with chemical!";
    }

    // @Override
    public Vehicle check(Vehicle v){
        double brokenchance = Utility.rnd();
        if (brokenchance <=.1){
            v.condition = Enums.Condition.Broken;
        }
        double chance = Utility.rnd();
        if (chance <= .8) {
            v.cleanliness = Enums.Cleanliness.Clean;
            //return  1;
        }
        else if  (chance >.8 && chance <=.9) {
            v.cleanliness = Enums.Cleanliness.Sparkling;
            // b += v.wash_bonus;
            // System.out.println("Intern "+i+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
            //return 2;
        }
        return v;

        
    }
}
 
 
 class ElbowGrease implements Strategy{
     public String washingMethod(){
         return "Washing with elbow grease!";
     }
    //  @Override 
    public Vehicle check(Vehicle v){
        double brokenchance = Utility.rnd();
        double chance = Utility.rnd();
        if (brokenchance <=.1 && v.condition != Enums.Condition.LikeNew){
            v.condition = Enums.Condition.LikeNew;
        }
        if (v.cleanliness == Enums.Cleanliness.Dirty){//??????
            if (chance <= .7) {
                v.cleanliness = Enums.Cleanliness.Clean;
            }
            else if (chance >.7 && chance <=.05){
                v.cleanliness = Enums.Cleanliness.Sparkling;
                // b += v.wash_bonus;
                // System.out.println("Intern "+i+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
            }
        }
        
        else if (v.cleanliness == Enums.Cleanliness.Clean){
            if (chance <=.15){
                v.cleanliness = Enums.Cleanliness.Dirty;
            }
            if (chance >=.85){
                v.cleanliness = Enums.Cleanliness.Sparkling;
            //  b += v.wash_bonus;
                // System.out.println("Intern "+i+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
                
            }
        }
        return v;
    }
     
 }
 
 class Detailed implements Strategy{
    public String washingMethod(){
        return "Washing with detailed!";
    }
    public Vehicle check(Vehicle v){
        double chance = Utility.rnd();
        if (v.cleanliness == Enums.Cleanliness.Dirty){
            if (chance <=.6){
                v.cleanliness = Enums.Cleanliness.Clean;
            }
            if (chance >=.8){
                v.cleanliness = Enums.Cleanliness.Sparkling;
                // b += v.wash_bonus;
            }
        }
        else if (v.cleanliness == Enums.Cleanliness.Clean){
            if (chance <=.05){
                v.cleanliness = Enums.Cleanliness.Dirty;
            }
            if (chance >=.6){
                v.cleanliness = Enums.Cleanliness.Sparkling;
                // b += v.wash_bonus;
                // System.out.println("Intern "+i+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
            }
        }
        return v;
    }
 }