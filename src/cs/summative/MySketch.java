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
    private Player fuhYou;
    
    
     public void settings(){
        size(400,400);
     }
     
     
     public void setup(){
        background(100,100,100);
         //runs once when you start the code
         //instanceiate the player
        Cards [] deck = new Cards [1];
        int block = 0;
        fuhYou  = new Player (this,"fuh you", 10, deck, 10,block, 200 ,200);
        deck[0] = new Cards("defend",0,10,9);
        fuhYou.selectCards(deck[0]);
        
        //i should make a emeny array that consists of many player objects. Attacks will proabaly just be random card that they can use.
        endTurn();
     }
     public void draw(){
        background (255);
        fuhYou.draw();
     }
     public int getPlayerAttack(){
        //gets the total attack from the cards the player makes
        int attack = 0;
        for (Cards i: fuhYou.getSelectedCards()){
           attack += i.getAttack();
        }
        return attack;
    }
    public int getPlayerBlock(){
        //gets the total block from the cards the player plays
        int block = 0;
        for (Cards i: fuhYou.getSelectedCards()){
            block += i.getBlock();
        }
        return block;
        
        
    }
    public void endTurn(){
        //runs the players things and then the enemies attacks. Finally ends the turn of the user
        int incommingDmg = 11;
        int damage = getPlayerBlock() - incommingDmg;
        //makes the user take damage if the users block is not sufficant
        if (damage < 0){
            fuhYou.setHp(damage + fuhYou.getHp());
        }
        
        
        
        
        
    }
}

