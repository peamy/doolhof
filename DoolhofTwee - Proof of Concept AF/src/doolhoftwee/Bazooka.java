
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;


public class Bazooka extends GameObject {

    public Bazooka(int x, int y) {
        setX(x);
        setY(y);
        
        try{
            setPathImage(ImageIO.read(new File("src/doolhoftwee/images/path.png")));
            setImage(ImageIO.read(new File("src/doolhoftwee/images/bazooka.png")));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        } 
    }

}