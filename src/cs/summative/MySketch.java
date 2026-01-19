/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs.summative;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PImage;

/**
 *
 * @author 344179247
 */
public class MySketch extends PApplet{
    //init everything
    public Player liu_Bei;
    private Enemy lu_Bu;
    int encounterTimer;
    public Cards selectedCard;
    private TurnEnd endTurn;
    PApplet app = this;
    private PImage cao_Cao;
    private PImage deathScreen;
    private PImage battleBackground;
    private PImage grassBackground;
    private PImage jailCell;
    int stage = 0;
    //init array for player and enemy
    ArrayList <Cards> enemyDeck = new ArrayList<Cards>();
    ArrayList <Cards> deck = new ArrayList<Cards>();
    int counter = 0;
    int turnCounter = 0;
    String displayText;
    int [] scores  = new int [5];
    File file = new File("fileData.txt"); 



    
    
    public void settings(){
        //sets the size of the window
        size(600,600);
     }
     
     
     public void setup(){
         //runs once when you start the code
        background(100,100,100);
        //init text size and center align it.
        textAlign(CENTER, CENTER);
        textSize(20);
        //loads all images
        deathScreen = loadImage("images/deathScreen.png");
        battleBackground = loadImage("images/battleBackground.jpg");
        cao_Cao = loadImage("images/cao_cao.png");
        grassBackground = loadImage("images/grassBackGround.jpg");
        jailCell = loadImage("images/prisonCell.png");
        //init player cards and stats player uses this because they have a 2d array, these are the cards that they can use, deck is what's being displayed
        int block = 0;
        Cards [] playerDeck = new Cards [10];
        playerDeck[0] = new Cards(this, "Slash",12 ,0,3, 300, 500);
        playerDeck[1] = new Cards(this, "Slash",12 ,0,3, 300, 500);
        playerDeck[2] = new Cards(this, "hit & block",3, 6,3, 300, 500);
        playerDeck[3] = new Cards(this, "hit & block",3, 6,3, 300, 500);
        playerDeck[4] = new Cards(this, "Block",0,8,3, 300, 500);
        playerDeck[5] = new Cards(this, "Block",0,8,3, 300, 500);
        playerDeck[6] = new Cards(this, "Heavy Strike",25,0,5, 300, 500);
        playerDeck[7] = new Cards(this, "Strike", 8 ,0 ,2,300,500);
        playerDeck[8] = new Cards(this, "Strike", 8 ,0 ,2,300,500);
        playerDeck[9] = new Cards(this, "Block",0,8,3, 300, 500);

        //init enemy cards
        enemyDeck.add(new Cards(this,15,10));
        enemyDeck.add(new Cards(this,20,5));
        enemyDeck.add(new Cards(this,30,0));
        enemyDeck.add(new Cards(this,0,20));
        enemyDeck.add(new Cards(this,8,17));



        
        //inint player and enemy
        liu_Bei  = new Player (this, "liu bei", 100, deck, 10,block, 350 ,250,"images/liu_bei.png");
        lu_Bu = new Enemy (this, "Lu Bu", 100, enemyDeck, 10, 0 , 60, 250,"images/lu.bu.png");
        //add player cards to deck
        for (Cards i : playerDeck){
            liu_Bei.addDeck(i);
        }
        //create the first hand
        liu_Bei.startTurn();
        // init the end turn button
        endTurn = new TurnEnd(this,550,450);
        //gets all the scores for the leaderboard
        try{
            int scoreNumber = 0;
                Scanner fileInput = new Scanner (new File ("fileData.txt"));
                while (fileInput.hasNextLine()){
                    displayText = fileInput.nextLine();
                    if (scoreNumber ==4){
                        break;
                    }else{
                        scores[scoreNumber] = Integer.valueOf(displayText);
                        scoreNumber++;
                    }
               }
            }catch(IOException e){
            System.out.print(e);
            }
     }
     
     
     
