
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject {
    private Map map;
    
    public Player(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public void move(Direction d) {
        switch(d) {
            case UP : 
                if(map.getGameObject(getY() - 1, getX()).canWalkThrough()) {
                    setY(getY() - 1);
                }
                break;                
            case DOWN :
                if(map.getGameObject(getY() + 1, getX()).canWalkThrough()) {
                    setY(getY() + 1);
                }
                break;
            case LEFT :
                if(map.getGameObject(getY(), getX()-1).canWalkThrough()) {
                    setX(getX() - 1);
                }
                break;                
            case RIGHT :
                if(map.getGameObject(getY(), getX()+1).canWalkThrough()) {
                    setX(getX() + 1);
                }
                break;
        }
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        
        g.setColor(Color.BLACK);
        
        g.fillOval((getX()-beginX) * PIXEL, (getY()-beginY) * PIXEL, PIXEL, PIXEL);
        
        repaint();
    }
    
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
