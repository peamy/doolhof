
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;


public class Cheater extends GameObject {
    private int value;
    
    public Cheater(int x, int y, int value) {
        setX(x);
        setY(y);
        this.value = value;
        
        try{
            setPathImage(ImageIO.read(new File("src/doolhoftwee/images/path.png")));
            setImage(ImageIO.read(new File("src/doolhoftwee/images/Rogue.png")));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        } 
    }
    
    public int getValue() {
        return value;
    }
    
}
