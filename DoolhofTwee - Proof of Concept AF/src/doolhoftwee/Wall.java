package doolhoftwee;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class Wall extends GameObject {
    
    public Wall(int x, int y) {
        setX(x);
        setY(y);
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {        
        g.setColor(Color.BLACK);
        g.fillRect((getX()-beginX) * PIXEL_VERTICAL, (getY()-beginY) * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }

    @Override
    public void paintComponent(Graphics g) {        
        g.setColor(Color.BLACK);
        g.fillRect(getX() * PIXEL_VERTICAL, getY() * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }
    
    @Override
    public boolean canWalkThrough() {
        return false;
    }
    
    public Path toPath() {
        return new Path(getX(), getY());
    }
}
