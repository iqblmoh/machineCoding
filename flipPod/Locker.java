package flipPod;

public class Locker {
    private  int id;
    private boolean isOccupied;
    private LockerSize size;
    private Integer orderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public LockerSize getSize() {
        return size;
    }

    public void setSize(LockerSize size) {
        this.size = size;
    }
}
