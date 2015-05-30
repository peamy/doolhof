
package doolhoftwee;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import javax.swing.JPanel;


public class Level extends JPanel {
    
    private Map map;
    
    private Player player;
    
    private Frame frame;
    
    private KeyAdapter adapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT :
                        player.move(Direction.RIGHT);
                        break;     
                        
                    case KeyEvent.VK_LEFT :
                         player.move(Direction.LEFT);
                        break;       
                        
                    case KeyEvent.VK_UP :
                        player.move(Direction.UP);
                        break;     
                        
                    case KeyEvent.VK_DOWN :
                        player.move(Direction.DOWN);
                        break;
                }
                
                frame.repaint();
            }
        };
    
    private final int blocksPerViewX = 7;
    private final int blocksPerViewY = 5;      
    
    public Level(Frame frame, String fileName) {        
        this.frame = frame;        
        generateMap(fileName);
        listenToKeys();        
        frame.requestFocus();
    }

    @Override
    /**
     * Een paintcomponent word nergens in de code aangeroepen, maar wanneer een class een JPanel extends word er automatisch naar een methode met deze naam gezogd.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  
        
        /*
        int startX = player.getX() - (blocksPerViewX/2);
        int startY = player.getY() - (blocksPerViewY/2);
        
        if(startX > (map.getYBounds()-blocksPerViewX)) {
            startX = map.getYBounds()-blocksPerViewX;
        }
        if(startY > (map.getXBounds()-blocksPerViewY)) {
            startY = map.getXBounds()-blocksPerViewY;
        }
        if(startX < 0) {
            startX = 0;   
        }
        if(startY < 0) {
            startY = 0;
        }
        
        for(int i = 0; i < blocksPerViewY; i++) {
            for(int j = 0; j < blocksPerViewX; j++) {
                if(map.getGameObject(i+startY, j+startX) != null) {
                    map.getGameObject(i+startY, j+startX).paintComponent(g, startX, startY);                    
                }
            }            
        }
        player.paintComponent(g, startX, startY);  
        */
        
        for(int i = 0; i < map.getXBounds(); i++) {
            for(int j = 0; j < map.getYBounds(); j++) {
                if(map.getGameObject(i, j) != null) {
                    map.getGameObject(i, j).paintComponent(g);                    
                }
            }            
        }
        player.paintComponent(g);
        
        try {
            Thread.sleep(20);
        }
        catch (InterruptedException ex) {
            System.out.println("error bij paintComponent " + ex);
        }
    }
    
     public void listenToKeys() {
        frame.addKeyListener(adapter);
    }
    
    public void generateMap(String fileName) {
        String[][] grid = Datareader.getData(fileName);
        
        GameObject[][] objectGrid = new GameObject[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++ ) {            
            for(int j = 0; j < grid[0].length; ++j ) {
                
                switch (grid[i][j]) {
                    case "." :    
                        Path path = new Path(j, i);
                        objectGrid[i][j] = path;    
                        break;
                    case "x" :
                        Wall ws = new Wall(j, i);
                        objectGrid[i][j] = ws;
                        break;
                    case "f" :
                        Finish f = new Finish(j, i);
                        objectGrid[i][j] = f;
                        break;
                    case "p" :
                        Path pathh = new Path(j, i);
                        objectGrid[i][j] = pathh; 
                        
                        player = new Player(j, i);
                        player.setFrame(frame);
                        break;
                }                
            }
        }       
       map = new Map(objectGrid);    
       player.setMap(map);
    }
    
    public void destroyComponents() {
        map.destroy();
        player = null;
        frame.removeKeyListener(adapter);        
    }
}
