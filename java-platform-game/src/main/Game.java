package main;

public class Game implements Runnable {

    // create gameWindow object
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;


    // call methods with a constructor which is considered the head method of the class - we can call any code within the constructor - NOTE: constructor name needs to match the class name
    public Game() {
        gamePanel = new GamePanel(); // we need to put the game panel into the game window

        gameWindow = new GameWindow(gamePanel); 
        
        // request inputs
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // perform fps check
    @Override
    public void run() {
        
        // store the duration of each frame in nanoseconds

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        // create an infinite loop that accepts an amount of frames per sec
        while(true) {
            // check if the duration has passed, if it has then another loop will occur
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame = now;
                   frames++;
            }

         // create a fps counter
     
        if(System.currentTimeMillis() - lastCheck >= 1000); {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
        }
        
    }
    
}
