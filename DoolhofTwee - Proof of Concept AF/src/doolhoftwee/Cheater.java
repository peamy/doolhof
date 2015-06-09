
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;


public class Cheater extends GameObject {
    private int value;
    
    public Cheater(int x, int y, int value) {
        setX(x);
        setY(y);
        this.value = value;
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.CYAN);        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.CYAN);        
        g.fillRect(getX() * Drawing.PIXEL_VERTICAL, getY() * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
        g.setColor(Color.BLACK);
        g.drawString("-" + value, ((getX()) * Drawing.PIXEL_VERTICAL) + ((int)(0.3*Drawing.PIXEL_VERTICAL)), ((getY()+1) * Drawing.PIXEL_HORIZONTAL) - ((int)(0.3*Drawing.PIXEL_HORIZONTAL)));
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
    public int getValue() {
        return value;
    }
    
}
