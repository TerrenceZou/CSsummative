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
public class Player extends Character{
    private Cards [] selectedCards = new Cards [5]; 
    private Cards[] drawPile = new Cards[5];
    private Cards[] discardPile = new Cards[5];
    public Player (String name, int hp, Cards[] deck, int energy, int x ,int y){
        super (name,hp,deck,energy, x, y);
    }
    /*
    @param the selected card
    Finds the first null spot inside of the array
    puts the selected object into the first empty selected file
    */
    
    public void selectCards(Cards selectedCard){
        if (selectedCard.getCost() < this.getEnergy()){
            for (int i =0 ; i < selectedCards.length; i++){
                if (selectedCards[i] == null){
                    selectedCard = selectedCards[i];
                }
            }
        }
        if (selectedCard.getCost() > this.getEnergy()){
            System.out.println("i dont have enough energy.");
        }
        
    }//end function
    /*
    @return returns the selected cards
    returns the cards selected by the select cards function.
    */
    public Cards[] getSelectedCards(){
        return selectedCards;
    }
    public void draw(){
        
    }
}
