/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jan
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setMap method, of class Player.
     */
    @Test
    public void testSetMap() {
        System.out.println("setMap");
        Map map = new Map();
        Player instance = new Player(0,0);
        instance.setMap(map);
        
        assertEquals(map, instance.getMap());        
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove1() {
        System.out.println("move");
        Map map = new Map();
        Path path1 = new Path(0,0);
        Path path2 = new Path(0,0);
        GameObject[][] layout = new GameObject[][] { {path1, path2 } };
        map.setMap(layout);
        Player instance = new Player(0,0);
        instance.setMap(map);
        
        int expectedX = 1;
        instance.move(Direction.RIGHT);
        assertEquals(expectedX, instance.getX());        
    }
    
    @Test
    public void testMove2() {
        System.out.println("move");
        Map map = new Map();
        Path path1 = new Path(0,0);
        Wall wall1 = new Wall(0,0);
        GameObject[][] layout = new GameObject[][] { {path1, wall1 } };
        map.setMap(layout);
        Player instance = new Player(0,0);
        instance.setMap(map);
        
        int expectedX = 0;
        instance.move(Direction.RIGHT);
        assertEquals(expectedX, instance.getX());        
    }
    

    /**
     * Test of shoot method, of class Player.
     */
        
    @Test
    public void testCheaterPositive() {        
        System.out.println("cheater");
        Player instance = new Player(0, 0);
        Cheater cheater = new Cheater(0, 0, 5);
        
        instance.setStepsTaken(10);
        
        instance.alterStepsTaken(-cheater.getValue());
        
        int expectedResult = 5;
        assertEquals(expectedResult, instance.getStepsTaken());
    }
    
    @Test
    public void testCheaterNegative() {
        System.out.println("cheater");
        Player instance = new Player(0, 0);
        Cheater cheater = new Cheater(0, 0, 12);
        
        instance.setStepsTaken(10);
        
        instance.alterStepsTaken(-cheater.getValue());
        
        int expectedResult = 0;
        assertEquals(expectedResult, instance.getStepsTaken());
    }
    
    @Test
    public void interactCheater() {
        Map map = new Map();
        GameObject[][] grid = new GameObject[1][1];
        Cheater c = new Cheater(0, 0, 18);
        grid[0][0] = c;        
        map.setMap(grid);
        
        Player p = new Player(0, 0);
        p.setStepsTaken(100);
        p.setMap(map);        
        
        int expectedResult = p.getStepsTaken() - c.getValue();
        p.interact();
        assertEquals(expectedResult, p.getStepsTaken());
       
        int expectedResult2 = p.getStepsTaken();
        p.interact();
        assertEquals(expectedResult2, p.getStepsTaken());
    }

    /**
     * Test of pickUpBazooka method, of class Player.
     */
    @Test
    public void testPickUpBazooka() {
        System.out.println("pickUpBazooka");
        Map map = new Map();
        GameObject[][] grid = new GameObject[1][1];
        Bazooka b = new Bazooka(0,0);
        grid[0][0] = b;
        map.setMap(grid);
        Player instance = new Player(0,0);
        instance.setMap(map);
        instance.pickUpBazooka();
        
        boolean expected = true;
        assertEquals(expected, instance.isCarryingBazooka());                
    }        
    
    /**
     * Test of isCarryingBazooka method, of class Player.
     */
    @Test
    public void testIsCarryingBazooka() {
        System.out.println("isCarryingBazooka");
        Player instance = new Player(0, 0);
        boolean expResult = false;
        boolean result = instance.isCarryingBazooka();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setCarryingBazooka method, of class Player.
     */
    @Test
    public void testSetCarryingBazooka() {
        System.out.println("setCarryingBazooka");        
        Player instance = new Player(0, 0);
        
        instance.setCarryingBazooka(true);        
        boolean expected = true;
        
        assertEquals(expected, instance.isCarryingBazooka());
    }

    /**
     * Test of getFaced method, of class Player.
     */
    @Test
    public void testDirection() {
        System.out.println("getFaced");
        Map m = new Map();
        m.setMap(new GameObject[][] { { new Path(0,0) } });
        Player instance = new Player(0, 0);
        instance.setMap(m);
        instance.move(Direction.DOWN);
        Direction expected = Direction.DOWN;
        
        assertEquals(expected, instance.getDirection());
    }

    /**
     * Test of getStepsTaken method, of class Player.
     */
    @Test
    public void testGetStepsTaken() {
        System.out.println("getStepsTaken");
        Player instance = new Player(0,0);
        instance.setStepsTaken(120);
        
        int expected = 120;
        
        assertEquals(expected, instance.getStepsTaken());
    }
    
}
