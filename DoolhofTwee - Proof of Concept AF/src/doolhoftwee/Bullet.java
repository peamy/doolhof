
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Bullet extends JComponent{
    
    private Direction direction;
    private int count = 0;
    private BufferedImage image;
    
    private int x;
    private int y;
    
    private Map m;
    
    public Bullet(int x, int y, Direction d, Map m) {
        setX(x);
        setY(y);
        
        try{
            image = ImageIO.read(new File("src/doolhoftwee/images/bullet.png"));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        } 
        
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
         g.drawImage(image, (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
    }
    
    @Override
    public void paintComponent(Graphics g) {        
          g.drawImage(image, getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
    }
    
    /**
     * moves into the direction it is shot, removes a wall from the map if it hits a wall
     * @return wether it is done or not.
     */
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
            
            count += 3;
        } 
        else {
            count ++;
        }        
        if(count > 10) {
            return true;
        }
        return false;
    }

}