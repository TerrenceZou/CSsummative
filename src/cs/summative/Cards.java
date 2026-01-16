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
public class Cards {
    String name;
    int attack;
    int block;
    int cost;
    int x;
    int y;
    private ArrayList <Cards>displayCards = new ArrayList<Cards>();
    PApplet app;
    private Cards displayedCard;
    
    
    Cards (PApplet p,String name,int attack,int block,int cost, int x, int y){
        this.name = name;
        this.attack = attack;
        this.block = block;
        this.cost = cost;
        this.app = p;
        this.x = x;
        this.y = y;
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
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    
    public boolean isClicked(int mouseX, int mouseY){
        boolean mouseInRectX = x <mouseX &&  mouseX < + x+ 50;
        boolean mouseInRectY = y < mouseY && mouseY < y + 100;
        if (mouseInRectX && mouseInRectY == true){
            return true;
        }else{
            return false;
        }
    }

    @Override
    /*
    to string method
    */
    public String toString(){
        return this.name + " " + this.attack  + " " + this.block  + " " + this.cost;
    }
    public void selectCardsDisplay(){
        if (displayCards.contains(this) == false){
            displayCards.add(this);
        }else{
            displayCards.remove(this);

        }
    }
    public void clearDisplay(){
        displayCards.clear();
    }
    public void displayStats(Cards card){
        displayedCard = card;
    }
    
    
    public void draw(){
        //draws a rectange
        if (displayCards.contains(this)){
            app.fill(255,255,0);
            app.rect(x-5,y-5,60,100);
        }
        app.fill(255,0,0);
        app.rect(x,y,50,100);
        app.fill(0,0,0);
        app.text(this.name, x+25 ,y-10);
        //display card stats better.
        
    
    }
    
    
}
