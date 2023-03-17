import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class askTimeCommand implements Command {

    @Override
    public void execute() {
        java.util.Date date = new java.util.Date();    
        System.out.println(date);
    }
    
}
