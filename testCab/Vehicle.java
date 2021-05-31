package testCab;


public class Vehicle {
    private int numberPlate;
    private String vehicleName;
    private VehicleType type;
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle(int numberPlate, String vehicleName, VehicleType type, Location location){
        this.numberPlate=numberPlate;
        this.vehicleName=vehicleName;
        this.type=type;
        this.location=location;
    }
    public int getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(int numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
