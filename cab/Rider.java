package cab;

import java.util.ArrayList;
import java.util.List;

public class Rider extends User {
	
	private Location location;
	private List<Ride> rides = new ArrayList<Ride>();
	
	public Rider(int id,String name, int age, Gender gender, Location location) {
		super(id,name,age,gender);// TODO Auto-generated constructor stub;
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Ride> getRides() {
		return rides;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}
	
}
