package cab;

public class Car extends Vehicle{

	public Car(String vehicleName,String vehicleNumber,Location location) {
		super(vehicleName,vehicleNumber,location,VehicleType.CAR);
	}
	
	
	@Override
	public String toString() {
		return "Car [getAvailableSeats()=" + getAvailableSeats() + ", getVehicleName()=" + getVehicleName()
				+ ", getVenhicleNumber()=" + getVenhicleNumber() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
