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
    int encounterTimer;
    Cards selectedCard;
    private TurnEnd endTurn;
    
    
    
     public void settings(){
        size(600,600);
     }
     
     
     public void setup(){
        background(100,100,100);
        //runs once when you start the code
        //instanceiate the player
        int block = 0;
        
        //init array for player and enemy
        ArrayList <Cards> deck = new ArrayList<Cards>();
        ArrayList <Cards> enemyDeck = new ArrayList<Cards>();
        
        
        //init player cards
        deck.add(new Cards(this, "hey",0,10,9, 300, 500));
        deck.add(new Cards(this, "guys",0,10,9, 300, 500));
        deck.add(new Cards(this, "defend",0,10,9, 300, 500));
        deck.add(new Cards(this, "superPowers",0,10,9, 300, 500));
        
        //init enemy cards
        enemyDeck.add(new Cards(this, "EnemyAttack1",20000,0,9, 300, 500));
        enemyDeck.add(new Cards(this, "EnemyAttack2",20000,0,9, 300, 500));
        
        //inint player and enemy
        fuhYou  = new Player (this, "fuh you", 10, deck, 10,block, 0 ,150);
        What = new Enemy (this, "What", 10, enemyDeck, 10, 0 , 200, 200);
        
        // init the end turn button
        endTurn = new TurnEnd(this,450,450);
     }
     
     
     public void draw(){
        background (255);
        fuhYou.draw();
        endTurn.draw();
        //gets the players deck and sets the card's x position to 50 more than its previous one
        for (int i =0; i < fuhYou.getDeck().size(); i++){
            fuhYou.getDeck().get(i).setX(100 + i*60);
            fuhYou.getDeck().get(i).draw();
        }
        checkCollisions();
     }
     
     //should be in player class
     
     
    //should be in player class
    public int getPlayerBlock(){
        //gets the total block from the cards the player plays
        int block = 0;
        for (Cards i: fuhYou.getSelectedCards()){
            block += i.getBlock();
        }
        return block;
    }
    public void endTurn(Enemy enemy){
        /*
        runs the players attack and then the enemies attacks. Finally ends the turn of the user
        @param the enemy
        */
        //player turn
        int playerAttack = fuhYou.getAttack();
        playerAttack = enemy.getBlock() - fuhYou.getAttack();
        if (playerAttack < 0){
            enemy.setHp(enemy.getHp() +playerAttack);
        }
        
        
        
        //enemy turn
        int EnemyAttack = enemy.getAttack();
        //takes the enemy's attack and reduces the player block by that number. If the enemy's attack is greater than the players block make them take damage.
        EnemyAttack = getPlayerBlock() - EnemyAttack;
        //makes the user take damage if the enemy attack is now a negative value
        if (EnemyAttack < 0){
            fuhYou.setHp(EnemyAttack + fuhYou.getHp());
        }
        //resets the encounter to the start and sets the players energy to the maximum
        fuhYou.setEnergy(10);
        encounterTimer = 0;
    }
    
    
    public boolean checkCollisions(){
        //checks if the mouse collides with a card
        for (Cards i : fuhYou.getDeck())
            if (i.isClicked(mouseX, mouseY)){
                selectedCard=  i;
                return true;
            }
            return false;
        
    }
    public boolean checkEndTurnCollisions(){
        //checks if the mouse clicks the turn end button
        if (endTurn.isClicked(mouseX,mouseY)){
            return true;
        }
        return false;
    }
    public void mousePressed(){
        //if the card is clicked select the card
        if (checkCollisions()){
            fuhYou.selectCards(selectedCard);
        }
        if (checkEndTurnCollisions()){
            //if the player clicks the turn end button it ends the turn.
            endTurn(What);
            System.out.println(true);
        }
        
    }
    
}

