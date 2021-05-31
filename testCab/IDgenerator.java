package testCab;

public class IDgenerator {
    private static int id=0;

    public static int getId() {
        id++;
        return id;
    }

    public static void setId(int id) {
        IDgenerator.id = id;
    }
}
