import java.util.Scanner;
import java.lang.Math.*;

public class FibonacciNim {
	// Initialise the variables
	static int heap1 = 9;
	static int heap2 = 9;
	static int heap3 = 9;
	static int round = 0;
	static boolean isGameInProgress = false;
	static int highestValueUsed;
	static int upperValue;
	static int previousValue;
	static int heapChosen;

	public static void main(String[] args) {

		// Create a do while loop:
		do {
			// create player integer
			int player;
			// start a new round
			round++;
			// determine who's turn it is using a if statement and even numbers
			if (round % 2 == 0) {
				player = 2;
			} else {
				player = 1;
			}
			// run "handlePlayer" function
			if (round == 1) {
				highestValueUsed = handlePlayer(1, 0, 1);
			} else {
				highestValueUsed = handlePlayer(player, highestValueUsed, round);
			}

			// Check if game has ended
			isGameInProgress = (heap1 + heap2 + heap3) > 0;
			if (!isGameInProgress) {
				System.out.print("Player " + player + " wins");
			}
			// If not run loop again

		} while (isGameInProgress);
	}
	// Create "handlePlayer" method:
	public static int handlePlayer(int player, int highestValueUsed, int round) {
		Scanner in = new Scanner(System.in);
		// Display heaps
		System.out.println("Heap 1 " + heap1);
		System.out.println("Heap 2 " + heap2 + "\n" + "Heap 3 " + heap3);
		// display who's turn it is
		System.out.println("Player " + player + "'s turn.");
		// Ask to choose heap
		System.out.print("Choose a heap (1-3): ");
		heapChosen = in.nextInt();
		// Find the max value of heap
		if (round == 1) {
			upperValue = 2;
		} else {
			switch (heapChosen) {
			case 1:
				if (heap1 > highestValueUsed * 2) {
					upperValue = highestValueUsed * 2;
				} else {
					upperValue = heap1;
				}
				break;
			case 2:
				if (heap2 > highestValueUsed * 2) {
					upperValue = highestValueUsed * 2;
				} else {
					upperValue = heap2;
				}
				break;
			case 3:
				if (heap3 > highestValueUsed * 2) {
					upperValue = highestValueUsed * 2;
				} else {
					upperValue = heap3;
				}
				break;
			default:
				System.out.println("Wrong value");
				break;
			}
		}
		// Ask to choose tokens
		System.out.println("The  number of tokens you may take is between 1 and " + upperValue);
		System.out.print("How many tokens do you want to take? ");
		int inputTokens = in.nextInt();
		// Check to see max number of tokens possible
		int highestValueUsedF = Math.max(inputTokens, previousValue);
		previousValue = inputTokens;
		// remove tokens from heap
		switch (heapChosen) {
		case 1:
			heap1 -= inputTokens;
			break;
		case 2:
			heap2 -= inputTokens;
			break;
		case 3:

			heap3 -= inputTokens;
			break;
		}
		return highestValueUsedF;
	}
}


