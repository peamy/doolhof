
package doolhoftwee;

import java.awt.Graphics;
import javax.swing.JComponent;


public abstract class GameObject extends JComponent {
    
    private int x;
    private int y;
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public abstract boolean canWalkThrough();
    
    public Path toPath() {
        return new Path(getX(), getY());
    }
    
    public abstract void paintComponent(Graphics g, int beginX, int beginY);
    
    public abstract void paintComponent(Graphics g);
}
