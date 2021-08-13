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
public class Main {
       
    public static void main(String[]args){
        
        // Setting and Displaying the Game Name
        RunGame rg = new RunGame("War Game");
        System.out.println(rg.getGameName());
        rg.play();
   }
}

