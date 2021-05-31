package testCab;

import java.util.ArrayList;
import java.util.List;

public class Rider extends USER {
    private Location location;

    private List<Ride> rideList= new ArrayList<>();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Ride> getRideList() {
        return rideList;
    }

    public void setRideList(List<Ride> rideList) {
        this.rideList = rideList;
    }
}
