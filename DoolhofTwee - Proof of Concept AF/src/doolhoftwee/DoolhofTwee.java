package doolhoftwee;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class DoolhofTwee extends JFrame {

    private JFrame frame;
    private JPanel panel;
    
    public static void main(String[] args) {
        new DoolhofTwee();
    }
    
    public DoolhofTwee() {
        frame = new JFrame();
        frame.setSize(825, 650);
        frame.setTitle("Doolhof");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JPanel buttonpanel = new JPanel();
        
        Button startbutton = new Button();
        startbutton.setLabel("START");
        startbutton.setBackground(Color.cyan);
        startbutton.addActionListener(new clickListener());
        
        buttonpanel.add(startbutton);
        
        panel.add(buttonpanel, BorderLayout.CENTER);
        
        frame.add(panel); 
        
        frame.setVisible(true);
    }
    
    class clickListener implements ActionListener {     
            public void actionPerformed(ActionEvent e) {
                startLevel();
            }
        }
    
    public void startLevel() {
        frame.remove(panel);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        Level l = new Level(frame);
        l.drawGrid();        
        
        JPanel knopPaneel = new JPanel();
        Button resetbutton = new Button();
        resetbutton.setLabel("RESET");
        resetbutton.setBackground(Color.cyan);
        resetbutton.addActionListener(new clickListener());
        knopPaneel.add(resetbutton);
        
        panel.add(l, BorderLayout.CENTER);
        panel.add(knopPaneel, BorderLayout.NORTH);
        
        frame.add(panel);        
        frame.setVisible(true);
    }
}
