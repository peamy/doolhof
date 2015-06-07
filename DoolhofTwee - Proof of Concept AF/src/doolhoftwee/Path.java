
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Jan
 */
public class Path extends GameObject {

    public Path(int x, int y) {
        setX(x);
        setY(y);
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.GRAY);        
        g.fillRect((getX()-beginX) * PIXEL_VERTICAL, (getY()-beginY) * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);        
        g.fillRect(getX() * PIXEL_VERTICAL, getY() * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
}
