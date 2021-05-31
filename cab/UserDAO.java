package cab;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {

	public static UserDAO userDAO = null;
	
	public Map<Integer,Rider> riderMap = new HashMap<Integer,Rider>();
	
	public Map<Integer,Driver> driverMap = new HashMap<Integer,Driver>();
	
	public Map<String,Vehicle> vehicleMap = new HashMap<String,Vehicle>();
	
	private UserDAO() {

	}

	public static UserDAO getInstance() {
		if(userDAO == null) {
			return new UserDAO();
		}

		return userDAO;
	}
	
	public Driver createDriver(int id,String name,int age,Gender gender,Vehicle vehicle) throws CreateException{
		Driver driver = new Driver(id,name,age,gender,vehicle);
		if(driver == null || driverMap.containsKey(driver.getId())) {
			throw new CreateException();
		}
		driverMap.put(driver.getId(), driver);
		vehicleMap.put(driver.getVehicle().getVenhicleNumber(),vehicle);
		return driver;
	}

	public Rider createRider(int id,String name, int age, Gender gender, Location location) throws CreateException{
		Rider rider = new Rider(id,name,age,gender,location);
		if(rider == null || riderMap.containsKey(rider.getId())) {
			throw new CreateException();
		}
		riderMap.put(rider.getId(), rider);
		
		return rider;
	}
	
	public boolean updateLocation(String vehicleNumber, Location location) throws VehicleDoesNotExistException{
		if(vehicleMap.containsKey(vehicleNumber)) {
			vehicleMap.get(vehicleNumber).setLocation(location);
			return true;
		}else {
			throw new VehicleDoesNotExistException();
		}
	}

	public boolean toggleAvailability(int id,boolean val) throws DriverNotFoundException {
		if(driverMap.containsKey(id)) {
			driverMap.get(id).setAvailable(val);
		}else {
			throw new DriverNotFoundException();
		}
		return true;
	}
	
	public static UserDAO getUserDAO() {
		return userDAO;
	}

	public static void setUserDAO(UserDAO userDAO) {
		UserDAO.userDAO = userDAO;
	}

	public Map<Integer, Rider> getRiderMap() {
		return riderMap;
	}

	public void setRiderMap(Map<Integer, Rider> riderMap) {
		this.riderMap = riderMap;
	}

	public Map<Integer, Driver> getDriverMap() {
		return driverMap;
	}

	public void setDriverMap(Map<Integer, Driver> driverMap) {
		this.driverMap = driverMap;
	}
	
	

}
