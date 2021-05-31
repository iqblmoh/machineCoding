package  splitwise;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Splitwise {
	public static void main(String[] args) {
		ExpenseManager expenseManager = new ExpenseManager();

		expenseManager.addUser(new User("pradipta", "Pradipta Sarma", "pradiptasarma@outlook.com", "8133910729"));
		expenseManager.addUser(new User("nasir", "Nasir Ahmed", "nasirkvbarpeta@gmail.com", "0000999909"));
		expenseManager.addUser(new User("hemant", "Hemant Saikia", "hmnt.ska23@gmail.com", "7123123123"));
		expenseManager.addUser(new User("asmita", "Asmita Dutta", "asmita.dutta@outlook.com", "8133910729"));
		expenseManager.addUser(new User("jishnu", "Jishnu Sankar Bora", "jb@al.com", "1231231232"));
		expenseManager.addUser(new User("swaranga", "Swaranga Sarma", "s@s.com", "1212121212"));
		expenseManager.addUser(new User("debanga", "Debanga Sarma", "d@d.com", "4747474747"));

		Scanner scanner = new Scanner(System.in);
		while (true){
			System.out.println("Select mode: Create Expense [1], Show Balance [2]");
			String input = scanner.nextLine();
			switch (input){
				case "1":
					//new expense
					createExpense(expenseManager, scanner);
					break;
				case "2":
					viewBalance(expenseManager, scanner);
					break;
			}
		}
	}

	private static void viewBalance(ExpenseManager expenseManager, Scanner scanner) {
		System.out.println("Enter userid for whom you want to see balance:");
		String userId = scanner.nextLine();
		//TODO put check
		expenseManager.showBalanceForUser(userId);
	}

	private static void createExpense(ExpenseManager expenseManager, Scanner scanner) {
		System.out.println("Choose split type:");
		System.out.println("1. Equal");
		System.out.println("2. Exact");
		System.out.println("3. Percent");

		String splitType = scanner.nextLine();

		switch(splitType){
			case "1":
				createEqualExpense(expenseManager, scanner);
				break;
			case "2":
				createExactExpense(expenseManager, scanner);
				break;
			case "3":
				createPercentExpense(expenseManager, scanner);
				break;
			default:
				System.out.println("Incorrect option");
				return;
		}
	}

	private static void createPercentExpense(ExpenseManager expenseManager, Scanner scanner) {
		System.out.println("Enter no. of Users:");
		int noOfUsers = Integer.parseInt(scanner.nextLine());
		List<Split> splits = new ArrayList<>();
		System.out.println("Who paid?");
		String paidBy = scanner.nextLine();
		System.out.println("What did you spend on?");
		String label = scanner.nextLine();
		System.out.println("Enter amount");
		double amount = Double.parseDouble(scanner.nextLine());

		System.out.println("Enter percentage shared by "+paidBy+":");
		double percentIndi = Double.parseDouble(scanner.nextLine());
		double percentCheck = percentIndi;

		//TODO check for total percentage
		splits.add(new PercentSplit(expenseManager.userMap.get(paidBy), percentIndi));

		for (int i = 1; i<noOfUsers; i++){
			System.out.println("Participant "+(i+1));
			System.out.println("Enter user id: ");
			String userIdNow = scanner.nextLine();
			System.out.println("Enter percentage shared by "+userIdNow+":");
			percentIndi = Double.parseDouble(scanner.nextLine());
			splits.add(new PercentSplit(expenseManager.userMap.get(userIdNow), percentIndi));
		}

		expenseManager.addExpense(ExpenseType.PERCENT, amount, paidBy, splits, label);
		expenseManager.showBalanceForUser(paidBy);
	}

	private static void createExactExpense(ExpenseManager expenseManager, Scanner scanner) {
		System.out.println("Enter no. of Users:");
		int noOfUsers = Integer.parseInt(scanner.nextLine());
		List<Split> splits = new ArrayList<>();
		System.out.println("Who paid?");
		String paidBy = scanner.nextLine();
		System.out.println("What did you spend on?");
		String label = scanner.nextLine();
		System.out.println("Enter total amount");
		double amount = Double.parseDouble(scanner.nextLine());

		System.out.println("Enter amount paid by "+paidBy+":");
		double amountIndi = Double.parseDouble(scanner.nextLine());
		double amountCheck = amountIndi;

		splits.add(new ExactSplit(amountIndi,expenseManager.userMap.get(paidBy)));
		for (int i = 1; i<noOfUsers; i++){
			System.out.println("Participant "+(i+1));
			System.out.println("Enter user id: ");
			String userIdNow = scanner.nextLine();
			System.out.println("Enter amount paid by "+userIdNow+":");
			amountIndi = Double.parseDouble(scanner.nextLine());
			splits.add(new ExactSplit(amountIndi,expenseManager.userMap.get(userIdNow)));
		}
		//TODO check total amount equal to sum of all
		expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splits, label);
		expenseManager.showBalanceForUser(paidBy);
	}

	private static void createEqualExpense(ExpenseManager expenseManager, Scanner scanner) {
		System.out.println("Enter no. of Users:");
		int noOfUsers = Integer.parseInt(scanner.nextLine());
		List<Split> splits = new ArrayList<>();
		System.out.println("Who paid?");
		String paidBy = scanner.nextLine();
		System.out.println("What did you spend on?");
		String label = scanner.nextLine();
		System.out.println("Enter amount");
		double amount = Double.parseDouble(scanner.nextLine());
		splits.add(new EqualSplit(amount,expenseManager.userMap.get(paidBy)));
		for (int i = 1; i<noOfUsers; i++){
			System.out.println("Participant "+(i+1));
			System.out.println("Enter user id: ");
			String userIdNow = scanner.nextLine();
			//TODO put check if user exists
			splits.add(new EqualSplit(amount,expenseManager.userMap.get(userIdNow)));
		}
		expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splits, label);
		expenseManager.showBalanceForUser(paidBy);
	}
}