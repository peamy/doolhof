
package doolhoftwee;

import static doolhoftwee.GameObject.PIXEL_VERTICAL;
import java.awt.Color;
import java.awt.Graphics;


public class Bullet extends GameObject{
    
    private Direction direction;
    
    private Map m;
    
    public Bullet(int x, int y, Direction d, Map m) {
        setX(x);
        setY(y);
        
        this.direction = d;
        
        this.m = m;
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.YELLOW);
        
        g.fillRect((getX()-beginX) * PIXEL_VERTICAL, (getY()-beginY) * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }
    
    @Override
    public void paintComponent(Graphics g) {        
        g.setColor(Color.YELLOW);
        g.fillRect(getX() * PIXEL_VERTICAL, getY() * PIXEL_HORIZONTAL, PIXEL_HORIZONTAL / 2, PIXEL_VERTICAL / 2);
    }
    
    public boolean shoot() {
        switch(direction) {
            case UP :
                if(getY() < m.getXBounds() - 1 && getY() > 0) {
                    setY(getY() - 1);
                }
                else {
                    return true;
                }
                break;                
            case DOWN :
                if(getY() < m.getXBounds() - 1 && getY() > 0) {
                    setY(getY() + 1);
                }
                else {
                    return true;
                }
                break;
            case LEFT :
                if(getX() < m.getYBounds() - 1 && getX() > 0) {
                    setX(getX() - 1);
                }
                else {
                    return true;
                }
                break;                
            case RIGHT :
                if(getX() < m.getYBounds() - 1 && getX() > 0) {
                    setX(getX() + 1);
                }
                else {
                    return true;
                }
                break;
        }
        
        if(m.getGameObject(getY(), getX()) instanceof Wall) {
            Wall w = (Wall) m.getGameObject(getY(), getX());
            m.setPath(w.toPath(), getX(), getY());
            
            return true;
        } 
        return false;
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
}