     public void draw(){
        background (255);
        if (stage == 0 && counter == 0){
            //intro 
            app.fill(255,255,255);
            app.rect(10,10,150,125);
            app.fill(0,0,0);
            text("Romance of the Three Kingdoms", 300,200);
            text("PREVIOUS", 75,25);
            for (int i = 0;  i < scores.length; i++){
                text ("Turn Count: " + scores[i] + "\n",75,50+i*20);
            }
        }
        if (stage == 0 && counter == 1){
            //cutscene 1
            image(grassBackground,0,0,width,height);
            text("During the late Han dynasty both Liu Bei and Cao Cao \n had been betrayed by Lu Bu", 300,150);
            liu_Bei.draw();
            liu_Bei.hideBattleGUI();
            image(cao_Cao,0,200,250,150);
        }
        if (stage == 0 && counter == 2){
        //cutscene 2
         image(grassBackground,0,0,width,height);
         text("So they had decided to team up and fight Lu Bu", 300,150);
         liu_Bei.draw();
         image(cao_Cao,0,200,250,150);
     }
        if (stage == 0 && counter == 3){
            //cutscene 3
            image(grassBackground,0,0,width,height);
            text("You will be playing as Liu Bei and fighting against Lu Bu", 300,150);
            liu_Bei.draw();
        }
        
        
        if (stage == 1){
            //background for the fight
            image(battleBackground,0,0,width,height);
            //gui for the deck board
            app.fill(188,158,130);
            app.rect(0,450,600,150);
            app.fill(150,75,0);
            app.rect(0,450,150,150);
            //draws players and the enemy
            liu_Bei.draw();
            endTurn.draw();
            lu_Bu.draw();
            //gets the players deck and sets the card's x position to 50 more than its previous one
            for (int i =0; i < liu_Bei.getDeck().size(); i++){
                //draws all of the users cards inside of their deck minus a bit
                liu_Bei.getDeck().get(i).setX(175 + i*100);
                liu_Bei.getDeck().get(i).draw();
            }
            
            //displays the stats of the last card you selected
            for (Cards i : liu_Bei.getDeck()){
                if (liu_Bei.getSelectedCards().size() > 0){
                    i.displayStats(liu_Bei.getSelectedCards().get(liu_Bei.getSelectedCards().size()-1));
                }
            }
            
            //if there is no selected cards display no cards
            if (liu_Bei.getSelectedCards().isEmpty()){
                for (Cards i : liu_Bei.getDeck()){
                    i.clearSelectedStats();
                }
            checkCollisions();
            
            }
        }
        if (stage == 2){
            //victory screen
            image(jailCell,0, 0,width,height);
            lu_Bu.hideBattleGUI();
            lu_Bu.setY(500);
            lu_Bu.draw();
            
            text("you have defeted Lu Bu, finnally defeating the flying general", 300,150);
            
        }
        if (stage == 3){
            //an ending anim if the player is dead
            image(deathScreen,0,0,width,height);
            app.fill(255,255,255);
            app.text("You died click anywhere to retry",300,450);
        }
     }
     
