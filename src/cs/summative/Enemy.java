/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.summative;
import java.util.Random;
import java.util.ArrayList;
import processing.core.PApplet;


/**
 *
 * @author 344179247
 */
public class Enemy extends Character{
    private int hp;
    private String name;
    private ArrayList<Cards> deck;
    private int energy; 
    private int block;
    private PApplet app;
    private int x;
    private int y;
    
    public Enemy (PApplet p, String name, int hp, ArrayList<Cards> deck ,int energy,int block, int x, int y){
        super (name,hp,deck,energy,block, x, y);
        this.app = p;
    }

    public Cards getEnemyCard(){
        //Makes the enemy use a random card from their deck.
        Random rand = new Random();
        int randInt = rand.nextInt(this.deck.size());
        return this.deck.get(randInt);
    }
    public void draw(){
        app.fill(255,0,0);
        app.rect(200,200,100,50);
    }
        
    
}
