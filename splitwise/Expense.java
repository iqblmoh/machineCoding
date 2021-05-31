package  splitwise;

import java.util.*;

public abstract class Expense {
	// private String id;
	private String label;
	private double amount;
	private User paidBy;
	private Date createdDate;
	private List<Split> splits;

	public Expense(double amount, User paidBy, Date now, List<Split> splits, String label) {
		// this.id = id;
		this.amount = amount;
		this.paidBy = paidBy;
		this.createdDate = now;
		this.splits = splits;
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Split> getSplits() {
		return splits;
	}

	public void setSplits(List<Split> splits) {
		this.splits = splits;
	}

	public abstract boolean validate();

}
