
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {

    // Instance variables
    private Player p;
    private Deck cards;
    private Scanner input;
    
    // Constructor for test game
    public Game(String[] testHand){
  
        p = new Player();
        cards = new Deck();
                    
        for (int i = 0; i < testHand.length; i++){
            
            p.addCard(new Card(testHand[i]));
            
        }
            
        input = new Scanner(System.in);
        
    }

    // Constructor for interactive game
    public Game(){
       
        p = new Player();
        cards = new Deck();
        input = new Scanner(System.in);
        
    }

    // Play method that plays the game
    public void play(){
      
        String anotherRound = "yes";
        
        if (p.getHand().size() == 0){
            
            while(anotherRound.equals("yes")){
                     
                int bet = placeBet();
                p.bets(bet);
        
                cards.shuffle();
                
                for (int i = 0; i < 5; i++){
                    
                    p.addCard(cards.deal());
                    
                }
        
                askReplace();
                
                String handValue = checkHand(p.getHand());
                System.out.println("That's a " + handValue);
                
                int payout = determinePayout(handValue);
                System.out.println("You win " + (payout * bet) + " token(s)");
                p.winnings(payout);
                System.out.println("You currently have " + p.getBankroll() +
                                   " tokens");
                
                System.out.println("Play again? Enter yes or no");
                anotherRound = input.nextLine();
                p.resetHand();
            
            }
       
        }
        
        else{
            
            int bet = placeBet();
            
            String handValue = checkHand(p.getHand());
            System.out.println("That's a " + handValue);
            
            int payout = determinePayout(handValue);
            System.out.println("You win " + (payout * bet) + " token(s)");
        
        }
        
        System.out.println("Thanks for playing");
           
    }
    
    // checkHand() method that scores hand and returns String
    public String checkHand(ArrayList<Card> hand){

        Collections.sort(hand);
       
        if (checkRoyalFlush(hand)){
        
            return "Royal Flush";
        
        }
        
        if (checkStraightFlush(hand)){
        
            return "Straight Flush";
        
        }
        
        if (check4OfAKind(hand)){
        
            return "4 of a Kind";
        
        }
        
        if (checkFullHouse(hand)){
        
            return "Full House";
        
        }
        
        if (checkFlush(hand)){
        
            return "Flush";
        
        }
        
        if (checkStraight(hand)){
        
            return "Straight";
        
        }
        
        if (check3OfAKind(hand)){
        
            return "3 of a Kind";
        
        }
        
        if (check2Pairs(hand)){
        
            return "2 Pairs";
        
        }
        
        if (check1Pair(hand)){
        
            return "1 Pair";
        
        }
        
        return "Nothing";
        
    }
    
    // Private helper method that checks for a Royal Flush
    private boolean checkRoyalFlush(ArrayList<Card> hand){
        
        if (!checkFlush(hand)){
        
            return false;
        
        }
        
        else{
            
            boolean royalFlush = hand.get(0).getRank() == 1 && 
                                 hand.get(1).getRank() == 10 &&
                                 hand.get(2).getRank() == 11 &&
                                 hand.get(3).getRank() == 12 &&
                                 hand.get(4).getRank() == 13;
            
            if (royalFlush){
            
                return true;
            
            }
            
            else{
            
                return false;
            
            }
            
        }
        
    }
    
    // Private helper method that checks for a Straight Flush
    private boolean checkStraightFlush(ArrayList<Card> hand){
        
        return checkFlush(hand) && checkStraight(hand);
    
    }
    
    // Private helper method that checks for a Four of a Kind
    private boolean check4OfAKind(ArrayList<Card> hand){
        
        int match = 0;
        Card yardStick = hand.get(2);
        
        for (int i = 0; i < hand.size(); i++){
                       
            if (hand.get(i).getRank() == yardStick.getRank()){
   
                match++;
                
            }
            
        }
        
        return match >= 4;
        
    }
    
    // Private helper method that checks for a Full House
    private boolean checkFullHouse(ArrayList<Card> hand){
        
        int match = 0;
        int pairCount = 0;
        Card yardStick = hand.get(2);
        
        for (int i = 0; i < hand.size(); i++){
           
            if (hand.get(i).getRank() == yardStick.getRank()){
            
                match++;
            
            }
             
        }    
        
        if(match >= 3){
            
            for (int i = 1; i < hand.size(); i++){
                
                if (!(hand.get(i).getRank() == yardStick.getRank()) &&                  
                    hand.get(i).getRank() == hand.get(i - 1).getRank()){
                    
                    pairCount++;
              
                }
            
            }
        
        }
        
        return pairCount == 1;
    
    }
	
    // Private helper method that checks for a Flush
    private boolean checkFlush(ArrayList<Card> hand){
        
        for (int i = 1; i < hand.size(); i++){
         
            if (hand.get(i).getSuit() != hand.get(i - 1).getSuit()){
           
                return false;
        
            }
        
        }
        
        return true;
        
    }
    
    // Private helper method that checks for a Straight
    private boolean checkStraight(ArrayList<Card> hand){
       
       boolean specialStraight = hand.get(0).getRank() == 1 && 
                                 hand.get(1).getRank() == 10 &&
                                 hand.get(2).getRank() == 11 &&
                                 hand.get(3).getRank() == 12 &&
                                 hand.get(4).getRank() == 13;
       
       if (specialStraight){
           
           return true;
       
       }
           
       for (int i = 1; i < hand.size(); i++){
            
            if (hand.get(i).getRank() != (hand.get(i - 1).getRank() + 1)){
            
                return false;
            
            }
           
       }
        
       return true;
        
    }
    
    // Private helper method that checks for a Three of a Kind
    private boolean check3OfAKind(ArrayList<Card> hand){
        
        int match = 0;
        Card yardStick = hand.get(2);
         
        for (int i = 0; i < hand.size(); i++){
           
            if (hand.get(i).getRank() == yardStick.getRank()){
            
                match++;
                
            }
            
        }
        
        return match >= 3;
        
    }
    
    // Private helper method that checks for a Two Pairs
    private boolean check2Pairs(ArrayList<Card> hand){
        
        int pairCount = 0;
        
        for (int i = 1; i < hand.size(); i++){
                
            if (hand.get(i).getRank() == hand.get(i - 1).getRank()){
                            
                pairCount++;
                
            }
         
        }
        
        return pairCount == 2;
        
    } 
    
    // Private helper method that checks for a One Pair
    private boolean check1Pair(ArrayList<Card> hand){
        
        int pairCount = 0;
        
        for (int i = 1; i < hand.size(); i++){
                
            if (hand.get(i).getRank() == hand.get(i - 1).getRank()){
          
                pairCount++;
              
            }
            
        }
        
        return pairCount == 1;
        
    }
    
    // Private helper method that computes the payout
    private int determinePayout(String handVal){
        
        if (handVal.equals("Nothing")){
        
            return 0;
        
        }
        
        if (handVal.equals("1 Pair")){
        
            return 1;
        
        }
        
        if (handVal.equals("2 Pairs")){
        
            return 2;
        
        }
        
        if (handVal.equals("3 of a Kind")){
        
            return 3;
        
        }
        
        if (handVal.equals("Straight")){
        
            return 4;
        
        }
        
        if (handVal.equals("Flush")){
        
            return 5;
        
        }
        
        if (handVal.equals("Full House")){
        
            return 6;
        
        }
        
        if (handVal.equals("4 of a Kind")){
        
            return 25;
            
        }
        
        if (handVal.equals("Straight Flush")){
            
            return 50;
            
        }
        
        if (handVal.equals("Royal Flush")){
            
            return 250;
            
        }
        
        return -1;
        
    }
    
    // Private helper method that enables a player to replace cards
    private void askReplace(){
        
        int replaceCount = 0;
        Card currentCard;
        
        System.out.println("Your hand is: \n" + p.printHand());
        
        for (int i = 1; i <= 5; i++){
            
            currentCard = p.getHand().get((i - 1) - replaceCount);
            System.out.println("Replace Card #" + i + " ? Enter yes or no");
            
            if (input.nextLine().equals("yes")){
                
                p.removeCard(currentCard);
                replaceCount++;
                
            }
            
        }
        
        for (int i = 0; i < replaceCount; i++){
            
            p.addCard(cards.deal());
            
        }
        
        System.out.println("Your hand is: \n" + p.printHand());
        
    }
    
    // Private helper method that enables a player to bet tokens
    private int placeBet(){
        
        int bet = 10;
        
        if (p.getHand().size() == 0){
            
            System.out.println("You have " + p.getBankroll() + " tokens");
            
        }
        
        System.out.println("How many tokens will you like to bet?");
        
        while (bet <= 0 || bet > 5){
            
            System.out.println("You can only bet 1 - 5 tokens!");
            bet = Integer.parseInt(input.nextLine());
            
        }
       
        return bet;
        
    }
    
}
