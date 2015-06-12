
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Cheater extends GameObject {
    private int value;
    
    private BufferedImage pathImage;
    private BufferedImage rogueImage;
    
    public Cheater(int x, int y, int value) {
        setX(x);
        setY(y);
        this.value = value;
        
        try{
            pathImage = ImageIO.read(new File("src/doolhoftwee/images/path.png"));
            rogueImage = ImageIO.read(new File("src/doolhoftwee/images/Rogue.png"));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        } 
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.CYAN);        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
        g.drawImage(rogueImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
        g.drawString("-" + value, ((getX()) * Drawing.PIXEL_VERTICAL) + ((int)(0.3*Drawing.PIXEL_VERTICAL)), ((getY()+1) * Drawing.PIXEL_HORIZONTAL) - ((int)(0.3*Drawing.PIXEL_HORIZONTAL)));
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
    public int getValue() {
        return value;
    }
    
}
