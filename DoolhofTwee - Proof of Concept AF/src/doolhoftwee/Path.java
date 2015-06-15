
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Jan
 */
public class Path extends GameObject {

    private boolean isShortestPath = false;
    
    private BufferedImage image;
    private BufferedImage short_path_image;
    
    public Path(int x, int y) {
        setX(x);
        setY(y);
        
        try{
            image            = ImageIO.read(new File("src/doolhoftwee/images/path.png"));
            short_path_image = ImageIO.read(new File("src/doolhoftwee/images/helperPath.png"));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        }
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.GRAY);        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        if(isShortestPath) {
            g.drawImage(short_path_image, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
        }
        else {
            g.drawImage(image, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
        }

    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
    public void setShortestPath(boolean isShortestPath) {
        
        this.isShortestPath = isShortestPath;
        
    }
    
}
