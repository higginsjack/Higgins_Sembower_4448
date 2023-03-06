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
        check();
    }
}

class ElbowGrease implements Strategy{
    public String washingMetod(){
        return "Washing with elbow grease!";
    }
    @override 
    check();
    }
}

class Deatiled implements Strategy{
    public String washingMetod(){
        return "Washing with detailed!";
    }
    @override 
    check();
}

