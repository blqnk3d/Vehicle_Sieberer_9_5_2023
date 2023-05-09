public class Car extends Vehicle implements Motorized {
    double power;
    boolean started;

    public Car(String brand, double power, boolean started) {
        super(brand, 4);
        setPower(power);
        this.started = started;
    }

    public Car(String brand, double power) {
       this(brand,power,false);
    }

    @Override
    public void start() {
        started = true;
    }

    @Override
    public void stop() {
    started = false;
    }

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        if (power < 0)
            throw new IllegalArgumentException();

        this.power = power;
    }
}
