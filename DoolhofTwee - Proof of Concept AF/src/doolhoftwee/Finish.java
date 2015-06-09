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
public class Finish extends GameObject {

    public Finish(int x, int y) {
        setX(x);
        setY(y);
    }

    public void paintComponent(Graphics g, int beginX, int beginY) {
        
        g.setColor(Color.GREEN);
        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
        
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.GREEN);
        
        g.fillRect(getX() * Drawing.PIXEL_VERTICAL, getY() * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
        repaint();
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
}
