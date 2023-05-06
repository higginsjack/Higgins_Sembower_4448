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
// import java.awt.peer.TextFieldPeer;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI("Slytherin");
            }
        });
    }
    public static void createAndShowGUI(String title) {
        //Create and set up the window.
        // JFrame frame = new JFrame("Slytherin");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // //Add the ubiquitous "Hello World" label.
        // JLabel pglabel = new JLabel("Play Game");
        // JLabel leaderlabel = new JLabel("Leader Board");
        // JLabel settingslabel = new JLabel("Settings");

        // ImageIcon img = new ImageIcon("img/snak.jpeg");
        // JButton play = new JButton("Play Game", img);
        // play.setSize(500,500);
        // frame.getContentPane().add(play);
        // frame.getContentPane().add(leaderlabel);
        // frame.getContentPane().add(settingslabel);

        //Display the window.
        // frame.pack();
        // frame.setVisible(true);
        // System.out.println(frame.getSize());
        JFrame sly = null;
        JFrame lb = null;
        JFrame set = null;
        if(title=="Slytherin") {
            sly = new JFrame("Slytherin");
            sly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            //Create and set up the content pane.
            Slytherin newContentPane = new Slytherin();
            newContentPane.setOpaque(true); //content panes must be opaque
            Dimension d = new Dimension(400,500);
            sly.setPreferredSize(d);
            sly.setContentPane(newContentPane);
            //Display the window.
            sly.pack();
            sly.setVisible(true);
        }
        else if(title =="LeaderBoard"){
            lb = new JFrame("LeaderBoard");
            lb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            //Create and set up the content pane.
            LeaderBoard newContentPane = new LeaderBoard();
            newContentPane.setOpaque(true); //content panes must be opaque
            Dimension d = new Dimension(400,500);
            lb.setPreferredSize(d);
            lb.setContentPane(newContentPane);
            //Display the window.
            lb.pack();
            lb.setVisible(true);
        }
        else if(title=="Settings") {
            set = new JFrame("Settings");
            set.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            //Create and set up the content pane.
            Settings newContentPane = new Settings();
            newContentPane.setOpaque(true); //content panes must be opaque
            Dimension d = new Dimension(400,500);
            set.setPreferredSize(d);
            set.setContentPane(newContentPane);
            //Display the window.
            set.pack();
            set.setVisible(true);
        }
    }
}