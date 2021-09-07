
public class Card implements Comparable<Card>{

    // Instance variables
    private int suit; // integers 1-4 encode the suit
    private int rank; // integers 1-13 encode the rank
     
    // Constructor 1 
    // Instantiates a Card with integers s and r for suit and rank
    public Card(int s, int r){
        
        suit = s;
        rank = r;
        
    }

    // Constructor 2
    // Instantiates a Card with string value such "s1" or "d13"
    public Card(String testCard){
        
        switch(testCard.charAt(0)){
            case 'c':
                suit = 1;
                break;
            case 'd':
                suit = 2;
                break;
            case 'h':
                suit = 3;
                break;
            case 's':
                suit = 4;
        }
        
        rank = Integer.parseInt(testCard.substring(1, testCard.length()));
        
    }

    // compareTo method that establishes natural ordering of Card objects
    public int compareTo(Card c){
  
        int comparisonVal = 0;
        
        if (rank > c.getRank()){
            
            comparisonVal = 1;
            
        }
        
        else if (rank < c.getRank()){
            
            comparisonVal = -1;
            
        }
        
        else if (rank == c.getRank()){
            
            if (suit > c.getSuit()){
                
                comparisonVal = 1;
                
            }
            
            else if (suit < c.getSuit()){
                
                comparisonVal = -1;
                
            }
            
            else if (suit == c.getSuit()){
                
                comparisonVal = 0;
                
            }
            
        }
        
        return comparisonVal;

    }

    // toString() method that enables printing of Card objects
    public String toString(){
        
        return rankName() + " of " + suitName();
      
    }
    
    // Accessor method for the suit of a card
    public int getSuit(){
        
        return suit;
        
    }
    
    // Accessor method for the rank of a card
    public int getRank(){
        
        return rank;
        
    }
   
    // Private helper method that returns suit as a string
    private String suitName(){
        
        if (suit == 1){
            
            return "Clubs";
            
        }
        
        else if (suit == 2){
            
            return "Diamonds";
            
        }
        
        else if (suit == 3){
            
            return "Hearts";
            
        }
        
        else{
            
            return "Spades";
            
        }
        
    }

    // Private helper method that returns rank as a string
    private String rankName(){
        
        if (rank == 1){
            
            return "Ace";
            
        }
        
        else if (rank == 11){
            
            return "Jack";
            
        }
        
        else if (rank == 12){
            
            return "Queen";
            
        }
        
        else if (rank == 13){
            
            return "King";
            
        }
        
        else{
            
            return "" + rank;
            
        }
        
    }

}
