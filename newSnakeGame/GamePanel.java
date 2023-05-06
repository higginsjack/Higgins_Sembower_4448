import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.time.LocalDateTime;    

import javax.swing.JPanel;
public class GamePanel extends JPanel implements ActionListener, Subject {

    Observer observer;
    private static final long serialVersionUID = 1L;

    static final int WIDTH = 500;
    static final int HEIGHT = 500;
    static final int UNIT_SIZE = 20;
    static final int NUMBER_OF_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);

    //for the snake body
    final int x[] = new int[NUMBER_OF_UNITS];
    final int y[] = new int[NUMBER_OF_UNITS];

    //intialize the original snake
    int length = 5;
    int foodEaten;
    int foodX;
    int foodY;
    
    char direction = 'D';
    boolean running = false;

    int spell1_active_timer; //How long the spell lasts
    Boolean spell1_active;
    Boolean cd1; // When this is true, the spells can't be used because they are in cooldown 
    Boolean cd2;
    int cd2_timer; // How long until the cooldown is over

    Random random;
    Timer timer;
    AlertStateContext gameState = new AlertStateContext();
    GamePanel() {
        registerObserver(Tracker.getInstance());
        random = new Random();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));  
        this.setBackground(Color.DARK_GRAY);

        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        if (running == true) gameState.setState(new StartGame());
        play();
    }

    public void play(){
        addFood();
        running = true;
        spell1_active = false;
        cd1 = false;

        cd2 = false;

        timer = new Timer(80, this);
        timer.start();

    }
    @Override
        public void paintComponent(Graphics graphics){
            super.paintComponent(graphics);
            draw(graphics);
        }

    public void move(){
        for (int i = length; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        if (direction == 'L'){
            x[0] = x[0] - UNIT_SIZE;
        }
        else if (direction == 'R'){
            x[0] = x[0] + UNIT_SIZE;
        }
        else if (direction == 'U'){
            y[0] = y[0] - UNIT_SIZE;
        }
        else {
            y[0] = y[0] + UNIT_SIZE;
        }

    }

    public void checkFood(){
        if (x[0] == foodX && y[0] == foodY){
            length++;
            foodEaten++;
            addFood();
        }
    }

    public void draw(Graphics graphics){
        if (running){
            graphics.setColor(new Color(210, 115, 90));
            graphics.fillOval(foodX, foodY, UNIT_SIZE, UNIT_SIZE);

            graphics.setColor(Color.white);
            graphics.fillRect(x[0], y[0], UNIT_SIZE, UNIT_SIZE);

            for (int i = 1; i < length; i++){
                graphics.setColor(new Color(40, 200, 150));
                graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            graphics.setColor(Color.white);
            graphics.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 25));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: " + foodEaten, (WIDTH - metrics.stringWidth("Score: " + foodEaten)) / 2, graphics.getFont().getSize());
        } else {
            gameOver(graphics);
            keepScore();
        }
    }

    public void addFood(){
        foodX = random.nextInt((int)(WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        foodY = random.nextInt((int)(HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    //checking to see if the snake collides with anything
    public void checkHit(){
        for (int i = length; i > 0; i--){
            if (x[0] == x[i] && y[0] == y[i]){
                running = false;
            }
        }

        //see if snake head runs into the wall
        if (x[0] < 0 || x[0] > WIDTH || y[0] < 0 || y[0] > HEIGHT){
            running = false;
        }
        if (!running){
            gameState.setState(new QuitGame());
            timer.stop();
        }
    }

    public void gameOver(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 50));
        FontMetrics metrics = getFontMetrics(graphics.getFont());
        graphics.drawString("Game over", (WIDTH - metrics.stringWidth("Game over")) / 2, HEIGHT / 2);

        graphics.setColor(Color.white);
        graphics.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 25));
        metrics = getFontMetrics(graphics.getFont());
        graphics.drawString("Score: " + foodEaten, (WIDTH - metrics.stringWidth("Score " + foodEaten)) / 2, graphics.getFont().getSize());
    }
    public void keepScore() {
        String inStr = JOptionPane.showInputDialog(null, "Save Score by entering your name",
        "Input Dialog", JOptionPane.PLAIN_MESSAGE);
        // System.out.println(inStr);
        if(inStr != null) {
            writeToCSV(inStr, foodEaten);
        }
        System.exit(0);
    }

    public void writeToCSV(String name, int score) { // Uses Tracker pattern and notifies observers then writes to CSV
        LocalDateTime now = LocalDateTime.now();  
        String date = now+"";
        notifyObserver(observer, name+ ","+score+","+date);
        observer.reportOut();
        unregisterObserver(observer);
    }
    @Override
    public void actionPerformed(ActionEvent arg0){
        if (running){
            if(spell1_active_timer % 2 == 0 && spell1_active){
                /*
                 * This was my way to slow down the snake
                 * It still checks for food and hit
                 * Doesn't move the snake every other action opportunity effectively halving the speed
                 */
                checkFood();
                checkHit();
            }
            else{
                move();
                checkFood();
                checkHit();
            }
            if(spell1_active) { 
                spell1_active_timer--;
                if(spell1_active_timer < 1) {
                    cd1 = true;
                    spell1_active=false;
                    spell1_active_timer=100;
                }
            }
            if(cd1) {
                spell1_active_timer--;
                if(spell1_active_timer==0) {
                    spell1_active_timer=100;
                    cd1=false;
                }
            }
            if(cd2) {
                cd2_timer--;
                if(cd2_timer < 1) {
                    cd2=false;
                }
            }
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                if (direction != 'R'){
                    direction = 'L';
                }
                break;

                case KeyEvent.VK_RIGHT:
                if (direction != 'L'){
                    direction = 'R';
                }
                break;

                case KeyEvent.VK_UP:
                if (direction != 'D'){
                    direction = 'U';
                }
                break;
                
                case KeyEvent.VK_DOWN:
                if (direction != 'U'){
                    direction = 'D';
                }
                break;
                case KeyEvent.VK_1: //If press 1, spell activates
                if (cd1==false){
                    spell1_active = true;
                    spell1_active_timer=100;
                }
                break;
                case KeyEvent.VK_2:
                if (cd2==false){
                    addFood(); //Food location will be changed to new spot
                    cd2=true;
                    cd2_timer=100;
                }
                break;
            }
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


