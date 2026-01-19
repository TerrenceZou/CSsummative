/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.summative;
import java.util.Random;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;


/**
 *
 * @author 344179247
 */
public class Enemy extends Character{
    private int hp;
    private String name;
    private ArrayList<Cards> deck = new ArrayList<Cards>();
    private int energy; 
    private int block;
    private PApplet app;
    private int x;
    private int y;
    public final int MAX_HP = 100;
    private PImage image;
    private boolean battleGUI = true;
    Cards enemyCard = new Cards(app,15,10);
    public Enemy (PApplet p, String name, int hp, ArrayList<Cards> deck ,int energy,int block, int x, int y,String imagePath){
        /*
        enemy class
        */
        super (name,hp,deck,energy,block, x, y);
        this.app = p;
        this.deck = deck;
        this.x = x;
        this.y = y;
        this.image = app.loadImage(imagePath);
    }
    /*
    selects a random card from the user
    */
    
    public void getEnemyCard(){
        //Makes the enemy use a random card from their deck.
        Random rand = new Random();
        int randInt = rand.nextInt(this.deck.size()-1);
        enemyCard = this.deck.get(randInt);
    }
    /*
    gets the attack of the random card
    @return the attack score
    */

    public int getAttack(){
        //if the enemy is alive get their attack
        if (this.getHp() >= 1){
            return enemyCard.getAttack();
        }

        return 0;
    }
    /*
    gets the block of the random card
    @return the block score
    */
    public int getBlock(){
        /*
        gets the enemy block
        @return the enemies block from the card it plays
        */
        return enemyCard.getBlock();
    }
    /*
    hides the battle GUI
    */
    public void hideBattleGUI(){
    battleGUI = false;
    }
    /*sets the Y value of the enemy
    @param new Y value
    */
    public void setY(int y){
        this.y = y; 
    }
    
    
    
    public void draw(){
        //enemy draw
        app.image(image, x-100,y-75);
        if (battleGUI != false){
            //health bar 
            app.fill(255,0,0);
            app.rect(x,y-60,10*(this.getHp()*10/MAX_HP),20);
            app.fill(0,0,0);
            app.text(this.getHp() + "/" + MAX_HP , x+50, y-50);
            //display enemy attack
            app.fill(255,0,0);
            app.ellipse(x+100,y+100,50,50);
            app.fill(0,0,0);
            app.text(enemyCard.getAttack(), x+100, y+100);
            //get enemy block
            app.fill(0,0,255);
            app.ellipse(x,y+100,50,50);
            app.fill(0,0,0);
            app.text(enemyCard.getBlock(), x, y+100);
        }
    }
    
}
