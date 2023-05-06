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

public class LeaderBoard extends JPanel implements ActionListener, Subject {
    
    protected JButton pg, lb, se;
    protected JLabel imgLabel, blank1, blank2;
    protected JButton back;
    Observer observer;
    public LeaderBoard() {
        JButton back = new JButton("Menu");
        back.setMnemonic(KeyEvent.VK_M);
        back.setActionCommand("Slytherin");
        back.addActionListener(this);
        back.setAlignmentX(RIGHT_ALIGNMENT);
        back.setAlignmentY(TOP_ALIGNMENT);
        registerObserver(Tracker.getInstance());
        
        File l = new File("data/leader.csv");
        try {
            Scanner sc = new Scanner(l);
            String data="";
            while (sc.hasNext()) {  
                String txt = sc.next();
                data+=txt;

            }
            sc.close();
            notifyObserver(observer, data);
            // System.out.println(data);
            String df[] = data.split(",");
            int len = df.length;
            String[][] table = new String[len/3][3];
            // System.out.println(len + " " + df[0]);
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
            MenuFactory.createAndShowGUI("Slytherin");
        }
    }

    @Override
    public void registerObserver(Observer obs) {
        observer = obs;
    }

    @Override
    public void unregisterObserver(Observer obs) {
        observer = null;
    }

    @Override
    public void notifyObserver(Observer obs, String msg) {
        obs.update(msg);
    }
}
