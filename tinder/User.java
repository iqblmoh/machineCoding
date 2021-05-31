package tinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private  int id;
    private String name;
    private Gender gender;
    private int age;
    private Location location;
    private String mobileNo;
    private Boolean isActive;


    private Map<User,ActionType> userActionTypeMap=new HashMap<>();
    private List<Match>  matches= new ArrayList<>();
    private List<User> usersWhoLikedYou=new ArrayList<>();

    public User(){

    }


    public User(int id, String name, Gender gender, int age, Location location,String mobileNo){
        this.id = id;
        this.age=age;
        this.name=name;
        this.location = location;
        this.gender=gender;
        this.mobileNo=mobileNo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String  mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Map<User, ActionType> getUserActionTypeMap() {
        return userActionTypeMap;
    }

    public void setUserActionTypeMap(Map<User, ActionType> userActionTypeMap) {
        this.userActionTypeMap = userActionTypeMap;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public List<User> getUsersWhoLikedYou() {
        return usersWhoLikedYou;
    }

    public void setUsersWhoLikedYou(List<User> usersWhoLikedYou) {
        this.usersWhoLikedYou = usersWhoLikedYou;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
