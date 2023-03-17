import java.io.File;  
import java.io.IOException;  
import java.io.FileWriter;   // Import the FileWriter class

public class Logger implements Observer{

    private static int day = 0;

    public void update(String msg) {
        reportOut(msg);
        try {
            String filename = "Logger" + getday() + "n.txt";
            File myObj = new File(filename);
            if (myObj.createNewFile()) { //file created - write
                FileWriter myWriter = new FileWriter(filename);
                myWriter.write(msg + "\n");
                myWriter.close();
            } 
            else {
                FileWriter myWriter = new FileWriter(filename, true);
                myWriter.write(msg + "\n");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }          
    }
    public static int getday(){
        return day;
    }
    public static void increaseDay(){
        day++;
    }
    public void reportOut(String msg){
        System.out.println(msg);
    }
}