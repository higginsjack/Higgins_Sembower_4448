import javax.swing.*;        
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Slytherin extends JPanel implements ActionListener, Subject{
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    
    protected JButton pg, lb, se;
    protected JLabel imgLabel, blank1, blank2;
    protected JButton back;
    Observer observer; 
    public Slytherin() {
        registerObserver(new Tracker());

        pg = new JButton("Play Game");
        pg.setActionCommand("Play Game");
        pg.setMnemonic(KeyEvent.VK_D);
 
        lb = new JButton("Leader Board");
        lb.setMnemonic(KeyEvent.VK_M);
        lb.setActionCommand("Leader Board");

        se = new JButton("Directions");
        se.setMnemonic(KeyEvent.VK_E);
        se.setActionCommand("Settings");
        
        //Listen for actions on buttons 1 and 3.
        pg.addActionListener(this);
        lb.addActionListener(this);
        se.addActionListener(this);
 
        Dimension bSize = new Dimension(100,100);
        pg.setPreferredSize(bSize);
        lb.setPreferredSize(bSize);
        se.setPreferredSize(bSize);

        ImageIcon i = createImageIcon("/img/house.jpg");
        JLabel imgLabel = new JLabel(i);
        imgLabel.setPreferredSize(new Dimension(100,160));
        imgLabel.setVisible(true);

        ImageIcon t = createImageIcon("/img/textSlySized.jpg");
        JLabel blank1 = new JLabel(t);
        blank1.setPreferredSize(bSize);

        JButton blank2 = new JButton("S");
        blank2.setPreferredSize(bSize);
        blank2.setVisible(false);

        JPanel grid = new JPanel(new GridLayout(1, 3));
        grid.add(pg);
        grid.add(lb);
        grid.add(se);

        imgLabel.setAlignmentX(RIGHT_ALIGNMENT);
        imgLabel.setAlignmentY(TOP_ALIGNMENT);
        imgLabel.setBounds(0, 0, 100, 160);
        add(imgLabel);
        add(grid);
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
        if ("Play Game".equals(e.getActionCommand())) {
            new GameFrame();
        } 
        else if ("Leader Board".equals(e.getActionCommand())) {
            lb.setVisible(false);
            pg.setVisible(false);
            se.setVisible(false);
            Main.createAndShowGUI("LeaderBoard");
            // imgLabel.setVisible(false);

        } else if ("Settings".equals(e.getActionCommand())) {
            lb.setEnabled(false);
            pg.setEnabled(false);
            se.setEnabled(false);
            Main.createAndShowGUI("Settings");
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