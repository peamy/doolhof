
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject {
    private Map map;
    private Frame frame;
    
    private Direction lastFaced = Direction.RIGHT;
    
    private boolean carriesBazooka = false;
    
    private int stepsTaken;
    
    public Player(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public void move(Direction d) {
        
        lastFaced = d;
        
        switch(d) {
            case UP : 
                if(map.getGameObject(getY() - 1, getX()).canWalkThrough()) {
                    stepsTaken++;
                    setY(getY() - 1);
                }
                break;                
            case DOWN :
                if(map.getGameObject(getY() + 1, getX()).canWalkThrough()) {
                    stepsTaken++;
                    setY(getY() + 1);
                }
                break;
            case LEFT :
                if(map.getGameObject(getY(), getX()-1).canWalkThrough()) {
                    stepsTaken++;
                    setX(getX() - 1);
                }
                break;                
            case RIGHT :
                if(map.getGameObject(getY(), getX()+1).canWalkThrough()) {
                    stepsTaken++;
                    setX(getX() + 1);
                }
                break;
        }
        
        GameObject currentObject = map.getGameObject(getY(), getX());
        if(currentObject instanceof Finish) {
            frame.finishLevel();
        }   
        else if(currentObject instanceof Cheater) {
            stepsTaken -= 10;                    
            map.setPath(currentObject.toPath(), getX(), getY());
            if(stepsTaken < 0) {
                stepsTaken = 0;
            }
        }
        else if(currentObject instanceof Helper) {
            Helper h = (Helper) currentObject;
            h.findShortestPath();
        }
    }
    
    public void shoot() {
        if(carriesBazooka == true) {
            carriesBazooka = false;
        }
    }
    
    public void pickUpBazooka() {
        if(map.getGameObject(getY(), getX()) instanceof Bazooka) {
            carriesBazooka = true;
                    
            Bazooka b = (Bazooka) map.getGameObject(getY(), getX());
            map.setPath(b.toPath(), getX(), getY());
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
    
    public boolean isCarryingBazooka() {
        return carriesBazooka;
    }
    
    public Direction getFaced() {
        return lastFaced;
    }
    
    public int getStepsTaken() {
        return stepsTaken;
    }
}
