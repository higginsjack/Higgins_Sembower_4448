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
    double wash_bonus;
    double sale_bonus;
    int range;
    int wins;
    Vehicle () {
        // all vehicles have the same cleanliness arrival chance
        double chance = Utility.rnd();
        if (chance <= .05) cleanliness = Enums.Cleanliness.Sparkling;
        else if (chance>.05 && chance<=.4) cleanliness = Enums.Cleanliness.Clean;
        else cleanliness = Enums.Cleanliness.Dirty;
        // all vehicles have the same condition arrival chance (even chance of any)
        condition = Utility.randomEnum(Enums.Condition.class);
        wins=0;
    }

    // utility for getting adjusted cost by condition
    double getCost(int low,int high) {
        double cost = Utility.rndFromRange(low, high);
        if (condition== Enums.Condition.Used) cost = cost*.8;
        if (condition== Enums.Condition.Broken) cost = cost*.5;
        return cost;
    }
    double getSalesPrice() {
        return price;
    }
    double getOriginalCost(){
        return cost;
    }
    // utility for getting Vehicles by Type
    // You could do this with getClass instead of Type, but I use the enum
    // because it's clearer to me (less Java-y)
    static ArrayList<Vehicle> getVehiclesByType(ArrayList<Vehicle> vehicleList, Enums.VehicleType t) {
        ArrayList<Vehicle> subclassInstances = new ArrayList<>();
        for (Vehicle v : vehicleList) {
            if (v.type == t) subclassInstances.add(v);
        }
        return subclassInstances;
    }

    // Utility for finding out how many of a Vehicle there are
    static int howManyVehiclesByType(ArrayList<Vehicle> vehicleList, Enums.VehicleType t) {
        int n = 0;
        for (Vehicle v: vehicleList) {
            if (v.type == t) n++;
        }
        return n;
    }
}

class Car extends Vehicle {
    // could make the name list longer to avoid as many duplicates if you like...
    static List<String> names = Arrays.asList("Probe","Escort","Taurus","Fiesta");
    static Namer namer = new Namer(names);
    Car() {
        super();
        type = Enums.VehicleType.Car;
        name = namer.getNext();  // every new car gets a new name
        cost = getCost(10000,20000);
        price = cost * 2;
        repair_bonus = 100;
        wash_bonus = 20;
        sale_bonus = 500;
    }
}

class Performance extends Vehicle {
    static List<String> names = Arrays.asList("Europa","Cayman","Corvette","Mustang");
    static Namer namer = new Namer(names);
    Performance() {
        super();
        type = Enums.VehicleType.Super;
        name = namer.getNext();  // every new perf car gets a unique new name
        cost = getCost(20000,40000);
        price = cost * 2;
        repair_bonus = 300;
        wash_bonus = 100;
        sale_bonus = 1000;
    }
}

class Pickup extends Vehicle {
    static List<String> names = Arrays.asList("Ranger","F-250","Colorado","Tundra");
    static Namer namer = new Namer(names);
    Pickup() {
        super();
        type = Enums.VehicleType.Pickup;
        name = namer.getNext();  // every new truck gets a unique new name
        cost = getCost(10000,40000);
        price = cost * 2;
        repair_bonus = 200;
        wash_bonus = 75;
        sale_bonus = 750;
    }
}

class Electric extends Vehicle {
    static List<String> names = Arrays.asList("Model S P90D", "Taycon Turbo S", "Cybertruck", "Bolt", "Model X 100D");
    static Namer namer = new Namer(names);
    Electric() {
        super();
        type = Enums.VehicleType.Electric;
        name = namer.getNext();
        cost = getCost(300000, 500000);
        price = cost * 2;
        repair_bonus = 300;
        wash_bonus = 100;
        sale_bonus = 1000; 
        range = Utility.rndFromRange(60, 400);
    }
}

//need to add engine size with the proper math involved
class Motorcyclce extends Vehicle {
    static List<String> names = Arrays.asList("Chopper", "Scooter", "Roadster", "Touring", "Scrambler", "Cruiser");
    static Namer namer = new Namer(names);
    Motorcyclce() {
        super();
        type = Enums.VehicleType.Motorcyclce;
        name = namer.getNext();
        cost = getCost(100000, 20000);
        price = cost * 2;
        repair_bonus = 150;
        wash_bonus = 25;
        sale_bonus = 50;
    }
}
//add more names to monster truck names
class Monster extends Vehicle {
    static List<String> names = Arrays.asList("Alien Invasion", "Avenger", "Bad Company", "Blue Thunder", "Ghost Rider", "Black Pearl");
    static Namer namer = new Namer(names);
    Monster() {
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


class Hyper extends Vehicle {
    static List<String> names = Arrays.asList("Bugatti Chiron", "Bugatti Veyron", "Ferrari Enzo", "McLaren P1", "McLaren F1", "Koenigsegg Agera RS");
    static Namer namer = new Namer(names);
    Hyper() {
        super();
        type = Enums.VehicleType.Hyper;
        name = namer.getNext();
        cost = getCost(100000, 200000);
        price = cost * 2;
        repair_bonus = 1000;
        wash_bonus = 500;
        sale_bonus = 3000;
    }
}

class F1 extends Vehicle {
    static List<String> names = Arrays.asList("F1-75", "MCL36", "A522", "AT03", "C42", "VF-22", "A522", "RB18");
    static Namer namer = new Namer(names);
    F1() {
        super();
        type = Enums.VehicleType.F1;
        name = namer.getNext();
        cost = getCost(100000, 200000);
        price = cost * 2;
        repair_bonus = 1000;
        wash_bonus = 500;
        sale_bonus = 3000;
    }
}

class Super extends Vehicle {
    static List<String> names = Arrays.asList("Audi R8", "Maserati MC20", "Porsche 911 GT3RS", "Chevrolet Corvette", "Lamborghini Huracan STO", "Ferrari 296 GTB", "McLaren 720s", "Ferrari 812 SuperFast");
    static Namer namer = new Namer(names);
    Super() {
        super();
        type = Enums.VehicleType.Super;
        name = namer.getNext();
        cost = getCost(80000, 90000);
        price = cost * 2;
        repair_bonus = 1000;
        wash_bonus = 500;
        sale_bonus = 3000;
    }
}