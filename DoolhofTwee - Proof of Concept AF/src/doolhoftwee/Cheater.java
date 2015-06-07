
package doolhoftwee;

import static doolhoftwee.GameObject.PIXEL_VERTICAL;
import java.awt.Color;
import java.awt.Graphics;


public class Cheater extends GameObject {
    
    public Cheater(int x, int y) {
        setX(x);
        setY(y);
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.CYAN);        
        g.fillRect((getX()-beginX) * PIXEL_VERTICAL, (getY()-beginY) * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.CYAN);        
        g.fillRect(getX() * PIXEL_VERTICAL, getY() * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
}
