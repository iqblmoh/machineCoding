package tinder;

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

    private Dao userDao = Dao.getInstance();

    public User registerUser(int age, String name,String no,  Gender gender,int x,int y){
        return userDao.createUser(age,name,no,gender,new Location(x,y));
    }

    public User deactivateAccount(User user){
        user.setActive(false);
        user.getUserActionTypeMap().clear();
        for(Match match : user.getMatches()){
            if(match.getUser1().equals(user) || match.getUser2().equals(user)){
                userDao.getMatchMap().remove(match.getId());

            }
        }
        user.getMatches().clear();
        for(User user1: user.getUsersWhoLikedYou()){
            user1.getUserActionTypeMap().remove(user);
        }
        for(Match match : userDao.getMatchMap().values()){
            if(match.getUser1().equals(user) || match.getUser2().equals(user)){
                userDao.getMatchMap().remove(match.getId());
            }
        }
        return user;
    }

}
