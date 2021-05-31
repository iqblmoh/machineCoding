package testCab;

public class Ride {

    private int id;
    private Rider rider;
    private Driver driver;
    private Location fromLocation;
    private Location toLocation;

    public Ride(int id,Rider rider, Driver driver, Location from , Location to){
        this.id=id;
        this.rider = rider;
        this.driver=driver;
        this.fromLocation=from;
        this.toLocation=to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Location fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }
}
