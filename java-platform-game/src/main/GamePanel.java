package main;

import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


// JPanel to be extended to see the difference in the call methods as compared to the object of JFrame
public class GamePanel extends JPanel {
    
    // create an object for mouse inputs as there are 2 variables
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 1f, yDir = 1f;
    private int frames = 0;
    private long lastCheck = 0;

    // inputing colors
    private Color color = new Color(150, 20, 90);
    // randomise color
    private Random random;

    // whilst JFrame is the frame, JPanel is the actual picture
    // constructor
    public GamePanel() {

        // initialise random color
        random = new Random();

        // initialise mouse input class
        mouseInputs = new MouseInputs(this);

        // add inputs inside the gamepanel - implemented from inputs package
        addKeyListener(new KeyboardInputs(this));

        // add mouse inputs
        addMouseListener(mouseInputs);

        // add mouse motion inputs
        addMouseMotionListener(mouseInputs); // same classes can be passed through as both are implemented within the class

    }

    // add method for changing x and y Delta axis

    public void changeXDelta(int value) {
        this.xDelta += value;
        // recalling the paintComponent to redraw every time and eventListener activates
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    // placing the rectangle on click
    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
    }

    // this is where we will be able to draw our images

    public void paintComponent(Graphics g) {
       
        // do all the things that need to be done first prior to painting the picture
        super.paintComponent(g);

        // frames move without input
        updateRectangle();

        // change colour of paint component
        g.setColor(color);
        // adding delta allows it to move based on our inputs
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

    

    }

    private void updateRectangle() {
        xDelta += xDir;
        if(xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRndColor();
        }

        yDelta+= yDir;
        if(yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRndColor();
        }
    }

    // generate a random color whenever the rectangle moves in a diff direction
    private Color getRndColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color (r,g,b);
    }
}
