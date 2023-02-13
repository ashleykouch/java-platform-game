package main;

import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.Graphics;


// JPanel to be extended to see the difference in the call methods as compared to the object of JFrame
public class GamePanel extends JPanel {
    
    // create an object for mouse inputs as there are 2 variables
    private MouseInputs mouseInputs;
    private int xDelta = 100, yDelta = 100;

    // whilst JFrame is the frame, JPanel is the actual picture
    // constructor
    public GamePanel() {

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
        repaint();
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
        repaint();
    }

    // placing the rectangle on click
    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    // this is where we will be able to draw our images

    public void paintComponent(Graphics g) {
       
        // do all the things that need to be done first prior to painting the picture
        super.paintComponent(g);

        // adding delta allows it to move based on our inputs
        g.fillRect(xDelta, yDelta, 200, 50);
    }
}
