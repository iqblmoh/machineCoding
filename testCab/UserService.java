package testCab;

public class UserService {
    private static UserService userService = null;

    private UserService(){

    }
    public static UserService getInstance(){
        if(userService==null){
            userService=new UserService();
        }
        return userService;
    }

    private UserDao userDao = UserDao.getInstance();

    public USER registerUser(int age, String name,int no,  Gender gender){
        return userDao.createUser( age,  name, no,   gender);
    }

    public Driver registerDriver(Integer id,int age, String name,int no,  Gender gender,  int numberPlate, String vehicleName, VehicleType type, int x, int y){
        Location location = new Location(x,y);
        Vehicle vehicle = new Vehicle(numberPlate,vehicleName,type,location);
        USER user;
        if(id !=null){
            user=userDao.getUserMap().get(id);
        }
        else{
            user = registerUser(age,name,no,gender);
        }
        return userDao.createDriver( user,vehicle );
    }


    public Rider registerRider(Integer id,int age, String name,int no,  Gender gender,  int x, int y){
        Location location = new Location(x,y);
        USER user;
        if(id !=null){
            user=userDao.getUserMap().get(id);
        }
        else{
            user = registerUser(age,name,no,gender);
        }
        return userDao.createRider( user,location );
    }



}
