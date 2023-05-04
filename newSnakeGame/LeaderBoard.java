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
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeaderBoard extends JPanel implements ActionListener {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    
    protected JButton pg, lb, se;
    protected JLabel imgLabel, blank1, blank2;
    protected JButton back;
    public LeaderBoard() {
        JButton back = new JButton("Menu");
        back.setMnemonic(KeyEvent.VK_M);
        back.setActionCommand("Slytherin");
        back.addActionListener(this);
        back.setAlignmentX(RIGHT_ALIGNMENT);
        back.setAlignmentY(TOP_ALIGNMENT);
        
        File l = new File("data/leader.csv");
        try {
            Scanner sc = new Scanner(l);
            sc.useDelimiter(",");   //sets the delimiter pattern 
            String data="";
            while (sc.hasNext()) {  
                // System.out.println(sc.next());
                String txt = sc.next();
                // System.out.println(txt.substring(txt.length()-1));
                if(txt.indexOf('\n')!=-1){
                    // System.out.println(txt);
                    int s = txt.indexOf('\n');
                    data=data + txt.substring(0,s) + ":" +  txt.substring(s) + ":";
                }
                else{
                    data=data + txt +":";
                }
                // System.out.println(sc.next());
            }   
            // data.substring(0,data.length()-1);
            sc.close();
            String df[] = data.split(":");
            int len = df.length;
            String[][] table = new String[len/3][3];
            System.out.println(len);
            for(int i = 0; i < 5;i++) {
                System.out.println(df[i]);
            }
            for(int i=0; i < len-1; i=i+3) {
                String[] temp = {df[i], df[i+1], df[i+2]};
                table[i/3] = temp;
            }
            String[] cols = {"NAME", "SCORE","DATE"};
            JTable jt = new JTable(table, cols);
            add(jt);
        }
        catch(FileNotFoundException ex){
            System.out.println("Error");
        }
        
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
