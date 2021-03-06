package com.nickeson.game.cardgame.blackjack;

//JDK 1.8.0
import java.util.List;
import java.util.Scanner;
import com.nickeson.Person;

/****************************************************************************
 * <b>Title</b>: Player.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A subclass of Person for use in Blackjack game play<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Player extends Person {
	private String screenName = null;
	private int acctBalance = 0;
	private Hand hand = new Hand();
	private Scanner scanner = null;

	/**
	 * primary constructor requires firstName and lastName at minimum
	 * to instantiate a Player
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 */
	public Player(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	/**
	 * convenience constructor allows firstName and lastName fields, dob,
	 * genderIdentity, nickName(s), screenName and acctBalance to be set upon 
	 * Player instantiation
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param dob the DateOfBirth to set (2016-12-03 is proper format)
	 * @param genderIdentity the gender identity to set
	 * @param nickNames the nickname(s) to set
	 * @param screenName the screen name to set
	 * @param acctBalance the account Balance to set
	 */
	public Player(String firstName, String lastName, String dob, 
			String genderIdentity, List<String> nickNames, 
			String screenName, int acctBalance) 
	{
		super(firstName, lastName, dob, genderIdentity, nickNames);
		this.screenName = screenName;
		this.acctBalance = acctBalance;
	}
	
	/**
	 * @return the Player's screenName
	 */
	public String getScreenName() {
		return screenName;
	}

	/**
	 * @param screenName the screenName to set
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	/**
	 * @return the Player's acctBalance
	 */
	public int getAcctBalance() {
		return acctBalance;
	}

	/**
	 * @param acctBalance the acctBalance to set
	 */
	public void setAcctBalance(int acctBalance) {
		this.acctBalance = acctBalance;
	}
	
	/**
	 * returns the Player's hand
	 * @return the Player's hand
	 */
	public Hand getHand() {
		return hand;
	}

	 /**
     * players have the option to (H)it (get another Card from Blackjack Dealer)
     * or (S)tand (no more Cards, Player's turn is finished)
     * @return (H)it = true, (S)tand = false
     */
	public boolean hitOrStand() {
        String inStr = null;
        boolean hosResult = false;
        scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
			inStr = scanner.nextLine();
			if(inStr.equalsIgnoreCase("h")) {
				hosResult = true;
				break;
			} else {
				if (inStr.equalsIgnoreCase("s")) {
					hosResult = false;
					break;
				} else {
					if (!inStr.isEmpty()) {
						System.out.print("(H)it or (S)tand?: ");
					}
				}
			}
			if (inStr.isEmpty()) {
				System.out.print("(H)it or (S)tand?: ");
			}
		}
		return hosResult;
    }

	/**
	 * Override toString() to print Player's field values, rather than hashcode
	 * @return the String value of the Player
	 */
	@Override
	public String toString() {
		String result = super.toString();
		result += "screenName: ";
		if (getScreenName() == null) {
			result += "unavailable\n";
		} else {
			result += getScreenName() + "\n";
		}
		result += "acctBalance: ";
		if (getAcctBalance() == 0) {
			result += "unavailable";
		} else {
			result += "$" + getAcctBalance();
		}
		return result;
	}
}