package flipPod;

public enum LockerSize {

    SMALL(1),LARGE(2);

    private final Integer value;

    LockerSize(Integer a){
        this.value=a;
    }

    public Integer getValue() {
        return value;
    }
}
