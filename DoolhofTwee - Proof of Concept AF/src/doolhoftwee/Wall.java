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
    public void paintComponent(Graphics g) {        
        g.setColor(Color.BLACK);
        g.fillRect(getX() * PIXEL, getY() * PIXEL, PIXEL, PIXEL);
    }

    @Override
    public boolean canWalkThrough() {
        return false;
    }
}
