
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject {
    private Map map;
    private Frame frame;
    
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
        
        if(map.getGameObject(getY(), getX()) instanceof Interactable) {
            Interaction i;
            i = ((Interactable)map.getGameObject(getY(), getX())).interact();
            switch(i) {
                case FINISH :
                    frame.finishLevel();
                    break;
            }            
        }
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        
        g.setColor(Color.BLACK);
        
        g.fillOval((getX()-beginX) * PIXEL_VERTICAL, (getY()-beginY) * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
        
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.BLACK);
        
        g.fillOval(getX() * PIXEL_VERTICAL, getY() * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
        repaint();
    }
    
    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
    public void setFrame(Frame frame) {
        this.frame = frame;
    }
    
}
