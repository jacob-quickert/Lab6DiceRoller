import java.util.Random;
import java.util.Scanner;

public class Lab6DiceRoller {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String cont = "y";

		System.out.println("Welcome to Grand Circus Casino!");
		System.out.println("");
		
		//Decision for first iteration of while loop
		System.out.println("Would you like to roll the dice?");
		cont = scan.nextLine();
		
		//initialize counter for number of rolls user tries
		int i = 0;

		while (cont.equalsIgnoreCase("y")); {
			//increment counter index
			++i;
			
			//prompt user input for number of sides on the dice
			System.out.println("How many sided dice would you like?:(enter an integer) ");
			int userNumSides = scan.nextInt();

			//create variables for each roll and call the "roll" method for each
			int die1Roll = rollTheDice(userNumSides);
			int die2Roll = rollTheDice(userNumSides);

			//Print roll number, 
			//roll values, 
			//and evaluation of your roll from the method call
			System.out.println("Role " + i + ": ");
			System.out.println("Your numbers were " + die1Roll + " and " + die2Roll);
			System.out.println("");
			System.out.println(analyzeTheRoll(die1Roll, die2Roll));//

			//prompt and receive user choice to continue
			System.out.println("Roll again? y/n");
			scan.nextLine();
			cont = scan.nextLine();
		}

		System.out.println("Good bye.");
		scan.close();
	}

	private static int rollTheDice(int numSides) {
		//create java Object "Random"
		Random rand = new Random();
		//spit out a random number with a range from 1 to numSides
		return rand.nextInt(numSides) + 1;
	}

	private static String analyzeTheRoll(int roll1, int roll2) {
		
		if (roll1 == 6 && roll2 == 6) {
			return "You got boxcars!";
		} else if (roll1 == 1 && roll2 == 1) {
			return "You got snake eyes!";
		} else if (roll1 + roll2 == 7 || roll1 + roll2 == 11) {
			return "You got craps!";
		} else {
			return "Too Bad.";
		}
	}

}
