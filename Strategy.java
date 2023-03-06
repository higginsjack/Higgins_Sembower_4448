public interface Strategy {
   String washingMetod();

}


class Chemical implements Strategy{
    public String washingMetod(){
        return "Washing with chemical!";
    }
    @override
    public double check(){
        return Utility.rnd();
    }
}

class ElbowGrease implements Strategy{
    public String washingMetod(){
        return "Washing with elbow grease!";
    }
    @override 
    public double check(){
        return Utility.rnd();
    }
}

class Deatiled implements Strategy{
    public String washingMetod(){
        return "Washing with detailed!";
    }
    @override 
    public double check(){
        return Utility.rnd();
    }
}

