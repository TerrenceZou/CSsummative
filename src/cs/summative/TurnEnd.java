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
public class TurnEnd {
    int x;
    int y;
    PApplet app;
    public TurnEnd(PApplet p, int x, int y){
        this.x = x;
        this.y = y;
        this.app = p;
    }

    public boolean isClicked(int mouseX, int mouseY){
        boolean mouseInRectX = x <mouseX &&  mouseX < + x+ 50;
        boolean mouseInRectY = y < mouseY && mouseY < y + 50;
        if (mouseInRectX && mouseInRectY == true){
            return true;
        }else{
            return false;
        }
    
    }
    public void draw(){
        app.fill(0,255,0);
        app.rect(x,y,50,50);
    }
}
