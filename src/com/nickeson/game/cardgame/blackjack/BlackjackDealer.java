package com.nickeson.game.cardgame.blackjack;

import java.util.List;
import com.nickeson.game.cardgame.Card;
import com.nickeson.game.cardgame.DealerIntfc;
import com.nickeson.game.cardgame.DeckIntfc;
import com.nickeson.game.cardgame.EmptyDeckException;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.ArrayList;
//import com.nickeson.game.cardgame.Shoe;
//import com.nickeson.game.cardgame.StdDeck;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: BlackjackDealer.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A dealer for the game of Blackjack<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class BlackjackDealer extends Player implements DealerIntfc {

	private DeckIntfc gameDeck = null;
	
	/**
	 * default constructor assumes the BlackjackDealer role is played by the PC, 
	 * @param gameDeck the gameDeck the BlackjackDealer uses
	 */
	public BlackjackDealer(DeckIntfc gameDeck) {
		super("Dealer", "(PC)");
		this.gameDeck = gameDeck;
	}
	
	/**
	 * minimal constructor allows setting of firstName and lastName during
	 * BlackjackDealer instantiation
	 * @param firstName the First Name to set
	 * @param lastName the Last Name to set
	 * @param gameDeck the Deck the BlackjackDealer uses
	 */
	public BlackjackDealer(String firstName, String lastName, DeckIntfc gameDeck) {
		super(firstName, lastName);
		this.gameDeck = gameDeck;
	}

	/**
	 * convenience constructor allows all Person fields to be set
	 * @param firstName the First Name to set
	 * @param lastName the Last Name to set
	 * @param dob the DateOfBirth to set
	 * @param genderIdentity the Gender Identity to set
	 * @param nickNames the Nicknames to set
	 * @param screenName the Screen Name to set
	 * @param acctBalance the Account Balance to set
	 * @param gameDeck the Deck the BlackjackDealer uses
	 */
	public BlackjackDealer(String firstName, String lastName, String dob, 
			String genderIdentity, List<String> nickNames, String screenName, 
			int acctBalance, DeckIntfc gameDeck) {
		super(firstName, lastName, dob, genderIdentity, 
				nickNames, screenName, acctBalance);
		this.gameDeck = gameDeck;
	}
	
	/**
	 * deal a specified number of Cards to a Player
	 * @param numCards the number of Cards to deal to Player
	 * @param player the Player to whom the BlackjackDealer deals Cards
	 */
	public void dealCard(Player player, int numCards) throws EmptyDeckException {
		for (int i = 0; i < numCards; i++) {
			if (gameDeck.getDeck().isEmpty()) {
				throw new EmptyDeckException("The Deck is Empty - you cannot get a Card");
			} else {
				Hand playerHand = player.getHand();
				Card c = gameDeck.getCard();
				playerHand.addCard(c);
			}
		}
	}
	
	/**
	 * deal a hand of Blackjack (2 cards to every player)
	 */
	public void dealHand(Player player) throws EmptyDeckException {
		if (gameDeck.getDeck().isEmpty()) {
			throw new EmptyDeckException("The Deck is Empty - you cannot get a Card");
		} else {
			Hand playerHand = player.getHand();
			Card c = gameDeck.getCard();
			Card c1 = gameDeck.getCard();
			playerHand.addCard(c);
			playerHand.addCard(c1);
		}
	}
	
	/**
	 * Dealer must hit when handValue is <= 17, returns true until handValue > 17
	 */
	@Override
	public boolean hitOrStand() {
		if (getHand().calcValue() <= 17) {
			return true;
		}
		return false;
	}
	
	/**
	 * Override the toString() method to print specific String when 
	 * BlackjackDealer is the PC and not a human Player, otherwise print
	 * BlackjackDealer's value as String rather than hashcode
	 */
	@Override
	public String toString() {
		String result = "";
		if ((getFirstName().equals("Dealer")) && (getLastName().equals("(PC)"))){
			result = "Dealer (PC)";
		} else {
			result = super.toString();
		}
		return result;
	}
	
	// unit test
//	public static void main(String[] args) {
//		Shoe gameShoe = null;
//		Map<String, Object> deckOpt = new HashMap<>();
//		deckOpt.put("typeOfDeck", (new StdDeck())); // modify to pull values from config file
//		deckOpt.put("stdDeckNumJoker", (new StdDeck(deckOpt))); // modify to pull values from config file
//		gameShoe = new Shoe(deckOpt); // builds first Deck of type specified in deckOpt
//		BlackjackDealer testDealer = new BlackjackDealer(gameShoe.getShoe());
//		BlackjackDealer testDealer = new BlackjackDealer("Kris", "Nickeson", gameShoe.getShoe());
//		System.out.println(testDealer);
//	}
}