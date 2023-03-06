public interface Strategy {
   String washingMetod();
public double check(){
    return Utility.rnd();
}

}


class Chemical implements Strategy{
    public String washingMetod(){
        return "Washing with chemical!";
    }
    @override
    public void check(Vehicle v){
        double brokenchance = Utility.rnd();
        if (brokenchance <=.1){
            v.Condition = Enums.Conidtion.Broken;
        }
        double chance = Utility.rnd();
        if (chance <= .8) {
            v.cleanliness = Enums.Cleanliness.Clean;
            //return  1;
        }
        else if  (chance >.8 && chance <=.9) {
            v.cleanliness = Enums.Cleanliness.Sparkling;
            bonusEarned += v.wash_bonus;
            out("Intern "+name+" got a bonus of "+Utility.asDollar(v.wash_bonus)+"!");
            out(washingMethod());
            //return 2;
        }

        
    }
 }


class ElbowGrease implements Strategy{
    public String washingMetod(){
        return "Washing with elbow grease!";
    }
    @override 
    public void check(v){
        double brokenchance = Utility.rnd();
        if (brokenchance <=.1 && v.Condition != Enums.Condition.LikeNew){
            v.Condition = Enuns.Condition.LikeNew;
        }
        if (v.Condition == Enums.Condition.Dirty){
        double chance = Utility.rnd();
        if (chance <= .7) {
            v.cleanliness = Enums.Clealiness.Clean;
        }
        else if (chance >.7 && chance <=.05){
            v.Cleanliness = Enums.Condtion.Sparkling;
        }
        }
        
        else if (v.Condition == Enums.Condition.Clean){
            if (chance <=.15){
                v.Condition = Enums.Condition.Dirty;
            }
            if (chance >=.85){
                v.Condition = V.Condition.Sparkling;
            }
        }
    }
}

class Deatiled implements Strategy{
    public String washingMetod(){
        return "Washing with detailed!";
    }
    @override 
    check();
}

