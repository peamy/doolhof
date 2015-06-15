/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

import java.awt.Graphics;
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
        Map map = null;
        Player instance = null;
        instance.setMap(map);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Direction d = null;
        Player instance = null;
        instance.move(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shoot method, of class Player.
     */
    @Test
    public void testShoot() {
        System.out.println("shoot");
        Player instance = new Player(0, 0);
        instance.setCarryingBazooka(true);
        instance.shoot();
        
        boolean expectedValue = false;
        boolean actualValue = instance.isCarryingBazooka();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void testCheater() {
        System.out.println("cheater");
        Player instance = new Player(0, 0);
        Cheater cheater = new Cheater(0, 0, 5);
        
        instance.setStepsTaken(10);
        
        instance.reduceSteps(cheater);
        
        int expectedResult = 5;
        assertEquals(expectedResult, instance.getStepsTaken());
    }

    /**
     * Test of pickUpBazooka method, of class Player.
     */
    @Test
    public void testPickUpBazooka() {
        System.out.println("pickUpBazooka");
        Player instance = null;
        instance.pickUpBazooka();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class Player.
     */
    @Test
    public void testPaintComponent_3args() {
        System.out.println("paintComponent");
        Graphics g = null;
        int beginX = 0;
        int beginY = 0;
        Player instance = null;
        instance.paintComponent(g, beginX, beginY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class Player.
     */
    @Test
    public void testPaintComponent_Graphics() {
        System.out.println("paintComponent");
        Graphics g = null;
        Player instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canWalkThrough method, of class Player.
     */
    @Test
    public void testCanWalkThrough() {
        System.out.println("canWalkThrough");
        Player instance = null;
        boolean expResult = false;
       // boolean result = instance.canWalkThrough();
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFrame method, of class Player.
     */
    @Test
    public void testSetFrame() {
        System.out.println("setFrame");
        Frame frame = null;
        Player instance = null;
        instance.setFrame(frame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCarryingBazooka method, of class Player.
     */
    @Test
    public void testIsCarryingBazooka() {
        System.out.println("isCarryingBazooka");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.isCarryingBazooka();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCarryingBazooka method, of class Player.
     */
    @Test
    public void testSetCarryingBazooka() {
        System.out.println("setCarryingBazooka");
        boolean bool = false;
        Player instance = null;
        instance.setCarryingBazooka(bool);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaced method, of class Player.
     */
    @Test
    public void testGetFaced() {
        System.out.println("getFaced");
        Player instance = null;
        Direction expResult = null;
        Direction result = instance.getFaced();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStepsTaken method, of class Player.
     */
    @Test
    public void testGetStepsTaken() {
        System.out.println("getStepsTaken");
        Player instance = null;
        int expResult = 0;
        int result = instance.getStepsTaken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
