import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class UtilityTest{
    @Test
    public void testUtilityFromRange(){
        //testing to see if it can make a vehicle
        int randomInt = Utility.rndFromRange(1, 2);
        if (randomInt == 1 || randomInt == 2){
            assert(true);
        }
        else{
            assert(false);
        }
        }
    
    }