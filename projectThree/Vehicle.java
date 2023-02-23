//New Vehicle class that uses enums, idea and code from Prof BRUCE

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Vehicle {
    String name;
    Enums.VehicleType type;
    Enums.Condition condition;
    Enums.Cleanliness cleanliness;
    double cost;
    double price;
    double repair_bonus;
    double sale_bonus;


    //vehicle constructor

    Vehicle(){
        //all vehicles come with the same level of cleanliness
        double chance = Utility.rnd();
        if (chance<= 0.5) cleanliness = Enums.Cleanliness.Sparkling;
        else if (chance>0.5 && chance<=.4) cleanliness =  Enums.Cleanliness.Clean;
        else cleanliness = Enum.Cleanliness.Dirty;

        condition = Utility.randomEnum(Enums.Condition.class);
    }


}


class Car extends Vehicle {
    static List<String> names = Arrays.aList("Focus", "Camry", "Trooper", "Tuscon", "Escalade");
    static Namer namer = new Namer(names);
    Car() {
        super();
        type = Enums.VehicleType.Car;
        name = namer.getNext();
        cost = getCost(10000, 20000);
        price = cost * 2;
        repair_bonus = 100;
        wash_bonus = 20;
        sale_bonus = 500;
    }
}


class Performance extends Vehicle {
    static List<String> names = Arrays.aList("Aventador", "812-SuperFast", "California-T", "Taycan", "Trackhawk");
    static Namer namer = new Namer(names);
    Car() {
        super();
        type = Enums.VehicleType.Performance;
        name = namer.getNext();
        cost = getCost(30000, 60000);
        price = cost * 2;
        repair_bonus = 300;
        wash_bonus = 100;
        sale_bonus = 1000;
    }
}

class Pickup extends Vehicle {
    static List<String> names = Arrays.aList("Tacoma", "Colorado", "F-150", "F-250", "Ram 1500");
    static Namer namer = new Namer(names);
    Car() {
        super();
        type = Enums.VehicleType.Pickup;
        name = namer.getNext();
        cost = getCost(10000, 40000);
        price = cost * 2;
        repair_bonus = 200;
        wash_bonus = 75;
        sale_bonus = 750;
    }
}


class Electric extends Vehicle {
    static List<String> names = Arrays.aList("Model S P90D", "Taycon Turbo S", "Cybertruck", "Bolt", "Model X 100D");
    static Namer namer = new Namer(names);
    Car() {
        super();
        type = Enums.VehicleType.Electric;
        name = namer.getNext();
        cost = getCost(300000, 500000);
        price = cost * 2;
        repair_bonus = 300;
        wash_bonus = 100;
        sale_bonus = 1000; 
        range = Utility.randomEnum(60, 400);
    }
}


class Motorcylce extends Vehicle {
    static List<String> names = Arrays.aList("Chopper", "Scooter", "Roadster", "Touring", "Scrambler", "Cruiser");
    static Namer namer = new Namer(names);
    Car() {
        super();
        type = Enums.VehicleType.Motorcylce;
        name = namer.getNext();
        cost = getCost(10000, 20000);
        price = cost * 2;
        repair_bonus = 150;
        wash_bonus = 25;
        sale_bonus = 50;
    }
}

class Monster extends Vehicle {
    static List<String> names = Arrays.aList("Alien Invasion", "Avenger", "Bad Company", "Blue Thunder", "Ghost Rider", "Black Pearl");
    static Namer namer = new Namer(names);
    Car() {
        super();
        type = Enums.VehicleType.Monster;
        name = namer.getNext();
        cost = getCost(50000, 80000);
        price = cost * 2;
        repair_bonus = 500;
        wash_bonus = 350;
        sale_bonus = 2000;
    }
}
