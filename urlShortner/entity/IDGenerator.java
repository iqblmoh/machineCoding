package urlShortner.entity;

public class IDGenerator {
    private static Integer id = 0;

    public static Integer getId(){
        id++;
        return id;
    }
}
