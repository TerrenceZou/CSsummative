/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.summative;
import processing.core.PApplet;
import java.util.ArrayList;


/**
 *
 * @author 344179247
 */
public class MySketch extends PApplet{
    private Player fuhYou;
    private Enemy What;
    
     public void settings(){
        size(400,400);
     }
     
     
     public void setup(){
        background(100,100,100);
        //runs once when you start the code
        //instanceiate the player
        int block = 0;
        int encounterTimer;
        
        //init stuff
        ArrayList <Cards> deck = new ArrayList<Cards>();
        fuhYou  = new Player (this, "fuh you", 10, deck, 10,block, 200 ,200);
        deck.add(new Cards(this, "hey",0,10,9, 200, 200));
        deck.add(new Cards(this, "guys",0,10,9, 200, 200));
        deck.add(new Cards(this, "defend",0,10,9, 200, 200));
        fuhYou.selectCards(deck.get(0));
        
        //i should make a ememy array that consists of many player objects. Attacks will proabaly just be random card that they can use.
        ArrayList <Cards> enemyDeck = new ArrayList<Cards>();
        
        What = new Enemy (this, "What", 10, enemyDeck, 10, 0 , 200, 200);
        endTurn(What);
     }
     
     
     public void draw(){
        background (255);
        fuhYou.draw();
        What.draw();
        //gets the players deck and sets the card's x position to 50 more than its previous one
        for (int i =0; i < fuhYou.getDeck().size(); i++){
            fuhYou.getDeck().get(i).setX(200 + i*60);
            fuhYou.getDeck().get(i).draw();
            System.out.println(fuhYou.getDeck().get(i).getX());
        }
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
    public void endTurn(Character enemy){
        //runs the players attack and then the enemies attacks. Finally ends the turn of the user
        int outgoingDmg = getPlayerAttack();
        int incommingDmg = 11;
        incommingDmg = getPlayerBlock() - incommingDmg;
        //makes the user take damage if the users block is not sufficant
        if (incommingDmg < 0){
            fuhYou.setHp(incommingDmg + fuhYou.getHp());
        }
    }
}

