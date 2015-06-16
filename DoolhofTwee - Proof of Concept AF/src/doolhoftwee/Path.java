
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Jan
 */
public class Path extends GameObject {

    private boolean isShortestPath = false;
    
    public Path(int x, int y) {
        setX(x);
        setY(y);
        
        try{
            setPathImage(ImageIO.read(new File("src/doolhoftwee/images/path.png")));
            setImage(ImageIO.read(new File("src/doolhoftwee/images/helperPath.png")));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        }
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        if(isShortestPath) {
            g.drawImage(getImage(), (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
        }
        else {
            g.drawImage(getPathImage(), (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        if(isShortestPath) {
            g.drawImage(getImage(), getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
        }
        else {
            g.drawImage(getPathImage(), getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
        }

    }
    
    public void setShortestPath(boolean isShortestPath) {
        
        this.isShortestPath = isShortestPath;
        
    }
    
}
