import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Vehicle[] test = Vehicle.getNRandom(100);

    @Test
    void getNRandomTest(){
        assertEquals(100,test.length);
    }

    @Test
    void getStartedCarsTest(){
        Vehicle[] testArray = new Vehicle[]{new Car("test",2,true),
                new Car("test",2,false),
                new Car("test",2,true),
                new Car("test",2,false),
                new Car("test",2,false),
                new Car("test",2,false),
                new Car("test",2,true),
                new Car("test",2,false),
                new Car("test",2,false),
        };
        assertEquals(3,Vehicle.getStartedCars(testArray));

    }
}