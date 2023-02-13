package main;

import javax.swing.JPanel;
import java.awt.Graphics;

// JPanel to be extended to see the difference in the call methods as compared to the object of JFrame
public class GamePanel extends JPanel {
    
    // whilst JFrame is the frame, JPanel is the actual picture
    // constructor
    public GamePanel() {

    }

    public void paintComponent(Graphics g) {
        // this is where we will be able to draw our images
        // do all the things that need to be done first prior to painting the picture
        super.paintComponent(g);

        g.fillRect(100, 100, 200, 50);
    }
}
