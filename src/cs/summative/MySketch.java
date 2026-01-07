/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.summative;
import processing.core.PApplet;

/**
 *
 * @author 344179247
 */
public class MySketch extends PApplet{
     public void settings(){
        size(400,400);
     }
     public void setup(){
        Cards [] deck = new Cards [5];
        deck[0] = new Cards ("I don know", 5,0,3);
        deck[1] = new Cards ("I don know", 5,0,3);
        deck[2] = new Cards ("I don know", 5,0,3);
        deck[3] = new Cards ("I don know", 5,0,3);
        
        Player fuhYou  = new Player ("fuh you", 10, deck, 10, 200 ,200);        
        if (deck[0].getCost()< fuhYou.getEnergy()){
            
            
            
            fuhYou.setEnergy(fuhYou.getEnergy() - deck[0].getCost());
            fuhYou.selectCards(deck[0]);
            System.out.print (fuhYou.getEnergy());
        } 
        
        
         
         
         
         
         
         //runs once when you start the code
         //instanceiate the player guy
     }
     public void draw(){
        background (255);
     }
}

