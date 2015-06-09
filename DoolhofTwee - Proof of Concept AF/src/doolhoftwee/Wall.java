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
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }

    @Override
    public void paintComponent(Graphics g) {        
        g.setColor(Color.BLACK);
        g.fillRect(getX() * Drawing.PIXEL_VERTICAL, getY() * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }
    
    @Override
    public boolean canWalkThrough() {
        return false;
    }
    
    public Path toPath() {
        return new Path(getX(), getY());
    }
}
