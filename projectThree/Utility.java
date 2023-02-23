//Utility class for helper functions IDEA FROM BRUCE as well as some code!


import java.text.NumberFormat;
import java.util.Random;

public interface Utility {
    static int randomFromRange(int min, int max) {
        return (int) ((Math.random() * ((max+1) - min)) + min);
    }


    //short random for 0-1
    static double rnd(){
        return Math.random();
    }

    static String asDollar(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(value);
    }


    //utility to get random enum value for any enum 

    static <T extends Enum<?>> randomEnum(Class<T> clazz) { 
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
        }
}