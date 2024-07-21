public class Car {
    private String make;
    private String model;
    private int year;
    private String driverName;
    private int speed;
    private int gear;

    // Constructor
    public Car(String make, String model, int year, String driverName) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.driverName = driverName;
        this.speed = 0; // Initial speed
        this.gear = 1;  // Initial gear
    }

    // Method to increase gear
    public void increaseGear() {
        if (gear < 5) { // Assuming 5 is the maximum gear
            gear++;
            System.out.println("Gear increased to: " + gear);
        } else {
            System.out.println("Already in highest gear.");
        }
    }

    // Method to decrease gear
    public void decreaseGear() {
        if (gear > 1) { // Assuming 1 is the minimum gear
            gear--;
            System.out.println("Gear decreased to: " + gear);
        } else {
            System.out.println("Already in lowest gear.");
        }
    }

    // Method to increase speed
    public void increaseSpeed(int increment) {
        speed += increment;
        System.out.println("Speed increased to: " + speed + " km/h");
    }

    // Method to decrease speed
    public void decreaseSpeed(int decrement) {
        if (speed >= decrement) {
            speed -= decrement;
            System.out.println("Speed decreased to: " + speed + " km/h");
        } else {
            System.out.println("Speed cannot be less than 0 km/h");
        }
    }

    // Method to display car information
    public void displayCarInfo() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Current Speed: " + speed + " km/h");
        System.out.println("Current Gear: " + gear);
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020, "Jane Smith");
        car.displayCarInfo();
        
        car.increaseGear();
        car.increaseSpeed(20);
        car.displayCarInfo();

        car.decreaseSpeed(10);
        car.decreaseGear();
        car.displayCarInfo();
    }
}
