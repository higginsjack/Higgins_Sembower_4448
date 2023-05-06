/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

/**
 * This example, like all Swing examples, exists in a package:
 * in this case, the "start" package.
 * If you are using an IDE, such as NetBeans, this should work 
 * seamlessly.  If you are compiling and running the examples
 * from the command-line, this may be confusing if you aren't
 * used to using named packages.  In most cases,
 * the quick and dirty solution is to delete or comment out
 * the "package" line from all the source files and the code
 * should work as expected.  For an explanation of how to
 * use the Swing examples as-is from the command line, see
 * http://docs.oracle.com/javase/javatutorials/tutorial/uiswing/start/compile.html#package
 */
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

        se = new JButton("Directions");
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
            // lb.dispose();
            new GameFrame();
            lb.setVisible(false);
            pg.setVisible(false);
            se.setVisible(false);
            // imgLabel.setVisible(false);
        } else if ("Leader Board".equals(e.getActionCommand())) {
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
        // TODO Auto-generated method stub
        observer = null;
    }

    @Override
    public void notifyObserver(Observer obs, String msg) {
        obs.update(msg);
    }
}