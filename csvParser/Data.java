package csvParser;

public class Data {
    private int id;
    private String name;
    private int salary;
    private String designation;
    private int age;


    public Data(int id, String name, int salary, int age, String designation){
        this.id=id;
        this.salary=salary;
        this.age=age;
        this.designation=designation;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
