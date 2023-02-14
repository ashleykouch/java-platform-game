package main;

import javax.swing.JFrame;

public class GameWindow {
    /* JFrame
     * - the backbone of the game window
     * - the "frame" of a painting
     * - part of a larger collection of GUI componenets including JPanel, JTextField, JScrollPane, JLabel, etc
     */
    private JFrame jframe;
     public GameWindow(GamePanel gamePanel) {

        // create JFrame object
        jframe = new JFrame();


        // set terminate java run with close button
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // call gamePanel
        jframe.add(gamePanel); // once added call the window inside the panel

        // set frame to open in the centre of the screen
        jframe.setLocationRelativeTo(null);

        // call new panel size method
        jframe.setResizable(false);
        jframe.pack();

          // set the visibility of the frame (false by default)
        jframe.setVisible(true);

     }
}
