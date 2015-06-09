
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class Bullet extends JComponent{
    
    private Direction direction;
    
    private int x;
    private int y;
    
    private Map m;
    
    public Bullet(int x, int y, Direction d, Map m) {
        setX(x);
        setY(y);
        
        this.direction = d;
        
        this.m = m;
    }
    
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
    
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.YELLOW);
        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }
    
    @Override
    public void paintComponent(Graphics g) {        
        g.setColor(Color.YELLOW);
        g.fillRect(getX() * Drawing.PIXEL_VERTICAL, getY() * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_HORIZONTAL / 2, Drawing.PIXEL_VERTICAL / 2);
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

}