import java.util.Arrays;
import java.util.Random;

public abstract class Vehicle {
    public static final String[] CAR_BRANDS = {"BMW", "Honda", "Suzuki",
            "VW", "Ferrari", "Alfa Romeo", "Mercedes", "Maserati", "Tesla"};
    public static final String[] MOTORCYCLE_BRANDS = {"BMW", "Honda", "Suzuki",
            "Ducati", "Moto Guzzi", "Kawasaki"};
    public static final String[] BICYCLE_BRANDS = {"Bianchi", "Giant", "Trek", "Scott", "Fuji"};
    private static final Random RANDOM = new Random();
    private String brand;
    private int wheels;

    /**
     * Creates a new vehicle.
     *
     * @param brand  the brad
     * @param wheels the number of wheels on the vehicle. Must be positive.
     */
    public Vehicle(String brand, int wheels) {
        this.brand = brand;
        setWheels(wheels);
    }

    /**
     * Counts how many vehicles have a motor in a given array.
     *
     * @param vehicles an array of vehicles
     * @return number of motorized Objects in array
     */
    private static int countMotorized(Vehicle[] vehicles) {
        int count = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Motorcycle || vehicles[i] instanceof Car) {
                if (((Motorized) vehicles[i]).isStarted()) {
                    count++;
                }

            }
        }
        return count;
    }

    /**
     * Filters all cars with running motor from a given array.
     *
     * @param vehicles an array of vehicles
     * @return an array of vehicles containing only Cars with running motor
     */
    public static Vehicle[] getStartedCars(Vehicle[] vehicles) {
        Vehicle[] ret = new Vehicle[1];
        int index = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Car && ((Car) vehicles[i]).isStarted()) {
                ret[index] = vehicles[i];
                index++;
                ret = Arrays.copyOf(ret, ret.length + 1);
            }
        }
        return ret;
    }

    /**
     * Creates an array of random Vehicles. Type is random, brand is random. If the vehicle has a motor, the power is
     * also randomized.
     *
     * @param n the number of desired Vehicels
     * @return an array of random Vehicles.
     */
    public static Vehicle[] getNRandom(int n) {
        Vehicle[] ret = new Vehicle[n];
        String brand;

        for (int i = 0; i < n; i++) {
            int randVehicle = RANDOM.nextInt(3);
            double power = RANDOM.nextDouble(100);
            boolean motorRunning = RANDOM.nextBoolean();

            switch (randVehicle) {
                case 0 -> {
                    brand = CAR_BRANDS[RANDOM.nextInt(CAR_BRANDS.length)];
                    ret[i] = new Car(brand, power, RANDOM.nextBoolean());
                }
                case 1 -> {
                    brand = MOTORCYCLE_BRANDS[RANDOM.nextInt(MOTORCYCLE_BRANDS.length)];
                    ret[i] = new Motorcycle(brand, 2, power, motorRunning);
                }
                case 2 -> {
                    brand = BICYCLE_BRANDS[RANDOM.nextInt(BICYCLE_BRANDS.length)];
                    ret[i] = new Bicycle(brand);
                }
            }
        }
        return ret;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        if (wheels <= 0) throw new IllegalArgumentException();
        this.wheels = wheels;
    }
};