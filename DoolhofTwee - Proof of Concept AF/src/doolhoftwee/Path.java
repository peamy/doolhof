
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
    public void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        
        g.fillRect(getX() * PIXEL, getY() * PIXEL, PIXEL, PIXEL);
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
}
