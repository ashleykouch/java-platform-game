# Platformer Game Intro

## First part - setup

- Create 4 main classes
  - main method class
  - game class - where everything is added and put together including:
    - handlers
    - player
    - levels
    - enemies
    - gameloop()
  - window class (JFrame)
  - game screen class (JPanel) - where everything will be drawn
- After classes are added, we will be able to draw something to output onto the screen

### Process

- create Main class
- create GameWindow class (frame)
  - call in Main class
  - create JFrame
- create GamePanel class (painting)
  - extend JPanel
  - create paintComponent
  - fill drawing inside window
- create Game class
  - call frame and panel into class
- Call GamePanel in GameWindow
  - call panel into window under Game class

## Second part - inputs

- add inputs and make sure they respond to events on keyboard/mouse
- move rectangle drawn from first part with new inputs
- mouse inputs
  - mouseListener()
    - clicked
    - pressed
    - released
    - entered & exit
  - mouseMotionListener()
    - moved
    - dragged
- repaint() - to call paintComponent again with new values

### Process

- create new package for inputs
  - add mouse input class
  - add keyboard input class
- implement event listeners in each class
  - KeyboardListener(import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener; )
  - MouseListener(import java.awt.event.MouseEvent; import java.awt.event.MouseListener;)
  - MouseMotionListener(import java.awt.event.MouseMotionListener;)
- add unimplemented classes (automatic fix)
- add variables movement on x and y axis
- implement movement through methods in gamePanel
- add methods to input activity

## Third part - game loop
