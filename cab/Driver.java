package cab;

public class Driver extends User{
	
	private Vehicle vehicle;
	private boolean isAvailable;
	private Kyc kyc;
	
	public Driver(int id,String name, int age, Gender gender,Vehicle vehicle) {
		super(id,name,age,gender);
		this.vehicle = vehicle;
		
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Kyc getKyc() {
		return kyc;
	}
	public void setKyc(Kyc kyc) {
		this.kyc = kyc;
	}

	@Override
	public String toString() {
		return "Driver [vehicle=" + vehicle + ", isAvailable=" + isAvailable + ", kyc=" + kyc + "]";
	}
	
	
	
	
	
}
