package tinder;

import java.util.List;
import java.util.Random;

public class DriverClass {


	public static void main(String[] args) {
		UserService userService = UserService.getInstance();
		MatchService matchService = MatchService.getInstance();
		System.out.println("Execution started");

		User user1 = userService.registerUser(21,"user_a","1234512345",Gender.MALE,0,0);
		User user2 = userService.registerUser(20,"user_b","1234512346",Gender.FEMALE,0,1);
		User user3 = userService.registerUser(19,"user_c","1234512347",Gender.FEMALE,0,2);
		User user4 = userService.registerUser(25,"user_d","1234512347",Gender.MALE,1,2);
		User user5 = userService.registerUser(18,"user_e","1234512347",Gender.MALE,0,4);
		User user6 = userService.registerUser(18,"user_f","1234512345",Gender.FEMALE,0,5);


		try {

			List<User> potentialUserforUser2=matchService.findPotentialMatches(user5);
			List<User> potentialUserforUser1=matchService.findPotentialMatches(user6);
			matchService.actOnPotentialMatch(user5.getId(),user6.getId(),ActionType.Liked);
			matchService.actOnPotentialMatch(user6.getId(),user5.getId(),ActionType.Liked);

			matchService.actOnPotentialMatch(user5.getId(),user3.getId(),ActionType.Liked);
			matchService.actOnPotentialMatch(user3.getId(),user5.getId(),ActionType.Liked);

			matchService.actOnPotentialMatch(user1.getId(),user2.getId(),ActionType.Liked);
			matchService.actOnPotentialMatch(user2.getId(),user1.getId(),ActionType.Liked);

			matchService.actOnPotentialMatch(user1.getId(),user3.getId(),ActionType.Ignored);

		} catch (NoUserFoundException e) {
			System.out.println("No potential Match found for user\n");
		}
		matchService.showMatchesForUser(user1);
		matchService.showMatchesForUser(user5);
		matchService.showAllMatches();
		System.out.println("Execution completed" );

	}


}
