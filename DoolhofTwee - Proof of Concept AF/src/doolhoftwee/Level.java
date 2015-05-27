
package doolhoftwee;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Level extends JPanel {
    
    private int[][] grid = new int[][] {
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
        { 1, 2, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
        { 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 },
        { 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1 },
        { 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1 },
        { 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1 },
        { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
    
    private Map map;
    
    /**
     * De grote van de witte rectangle op het scherm.
     */
        
    private Player p;
    
    private JFrame d;
    
    private final int blocksPerViewX = 7;
    private final int blocksPerViewY = 5;
      
    
    /**
     * de 0 is een stuk waarop je kan lopen. de 1 is een muur.
     * @return 
     */    
    
    public Level(JFrame d) {        
        this.d = d;        
        generateMap();
        listenToKeys();        
        d.requestFocus();
    }

    @Override
    /**
     * Een paintcomponent word nergens in de code aangeroepen, maar wanneer een class een JPanel extends word er automatisch naar een methode met deze naam gezogd.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  
        
        /* DIT GEDEELTE DOET INGEZOOMD SPELEN
        int startX = p.getX() - (blocksPerViewX/2);
        int startY = p.getY() - (blocksPerViewY/2);
        
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
        p.paintComponent(g, startX, startY);        
        */
        for(int i = 0; i < map.getXBounds(); i++) {
            for(int j = 0; j < map.getYBounds(); j++) {
                if(map.getGameObject(i, j) != null) {
                    map.getGameObject(i, j).paintComponent(g);                    
                }
            }            
        }
        p.paintComponent(g);
        
        try {
            Thread.sleep(20);
        }
        catch (InterruptedException ex) {
            System.out.println("error bij paintComponent " + ex);
        }
    }
    
     public void listenToKeys() {
        d.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT :
                        p.move(Direction.RIGHT);
                        break;     
                        
                    case KeyEvent.VK_LEFT :
                         p.move(Direction.LEFT);
                        break;       
                        
                    case KeyEvent.VK_UP :
                        p.move(Direction.UP);
                        break;     
                        
                    case KeyEvent.VK_DOWN :
                        p.move(Direction.DOWN);
                        break;
                }
                
                d.repaint();
            }
        });
    }
    
    public void generateMap() {
        GameObject[][] objectGrid = new GameObject[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++ ) {            
            for(int j = 0; j < grid[0].length; ++j ) {
                
                switch (grid[i][j]) {
                    case 0 :    
                        Path path = new Path(j, i);
                        objectGrid[i][j] = path;    
                        break;
                    case 1 :
                        Wall ws = new Wall(j, i);
                        objectGrid[i][j] = ws;
                        break;
                    case 2 :
                        Path pathh = new Path(j, i);
                        objectGrid[i][j] = pathh; 
                        
                        p = new Player(j, i);
                        break;
                }                
            }
        }       
       map = new Map(objectGrid);    
       p.setMap(map);
    }
}
