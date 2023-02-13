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
