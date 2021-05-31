package testCab;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static UserDao userDao=null;


    public Map<Integer,Rider> riderMap = new HashMap<Integer,Rider>();

    public Map<Integer,Driver> driverMap = new HashMap<Integer,Driver>();

    public Map<Integer,Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();

    public Map<Integer,USER> userMap = new HashMap<Integer,USER>();

    private UserDao(){

    }
    public static  UserDao getInstance(){
        if(userDao==null){
            userDao=new UserDao();
        }
        return userDao;
    }
    public USER createUser(int age, String name,int no,  Gender gender){
        USER user = new USER();
        user.setId(IDgenerator.getId());
        user.setAge(age);
        user.setGender(gender);
        user.setMobileNo(no);
        user.setName(name);
        userMap.put(user.getId(),user);
        return user;
    }

    public Driver createDriver(USER user, Vehicle vehicle){

        Driver driver = new Driver();
        driver.setAge(user.getAge());
        driver.setGender(user.getGender());
        driver.setMobileNo(user.getMobileNo());
        driver.setName(user.getName());
        driver.setId(user.getId());
        driver.setAvailable(true);
        driver.setVehicle(vehicle);
        driverMap.put(user.getId(),driver);
        System.out.println("driver Registered with name "+driver.getName()+" with Id "+ driver.getId());

        return driver;
    }

    public Rider createRider(USER user, Location location){
        Rider rider = new Rider();
        rider.setLocation(location);
        rider.setAge(user.getAge());
        rider.setGender(user.getGender());
        rider.setMobileNo(user.getMobileNo());
        rider.setName(user.getName());
        rider.setId(user.getId());
        riderMap.put(rider.getId(),rider);
        System.out.println("Rider Registered with name "+rider.getName()+" with Id "+ rider.getId());
        return rider;
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

    public Map<Integer, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(Map<Integer, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public Map<Integer, USER> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Integer, USER> userMap) {
        this.userMap = userMap;
    }
}
