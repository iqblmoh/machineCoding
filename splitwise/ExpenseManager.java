package  splitwise;


import java.util.*;
import java.util.Map.Entry;

public class ExpenseManager {
	List<Expense> expenses;
	// userMap: userId to User
	Map<String, User> userMap;
	Map<User, Map<User, Double>> balanceSheet;

	public ExpenseManager() {
		this.expenses = new ArrayList<Expense>();
		this.userMap = new HashMap<String, User>();
		this.balanceSheet = new HashMap<User, Map<User, Double>>();
	}

	public void addUser(User user) {
		userMap.put(user.getId(), user);
		balanceSheet.put(user, new HashMap<User, Double>());
	}
	
	public void addExpense (ExpenseType type, double amount, String userId, List<Split> splits, String label) {
		//TODO add expense, add to expenses list, add to balance sheet
		User paidBy = userMap.get(userId);
		Expense newExpense = SplitwiseService.createExpense(type, amount, paidBy, splits, label);
		expenses.add(newExpense);
		
		for (Split split : newExpense.getSplits()) {
			User paidTo = split.getUser();
			Map<User, Double> balances = balanceSheet.get(paidBy);
			if (!balances.containsKey(paidTo)) {
				balances.put(paidTo, 0.0);
			}
			balances.put(paidTo, balances.get(paidTo)+split.getAmount());
			balances = balanceSheet.get(paidTo);
			
			if (!balances.containsKey(paidBy)) {
				balances.put(paidBy, 0.0);
			}
			balances.put(paidBy, balances.get(paidBy) - split.getAmount());
		}
	}
	
	public void showBalanceForUser (String userId) {
		//TODO
		User thisUser = userMap.get(userId);
		if (thisUser == null){
			System.out.println("User doesn't exist");
			return;
		}
		for (Map.Entry<User, Double> userBalance : balanceSheet.get(thisUser).entrySet()) {
			//We don't want to print balance to self, which will be Zero ideally
			if (userBalance.getKey()!=thisUser) {
				printBalances(userId, userBalance);
			}
		}
	}
	
	private void printBalances(String userId, Entry<User, Double> userBalance) {
		//TODO
		if (userBalance.getValue()!= 0) {
			if (userBalance.getValue()<0) {
				System.out.println(userMap.get(userId).getName()+" owes "+Math.abs(userBalance.getValue())+" to "+userBalance.getKey().getName());
				return;
			}
			System.out.println(userBalance.getKey().getName()+" owes "+Math.abs(userBalance.getValue())+" to "+userMap.get(userId).getName());
			return;
		}
		System.out.println("No balances for "+userId);
	}

	public void showAllBalances () {
		//TODO
	}

}
