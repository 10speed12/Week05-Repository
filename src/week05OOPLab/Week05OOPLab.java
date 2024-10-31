package week05OOPLab;

import java.util.*;

public class Week05OOPLab {
		// This Lab will give you a basic look at creating an Object Oriented Card Game.  
		//		The idea here is to prepare you for your Week 6 Unit Final Project.
		//		There are many ways to implement this Lab, please use the tools that you know,
		//		and go from there.
		// These exercises are intended to be coded in order 1 through 5.
			
		
		public static void main(String[] args) {
		
			
			// A standard deck of playing cards has 52 cards as specified below 
			//		i. There are 4 suits:  Clubs, Diamonds, Hearts, & Spades
			//				
			//	   ii. Each suit has 13 cards:  Two, Three, Four, Five, Six, Seven, 
			//									 Eight, Nine, Ten, Jack, Queen, King & Ace
			//
			//	  iii. Comparing Cards:  When comparing two cards, Ace is high and Two is low.
			//							 to make this easy, a Two will have a value of 2, a
			//							 Three will have a value of 3, ... and an Ace will have
			//							 a value of 14.
			//
		
			
			// 1. Card Class:
			//		Create a class called Card to represent a standard playing card. 
			//		Fields:   The Card class should have the following fields:
			// 			a. name field
			//			b. suit field
			//			c. value field for comparing against other cards.
			//
			//		Methods:  This class can have any useful method.
			//			a. describe() to display the card information to the Console.
			//			b. Getters & Setters 
			//
			System.out.println("\nQuestion 1: Card Class");
			// Add your code here to instantiate a Card
			Card firstCard = new Card("Ace","Spades",14);
			
			// Call the describe method on the newly instantiated card.
			firstCard.describe();
			
			
			

			// 2. Deck Class:
			//		Create a class called Deck.
			//		Fields:  This class should have a list of Card field called cards 
			//				 that will hold all the cards in the deck. 
			//			List<Card> cards = new ArrayList<Card>(); 
			//
			//		Constructor: The constructor for the Deck Class should
			// 			instantiate all 52 standard playing cards and add them to the cards list.
			//
			//		Methods:  
			//			a.  describe() to describe the deck to the Console -- 
			//					print out all of the cards in the deck.
			//
			System.out.println("\nQuestion 2: Deck Class");
		    // Add your code here to instantiate a Deck	
		    Deck deck = new Deck();
		    
		    // Call the describe method on the newly instantiated deck.
		    deck.describe();
		    
		    
		    
			
			
			// 3. Deck shuffle() Method:
			//		Add a shuffle method within the Deck Class
			System.out.println("\nQuestion 3: Deck shuffle() method");
			// Test your method here
			deck.shuffle();
			
			
			// Call the describe method on the newly shuffled deck.
			deck.describe();
			
			
			
			// 4. Deck draw() Method:
			//		Add a draw method within the Deck Class
			System.out.println("\nQuestion 4: Deck draw() method");
			// Test your method here
			System.out.println("Current length of deck:"+deck.getCards().size());
			Card draw1 = deck.draw();
			draw1.describe();
			System.out.println("Current length of deck:"+deck.getCards().size());
			Card draw2 = deck.draw();
			draw2.describe();
			System.out.println("Current length of deck:"+deck.getCards().size());
			
			
			
			
			// 5. Create Game Board:
			//		Create and test a method that takes an int as a parameter (representing the
			// 			number of players for a game) and returns a Map<String, List<Card>>
			// 			that represents each player (i.e. "Player 1", "Player 2", etc..) 
			//			and their cards.
			//
			// 			The method should create a new instance of Deck, shuffle it,
			// 			and deal the cards out to the "players" in the Map.
			System.out.println("\nQuestion 5: Create Game");
			// Call your method here
			Map<String, List<Card>> fourPlayers=createGame(4);
			System.out.println("Result of dealing to 4 players:");
			for(int i=1; i<=4 ;i++) {
				System.out.println("Hand of Player "+i);
				List<Card> currentHand = fourPlayers.get("Player "+i);
				for(Card card: currentHand) {
					card.describe();
				}
			}
			Map<String, List<Card>> fiftyfivePlayers=createGame(55);
			System.out.println("Result of dealing to 55 players:");
			for(int i=1; i<=55;i++) {
				System.out.println("Hand of Player "+i);
				List<Card> currentHand = fiftyfivePlayers.get("Player "+i);
				for(Card card: currentHand) {
					card.describe();
				}
			}
			
			
		} 
		
		// Method 5:
		public static Map<String, List<Card>> createGame(int numberOfPlayers){
			// Create a map to store results of dealing out the cards in the deck:
			Map<String,List<Card>> playerHands= new HashMap<String, List<Card>>();
			if(numberOfPlayers<=0) {
				// If a value less than 1 was entered as numberOfPlayers, print out an error message and return empty map:
				System.out.println("Error, you can't have a game with less than one player. Returning empty map.");
				return playerHands;
			}
			// Initialize new deck object:
			Deck deck = new Deck();
			// Shuffle deck:
			deck.shuffle();
			// Fill playerNames with numberOfPlayer strings:
			for(int i=1;i < numberOfPlayers+1; i++) {
				// Create a new list to store current player's cards:
				List<Card> tempHand = new ArrayList<Card>();
				playerHands.put("Player "+i,tempHand);
			}
			// Set up player iterator for usage in loop:
			int player=1;
			// Set up a while loop to repeat dealing cards until deck is empty:
			while(!deck.getCards().isEmpty()) {
				// Draw top card of deck and store it in a temp value:
				Card card = deck.draw();
				// Obtain hand of current player:
				List<Card> currentHand=playerHands.get("Player "+player);
				// Add card to currentHand:
				currentHand.add(card);
				// Update map with currentHand:
				playerHands.replace("Player "+player,currentHand);
				// Increment current player pointer:
				player++;
				if(player > numberOfPlayers) {
					// If player value increments beyond numberOfPlayers, reset it to 1:
					player=1;
				}
			}
			// Return generated map to calling function:
			return playerHands;
		}
}
