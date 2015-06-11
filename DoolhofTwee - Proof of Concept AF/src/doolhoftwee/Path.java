
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Jan
 */
public class Path extends GameObject {
    private boolean isShortestPath = false;
    
    public Path(int x, int y) {
        setX(x);
        setY(y);
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.GRAY);        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        if(isShortestPath) {
            g.setColor(Color.LIGHT_GRAY);
        }
        else {
            g.setColor(Color.GRAY);
        }
                
        g.fillRect(getX() * Drawing.PIXEL_VERTICAL, getY() * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
    public void setShortestPath(boolean isShortestPath) {
        this.isShortestPath = isShortestPath;
    }
    
}
