/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.summative;

/**
 *
 * @author 344179247
 */
public class Cards {
    String name;
    int attack;
    int block;
    int cost;
    Cards (String name,int attack,int block,int cost){
        this.name = name;
        this.attack = attack;
        this.block = block;
        this.cost = cost;
    }
    public String getName(){
        return this.name;
    }
    public int getAttack(){
        return this.attack;
    }
    public int getBlock(){
        return this.block;
    }
    public int getCost(){
        return this.cost;
    }
}
