package tinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {
    private static Dao userDao=null;


    public Map<Integer,User> userMap = new HashMap<Integer,User>();

    public Map<Integer,Match> matchMap = new HashMap<>();

    public HashMap<String,Integer> phoneMap = new HashMap<>();

    private Dao(){

    }
    public static  Dao getInstance(){
        if(userDao==null){
            userDao=new Dao();
        }
        return userDao;
    }
    public User createUser(int age, String name,String no,  Gender gender, Location location){
        if(phoneMap.containsKey(no)){
            User user= userMap.get(phoneMap.get(no));
            System.out.println("user already exist with id "+user.getId());
            return user;
        }
        User user = new User();
        user.setId(IDgenerator.getId());
        user.setAge(age);
        user.setGender(gender);
        user.setMobileNo(no);
        user.setName(name);
        user.setLocation(location);
        user.setActive(Boolean.TRUE);
        System.out.println("New User has been created. Name: "+name+" userId: "+user.getId()+"\n" );
        userMap.put(user.getId(),user);
        phoneMap.put(no,user.getId());
        return user;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }

    public Map<Integer, Match> getMatchMap() {
        return matchMap;
    }

    public void setMatchMap(Map<Integer, Match> matchMap) {
        this.matchMap = matchMap;
    }
}
