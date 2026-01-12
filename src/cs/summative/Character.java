/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.summative;
import java.util.ArrayList;
import processing.core.PApplet;

/**
 *
 * @author 344179247
 */
public class Character {
    private int hp;
    private String name;
    private ArrayList<Cards> deck;
    private int energy; 
    private int block;
    private int x;
    private int y;
    //private PApplet charSprite;
    Character (String name, int hp, ArrayList<Cards> deck, int energy,int block, int x, int y){
        this.name = name;
        this.hp = hp;
        this.deck = deck;
        this.energy = energy;
        this.block = block;
        this.x = x;
        this.y = y;
        //this.charSprite = charSprite;
    }
    public String getName(){
        return this.name;
    }
    public int getHp(){
        return this.hp;
    }
    public ArrayList<Cards> getDeck(){
        return this.deck;
    }
    public int getEnergy(){
        return this.energy;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setEnergy(int energy){
        this.energy = energy;
    }
}

