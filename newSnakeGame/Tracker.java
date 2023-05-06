import java.io.FileWriter;
import java.io.File;

public class Tracker implements Observer{
    private static final Tracker instance = new Tracker(); //Singleton pattern
    String data;

    @Override
    public void update(String msg) {
        data+=msg;
    }

    @Override
    public void reportOut() { // Writes to the csv by copying old data, adding new run, then creating new csv of same name.
        File l = new File("data/leader.csv"); 
        try{
            FileWriter fileWriter = new FileWriter(l);
            fileWriter.write("Name,Score,Date,\n"); // Creates column names
            // System.out.println(data);
            String[] split = data.split(",");
            for(int i=3; i < split.length; i+=3) {
                fileWriter.write(split[i] + "," + split[i+1] + "," + split[i+2] + ",\n");
            }

            fileWriter.flush();
            fileWriter.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static Tracker getInstance(){ // Lazy instantiation for Singleton
        return instance;
    }
}