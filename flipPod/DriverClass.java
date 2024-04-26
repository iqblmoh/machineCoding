package flipPod;

public class DriverClass {



    public static void main(String args[]){
        UserService userService  = UserService.getInstance();
        System.out.println("Execution started");
        Customer c1 = userService.createCustomer("Iqbal",21,7,"abc xyz rajasthan");
        LockerPod lockerPod = userService.creareLockerPod(5,5);
        Order order = userService.placeOrder(c1.getId(),"Mobile",LockerSize.SMALL,lockerPod);

        System.out.println("Execution completed");
    }
}