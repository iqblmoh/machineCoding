package lockerManagementSystem;

import java.util.List;

public class Customer {
    private int id;
    private String name;
    private int age;
    private long contactNumber;
    private String address;
    private List<Order> orderList;

    public Customer(int id, String name, int age, long contactNumber, String address ){
        this.id=id;
        this.name=name;
        this.age=age;
        this.contactNumber = contactNumber;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
