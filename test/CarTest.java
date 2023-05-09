import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car ;
    @BeforeEach
    void  setUp(){
        car = new Car("Brand",5);
    }

    @org.junit.jupiter.api.Test
    void start() {
        car.start();
        assertTrue(car.isStarted());
    }

    @org.junit.jupiter.api.Test
    void stop() {
        car.start();
        assertTrue(car.isStarted());
        car.stop();
        assertFalse(car.isStarted());
    }

    @org.junit.jupiter.api.Test
    void isStarted() {
        car.start();
        assertTrue(car.isStarted());
    }

    @org.junit.jupiter.api.Test
    void getPower() {
        assertEquals(5,car.getPower());
    }

    @org.junit.jupiter.api.Test
    void setPower() {
        assertThrows(IllegalArgumentException.class,()-> car.setPower(-2));
        car.setPower(123);
        assertEquals(123,car.getPower());
    }
}