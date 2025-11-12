interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String number, String type, double rate) {
        this.vehicleNumber = number;
        this.type = type;
        this.rentalRate = rate;
    }

    public double getRentalRate() { return rentalRate; }
    public String getType() { return type; }

    public abstract double calculateRentalCost(int days);

    public void displayVehicle() {
        System.out.println("Vehicle: " + type + ", Number: " + vehicleNumber + ", Rate: " + rentalRate);
    }
}

class Car extends Vehicle implements Insurable {
    public Car(String number, double rate) { super(number, "Car", rate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days; }
    public double calculateInsurance() { return 1000; }
    public String getInsuranceDetails() { return "Car Insurance: Rs.1000"; }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String number, double rate) { super(number, "Bike", rate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days; }
    public double calculateInsurance() { return 500; }
    public String getInsuranceDetails() { return "Bike Insurance: Rs.500"; }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String number, double rate) { super(number, "Truck", rate); }
    public double calculateRentalCost(int days) { return getRentalRate() * days; }
    public double calculateInsurance() { return 2000; }
    public String getInsuranceDetails() { return "Truck Insurance: Rs.2000"; }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("UP32AB1234", 1500),
            new Bike("UP32XY5678", 500),
            new Truck("UP32TR9999", 2500)
        };

        for (Vehicle v : vehicles) {
            v.displayVehicle();
            System.out.println("Rental(5 days): " + v.calculateRentalCost(5));
            if (v instanceof Insurable) {
                System.out.println(((Insurable)v).getInsuranceDetails());
            }
        }
    }
}
