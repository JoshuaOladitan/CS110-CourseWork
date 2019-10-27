import java.util.Scanner;
// Next make sure all wrong values entered are caught out.
// Test it.
public class FibonacciNim {
	// Here the variables are declared
	static int heap1 = 9;
	static int heap2 = 9;
	static int heap3 = 9;
	static boolean gamePlaying = true;
	static int heapChoice;
	static int upperNum = 2;
	static int maxValue = 0;
	
	public static void main(String[] args) {
		// This first do while loop cycles through the two people playing until one wins
		
		do {
			Scanner in = new Scanner(System.in);
			boolean wrongChoice = true;
			do { // This do while loop checks if the response given is valid
				System.out.println("Heap 1 " + heap1 + "\n" + "Heap 2 " + heap2 + "\n" + "Heap 3 " + heap3 + "\n"
						+ "Player 1's turn." + "\n" + "Choose heap (1-3): ");
				heapChoice = in.nextInt();
				
				if(heapChoice >= 1 && heapChoice <= 3) {
					wrongChoice = false;
				}
			
			}while(wrongChoice);
			if(heap1 + heap2 + heap3 == 27) {
				upperNum = 2;
			}else {
				setUpperValue(maxValue, heapChoice);
			}

			int tokensPicked;
			do{
				System.out.println("The number of tokens is between 1 and " + upperNum +  "\n" + "How many tokens do you want to take? ");
				tokensPicked = in.nextInt();
				if(tokensPicked < 1 || tokensPicked > upperNum) {
					wrongChoice = true;
				}else { wrongChoice = false;}
			}while(wrongChoice);
			if(tokensPicked > maxValue) {
				maxValue = tokensPicked;
			}
			
			removeTokens(heapChoice, tokensPicked); // The method to remove tokens from a heap is called
			
			if(heap1 + heap2 + heap3 == 0) {
				System.out.println("Player 1 wins");
				break; }
			
			wrongChoice = true;
			do { // Another loop validating an answer
				System.out.println("Heap 1 " + heap1 + "\n" + "Heap 2 " + heap2 + "\n" + "Heap 3 " + heap3 + "\n"
						+ "Player 2's turn." + "\n" + "Choose heap (1-3): ");
				heapChoice = in.nextInt();
				
				if(heapChoice >= 1 && heapChoice <= 3) {
					wrongChoice = false;
				}
				
			}while(wrongChoice);
			
			setUpperValue(maxValue, heapChoice);
			do{
				System.out.println("The number of tokens is between 1 and " + upperNum +  "\n" + "How many tokens do you want to take? ");
				tokensPicked = in.nextInt();
				if(tokensPicked < 1 || tokensPicked > upperNum) {
					wrongChoice = true;
				}else { wrongChoice = false;}
			}while(wrongChoice);
			if(tokensPicked > maxValue) {
				maxValue = tokensPicked;
			}
			
			removeTokens(heapChoice, tokensPicked);
			
			if(heap1 + heap2 + heap3 == 0) {
				System.out.println("Player 2 wins");
				break; } // Checks to see if a player has won
			
			
			
		} while (true);

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
	
	public static void setUpperValue(int maxValue, int heapChoice) {
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
}