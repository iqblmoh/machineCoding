package  splitwise;


import java.util.Date;
import java.util.List;

public class SplitwiseService {
	public static Expense createExpense(ExpenseType type, double amount, User paidBy, List<Split> splits, String label) {
		switch (type) {
		//change to cases for EQUAL, EXACT, PERCENT when implemented
		case EQUAL:
			int totalSplits = splits.size();
			double splitAmount = ((double) Math.round(amount * 100 / totalSplits)) / 100;
			for (Split split : splits) {
				split.setAmount(splitAmount);
			}
			//to avoid decimal error. Like 100/3 = 33.33, adds up to 99.99. To avoid that
			splits.get(0).setAmount(splitAmount + amount - splitAmount*totalSplits);
			return new EqualExpense(amount, paidBy, new Date(), splits, label);

		case PERCENT:
			for (Split split:splits){
				PercentSplit percentSplit = (PercentSplit) split;
				//double percentAmount = Math.round(amount*percentSplit.getPercent()/100);
				split.setAmount(amount*percentSplit.getPercent()/100);
			}
			return new PercentExpense(amount, paidBy, new Date(), splits, label);
		case EXACT:
			return new ExactExpense(amount, paidBy, new Date(), splits, label);
		default:
			System.out.println("Invalid split type");
			return null;
		}
	}
}
