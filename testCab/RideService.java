package testCab;

import cab.DriverNotAvailableException;

import java.util.List;

public class RideService {
    private static RideService rideService = null;

    private UserDao userDao=UserDao.getInstance();

    private RideService(){

    }
    private static Integer MAX_DISTANCE =  3;

    public static RideService getInstance(){
        if(rideService==null){
            rideService=new RideService();
        }
        return rideService;
    }

    public int distance(Location l1,Location l2) {
        return Math.abs(l1.getX() - l2.getX()) + Math.abs(l1.getY() - l2.getY());
    }

    public  Driver bookRide(int riderId, Location from, Location to) throws DriverNotAvailableException {
        Rider rider = userDao.getRiderMap().get(riderId);
        Driver driver = fetchAllDrivers(from);
        if(driver==null){
            throw new  DriverNotAvailableException();
        }
        driver.setAvailable(false);
        Ride ride = new Ride(IDgenerator.getId(),rider,driver,from,to);
        driver.getRideList().add(ride);
        rider.getRideList().add(ride);
        System.out.println("Ride Booked for rider "+ rider.getId()+". Your Driver is "+driver.getName()+". Ride id "+ride.getId());
        return driver;
    }

    public Driver fetchAllDrivers(Location from){

        for(Driver driver : userDao.getDriverMap().values()){
            if(driver.isAvailable() && distance(driver.getVehicle().getLocation(),from) < MAX_DISTANCE){
                return driver;
            }
        }
        return null;
    }
}
