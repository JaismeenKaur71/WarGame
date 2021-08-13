/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class RunGame extends Game {

    public RunGame(String givenName){
        super(givenName);
    }
    
    @Override
    public void play() {
        GroupOfCards mainDeck = new GroupOfCards(52);
        mainDeck.shuffle();
        
        
        //Registering and Displaying the names of Players
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of Player1:");
        String player1name = sc.nextLine();
        Player player1 = new Player(player1name);
        
        System.out.println("Enter the name of Player2:");
        String player2name = sc.nextLine();
        Player player2 = new Player(player2name);
        
        this.getPlayers().add(player1);
        this.getPlayers().add(player2);
        
         
        System.out.println("Name of Player1 - "+ player1.getPlayerID());
        System.out.println("Name of Player2 - " + player2.getPlayerID());
        
        // Distribution of cards among players
        while(mainDeck.getSize() > 0) {
            
            Card card1 = mainDeck.removeFromTop();
            Card card2 = mainDeck.removeFromTop();

            player1.receiveCard(card1);
            player2.receiveCard(card2);
        }
        
        // Continue playing rounds until one player is out of cards.
        int numberOfRounds = 0;
        
        while(player1.getNumberOfCards() > 0 && player2.getNumberOfCards() > 0) {
            //if(verbose == true) {
                System.out.print("\n"+ player1.getPlayerID() +" has " + player1.getNumberOfCards());
                System.out.println(" cards,"+ player2.getPlayerID()+" has " + player2.getNumberOfCards() + " cards");
            //}
            player1.play(player2);
            numberOfRounds++;
        }
        
        // finding and displaying the Winner
        declareWinner(player1, player2);
        System.out.println("Number of rounds: " + numberOfRounds);
        
    }
    

    @Override
    public void declareWinner(Player player1, Player player2) {
        String winner = (player1.getNumberOfCards() == 0) ? player1.getPlayerID(): player2.getPlayerID();
        System.out.println("\n" + winner + " wins!!!");
    }
    
}
