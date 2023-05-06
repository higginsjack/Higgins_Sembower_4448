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
    public void reportOut() {
        File l = new File("data/leader.csv");
        try{
            FileWriter fileWriter = new FileWriter(l);
            fileWriter.write("Name,Score,Date,\n");

            System.out.println(data);
            String[] split = data.split(",");
            for(int i=3; i < split.length; i+=3) {
                fileWriter.write(split[i] + "," + split[i+1] + "," + split[i+2] + ",\n");
            }

            System.out.println(data);
            fileWriter.flush();
            fileWriter.close();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static Tracker getInstance(){ // Lazy instantiation for Singleton
        return instance;
    }
}