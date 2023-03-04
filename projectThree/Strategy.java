public interface Strategy {
   String washingMetod();

}


class Chemical implements Strategy{
    public String washingMetod(){
        return "Washing with chemical!";
    }
}

class ElbowGrease implements Strategy{
    public String washingMetod(){
        return "Washing with elbow grease!";
    }
}

class Deatiled implements Strategy{
    public String washingMetod(){
        return "Washing with detailed!";
    }
}

