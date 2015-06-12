/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Remco
 */
public class Finish extends GameObject {
    
    private BufferedImage pathImage;
    private BufferedImage finishImage;

    public Finish(int x, int y) {
        setX(x);
        setY(y);
        
        try{
            pathImage = ImageIO.read(new File("src/doolhoftwee/images/path.png"));
            finishImage = ImageIO.read(new File("src/doolhoftwee/images/finish.png"));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        } 
    }

    public void paintComponent(Graphics g, int beginX, int beginY) {
        
        g.setColor(Color.GREEN);
        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
        
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.BLUE);
        
        g.drawImage(pathImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
        g.drawImage(finishImage, getX() * Drawing.PIXEL_HORIZONTAL, getY() * Drawing.PIXEL_VERTICAL, null);
        repaint();
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
}
