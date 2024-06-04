import java.util.*;

public class BlackJack {
    public static void initialize(String[] deck) {
	String[] suits = { "♦", "♥", "♠", "♣" };
	int i, j, rand;
	Random random = new Random();
	for (i = 0; i < suits.length; i++) {
	    deck[13*i] = "A" + suits[i];
	    for (j = 2; j < 11; j++)
		deck[13 * i + j - 1] = j + suits[i];
	    deck[13 * i + 10] = "J" + suits[i];
	    deck[13 * i + 11] = "Q" + suits[i];
	    deck[13 * i + 12] = "K" + suits[i];
	}
	String temp;
	for(i = 0; i < deck.length - 1; i++) {
	    rand = i + random.nextInt(deck.length - i);
	    temp = deck[i];
	    deck[i] = deck[rand];
	    deck[rand] = temp;
	}
    }
    public static int value(String card) {
	try (Scanner scanner = new Scanner(card)) {
	    scanner.useDelimiter("[^0-9]");
	    return Character.isDigit(card.charAt(0))? scanner.nextInt(): card.charAt(0) == 'A'? 11: 10; 
	}
    }

    public static void main(String[] args) {
	String[] deck = new String[52];
	initialize(deck); // initializes and shuffles the deck of cards. Don't delete
	Scanner keyboard = new Scanner(System.in);
	String playerName;
	System.out.print("Enter the player's name: ");
	playerName = keyboard.nextLine();
	int playerScore = 0;
	int dealerScore = 0;
	System.out.println("Game starts... Dealer is dealing...");
	System.out.println("First card for " + playerName + ": " + deck[0]);//deck[0] for the player
	playerScore += value(deck[0]);
	System.out.println("First card for dealer: Hidden");//deck[1] for the dealer
	dealerScore += value(deck[1]);
	System.out.println("Second card for " + playerName + ": " + deck[2]);//deck[2] for the player
	if(deck[2].startsWith("A") && playerScore > 10)//Ace's value is 1 or 11
	   
		playerScore++;//Ace's value is 1 here...
	else
	    playerScore += value(deck[2]);//Ace's value is 11 here...
	if(playerScore == 21)//game ends early in favor of the player
	    System.out.println(playerName + " won!");
	System.out.println("Second card for dealer: " + deck[3]);//deck[3] for the dealer
	if(deck[3].startsWith("A") && dealerScore > 10)//Ace's value is 1 or 11
	    dealerScore++;//Ace's value is 1 here...
	else
	    dealerScore += value(deck[3]);//Ace's value is 11 here...
	
	String playerChoice; //initialization of variable
	int i = 4; //initializes deck to 4 draw new card
	boolean hitsOfPlayer = true; //boolean expression for following switch case
	
	while (hitsOfPlayer) { //while loop for player to hit or stay
		System.out.println("Hit or Stay?");
		playerChoice = keyboard.next(); //the user's choice
			
		switch (playerChoice) //start of switch case
		{
			case "Hit": //when user enters "Hit"
				playerScore += value(deck[i]); //player score adds value of new card
				System.out.println("Next card for " + playerName +  ": "  + (deck[i]));
				i = i+1; //lets compiler know to pull from next card in the array
				if(playerScore == 21) //indicator if user has 21
					
				    System.out.println(playerName + " won!");
			    if(playerScore > 21) { //indicator if user busts
					System.out.println(playerName + " lost!");
					{System.exit(0);} //forces exit of while loop
					
					
					}
				break;
				
			case "Stay": //if user decides to stay
				hitsOfPlayer = false; //boolean expression becomes false
				break;
			
			default:
				System.out.println("Invalid Input "); //default catch for when a user enters anything but "Hit" or "Stay"
				
				break;				
			}
		}
	
		System.out.println("First card for dealer: " + deck[1]); //displays dealer's originally hidden card
		while(dealerScore < 17) { //game rule if dealer's score is less than 17
			dealerScore += value(deck[i]);
			System.out.println("Next card for dealer: "  + (deck[i]));
			i = i+1; //pulling next card
		}
		
		if(dealerScore > 21 || dealerScore < playerScore) { //closing game statement for player winning
			System.out.println(playerName + " wins!");
		}
		else if(dealerScore == playerScore) { //closing game statement for a tie game
			System.out.println("Tie Game!");
		}
		else if(dealerScore > playerScore) { //closing game statement for dealer winning
			System.out.println("Dealer wins.");
		}
	}
}

