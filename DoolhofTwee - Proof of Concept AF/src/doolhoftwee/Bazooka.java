
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;


public class Bazooka extends GameObject {

    public Bazooka(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.RED);
        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }

    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);        
        g.fillRect(getX() * Drawing.PIXEL_VERTICAL, getY() * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
        
        g.setColor(Color.red);        
        g.fillRect(getX() * Drawing.PIXEL_VERTICAL, (int) ((double)(getY() +((double)3/4)) * Drawing.PIXEL_HORIZONTAL), Drawing.PIXEL_VERTICAL,(int) (Drawing.PIXEL_HORIZONTAL/4));
    }    

    @Override
    public boolean canWalkThrough() {
        return true;
    }
}