package main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;


import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;


// JPanel to be extended to see the difference in the call methods as compared to the object of JFrame
public class GamePanel extends JPanel {
    
    // create an object for mouse inputs as there are 2 variables
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    
    // import image into code
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 10;

    // create a global variable for player class
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;




    // whilst JFrame is the frame, JPanel is the actual picture
    // constructor
    public GamePanel() {


        // initialise mouse input class
        mouseInputs = new MouseInputs(this);

        // create method for importing image
        importImg();

        // load animations method
        loadAnimations();

        // remove panel size from gameWindow and create a new method to set the panel size
        setPanelSize();

        // add inputs inside the gamepanel - implemented from inputs package
        addKeyListener(new KeyboardInputs(this));

        // add mouse inputs
        addMouseListener(mouseInputs);

        // add mouse motion inputs
        addMouseMotionListener(mouseInputs); // same classes can be passed through as both are implemented within the class

    }

     // load animations method
    private void loadAnimations() {
        animations = new BufferedImage[9][6];

        for(int j = 0; j< animations.length; j++)
            for (int i = 0; i < animations[j].length; i++)
             animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
    }


    private void importImg() {
        InputStream is = getClass().getResourceAsStream("../res/player_sprites.png");

        // try and catch is a stronger if check
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       
    }


    // create a new method to set the panel size
    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    // create method for animation movement
    public void setDirection (int direction) {
        this.playerDir = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }



    // create animation tick method to loop through the animations
    private void updateAnimationTick() {
       
        aniTick++;
        if(aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction))
                aniIndex = 0;
        }



    }

        private void setAnimation() {

            if(moving)
            playerAction = RUNNING;
            else
            playerAction = IDLE;

    }

        private void updatePos() {
            if(moving) {
                switch(playerDir) {
                    case LEFT:
                    xDelta-=5;
                    break;
                    case UP:
                    yDelta-=5;
                    break;
                    case RIGHT:
                    xDelta+=5;
                    break;
                    case DOWN:
                     yDelta+=5;
                    break;

                }
            }
    }

    // this is where we will be able to draw our images

    public void paintComponent(Graphics g) {
       
        // do all the things that need to be done first prior to painting the picture
        super.paintComponent(g);

        updateAnimationTick();

        setAnimation();
        updatePos();

        // draw the image - drawing sprecific sections with a sub image
        g.drawImage(animations[playerAction][aniIndex], (int)xDelta, (int)yDelta, 256, 160,  null);
    }







}
