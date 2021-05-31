package testCab;

public enum  VehicleType {
    TWO_SEATER(2),FOUR_SEATER(4),SIX_SEATER(6);
    private final Integer numberOfSeats;

    VehicleType(Integer s) {
        this.numberOfSeats=s;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

}
