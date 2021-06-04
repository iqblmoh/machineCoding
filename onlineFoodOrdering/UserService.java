package onlineFoodOrdering;

public class UserService {
    private static UserService instance = null;
    private UserService(){

    }
    public static UserService getInstance(){
        if(instance==null){
            instance=new UserService();
        }
        return instance;
    }
    UserDao userDao=UserDao.getInstance();
    public User registerUser(Long phone, String name, Long pinCode, Gender gender){
        if(phone==null || phone<=0 ){
            System.out.println("Phone number can not be null\n");
            return null;
        }
        else if(pinCode==null || pinCode<=0){
            System.out.println("invalid value for pinCode\n");
            return null;
        }
        else if(name.isEmpty()){
            System.out.println("invalid value for name\n");
            return null;
        }
        return userDao.registerUser(phone, name, pinCode, gender);
    }

    public User login(Long id){
        return  userDao.login(id);
    }
}
