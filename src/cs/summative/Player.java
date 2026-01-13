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
public class Player extends Character{
    PApplet app;
    //creates an array list of selectedCards
    ArrayList <Cards> selectedCards = new ArrayList<Cards>();
    private int x;
    private int y;
    public Player (PApplet p,String name, int hp, ArrayList<Cards> deck, int energy,int block, int x ,int y){
        super (name,hp,deck,energy,block, x, y);
        this.app = p;
        this.x = x;
        this.y = y;
    }
    /*
    @param the selected card
    Finds the first null spot inside of the array
    puts the selected object into the first empty selected file
    */
    
    public void selectCards(Cards selectedCard){
        /*
        Selecting cards puts the card into the selected cards array if the player has enough energy
        handeles energy
        returns nothing
        if the player clicks the card a second time it unselects the card and refunds energy
        @param the card the user has selected.
        */
        //if you have enough energy
        if (!selectedCards.contains(selectedCard)){
            if (selectedCard.getCost() <= this.getEnergy()){
                //selects the card into the selected card array in the first empty slot
                selectedCards.add(selectedCard);
                //removes the energy from the player
                this.setEnergy(this.getEnergy() - selectedCard.getCost());
            }
            else{
                System.out.println("i dont have enough energy.");
            }
        }else{
            this.setEnergy(this.getEnergy() + selectedCard.getCost());
            selectedCards.remove(selectedCard);
        }
        
    }//end function
    /*
    @return returns the selected cards
    returns the cards selected by the select cards function.
    */
    public ArrayList<Cards> getSelectedCards(){
        return selectedCards;
    }
    public int getAttack(){
            //gets the total attack score from the players cards.
        int attack = 0;
        for (Cards i: this.getSelectedCards()){
           attack += i.getAttack();
        }
        return attack;
     }
    
    public void draw(){
        app.fill(50,50,50);
        app.rect(x,y,100,100);
        
        
    }
    
}
