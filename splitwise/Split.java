package  splitwise;

public abstract class Split {
	private double amount;
	private User user;

	public Split(double amount, User user) {
		this.setAmount(amount);
		this.setUser(user);
	}

	public Split(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}