package flipPod;

import com.sun.org.apache.xpath.internal.operations.Or;

public class UserService {
    private static UserService userService = null;
    private Dao dao = Dao.getInstance();
    private UserService(){

    }
    public static UserService getInstance(){
        if(userService==null){
            userService=new UserService();
        }
        return userService;
    }

    public Customer createCustomer(String name,int age,long contactNumber,String address){
        return dao.createCustomer(name, age, contactNumber, address);
    }
    public LockerPod creareLockerPod(int a,int b){
        return dao.createLockerPod(a,b);
    }
    public Order placeOrder(int customerId,String item, LockerSize orderSize ,LockerPod lockerPod){
        return dao.placeOrder(customerId,item,lockerPod,orderSize);
    }
//    public Order pickOrder(int customerid, int orderId){
//
//    }
}
