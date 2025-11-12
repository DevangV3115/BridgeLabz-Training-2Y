interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class VehicleRide {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    public VehicleRide(int id, String driver, double rate) {
        this.vehicleId = id;
        this.driverName = driver;
        this.ratePerKm = rate;
    }

    public double getRatePerKm() { return ratePerKm; }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("VehicleID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: " + ratePerKm);
    }
}

class CarRide extends VehicleRide implements GPS {
    private String location;
    public CarRide(int id, String driver, double rate) { super(id, driver, rate); }
    public double calculateFare(double distance) { return distance * getRatePerKm(); }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}

class BikeRide extends VehicleRide implements GPS {
    private String location;
    public BikeRide(int id, String driver, double rate) { super(id, driver, rate); }
    public double calculateFare(double distance) { return distance * getRatePerKm(); }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}

class AutoRide extends VehicleRide implements GPS {
    private String location;
    public AutoRide(int id, String driver, double rate) { super(id, driver, rate); }
    public double calculateFare(double distance) { return distance * getRatePerKm(); }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}

public class RideHailingApp {
    public static void main(String[] args) {
        VehicleRide[] rides = {
            new CarRide(1, "Amit", 15),
            new BikeRide(2, "Raj", 8),
            new AutoRide(3, "Suresh", 12)
        };

        for (VehicleRide v : rides) {
            v.getVehicleDetails();
            System.out.println("Fare (10 km): " + v.calculateFare(10));
        }
    }
}
