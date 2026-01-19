/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.summative;
import processing.core.PApplet;
import java.util.ArrayList;
import processing.core.PImage;
import java.util.Collections;

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
    public final int MAX_HP = 100;
    private PImage image;
    private String imagePath;
    private boolean battleGUI = true;
    //creates a 2d array list where the first obj inside will be the current hand and the second one will be the rest of the 
    ArrayList<ArrayList<Cards>> totalDeck = new ArrayList<ArrayList <Cards>>();
    
    
    //player constructor
    public Player (PApplet p,String name, int hp, ArrayList<Cards> deck, int energy,int block, int x ,int y,String imagePath){
        super (name,hp,deck,energy,block, x, y);
        this.app = p;
        this.image = app.loadImage(imagePath);
        this.x = x;
        this.y = y;
        //the players hand
        totalDeck.add(deck);
        //the players total deck
        totalDeck.add(new ArrayList<Cards>());
    }
    
    
    public void selectCards(Cards selectedCard){
        /*
        displays card stats
        Selecting cards puts the card into the selected cards array if the player has enough energy
        handeles energy
        returns nothing
        if the player clicks the card a second time it unselects the card and refunds energy
        @param the card the user has selected.
        */
        //display card stats
        
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
    /*
    add to the users deck
    @param what you want to add to the deck
    */
    
    public void addDeck(Cards card){
        totalDeck.get(1).add(card);
    }
    /*
    get the users hand
    @return what the users hand is
    */
    
    public ArrayList<Cards> getHand(){
        return totalDeck.get(0);
    }
    /*
    clears the users hand
    */
    
    public void clearHand(){
        totalDeck.get(0).clear();
    }
    
    
    /*
    gets the total attack score from all of the players cards
    @return the total attack score
    */
    public int getAttack(){
        int attack = 0;
        for (Cards i: this.getSelectedCards()){
           attack += i.getAttack();
        }
        return attack;
     }
    /*
    gets the total block score of all of the players used cards
    @param the total block of the player
    */
    
    
    public int getBlock(){
        //gets the total block from the cards the player plays
        int block = 0;
        for (Cards i: this.getSelectedCards()){
            block += i.getBlock();
        }
        return block;
    }
    /* 
    shuffles the deck
    */
    
    public void clearSelectedCards(){
        //clears selected cards and shuffles deck
        selectedCards.clear();
        Collections.shuffle(totalDeck.get(1));
    }
    /*
    gets 4 cards from the deck and adds it to the hand
    */
    
    public void startTurn(){
        
        for (int i = 0; i < 4; i++){
            //take from the first array and adds it to the second array
            totalDeck.get(0).add(totalDeck.get(1).get(0));
            //removes it from the second array
            totalDeck.get(1).remove(0);

        }
    }
    /*
    hides the battle UI
    */
    
    public void hideBattleGUI(){
        battleGUI = false;
    }
    
    /*
    Shows the battle UI
    */
    public void showBattleGUI(){ 
        battleGUI = true;
    }
    
    
    public void draw(){
        //player png
        app.image(image,x,y-50);
        if (battleGUI != false){
            //health bar
            app.fill(255,0,0);
            app.rect(x+100,y-60,10*(this.getHp()*10/MAX_HP),20);
            app.fill(0,0,0);
            app.text(this.getHp() + "/" + MAX_HP , x+150, y-50);
            //energy thing png
            app.fill(0,150,255);
            app.ellipse(x+210,y-50,50,50);
            app.fill(0,0,0);
            app.text(this.getEnergy() +"/10", x+210,y-50);
            //attack display
            app.fill(255,0,0);
            app.ellipse(x+200,y+100,50,50);
            app.fill(0,0,0);
            app.text(this.getAttack(),x+200,y+100);
            //block display
            app.fill(0,0,255);
            app.ellipse(x+100,y+100,50,50);
            app.fill(0,0,0);
            app.text(this.getBlock(), x+100, y+100);
        }
        }
    
}
