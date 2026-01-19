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
    private Cards shownStats;
    
    
    Cards (PApplet p,String name,int attack,int block,int cost, int x, int y){
        /*
        cards for the players use
        @param Papplet p visuals
        @param name, name of cards
        @param attack, attack of the card
        @param block, block of the card
        @param cost, cost of the card
        @param x, x pos of the card
        @param y, y pos of the card
        */
        this.name = name;
        this.attack = attack;
        this.block = block;
        this.cost = cost;
        this.app = p;
        this.x = x;
        this.y = y;
    }
    Cards (PApplet p,int attack,int block){
        /*
        cards for the enemy use
        @param Papplet p, visuals might be unused
        @param attack, attack of card
        @param block, block of the card
        */
        this.app = p;
        this.attack = attack;
        this.block = block;
    }
    public String getName(){
        /*
        returns the name of the card
        @return the name of the card
        */
        return this.name;
    }
    
    public int getAttack(){
        /*
        gets attack of card
        @return attack of card
        */
        return this.attack;
    }
    
    public int getBlock(){
        /*
        gets block of card
        @return block fo card
        */
        return this.block;
        
    }
    
    public int getCost(){
        /*
        gets cost of card
        @returns cost of card
        */
        return this.cost;
    }
    
    public void setX(int x){
        /*
        sets the x value of the card
        @param the x desired x value of this card
        */
        this.x = x;
    }
    
    public int getX(){
        /*
        gets the x value of this card
        @return the x value of this card
        */
        return this.x;
    }
    public int getY(){
        /*
        gets the Y value of this card
        @return the Y value of this card
        */
        return this.y;
    }
    
    public boolean isClicked(int mouseX, int mouseY){
        /*
        collison detection for the cards
        @param the mouse coordinates 
        @return returns true if the mouse is within the card else returns false
        */
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
        /*
        toString method for cards mainly for debug
        @reurn the cards stats
        */
        return this.name + " " + this.attack  + " " + this.block  + " " + this.cost;
    }
    public void selectCardsDisplay(){
        /*
        selects a card to display
        */
        if (displayCards.contains(this) == false){
            displayCards.add(this);
        }else{
            displayCards.remove(this);

        }
    }
    public void clearDisplay(){
        /*
        slears the card display
        */
        displayCards.clear();
    }
    public void displayStats(Cards card){
        /*
        displays the stats of the specified card, if the card is not the one in the parameters do not display it
        @param the card you would like to display the stats of
        */
        if (this == card){
            shownStats = this;
        }
        else {
            shownStats = null;
        }
    }
    /*
    clears the selected stats
    */
    public void clearSelectedStats(){
        
        shownStats = null;
    }
    
    
    public void draw(){
        //draws the cards
        if (displayCards.contains(this)){
            app.fill(255,255,0);
            app.rect(x-5,y-5,60,100);
        }
        app.fill(255,0,0);
        app.rect(x,y,50,100);
        app.fill(0,0,0);
        app.text(this.name, x+25 ,y-10);
        //display card stats at the display cards area.
        if (shownStats!= null){
            app.text("Card Stats", 75,460);
            app.text (this.name, 75,500);
            app.text("cost: " + this.cost, 75,525);
            app.text("attack: " + this.attack, 75, 550);
            app.text("block: " + this.block, 75, 575);
        }
    }
    
}
