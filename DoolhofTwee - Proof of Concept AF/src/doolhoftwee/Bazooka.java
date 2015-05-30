
package doolhoftwee;

import static doolhoftwee.GameObject.PIXEL_VERTICAL;
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
        
        g.fillRect((getX()-beginX) * PIXEL_VERTICAL, (getY()-beginY) * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }

    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        
        g.fillRect(getX() * PIXEL_VERTICAL, getY() * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }
    
    public Path toPath() {
        return new Path(getX(), getY());
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
}