package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Wall extends GameObject {
    
    private BufferedImage image;
    
    public Wall(int x, int y) {
        setX(x);
        setY(y);
        
        try{
            image = ImageIO.read(new File("src/doolhoftwee/images/wall.png"));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        }
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.BLACK);
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }

    @Override
    public void paintComponent(Graphics g) {        
        g.drawImage(image, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
    }
    
    @Override
    public boolean canWalkThrough() {
        return false;
    }
    
    public Path toPath() {
        return new Path(getX(), getY());
    }
}