    public void endTurn(Enemy enemy){
        /*
        runs the players attack and then the enemies attacks. Finally ends the turn of the user
        @param the enemy
        */
        
        //player turn
        int playerAttack = liu_Bei.getAttack();
        playerAttack = enemy.getBlock() - playerAttack;
        if (playerAttack < 0){
            enemy.setHp(enemy.getHp() +playerAttack);
            //increment turn counter
            turnCounter++;
            //if the enemy dies then change to stage 2
            if (enemy.getHp() <= 0){
                try{
                //checks if the players turn count is lower than any of the others scores saved in the array, skips over anything 0.
                Scanner fileInput = new Scanner (new File ("fileData.txt"));
                FileWriter writer = new FileWriter ("fileData.txt",true);
                PrintWriter output = new PrintWriter (writer);
                for(int i =0;i < 5; i++){
                    if (fileInput.hasNextLine() && turnCounter < Integer.valueOf(fileInput.nextLine()) && Integer.valueOf(fileInput.nextLine()) != 0 ){
                        //if it is add it to the scoreboard
                        output.println(turnCounter);
                        break;
                        
                    }else{
                        if (i < 5 ){
                            //if there is not enough scores on the board add it to the list
                            output.println(turnCounter);
                            System.out.print(fileInput);

                            break;
                        }
                    }
                }
                output.close();
            }catch(IOException e){
                System.out.println(e);
            }
                stage = 2;
            }
        }
        //enemy turn
        int EnemyAttack = enemy.getAttack();
        //takes the enemy's attack and reduces the player block by that number. If the enemy's attack is greater than the players block make them take damage.
        EnemyAttack = liu_Bei.getBlock()- EnemyAttack;
        //makes the user take damage if the enemy attack is now a negative value
        if (EnemyAttack < 0){
            liu_Bei.setHp(EnemyAttack + liu_Bei.getHp());
            if (liu_Bei.getHp() <= 0){
                stage = 3;
            }
        }
        //resets the encounter to the start and sets the players energy to the maximum
        liu_Bei.setEnergy(10);
        //clears the display for the turn and adds it to the deck
        for (Cards i: liu_Bei.getDeck()){
            i.clearDisplay();
            liu_Bei.addDeck(i);
            }
        //clears the selected cards 
        liu_Bei.clearSelectedCards();
        //for animations/intermissions
        encounterTimer = 0;
        //clears the hand of the player
        liu_Bei.clearHand();
        //adds new cards to the hand
        liu_Bei.startTurn();
        //changes the card the enemy uses
        lu_Bu.getEnemyCard();
    }
    
    
    public boolean checkCollisions(){
        //checks if the mouse collides with a card
        for (Cards i : liu_Bei.getDeck())
            if (i.isClicked(mouseX, mouseY)){
                selectedCard = i;
                return true;
            }
        return false;
        
    }
    public boolean checkEndTurnCollisions(){
        //checks if the mouse clicks the turn end button
        if (endTurn.isClicked(mouseX,mouseY)){
            return true;
        }
        return false;
    }
    public void mousePressed(){
        //increments if the player is clicking
        if (stage == 0){
            counter++;
            if (counter == 4){
                liu_Bei.showBattleGUI();
                stage = 1;
                counter = 0;
            }
        }
        
        //loop through array with a function that checks if this card is the card that they want to displasy
        if (stage == 1){
            //if the card is clicked select the card
            if (checkCollisions()){
                liu_Bei.selectCards(selectedCard);

            }
            if (checkEndTurnCollisions()){
                //if the player clicks the turn end button it ends the turn.
                endTurn(lu_Bu);
            }
        }
        //resets back to stage 1 after death screen
        if (stage == 3){
            counter ++;
            if (counter == 2){
                stage = 1;
                counter = 0;
                reset();

            }
        }
        
    }
    public void keyPressed(){
        //only runs when mouse is clicked
        if (stage == 1){ 
            if (keyCode == 49 ){
                //if the user selects one it selects the first card of the deck
                liu_Bei.selectCards(liu_Bei.getDeck().get(0));
            }
            if (keyCode == 50 ){
                //if the user selects two its selects the second card of the deck
                liu_Bei.selectCards(liu_Bei.getDeck().get(1));
            }
            if (keyCode == 51 ){
                //if the user selects 3 its selects the third card of the deck
                liu_Bei.selectCards(liu_Bei.getDeck().get(2));
            }
            if (keyCode == 52 ){
                //if the user selects 4 its selects the last card of the deck
                liu_Bei.selectCards(liu_Bei.getDeck().get(3));
            }
            if (keyCode == 69){
                //if the user presses e then it ends the turn
                endTurn(lu_Bu);
            }
        }
        
    }
    public void reset(){
        //resets max hp's in fight
        liu_Bei.setHp(liu_Bei.MAX_HP);
        lu_Bu.setHp(lu_Bu.MAX_HP);
    }
    
}

