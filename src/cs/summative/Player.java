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
        //if this card has not already been selected
        if (!selectedCards.contains(selectedCard)){
            //and if you have enough energy
            if (selectedCard.getCost() <= this.getEnergy()){
                //it adds the card to the selected card array list
                selectedCards.add(selectedCard);
                //removes the energy from the player
                this.setEnergy(this.getEnergy() - selectedCard.getCost());
                //displays that this card is selected
                selectedCard.selectCardsDisplay();
            }
            else{
                System.out.println("i dont have enough energy.");
            }
        }else{
            //when unselected refunds the player of their energy
            this.setEnergy(this.getEnergy() + selectedCard.getCost());
            //removes it from the list of selected cards
            selectedCards.remove(selectedCard);
            //undisplays the card
            selectedCard.selectCardsDisplay();
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
    
    public int getBlock(){
        //gets the total block from the cards the player plays
        int block = 0;
        for (Cards i: this.getSelectedCards()){
            block += i.getBlock();
        }
        return block;
    }
    public void clearSelectedCards(){
        //clears selected cards
        selectedCards.clear();
    }
    public void draw(){
        app.fill(50,50,50);
        app.rect(x,y,100,100);
        app.fill(0,150,255);
        app.ellipse(100,350,50,50);
        app.fill(0,0,0);
        app.text(this.getEnergy() +"/10", 100,350);
        app.fill(0,0,0);
        app.text(this.getHp(), x+20, y-50);
        
        
    }
    
}
