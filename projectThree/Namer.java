import java.util.Arrays;
import java.util.List;


//random name generator or really a helper function From Prof Bruce

public class Namer {
    List<String> names;
    int pass;
    int nextName;

    Namer(List<String> n){
        names = n;
        pass = 1;
        nextName = 0;
    }

    String getNext(){
        String name = names.get(nextName);
        if (pass>1) name = name + "-" + pass;
        nextName += 1;
        if (nextName == names.size()) { 
            nextName = 0;
            pass = pass + 1;
        }
        return name;
    }
}