public class Motorcycle extends Vehicle implements Motorized {
    private double power;
    private boolean started;

    public Motorcycle(String brand, double power) {
        this(brand,2,power,false);
    }

    public Motorcycle(String brand, int wheels, double power, boolean started) {
        super(brand, wheels);
        setPower(power);
        this.started = started;
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
        if (power < 0) throw new IllegalArgumentException();
        this.power = power;
    }
}
