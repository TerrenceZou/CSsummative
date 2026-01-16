/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.summative;
import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author 344179247
 */
public class MySketch extends PApplet{
    private Player fuhYou;
    private Enemy What;
    int encounterTimer;
    public Cards selectedCard;
    private TurnEnd endTurn;
    PApplet app = this;
    int stage = 0;
    ArrayList <Cards> deck = new ArrayList<Cards>();

    
    
    public void settings(){
        size(600,600);
     }
     
     
     public void setup(){
        background(100,100,100);
        //runs once when you start the code
        int block = 0;
        
        //init array for player and enemy
        ArrayList <Cards> enemyDeck = new ArrayList<Cards>();
        
        //init text size and center align it.
        textAlign(CENTER, CENTER);
        textSize(12);


        
        //init player cards
        deck.add(new Cards(this, "hey",2,3,3, 300, 500));
        deck.add(new Cards(this, "guys",3,3,4, 300, 500));
        deck.add(new Cards(this, "defend",4,3,5, 300, 500));
        deck.add(new Cards(this, "superPowers",8,3,1, 300, 500));
        
        //init enemy cards
        enemyDeck.add(new Cards(this, "EnemyAttack1",8,1,9, 300, 500));
        enemyDeck.add(new Cards(this, "EnemyAttack2",3,1,9, 300, 500));
        
        //inint player and enemy
        fuhYou  = new Player (this, "fuh you", 10, deck, 10,block, 100 ,250);
        What = new Enemy (this, "What", 10, enemyDeck, 10, 0 , 300, 250);
        
        // init the end turn button
        endTurn = new TurnEnd(this,550,450);
     }
     
     
     public void draw(){
        background (255);
        if (stage == 0){
            //a starting animation for the story
        }
        if (stage == 1){
            app.fill(188,158,130);
            app.rect(0,450,600,150);
            app.fill(150,75,0);
            app.rect(0,450,150,150);
            fuhYou.draw();
            endTurn.draw();
            What.draw();
            //gets the players deck and sets the card's x position to 50 more than its previous one
            for (int i =0; i < fuhYou.getDeck().size(); i++){
                //draws all of the users cards inside of their deck minus a bit
                fuhYou.getDeck().get(i).setX(width/(fuhYou.getDeck().size()) + i*60 + 150);
                fuhYou.getDeck().get(i).draw();
            }
            checkCollisions();
         }
        if (stage == 2){
            //an ending anim if the enemy is dead
        }
     }
     
    public void endTurn(Enemy enemy){
        /*
        runs the players attack and then the enemies attacks. Finally ends the turn of the user
        @param the enemy
        */
        
        //player turn
        int playerAttack = fuhYou.getAttack();
        playerAttack = enemy.getBlock() - playerAttack;
        if (playerAttack < 0){
            enemy.setHp(enemy.getHp() +playerAttack);
            if (enemy.getHp() <= 0){
                stage = 2;
            }
        }
        //enemy turn
        int EnemyAttack = enemy.getAttack();
        //takes the enemy's attack and reduces the player block by that number. If the enemy's attack is greater than the players block make them take damage.
        EnemyAttack = fuhYou.getBlock()- EnemyAttack;
        //makes the user take damage if the enemy attack is now a negative value
        if (EnemyAttack < 0){
            fuhYou.setHp(EnemyAttack + fuhYou.getHp());
        }
        //resets the encounter to the start and sets the players energy to the maximum
        fuhYou.setEnergy(10);
        //clears the display for the encounter
        for (Cards i: fuhYou.getDeck()){
            i.clearDisplay();
            }
        //clears the selected cards 
        fuhYou.clearSelectedCards();
        //randomises the players cards
        Collections.shuffle(deck);
        //for animations/intermissions
        encounterTimer = 0;
    }
    
    
    public boolean checkCollisions(){
        //checks if the mouse collides with a card
        for (Cards i : fuhYou.getDeck())
            if (i.isClicked(mouseX, mouseY)){
                selectedCard = i;
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
        if (stage == 0){
            stage = 1;
        }
        
        
        if (stage == 1){
            //if the card is clicked select the card
            if (checkCollisions()){
                fuhYou.selectCards(selectedCard);
                //selectedCard.displayStats();
            }
            if (checkEndTurnCollisions()){
                //if the player clicks the turn end button it ends the turn.
                endTurn(What);
            }
        }
        
    }
    
}

