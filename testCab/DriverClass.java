package testCab;

import cabBooking.service.CabBookingService;

public class DriverClass {



    private BookingService bookingService = BookingService.getInstance();
    public static void main(String args[]){
        UserService userService = UserService.getInstance();

        RideService rideService = RideService.getInstance();

        System.out.println("Execution started");

        Rider rider = userService.registerRider(null,20,"Iqbal",70662960,Gender.MALE,0,0);
        Rider rider1 = userService.registerRider(null,22,"Emma",706162960,Gender.FEMALE,0,1);
        Driver driver = userService.registerDriver(null,25,"ramesh",1234,Gender.MALE,1234,"HONDA",VehicleType.TWO_SEATER,1,1);
        Driver driver1 = userService.registerDriver(null,25,"sourav",12345,Gender.MALE,1235,"HONDA",VehicleType.FOUR_SEATER,0,0);

        try {
            rideService.bookRide(rider.getId(),new Location(0,0) , new Location(0,1));
        } catch (CabBookingService.DriverNotAvailableException e) {
            System.out.println("No driver available, please try later");
            e.printStackTrace();
        }
        System.out.println("Execution completed");
    }
}