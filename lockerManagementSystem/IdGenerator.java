package lockerManagementSystem;

public class IdGenerator {
    private static int id=0;

    public static int getId() {
        id++;
        return id;
    }

    public static void setId(int id) {
        IdGenerator.id = id;
    }
}
