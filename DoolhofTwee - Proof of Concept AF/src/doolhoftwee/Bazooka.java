
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Bazooka extends GameObject {

    private BufferedImage pathImage;
    private BufferedImage bazookaImage;
    
    public Bazooka(int x, int y) {
        setX(x);
        setY(y);
        
        try{
            pathImage = ImageIO.read(new File("src/doolhoftwee/images/path.png"));
            bazookaImage = ImageIO.read(new File("src/doolhoftwee/images/bazooka.png"));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        } 
    }

    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.RED);
        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }

    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
        g.drawImage(bazookaImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
    }    

    @Override
    public boolean canWalkThrough() {
        return true;
    }
}