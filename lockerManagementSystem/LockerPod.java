package lockerManagementSystem;

import java.util.List;

public class LockerPod {
    private Integer Id;
    List<Locker> smallLockers;
    List<Locker> largeLockers;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public List<Locker> getLargeLockers() {
        return largeLockers;
    }

    public void setLargeLockers(List<Locker> largeLockers) {
        this.largeLockers = largeLockers;
    }

    public List<Locker> getSmallLockers() {
        return smallLockers;
    }

    public void setSmallLockers(List<Locker> smallLockers) {
        this.smallLockers = smallLockers;
    }
}
