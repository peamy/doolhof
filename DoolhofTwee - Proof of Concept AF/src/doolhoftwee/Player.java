
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Player extends JComponent  {
    private Map map;
    private Frame frame;
    private int x;
    private int y;
    
    private BufferedImage playerImage;
    private BufferedImage playerBazookaUp;
    private BufferedImage playerBazookaDown;
    private BufferedImage playerBazookaLeft;
    private BufferedImage playerBazookaRight;
    
    private Direction lastFaced = Direction.RIGHT;
    
    private boolean carriesBazooka = false;
    
    private int stepsTaken;
    
    public Player(int x, int y) {
        setX(x);
        setY(y);
        
        try{           
            playerImage = ImageIO.read(new File("src/doolhoftwee/images/player.png"));
            playerBazookaDown = ImageIO.read(new File("src/doolhoftwee/images/playerBazookaDown.png"));
            playerBazookaUp = ImageIO.read(new File("src/doolhoftwee/images/playerBazookaUp.png"));
            playerBazookaLeft = ImageIO.read(new File("src/doolhoftwee/images/playerBazookaLeft.png"));
            playerBazookaRight = ImageIO.read(new File("src/doolhoftwee/images/playerBazookaRight.png"));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        }
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
    
    /**
     * Moves into a certain direction (if theres no wall)
     * Also interacts with GameObject (if there is one at the position)
     * @param d direction to move in
     */
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
        interact();
    }
    
    public void interact() {
        GameObject currentObject = map.getGameObject(getY(), getX());
        if(currentObject instanceof Finish) {
            frame.finishLevel();
        }   
        else if(currentObject instanceof Cheater) {
            alterStepsTaken(-((Cheater)currentObject).getValue());
            map.setPath(currentObject.toPath(), getX(), getY());
            map.resetShortestPath();
        }
        else if(currentObject instanceof Helper) {
            Helper h = (Helper) currentObject;
            h.findShortestPath(map);
            map.setPath(currentObject.toPath(), getX(), getY());
        }
        else if(currentObject instanceof Vijand) {           
            alterStepsTaken(((Vijand)currentObject).getValue());
            map.setPath(currentObject.toPath(), getX(), getY());
            map.resetShortestPath();
        }
    }
    
    public void alterStepsTaken(int value) {
        stepsTaken += value;
        if(stepsTaken < 0) {
            stepsTaken = 0;
        }
    }      
    
    public void paintComponent(Graphics g, int beginX, int beginY) {        
        
        //draw the bazooka
        if(carriesBazooka) {
            switch(lastFaced) {
                case DOWN :
                      //g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
                      g.drawImage(playerBazookaDown, (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
                    break;
                case LEFT :
                    //g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
                    g.drawImage(playerBazookaLeft, (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
                    break;
                case RIGHT :
                    //g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
                    g.drawImage(playerBazookaRight, (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
                    break;
                case UP :
                   //g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
                   g.drawImage(playerBazookaUp, (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
                    break;
            }
        }
        else {
            g.drawImage(playerImage, (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
        }
    }
    
    public void paintComponent(Graphics g) {        
        g.drawImage(playerImage, getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
        
        //draw the bazooka
        if(carriesBazooka) {
            switch(lastFaced) {
                case DOWN :
                      //g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
                      g.drawImage(playerBazookaDown, getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
                    break;
                case LEFT :
                    //g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
                    g.drawImage(playerBazookaLeft, getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
                    break;
                case RIGHT :
                    //g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
                    g.drawImage(playerBazookaRight, getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
                    break;
                case UP :
                   //g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
                   g.drawImage(playerBazookaUp, getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
                    break;
            }
        }
        
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
    
    public Direction getDirection() {
        return lastFaced;
    }
    
    public int getStepsTaken() {
        return stepsTaken;
    }
    
    public void setStepsTaken(int steps) {
        this.stepsTaken = steps;
    }
    
    public Map getMap() {
        return map;
    }
    
    public void spacebarPressed() {
        if(isCarryingBazooka()) {
            setCarryingBazooka(false);
            //bullet shot
        }
        else if(map.getGameObject(getY(), getX()) instanceof Bazooka){
            carriesBazooka = true;

            GameObject b = map.getGameObject(getY(), getX());
            map.setPath(b.toPath(), getX(), getY());
            
        }
    }
    
}
