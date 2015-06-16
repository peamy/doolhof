package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;


public class Wall extends GameObject {
    
    public Wall(int x, int y) {
        setX(x);
        setY(y);
        
        try{
            setImage(ImageIO.read(new File("src/doolhoftwee/images/wall.png")));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        }
    }    

    @Override
    public boolean canWalkThrough() {
        return false;
    }
    
}
