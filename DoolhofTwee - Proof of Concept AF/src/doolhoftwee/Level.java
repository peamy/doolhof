
package doolhoftwee;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Level extends JPanel {
    
    private int[][] grid;
    
    private GameObject[][] objectGrid;
    
    /**
     * De grote van de witte rectangle op het scherm.
     */
    
    private boolean generated;
    
    private Player p;
    
    private JFrame d;
        
    
    /**
     * de 0 is een stuk waarop je kan lopen. de 1 is een muur.
     * @return 
     */
    public int[][] drawGrid() {
        grid = new int[][] {
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 0, 2, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
        { 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1 },
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
        
        return grid;
    }
    
    public Level(JFrame d) {        
        this.d = d;        
        walk();        
        d.requestFocus();
    }

    @Override
    /**
     * Een paintcomponent word nergens in de code aangeroepen, maar wanneer een class een JPanel extends word er automatisch naar een methode met deze naam gezogd.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  
        
        if(!generated) {
            generateMap();
        }
        
        for(int y = 0; y < objectGrid.length; y++) {
            for(int j = 0; j < objectGrid[0].length; j++) {
                if(objectGrid[y][j] != null) {
                    objectGrid[y][j].paintComponent(g);                    
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
    
     public void walk() {
        d.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT :
                       if(objectGrid[p.getY()][p.getX()+1].canWalkThrough()) {
                            p.setX(p.getX() + 1);
                        }
                        break;
                        
                    case KeyEvent.VK_LEFT :
                         if(objectGrid[p.getY()][p.getX()-1].canWalkThrough()) {
                            p.setX(p.getX() - 1);
                        }
                        break;
                    
                    case KeyEvent.VK_UP :
                        if(objectGrid[p.getY() - 1][p.getX()].canWalkThrough()) {
                            p.setY(p.getY() - 1);
                        }
                        break;
                    
                    case KeyEvent.VK_DOWN :
                        if(objectGrid[p.getY() + 1][p.getX()].canWalkThrough()) {
                            p.setY(p.getY() + 1) ;
                        }
                        break;
                }
                
                d.repaint();
            }
        });
    }
    
    public void generateMap() {
        objectGrid = new GameObject[grid.length][grid[0].length];
        
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
                        
                        Player ps = new Player(j, i);
                        p = ps;
                        break;
                }
                
            }
        }
       
        generated = true;
    }
}
