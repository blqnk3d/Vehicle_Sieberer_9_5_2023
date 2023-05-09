import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MotorcycleTest {

    Motorcycle motorcycle;

    @BeforeEach
    void setUp(){
        motorcycle = new Motorcycle("teting",2);
    }

    @Test
    void checkConst(){
        assertThrows(IllegalArgumentException.class, ()-> new Motorcycle("test",-4));
    }


    @org.junit.jupiter.api.Test
    void start() {
        motorcycle.start();
        assertTrue(motorcycle.isStarted());
    }

    @org.junit.jupiter.api.Test
    void stop() {
        motorcycle.start();
        assertTrue(motorcycle.isStarted());
        motorcycle.stop();
        assertFalse(motorcycle.isStarted());
    }

    @org.junit.jupiter.api.Test
    void isStarted() {
        motorcycle.start();
        assertTrue(motorcycle.isStarted());
    }

    @org.junit.jupiter.api.Test
    void getPower() {
        assertEquals(2,motorcycle.getPower());
    }

    @org.junit.jupiter.api.Test
    void setPower() {
        assertThrows(IllegalArgumentException.class,()-> motorcycle.setPower(-2));
        motorcycle.setPower(123);
        assertEquals(123,motorcycle.getPower());
    }
}