// package start;

/*
 * HelloWorldSwing.java requires no other files. 
 */
import javax.swing.*;        
import java.awt.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Settings extends JPanel implements ActionListener {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    
    protected JButton pg, lb, se;
    protected JLabel imgLabel, blank1, blank2;
    protected JButton back;
    public Settings() {
        JButton back = new JButton("Menu");
        back.setMnemonic(KeyEvent.VK_M);
        back.setActionCommand("Slytherin");
        back.addActionListener(this);
        back.setAlignmentX(RIGHT_ALIGNMENT);
        back.setAlignmentY(TOP_ALIGNMENT);
        add(back);
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Slytherin.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if ("Slytherin".equals(e.getActionCommand())) {
            Main.createAndShowGUI("Slytherin");
        }
    }
}
