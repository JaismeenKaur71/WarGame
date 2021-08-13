/**
c * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 */
public class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    private String suit;
    private int rank;
    static final String[] faceCards = { "Jack", "Queen", "King", "Ace" };
    
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public int getRank() {
        return rank;
    }
    
    public String getName() {
        if(rank <= 10) {
            return "" + rank;
        } else {
            return faceCards[rank - 11];
        }
    }
    
    
    
    
    
    @Override
    public String toString(){
        return getName()+" of "+suit;
    }
    
}
