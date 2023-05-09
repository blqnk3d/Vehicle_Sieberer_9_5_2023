import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BicycleTest {

    @Test
    void checkConst(){
     assertThrows(IllegalArgumentException.class, ()-> new Bicycle("test",4));
     assertThrows(IllegalArgumentException.class, ()-> new Bicycle("test",1));
     assertEquals(2, new Bicycle("test").getWheels());
    }
}