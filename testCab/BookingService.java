package testCab;

public class BookingService {

    private static BookingService bookingService = null;

    private RideService rideService = RideService.getInstance();
    private UserService userService = UserService.getInstance();
    private BookingService(){

    }
    public  static BookingService getInstance(){
        if(bookingService==null){
            bookingService=new BookingService();
        }
        return bookingService;
    }
    public Driver registerDriver(Integer id,int age, String name,int no,  Gender gender,  int numberPlate, String vehicleName, VehicleType type, int x, int y)
    {
        return  userService.registerDriver(id, age, name, no, gender, numberPlate, vehicleName, type, x, y);
    }
    public Rider registerRider(Integer id,int age, String name,int no,  Gender gender,   int x, int y)
    {
        return  userService.registerRider(id, age, name, no, gender, x, y);
    }


}
