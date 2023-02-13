package main;

public class Game {

    // create gameWindow object
    private GameWindow gameWindow;
    private GamePanel gamePanel;

    // call methods with a constructor which is considered the head method of the class - we can call any code within the constructor - NOTE: constructor name needs to match the class name
    public Game() {
        gamePanel = new GamePanel(); // we need to put the game panel into the game window

        gameWindow = new GameWindow(gamePanel); 
        
        // request inputs
        gamePanel.requestFocus();
    }
    
}
