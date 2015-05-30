/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Remco
 */
public class Finish extends GameObject implements Interactable{

    public Finish(int x, int y) {
        setX(x);
        setY(y);
    }
    
    @Override
    public Interaction interact() {
        return Interaction.FINISH;
    }

    public void paintComponent(Graphics g, int beginX, int beginY) {
        
        g.setColor(Color.GREEN);
        
        g.fillRect((getX()-beginX) * PIXEL_VERTICAL, (getY()-beginY) * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
        
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.GREEN);
        
        g.fillRect(getX() * PIXEL_VERTICAL, getY() * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
        repaint();
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
}
