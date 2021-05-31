package  splitwise;

import java.util.Date;
import java.util.List;

public class PercentExpense extends Expense{

    public PercentExpense(double amount, User paidBy, Date now, List<Split> splits, String label){
        super(amount, paidBy, now, splits, label);
    }

    @Override
    public boolean validate() {
        int checkPercent = 0;
        for (Split split : super.getSplits()) {
            if (!(split instanceof PercentSplit)) {
                return false;
            }
            checkPercent+=((PercentSplit) split).getPercent();
        }
        double totalPercent = 100;
        if (checkPercent!=totalPercent) return false;
        return true;
    }
}
