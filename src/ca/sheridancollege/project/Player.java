/**
 * SYST 17796 Project Winter 2019 Base code.
 * Jaismeen Gill 
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 */
public class Player 
{
    private String playerID; //the unique ID for this player
    private GroupOfCards deck;
    
    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
    public Player(String name)
    {
        playerID= name;
        deck = new GroupOfCards();
    }
    
    /**
     * @return the playerID
     */
    public String getPlayerID() 
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     */
    public void play(Player player2){
        Card card1 = this.playTopCard();
        Card card2 = player2.playTopCard();
        
        printCards(card1, card2,this,player2);
        
        if(card1.getRank() > card2.getRank()) { // Player 1 wins round.
            GroupOfCards deck = new GroupOfCards();
            deck.addToTop(card1);
            deck.addToTop(card2);
            this.receiveGroupOfCards(deck);

        } else if(card2.getRank() > card1.getRank()) { // Player 2 wins round.
            GroupOfCards deck = new GroupOfCards();
            deck.addToTop(card1);
            deck.addToTop(card2);
            player2.receiveGroupOfCards(deck);

        } else { // Players tie, go to war.

            // These decks will contain the cards that players 1
            // and 2, respectively, have laid down this round.
            GroupOfCards deck1 = new GroupOfCards();
            GroupOfCards deck2 = new GroupOfCards();
            deck1.addToTop(card1);
            deck2.addToTop(card2);

            war(this, player2, deck1, deck2);
        }
        
    }  
    
    void war(Player player1, Player player2, GroupOfCards deck1, GroupOfCards deck2) {

        // If a player doesn't have enough cards to continue, we return all of
        // the cards each player has laid down to the bottom of their decks.
        if(player1.getNumberOfCards() < 4 || player2.getNumberOfCards() < 4) {
            player1.receiveGroupOfCards(deck1);
            player2.receiveGroupOfCards(deck2);

        } else {

            // Each player plays three card face down.
            Card faceDown1 = player1.playTopCard();
            Card faceDown2 = player2.playTopCard();
            deck1.addToTop(faceDown1);
            deck2.addToTop(faceDown2);
            
            Card faceDown3 = player1.playTopCard();
            Card faceDown4 = player2.playTopCard();
            deck1.addToTop(faceDown3);
            deck2.addToTop(faceDown4);
            
            Card faceDown5 = player1.playTopCard();
            Card faceDown6 = player2.playTopCard();
            deck1.addToTop(faceDown5);
            deck2.addToTop(faceDown6);

            // Then each player plays one card face up.
            Card faceUp1 = player1.playTopCard();
            Card faceUp2 = player2.playTopCard();
            deck1.addToTop(faceUp1);
            deck2.addToTop(faceUp2);

            //if(verbose == true) {
                System.out.println("War:");
                printCards(faceUp1, faceUp2, player1, player2);
            //}

            if(faceUp1.getRank() > faceUp2.getRank()) { // Player 1 wins round.
                player1.receiveGroupOfCards(deck1);
                player1.receiveGroupOfCards(deck2);

            } else if(faceUp2.getRank() > faceUp1.getRank()) { // Player 2 wins round.
                player2.receiveGroupOfCards(deck1);
                player2.receiveGroupOfCards(deck2);

            } else { // Players tie, go to war again.
                war(player1, player2, deck1, deck2);
            }
        }
    }
    
    public void receiveGroupOfCards(GroupOfCards bottomCards){
        deck.addToBottom(bottomCards);
    }
    
    public void receiveCard(Card card){
        deck.addToTop(card);
    }
    
    public Card playTopCard(){
        Card topCard = deck.removeFromTop();
        return topCard;
    }
    
    public int getNumberOfCards(){
        return deck.getSize();
    }
    
    // Print the cards played by each player.
    void printCards(Card card1, Card card2,Player player1, Player player2) {
        System.out.print( player1.getPlayerID() + " plays ");
        System.out.println(card1.toString());
        System.out.print(player2.getPlayerID() +" plays ");
        System.out.println(card2.toString());
    }
    
    
}
