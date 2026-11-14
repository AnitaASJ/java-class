import java.util.ArrayList;

// Abstract parent class
abstract class Vehicle {

    double fuelCapacity;

    // Constructor
    Vehicle(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    // Abstract method
    abstract double calculateRange();
}

// Car class
class Car extends Vehicle {

    Car(double fuelCapacity) {
        super(fuelCapacity);
    }

    @Override
    double calculateRange() {
        return fuelCapacity / 10;
    }
}

// Truck class
class Truck extends Vehicle {

    Truck(double fuelCapacity) {
        super(fuelCapacity);
    }

    @Override
    double calculateRange() {
        return fuelCapacity / 5;
    }
}

// Motorcycle class
class Motorcycle extends Vehicle {

    Motorcycle(double fuelCapacity) {
        super(fuelCapacity);
    }

    @Override
    double calculateRange() {
        return fuelCapacity / 15;
    }
}

// Logistics class
class Logistics {

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    // Method to add vehicles
    void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Method to display ranges
    void displayRanges() {

        for (Vehicle vehicle : vehicles) {

            System.out.println(
                vehicle.getClass().getSimpleName()
                + " Range = "
                + vehicle.calculateRange()
                + " km"
            );
        }
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        // Create Logistics object
        Logistics logistics = new Logistics();

        // Create vehicles
        Car car = new Car(100);
        Truck truck = new Truck(150);
        Motorcycle motorcycle = new Motorcycle(90);

        // Add vehicles to logistics
        logistics.addVehicle(car);
        logistics.addVehicle(truck);
        logistics.addVehicle(motorcycle);

        // Display ranges
        logistics.displayRanges();
    }
}