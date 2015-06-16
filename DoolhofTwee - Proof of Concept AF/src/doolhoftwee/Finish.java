/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Remco
 */
public class Finish extends GameObject {
    
    public Finish(int x, int y) {
        setX(x);
        setY(y);
        
        try{
            setPathImage(ImageIO.read(new File("src/doolhoftwee/images/path.png")));
            setImage(ImageIO.read(new File("src/doolhoftwee/images/finish.png")));
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        } 
    }
    
}
