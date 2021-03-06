/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Remco
 */
public class Frame extends JFrame {
    JPanel panel;
    Level level = null;
    LevelHandler handler = null;
    
    public Frame() {
        setSize(910, 760);
        setTitle("Doolhof");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
    }
   
    /**
     * Initialises the necesarry variables and the start screen.
     */
    public void init() {
        handler = new LevelHandler();
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JPanel buttonpanel = new JPanel();
        
        Button startbutton = new Button();
        startbutton.setLabel("START");
        startbutton.setBackground(Color.cyan);
        startbutton.addActionListener(new clickListener());
        
        buttonpanel.add(startbutton);
        
        try{
            BufferedImage image = ImageIO.read(new File("src/doolhoftwee/images/Legenda.png"));
            
            JLabel picLabel = new JLabel(new ImageIcon(image));
            panel.add(picLabel, BorderLayout.CENTER);
            panel.repaint();
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        }
        
        panel.add(buttonpanel, BorderLayout.NORTH);
        
        add(panel); 
    }
    
    class clickListener implements ActionListener {     
        public void actionPerformed(ActionEvent e) {
            loadGame();
        }
    }
    
    /**
     * loads the current level in the levelHandler (if possible)
     */
    public void loadGame() {
        remove(panel);
        
        if(level != null) {
            level.destroyComponents();
            level = null;
        }
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        if(handler.hasNextLevel()) {
            level = new Level(this, handler.getCurrentLevel());

            JPanel knopPaneel = new JPanel();
            Button resetbutton = new Button();
            resetbutton.setLabel("RESET");
            resetbutton.setBackground(Color.cyan);
            resetbutton.addActionListener(new clickListener());
            knopPaneel.add(resetbutton);

            panel.add(level, BorderLayout.CENTER);
            panel.add(knopPaneel, BorderLayout.NORTH);

            add(panel);
        }
        else {
            endGame();
        }
        setVisible(true);
        
    }
    
    /**
     * Loads the main menu after taking care of old data.
     */
    public void endGame() {
        remove(panel);
        if(level != null) {
            level.destroyComponents();
            level = null;
        }
        requestFocus();
        init();
        setVisible(true);
    }
    
    /**
     * Go to the next level
     * Loads the game again
     */
    public void finishLevel() {
        remove(panel);
        level.destroyComponents();
        level = null;
        if(handler.hasNextLevel()) {            
            handler.nextLevel();
        }
        loadGame();
    }
        
}
