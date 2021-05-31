package cab;

public class DriverClass {


	public static void main(String[] args) {
		CabBookingService cabService = CabBookingService.getInstance();
		
		Location location1 = new Location(1,1);
		Vehicle vehicle1 = new Car("Swift","1242",location1);
		Driver d1= null;
		try {
			d1 = cabService.registerDriver(1,"D1", 20, "male", vehicle1);
			System.out.println(d1.getId());
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Location location2 = new Location(2,5);
		Vehicle vehicle2 = new Car("Swift","1242",location2);

//		try {
//			Driver driver2 = cabService.registerDriver(2,"D2", 20, "female", vehicle2);
//			System.out.println(driver2.getId());
//		} catch (CreateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		Rider r1 = null;
		Rider r2 = null;
		try {
			r1 = cabService.registerRider(11,"R1", 20, "male", new Location(0,0));
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			r2 = cabService.registerRider(12,"R2", 25, "male", new Location(5,2));
//		} catch (CreateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		System.out.println(cabService.bookRide(11, new Location(0,0), new Location(10,10)));
		
		
		cabService.switchAvailability(1, Boolean.TRUE);
		
		System.out.println(cabService.bookRide(11, new Location(0,0), new Location(10,10)));		
		
		
	}


}
