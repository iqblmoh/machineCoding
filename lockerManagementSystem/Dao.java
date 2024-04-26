package lockerManagementSystem;

import java.util.*;

public class Dao {
    private static Dao dao = null;
    private Dao(){

    }
    public static Dao getInstance(){
        if(dao==null){
            dao= new Dao();
        }
        return dao;
    }
    Map<Integer,Customer> customerMap = new HashMap<>();
    Map<Integer,Order> orderMap = new HashMap<>();
    Map<Integer,LockerPod> lockerPodMap = new HashMap<>();
    Queue<Order> orderQueue = new LinkedList<>();

    public Customer createCustomer(String name,int age,long contactNumber,String address){
        Customer customer = new Customer(IdGenerator.getId(),name,age,contactNumber,address);
        System.out.println("New customer has been created  with name "+ name);
        System.out.println("New customer has been created  with Id "+ customer.getId());
        customerMap.put(customer.getId(),customer);
        return customer;
    }

    public LockerPod createLockerPod(int numberOfSmallLocker, int numberOfLargeLocker){
        LockerPod lockerPod = new LockerPod();
        lockerPod.setId(IdGenerator.getId());
        List<Locker> smallLockers= new ArrayList<>();
        for(int i=0;i<numberOfSmallLocker;i++){
            Locker locker = new Locker();
            locker.setId(IdGenerator.getId());
            locker.setSize(LockerSize.SMALL);
            locker.setOccupied(false);
            smallLockers.add(locker);
        }

        List<Locker> largeLockers= new ArrayList<>();
        for(int i=0;i<numberOfLargeLocker;i++){
            Locker locker = new Locker();
            locker.setId(IdGenerator.getId());
            locker.setSize(LockerSize.LARGE);
            locker.setOccupied(false);
            largeLockers.add(locker);
        }
        lockerPod.setLargeLockers(largeLockers);
        lockerPod.setSmallLockers(smallLockers);
        lockerPodMap.put(lockerPod.getId(),lockerPod);
        System.out.println("new Locked pod has been created");

        return lockerPod;
    }
    public Order placeOrder(int customerId, String item, LockerPod lockerPod, LockerSize size){
        Order order  = new Order();
        order.setId(IdGenerator.getId());
        order.setCustomerId(customerId);
        order.setItemName(item);
        List<Locker> lockers = new ArrayList<>();
        if(size.equals(LockerSize.SMALL)){
            lockers=lockerPod.getSmallLockers();
        }
        else if(size.equals(LockerSize.LARGE)){
            lockers=lockerPod.getLargeLockers();
        }
        for(Locker locker : lockers){
            if(locker.isOccupied()==false){
                locker.setOccupied(true);
                order.setLockerId(locker.getId());
                orderMap.put(customerId,order);
                System.out.println("Order successfully placed and locker has been assigned to the order");
                return order;
            }
        }
        System.out.println("Order successfully placed and but locker has not been assigned to the order");
        orderQueue.add(order);
        return order;
    }

}
