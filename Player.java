
import java.util.ArrayList;

public class Player {

    // Instance variables
    private ArrayList<Card> hand; //the player's cards
    private double bankroll;
    private double bet;

    // Constructor
    // Instantiates a Player with 100 tokens
    public Player(){		
        
        hand = new ArrayList<Card>();
        bankroll = 100;
        bet = 0;
        
    }

    // Method for adding a card to the player's hand
    public void addCard(Card c){
        
        hand.add(c);
        
    }

    // Method for removing a card from the player's hand
    public void removeCard(Card c){
       
        hand.remove(c);
        
    }

    // Method for betting a number of tokens
    public void bets(double amt){
        
        bet = amt;
        bankroll = bankroll - amt;
        
    }

    // Method that adjusts bankroll if player wins
    public void winnings(double odds){
        
        bankroll = bankroll + (bet * odds);
        
    }

    // Accessor method that returns current balance of bankroll
    public double getBankroll(){
        
        return bankroll;
        
    }

    // Method that prints the cards in the player's hand
    public String printHand(){
        
        int i = 1;
        String handString = "";
        
        for (Card c : hand){
            
            handString = handString + "Card #" + i + " -> " + c + "\n";
            i++;
            
        }
        
        return handString;
        
    }
    
    // Accessor method that returns the player's hand
    public ArrayList<Card> getHand(){
        
        return hand;
        
    }
    
    // Method that resets player's hand for a new round
    public void resetHand(){
        
        hand = new ArrayList<Card>();
        
    }
    
}


