
import java.util.Arrays;

public class Deck {

    // Instance variables
    private Card[] cards;
    private int top; //the index of the top of the deck

    // Constructor
    // Instantiates a 52-card deck
    public Deck(){
        
        cards = new Card[52];
        
        int i = 0;
        
        for (int suit = 1; suit <= 4; suit++){
            
            for (int rank = 1; rank <= 13; rank++){
                
                cards[i] = new Card(suit, rank);
                i++;
                
            }
            
        }
        
        top = 0;
        
    }

    // shuffle() method for shuffling the cards in the deck
    public void shuffle(){
        
        for (int i = 0; i < 1000; i++){
            
            int random1 = (int) (Math.random() * 52);
            int random2 = (int) (Math.random() * 52);
            
            Card temp = cards[random1];
            cards[random1] = cards[random2];
            cards[random2] = temp;
            
        }
        
        top = 0;
        
    }

    // deal() method that deals the top card in the deck
    public Card deal(){
        
        if (top > 51){
            
            shuffle();
            
        }
        
        top++;
        
        return cards[top - 1];
       
    }

}
