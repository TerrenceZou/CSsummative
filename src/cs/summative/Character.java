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
public class Character {
    private int hp;
    private String name;
    private Cards [] deck;
    private int energy; 
    private PApplet charSprite;
    Character (String name, int hp, Cards[] deck, int energy, PApplet charSprite){
        this.name = name;
        this.hp = hp;
        this.deck = deck;
        this.energy = energy;
        this.charSprite = charSprite;
    }
    public String getName(){
        return this.name;
    }
    public int getHp(){
        return this.hp;
    }
    public Cards [] getDeck(){
        return this.deck;
    }
    public int getEnergy(){
        return this.energy;
    }
}

