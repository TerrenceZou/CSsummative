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
    ArrayList<Cards> deck;
    private int energy; 
    private int block;
    private int x;
    private int y;
    Character (String name, int hp, ArrayList<Cards> deck, int energy,int block, int x, int y){
        this.name = name;
        this.hp = hp;
        this.deck = deck;
        this.energy = energy;
        this.block = block;
        this.x = x;
        this.y = y;
    }
    /*
    retruns char name
    @return charater name
    */
    public String getName(){
        return this.name;
    }
    /*
    returns char hp
    @return returns char hp
    */
    public int getHp(){
        return this.hp;
    }
    /*
    returns the deck of the cards
    @return the deck
    */
    public ArrayList<Cards> getDeck(){
        return this.deck;
    }
    /*
    returns the amount of energy the user has
    @return the amount of energy the user has
    */
    public int getEnergy(){
        return this.energy;
    }
    /*
    sets the users hp
    @param the hp of the user
    */
    public void setHp(int hp){
        this.hp = hp;
    }
    /*
    sets the energy of the character
    @param the new energy
    */
    public void setEnergy(int energy){
        this.energy = energy;
    }
}

