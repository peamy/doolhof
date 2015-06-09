
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class Player extends JComponent  {
    private Map map;
    private Frame frame;
    private int x;
    private int y;
    
    private Direction lastFaced = Direction.RIGHT;
    
    private boolean carriesBazooka = false;
    
    private int stepsTaken;
    
    public Player(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
    
    public void paintComponent(Graphics g, int beginX, int beginY) {
        
        g.setColor(Color.BLACK);
        
        g.fillOval((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
        
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.BLACK);        
        g.fillOval(getX() * Drawing.PIXEL_VERTICAL, getY() * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
        
        //draw the bazooka
        if(carriesBazooka) {
            switch(lastFaced) {
                case DOWN :
                    g.setColor(Color.red);        
                    g.fillRect(getX() * Drawing.PIXEL_VERTICAL, getY() * Drawing.PIXEL_HORIZONTAL, (int) (Drawing.PIXEL_VERTICAL/4), Drawing.PIXEL_HORIZONTAL);
                    break;
                case LEFT :
                    g.setColor(Color.red);        
                    g.fillRect(getX() * Drawing.PIXEL_VERTICAL, getY()* Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL,(int) (Drawing.PIXEL_HORIZONTAL/4));
                    break;
                case RIGHT :
                    g.setColor(Color.red);        
                    g.fillRect(getX() * Drawing.PIXEL_VERTICAL, (int) ((double)(getY() +((double)3/4)) * Drawing.PIXEL_HORIZONTAL), Drawing.PIXEL_VERTICAL,(int) (Drawing.PIXEL_HORIZONTAL/4));
                    break;
                case UP :
                    g.setColor(Color.red);        
                    g.fillRect((int) ((double)(getX() +((double)3/4)) * Drawing.PIXEL_VERTICAL), getY() * Drawing.PIXEL_HORIZONTAL, (int) (Drawing.PIXEL_VERTICAL/4), Drawing.PIXEL_HORIZONTAL);
                    break;
            }
        }
        
        repaint();
    }    
    
    public void setFrame(Frame frame) {
        this.frame = frame;
    }
    
    public boolean isCarryingBazooka() {
        return carriesBazooka;
    }
    
    public void setCarryingBazooka(boolean bool) {
        this.carriesBazooka = bool;
    }
    
    public Direction getFaced() {
        return lastFaced;
    }
    
    public int getStepsTaken() {
        return stepsTaken;
    }
}
