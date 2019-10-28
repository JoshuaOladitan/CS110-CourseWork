import java.util.Scanner;
// Test it.
public class FibonacciNim {
	// Here the variables are declared
	static int heap1 = 9;
	static int heap2 = 9;
	static int heap3 = 9;
	static boolean gamePlaying = true;
	static int heapChoice;
	static int upperNum = 2;
	static int maxValue = 2;
	static int tokensPicked = 0;
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Heap 1 "+ heap1 + "\n" + "Heap 2 " + heap2 + "\n" + "Heap 3 " + heap3);
		// This first do while loop cycles through the two people playing until one wins
		do {
			
			player1Run(upperNum, heap1, heap2, heap3, maxValue);
			
			if(heap1 + heap2 + heap3 == 0) { // Checks to see if game was won
				System.out.println("Player 1 wins");
				break; }
			
			player2Run(upperNum, heap1, heap2, heap3, maxValue);
			
			if(heap1 + heap2 + heap3 == 0) {
				System.out.println("Player 2 wins");
				break; } // Checks to see if a player has won
			
		}while(true);
	}

	public static void removeTokens(int heapChoice, int tokensPicked) {
		// Switch statement to determine where to remove the tokens from
		switch (heapChoice) {
		case 1:
			heap1 -= tokensPicked;
			break;
		case 2:
			heap2 -= tokensPicked;
			break;
		case 3:
			heap3 -= tokensPicked;
			break;
		}
	}
	
	public static void setUpperValue(int maxValue, int heapChoice) { // This method sets the upper value that can be picked
		switch(heapChoice) {
		case 1:
			if(upperNum * 2 >= heap1) {
				upperNum = heap1;
			}else {
				upperNum = maxValue * 2;
			}
			break;
		case 2:
			if(upperNum * 2 >= heap2) {
				upperNum = heap2;
			}else {
				upperNum = maxValue * 2;
			}
			break;
		case 3:
			if(upperNum * 2 >= heap3) {
				upperNum = heap3;
			}else {
				upperNum = maxValue * 2;
			}
			break;
			
		}
	}
	public static void player1Run(int upperNum, int heap1, int heap2, int heap3, int maxValue ) {
		
		System.out.println("Player 1's turn.");
		System.out.println("Choose a heap (1-3): " + "The  number of tokens you may take is between 1 and " + upperNum +  "\n" + "How many tokens do you want to take? " +
				"Heap 1 " + heap1);
		System.out.println("Heap 2 " + heap2);
		System.out.println("Heap 3 " + heap3);
		
		heapChoice = in.nextInt();
		tokensPicked = in.nextInt();
		
		if(tokensPicked > maxValue) {
			maxValue = tokensPicked;
		}
		setUpperValue(maxValue, heapChoice);
		removeTokens(heapChoice, tokensPicked); // The method to remove tokens from a heap is called
	}
	public static void player2Run(int upperNum, int heap1, int heap2, int heap3, int maxValue) {
		System.out.println("Player 2's turn.");
		
		System.out.println("Choose a heap (1-3): " + "The  number of tokens you may take is between 1 and " + upperNum +  "\n" + "How many tokens do you want to take? " +
		    "Heap 1 " + heap1);
		System.out.println("Heap 2 " + heap2);
		System.out.println("Heap 3 " + heap3);
		
		heapChoice = in.nextInt();
		tokensPicked = in.nextInt();
		if(tokensPicked > maxValue) {
			maxValue = tokensPicked;
		}
		
		setUpperValue(maxValue, heapChoice);
		removeTokens(heapChoice, tokensPicked);
	}
}