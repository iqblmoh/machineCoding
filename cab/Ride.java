package cab;

public class Ride {

	private Driver driver;
	private Rider ride;
	private Location fromLocation;
	private Location toLocation;
	
	public Ride(Driver drive, Rider rider, Location fromLocation,Location toLocation) {
		this.driver = driver;
		this.ride = ride;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Rider getRide() {
		return ride;
	}
	public void setRide(Rider ride) {
		this.ride = ride;
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
