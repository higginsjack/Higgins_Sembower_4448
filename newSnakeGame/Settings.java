// package start;

/*
 * HelloWorldSwing.java requires no other files. 
 */
import javax.swing.*;        
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Settings extends JPanel implements ActionListener {
    
    protected JButton pg, lb, se;
    protected JLabel imgLabel, blank1, blank2;
    protected JButton back;
    public Settings() {
        JButton back = new JButton("Menu");
        back.setMnemonic(KeyEvent.VK_M);
        back.setActionCommand("Slytherin");
        back.addActionListener(this);
        back.setAlignmentX(CENTER_ALIGNMENT);
        back.setAlignmentY(TOP_ALIGNMENT);
        add(back);

        ImageIcon t = createImageIcon("/img/directionsSized.jpg");
        JLabel direc = new JLabel(t);;
        direc.setLocation(350,100);
        add(direc);
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
}
