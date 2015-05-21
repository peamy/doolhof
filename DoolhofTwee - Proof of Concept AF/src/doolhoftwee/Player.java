
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Player extends GameObject {
    
    public Player(int x, int y) {
        setX(x);
        setY(y);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.BLACK);
        
        g.fillOval(getX() * PIXEL, getY() * PIXEL, PIXEL, PIXEL);
        
        repaint();
    }
    
    @Override
    public boolean canWalkThrough() {
        return true;
    }
}
