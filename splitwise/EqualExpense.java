package splitwise;

import java.util.*;

public class EqualExpense extends Expense {
	public EqualExpense(double amount, User paidBy, Date now, List<Split> splits, String label) {
		super(amount, paidBy, now, splits, label);
	}

	@Override
	public boolean validate() {
		for (Split split : super.getSplits()) {
			if (!(split instanceof EqualSplit)) return false;
		}
		return true;
	}
}
