package lockerManagementSystem;

public class Order {
    private int id;
    private int customerId;
    private boolean isLockerAllocated;
    private String itemName;
    private boolean isPicked;
    private Integer lockerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isLockerAllocated() {
        return isLockerAllocated;
    }

    public void setLockerAllocated(boolean lockerAllocated) {
        isLockerAllocated = lockerAllocated;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }

    public Integer getLockerId() {
        return lockerId;
    }

    public void setLockerId(Integer lockerId) {
        this.lockerId = lockerId;
    }
}
