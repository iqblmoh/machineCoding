package cab;

public class UserService {
	
	public static UserService userService = null;

	private UserDAO userDAO = UserDAO.getInstance();
	
	private UserService() {

	}

	public static UserService getInstance() {
		if(userService == null) {
			return new UserService();
		}

		return userService;
	}
	
	public Driver registerDriver(int id,String name,int age,Gender gender,Vehicle vehicle) throws CreateException{
		return userDAO.createDriver(id,name,age,gender,vehicle);
	}
	
	public Rider registerRider(int id,String name,int age,Gender gender,Location location) throws CreateException{
		return userDAO.createRider(id,name,age,gender,location);
	}
	
	
	public boolean updateLocation(String vehicleNumber,Location location) throws VehicleDoesNotExistException{
		return userDAO.updateLocation(vehicleNumber,location);
	}
	
	public boolean toggleDriverAvailability(int driverId, boolean val) throws DriverNotFoundException{
		return userDAO.toggleAvailability(driverId, val);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
}
