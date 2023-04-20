package start;

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

public class LeaderBoard extends JPanel implements ActionListener{
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    
    protected JButton pg, lb, se;
    protected JLabel imgLabel, blank1, blank2;
    protected JButton back;
    public LeaderBoard() {
        // ImageIcon topButtonIcon = createImageIcon("/img/snak.jpg");
        // ImageIcon middleButtonIcon = createImageIcon("/img/snak.jpg");
        // ImageIcon bottomButtonIcon = createImageIcon("/img/snak.jpg");
        // back = new Jbutton
        pg = new JButton("Play Game");
        // pg.setVerticalTextPosition(AbstractButton.TOP);
        // pg.setHorizontalTextPosition(AbstractButton.CENTER); //aka LEFT, for left-to-right locales
        pg.setActionCommand("Play Game");
        pg.setMnemonic(KeyEvent.VK_D);
        // pg.setActionCommand("disable");
 
        lb = new JButton("Leader Board");
        // lb.setVerticalTextPosition(AbstractButton.BOTTOM);
        // lb.setHorizontalTextPosition(AbstractButton.CENTER);
        // lb.setVerticalTextPosition(AbstractButton.CENTER);
        lb.setMnemonic(KeyEvent.VK_M);
        lb.setActionCommand("Leader Board");

        se = new JButton("Settings");
        // lb.setVerticalTextPosition(AbstractButton.BOTTOM);
        // lb.setHorizontalTextPosition(AbstractButton.CENTER);
        //Use the default text position of CENTER, TRAILING (RIGHT).
        se.setMnemonic(KeyEvent.VK_E);
        se.setActionCommand("Settings");
        // se.setEnabled(false);
        
        //Listen for actions on buttons 1 and 3.
        pg.addActionListener(this);
        lb.addActionListener(this);
        se.addActionListener(this);
 
        pg.setToolTipText("Click this button to disable the middle button.");
        lb.setToolTipText("This middle button does nothing when you click it.");
        se.setToolTipText("Click this button to enable the middle button.");
 
        //Add Components to this container, using the default FlowLayout.

        Dimension bSize = new Dimension(100,100);
        pg.setPreferredSize(bSize);
        lb.setPreferredSize(bSize);
        se.setPreferredSize(bSize);

        ImageIcon i = createImageIcon("/img/snak.jpg");
        JLabel imgLabel = new JLabel(i);
        imgLabel.setPreferredSize(new Dimension(100,160));
        imgLabel.setVisible(true);

        ImageIcon t = createImageIcon("/img/textSlySized.jpg");
        JLabel blank1 = new JLabel(t);
        blank1.setPreferredSize(bSize);
        // blank1.setVisible(false);
        JButton blank2 = new JButton("S");
        blank2.setPreferredSize(bSize);
        blank2.setVisible(false);

        JPanel grid = new JPanel(new GridLayout(1, 3));
        grid.add(pg);
        grid.add(lb);
        grid.add(se);
        // southPanel.add( buttons );
        // southPanel.add( clearButton );
        
        // add(imgLabel);
        imgLabel.setAlignmentX(RIGHT_ALIGNMENT);
        imgLabel.setAlignmentY(TOP_ALIGNMENT);
        imgLabel.setBounds(0, 0, 100, 160);
        add(imgLabel);
        // add(grid);
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
            // lb.dispose();
            lb.setVisible(false);
            pg.setVisible(false);
            se.setVisible(false);
            // imgLabel.setVisible(false);
        } else if ("Leader Board".equals(e.getActionCommand())) {
            lb.setVisible(false);
            pg.setVisible(false);
            se.setVisible(false);
            // imgLabel.setVisible(false);

        } else if ("Settings".equals(e.getActionCommand())) {
            lb.setEnabled(false);
            pg.setEnabled(false);
            se.setEnabled(false);
            // imgLabel.setVisible(false);
        }
    }
}
