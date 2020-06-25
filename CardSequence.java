import java.util.Arrays;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class CardSequence {

	static Logger logger = Logger.getLogger(CardSequence.class.getName());
	

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.print("Enter cardSequence- ");  
		
		String cardSequence =sc.nextLine();
		
		System.out.println(checkSequence(cardSequence));
		
	}

	public static boolean checkSequence(String cardSequence) {

		logger.info("Checking whether all cards are having same type of card");
		char cardType = 0;
		for (int j = 0; j < cardSequence.length(); j++) {
			if (cardSequence.charAt(j) == '#') {

				if (cardType == 0) {
					cardType = cardSequence.charAt(j- 1);//for first occurrence taking the type of card
					
				} else {

					if (cardSequence.charAt(j - 1) != cardType) {
					
						return false;//checking whether all remaining cards are having same type, if not the return false
					}
				}

			}
		}
		
		logger.info("Checking whether cards the is in sequence");

		String[] properSequence = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };//this is correct sequence of cards used for reference

		int numberOfCards = getNumberOfCards(cardSequence);//taking the number of cards present in string

		String[] card = new String[numberOfCards];
		int index = 0;
		for (int a = 0; a < cardSequence.length(); a++) {//Insertion of cards in an array to check the sequence
			if (cardSequence.charAt(a) == '#') {
				if (cardSequence.charAt(a + 1) == '1') {
					if(cardSequence.charAt(a + 2)!='0')
					{
						return false;
					}
					card[index] = "10";
				} else {
					card[index] = Character.toString(cardSequence.charAt(a + 1));
				}

				index++;
			}
		}
		int previousIndex = 0;
		int a = 0;
		for (int i = 0; i < card.length; i++) {//Mapping the cards with the proper sequence of cards 
			System.out.println(findIndex(properSequence, card[i]));

			if (i == 0) {
				previousIndex = findIndex(properSequence, card[i]);

			} else {
				a = findIndex(properSequence, card[i]);
				if (a != previousIndex + 1) {

					return false;
				}
				previousIndex = a;
			}
		}
		return true;//If every condition mentioned above is satisfied then return true
	}

	
	public static int getNumberOfCards(String cardSequence) {//this method returns  the number of cards present in String 
		int count = 0;

		for (int i = 0; i < cardSequence.length(); i++) {
			if (cardSequence.charAt(i) == ',') {
				count++;
			}
		}
		return count + 1;
	}
	
	
	
	public static int findIndex(String arr[], String t) {//this method returns the index of element in array

		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(t)) {
				index = i;
				break;
			}
		}
		return index;
	}

}
