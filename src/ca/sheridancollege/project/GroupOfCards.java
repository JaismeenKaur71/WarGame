/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards()
    {       
        cards = new ArrayList<Card>();
    }
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        
        cards = new ArrayList<Card>();
        
        if(givenSize==52){
            for(int i = 0; i <= 3; i++) {
                // For each value of card with this suit.
                for(int j = 2; j <= 14; j++) {
                    Card card = new Card(suits[i], j);
                    cards.add(card);
                    
                }
            }
            System.out.println("Deck Created Successfully");
        }
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize() {
        size = cards.size();
    }
    
    // Remove a card from the top of the deck and return that card.
    public Card removeFromTop() {
        
        Card card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        setSize();
        return card;
    }
    
    
    // Add a card to the top of the deck.
    public void addToTop(Card topCard) {
        cards.add(topCard);
        setSize();
    }

    // Add a group of cards to the bottom of a deck. Shuffle
    // the group of cards first to ensure randomness.
    public void addToBottom(GroupOfCards bottomCards) {
        bottomCards.shuffle();

        while(bottomCards.getSize() > 0) {
            cards.add(0, bottomCards.removeFromTop());
            setSize();
        }
    }
}//end class
