import java.util.ArrayList;

public class Invoker {
    Command command;
    ArrayList<Command> commands = new ArrayList<>();
    public Invoker(Command command) {
        this.command=command;
    }
    public Command getCommand(){
        return this.command;
    }
    public void executeCommand(){
        command.execute();
    }
    public void setCommand(Command command){
        this.command = command;
    }
}
