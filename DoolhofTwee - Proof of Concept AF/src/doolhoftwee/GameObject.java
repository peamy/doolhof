
package doolhoftwee;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;


public abstract class GameObject extends JComponent {
    
    private int x;
    private int y;
    private BufferedImage pathImage;
    private BufferedImage image;
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean canWalkThrough() {
        return true;
    }
    
    public Path toPath() {
        return new Path(getX(), getY());
    }
    
    /**
     * Paints a component at a specific location
     * @param g the thing that paints
     * @param beginX the position to start horizontally
     * @param beginY the position to start vertically
     */
    public void paintComponent(Graphics g, int beginX, int beginY) {
        if(pathImage != null) {
            g.drawImage(pathImage, (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
        }        
        g.drawImage(image, (getX()-beginX) * Drawing.PIXEL_X_ZOOM, (getY()-beginY) * Drawing.PIXEL_Y_ZOOM, Drawing.PIXEL_X_ZOOM, Drawing.PIXEL_Y_ZOOM, null);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        if(pathImage != null) {
            g.drawImage(pathImage, getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
        }        
        g.drawImage(image, getX() * Drawing.PIXEL_X, getY() * Drawing.PIXEL_Y, Drawing.PIXEL_X, Drawing.PIXEL_Y, null);
    } 
    
    public BufferedImage getPathImage() {
        return pathImage;
    }

    public void setPathImage(BufferedImage pathImage) {
        this.pathImage = pathImage;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    
}
