package onlineFoodOrdering;

import java.util.List;


public class DriverClass{
    public static void main(String[] args){
        System.out.println("Execution started");
        UserService userService = UserService.getInstance();
        RestaurantService restaurantService = RestaurantService.getInstance();
        OrderService orderService = OrderService.getInstance();

        User user1 = userService.registerUser(9898989891L,"User_a",1L,Gender.MALE);
        User user2 = userService.registerUser(9898989892L,"User_b",2L,Gender.MALE);
        User user3 = userService.registerUser(9898989893L,"User_c",3L,Gender.MALE);

        User logIn = userService.login(user1.getPhone());
        Restaurant r1 = restaurantService.registerRestaurant("r_a","1,2,4","pizza",100,10);
        Restaurant r2 = restaurantService.registerRestaurant("r_b","1,4","burger",50,15);
        r1=restaurantService.updateQuantity("r_a",5);
        logIn=userService.login(user2.getPhone());
        Restaurant r3 = restaurantService.registerRestaurant("r_c","2,4","burger",50,15);

        logIn=userService.login(user3.getPhone());

        Restaurant r4 = restaurantService.registerRestaurant("r_d","3,4","burger",50,15);

        logIn=userService.login(user1.getPhone());
        restaurantService.showRestaurant("rating");
        Order order = orderService.placeOrder("r_a",5);
        Review review = restaurantService.rateRestaurant("r_a",5,"good");
        List<Order> orderList=orderService.listOrders();
        restaurantService.showRestaurant("rating");

        System.out.println("Execution ended");
    }
}