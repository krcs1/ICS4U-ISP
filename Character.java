import java.awt.Graphics;
import javax.swing.JComponent;
import java.util.*;

/**
 * This class is used to create the main character and control their movement
 * mechanics alongside primary gameplay controls.
 * This class to BY FAR the longest to create as it was complicated to make the
 * character interact with everything, but I am almost done our current plans
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class Character extends JComponent /* implements KeyListener */ {

   /**
    * This int keeps track of the player's x coordinate.
    */
   private int x;

   /**
    * This int keeps track of the player's y coordinate.
    */
   private int y;

   /**
    * The length of the character.
    */
   private int length = 30;

   /**
    * The height of the character.
    */
   private int height = 45;

   /**
    * This int keeps track of the player's x axis movement speed.
    */
   private int xSpeed;

   /**
    * This int keeps track of the player's y axis movement speed.
    */
   private int ySpeed;

   /**
    * This boolean keeps track of the state of the up arrow key (pressed or not).
    */
   private boolean upKey;

   /**
    * This boolean keeps track of the state of the left arrow key (pressed or not).
    */
   private boolean leftKey;

   /**
    * This boolean keeps track of the state of the down arrow key (pressed or not).
    */
   private boolean downKey;

   /**
    * This boolean keeps track of the state of the right arrow key (pressed or
    * not).
    */
   private boolean rightKey;

   /**
    * This walls variable helps keep track of boundary collision detection.
    */
   private Walls gameWall;

   /**
    * The height the player has jumped to.
    */
   private int jumpHeight;

   /**
    * The maximum height you can jump to .
    */
   private static int maxJump;

   /**
    * This boolean is used to evaluate whether or not the user can jump.
    */
   private boolean canJump;

   /**
    * This boolean is used to keeptrack of whether or not the character can fly .
    */
   private boolean canFly;

   /**
    * This int variable stores the distance flown by the character.
    */
   private int flyDistance;

   /**
    * This int variable stores the distance flown by the character.
    */
   private static int maxFly;

   /**
    * /*This boolean checks if the q key is pressed (for flight).
    */
   private boolean qKey;

   /**
    * /*This String keeps track of the direction in which the user is facing.
    */
   private boolean facingRight;

   /**
    * /*This ArrayList holds the platforms the character can interact with.
    */
   private ArrayList<Block> platforms;

   /**
    * /*This boolean keeps track of if the user is on the ground.
    */
   private boolean grounded;

   /**
    * /*This ArrayList holds the hazards the character can interact with.
    */
   // private ArrayList<Hazard> hazard;

   /**
    * /*This int holds the starting x coordinate of the character.
    */
   private int startingX;
   /**
    * /*This int holds the starting y coordinate of the character.
    */
   private int startingY;
   /**
    * /*This BasicImage holds the right facing sprite of the character.
    */
   private BasicImage rightSprite;
   /**
    * /*This BasicImage holds the left facing sprite of the character.
    */
   private BasicImage leftSprite;
   /**
    * /*This BasicImage holds the right facing sprite of the character when flying.
    */
   private BasicImage rightSpriteFly;
   /**
    * /*This BasicImage holds the left facing sprite of the character when flying.
    */
   private BasicImage leftSpriteFly;
   /**
    * /*This int holds the coordinate of the bottom wall.
    */
   private int downWall;
   /**
    * /*This int holds the coordinate of the top wall.
    */
   private int upWall;
   /**
    * /*This int holds the coordinate of the left wall.
    */
   private int leftWall;
   /**
    * This int holds the coordinate of the right wall.
    */
   private int rightWall;
   /**
    * /*The background.
    */
   private Background background;
   /**
    * If the level is done.
    */
   private boolean levelEnded;
   /**
    * If the fly is unlocked.
    */
   private boolean flyUnlocked;
   /**
    * The deathcount.
    */
   private DeathCount deathCount;
   /**
    * The deathcount (int value).
    */
   private int numDeaths;
   /**
    * If key 1 is pressed.
    */
   private boolean key1;
   /**
    * If key 2 is pressed.
    */
   private boolean key2;
   /**
    * If key 3 is pressed.
    */
   private boolean key3;
   /**
    * If it is fullscreen.
    */
   private boolean fullscreen;
   /**
    * If key E is pressed.
    */
   private boolean eKey;

   /**
    * Constructs a Character object and initalizes all variables as need be.
    * 
    * @param startX     The x position of the character when starting.
    * @param startY     The y position of the character when starting.
    * @param fullscreen If the game is fullscreen.
    */
   public Character(int startX, int startY, boolean fullscreen) {
      startingX = startX;
      startingY = startY;
      x = startingX;
      y = startingY;
      upKey = false;
      leftKey = false;
      rightKey = false;
      downKey = false;
      qKey = false;
      jumpHeight = 0;
      maxJump = 100;
      canJump = true;
      canFly = true;
      flyDistance = 0;
      maxFly = 200;
      this.fullscreen = fullscreen;
      facingRight = true;

      platforms = new ArrayList<Block>();

      // addKeyListener(this);
      // setFocusable(true);
      // setFocusTraversalKeysEnabled(false);

      grounded = true;

      rightSprite = new BasicImage("Images/RightSprite.png", length + 5, height);
      leftSprite = new BasicImage("Images/LeftSprite.png", length + 5, height);
      rightSpriteFly = new BasicImage("Images/RightSpriteFly.png", length + 5, height);
      leftSpriteFly = new BasicImage("Images/leftSpriteFly.png", length + 5, height);

      levelEnded = false;
      flyUnlocked = false;

      deathCount = new DeathCount();
   }

   /**
    * Sets the level's walls and givs the character boundaries on their movement.
    * 
    * @param w The walls to be used in out of bounds calculations.
    */
   public void setWalls(Walls w) {
      gameWall = w;
      y = gameWall.getDownWall() - height;
      rightWall = gameWall.getRightWall();
      leftWall = gameWall.getLeftWall();
      upWall = gameWall.getUpWall();
      downWall = gameWall.getDownWall();

   }

   /**
    * Sets the key values.
    * 
    * @param keyLeft  The left key presssed or not.
    * @param keyRight The right key presssed or not.
    * @param keyUp    The up key presssed or not.
    * @param keyDown  The down key presssed or not.
    * @param key1     The 1 key presssed or not.
    * @param key2     The 2 key presssed or not.
    * @param key3     The 3 key presssed or not.
    * @param eKey     The e key presssed or not.
    */
   public void setKeys(boolean keyLeft, boolean keyRight, boolean keyUp, boolean keyDown, boolean key1, boolean key2,
         boolean key3, boolean eKey) {
      leftKey = keyLeft;
      rightKey = keyRight;
      upKey = keyUp;
      downKey = keyDown;
      this.key1 = key1;
      this.key2 = key2;
      this.key3 = key3;
      this.eKey = eKey;
      if (leftKey) {
         facingRight = false;
      }
      if (rightKey) {
         facingRight = true;
      }
      if (!upKey) {
         canJump = false;
      }
   }

   /**
    * Sets the Q key values.
    * 
    * @param qKey The q key presssed or not.
    */
   public void setQKey(boolean qKey) {
      this.qKey = qKey;
   }

   /**
    * Gets the completionn status fof the screen.
    * 
    * @return Is the level ended or not.
    */
   public boolean getLevelEnded() {
      return levelEnded;
   }

   /**
    * Sets the background.
    * 
    * @param b The background.
    */
   public void setBackground(Background b) {
      background = b;
   }

   /**
    * Sets the fly ability as unlocked.
    * 
    * @param b The boolean if the fly is unlocked or not.
    */
   public void setFlyUnlocked(boolean b) {
      flyUnlocked = b;
   }

   /**
    * Gives Character a little bit of movement to his right.
    */
   public void moveRight() {
      xSpeed += 3;
   }

   /**
    * Gives Character a little bit of movement to his left.
    */
   public void moveLeft() {
      xSpeed -= 3;
   }

   /**
    * Gives Character a little bit of movement to his downward direction.
    */
   public void moveDown() {
      ySpeed += 2;
   }

   /**
    * Adds a platofrm to the current list.
    * 
    * @param p The platform to be added.
    */
   public void setPlatform(ArrayList<Block> p) {
      platforms = p;
   }

   /**
    * Gives Character a little bit of movement upwards.
    */
   public void moveUp() {
      if (canJump == true || canFly == true) {
         ySpeed -= 3;
         jumpHeight += 3;
      }
   }

   /**
    * Returns x coordinate.
    * 
    * @return int The x coordinate of player.
    */
   public int getX() {
      return x;
   }

   /**
    * Returns y coordinate.
    * 
    * @return int The y coordinate of player.
    */
   public int getY() {
      return y;
   }

   /**
    * Gets the completion status.
    * 
    * @return If the level is ended or not.
    */
   public boolean getLevelCompletionStatus() {

      return levelEnded;
   }

   /**
    * Causes the character to fall down.
    */
   public void gravity() {
      if (!(qKey && canFly && flyDistance < maxFly) && y + ySpeed + height < downWall) {
         if (ySpeed > -3) {
            // canJump = false;
            ySpeed += 3;

         }

      }

      grounded = false;

      if (y + height >= downWall) {
         grounded = true;
      }

      else if (canJump != true || !canFly) {

      }

   }

   /**
    * Gets the key pressed.
    * 
    * @return The number of key pressed (or 4 for e).
    */
   public int getKeyNums() {
      if (key1) {
         return 1;
      }
      if (key2) {
         return 2;
      }
      if (key3) {
         return 3;
      }
      if (eKey) {
         return 4;
      }
      return 0;
   }

   /**
    * Sets the completion status.
    * 
    * @param levelEnded Whether or not the level is completed.
    */
   public void setLevelEnded(boolean levelEnded) {
      this.levelEnded = levelEnded;
   }

   /**
    * Sets the death count.
    * 
    * @param deaths The number of deaths.
    */
   public void setDeaths(int deaths) {
      numDeaths = deaths;
   }

   /**
    * Gets the death count.
    * 
    * @return Number of deaths.
    */
   public int getDeaths() {
      return numDeaths;
   }

   /**
    * Changes Character's position based on any changes in movement/new input.
    */
   public void move() {

      if (flyDistance == maxFly) {
         qKey = false;
         canFly = false;
         canJump = true;
         jumpHeight = 0;
         flyDistance++;
      }

      if (leftKey && x + xSpeed * 2 > leftWall) {
         moveLeft();
      }

      if (rightKey && x + length + xSpeed * 2 < rightWall) {
         moveRight();
      }

      if (qKey && canFly && flyDistance < maxFly) {

         if (upKey) {
            if (y + ySpeed > upWall) {
               moveUp();
            } else {
               ySpeed++;
            }
         }
         if (downKey && y + ySpeed + height < downWall - 5) {
            moveDown();
         }
         canJump = true;
      }

      else {
         if (ySpeed < -15) {
            upKey = false;
         } else if (jumpHeight < maxJump && canJump && upKey && y + ySpeed > upWall) {

            moveUp();

         }

      }

      gravity();

      for (Block p : platforms) {

         switch (p.collisionDetection(x, y, xSpeed, ySpeed, height, length)) {

            case 1:
               ySpeed = 0;
               grounded = true;

               break;

            case 2:
               xSpeed = 0;
               break;

            case 3:
               canJump = true;
               canFly = true;
               x = startingX;
               y = startingY - height;
               flyDistance = 0;
               jumpHeight = 0;
               qKey = false;
               numDeaths++;
               for (Block b : platforms) {
                  b.setUsed();
               }
               break;

            case 4:
               levelEnded = true;
               break;

            case 5:
               // ySpeed = 0;
               xSpeed = 0;
               if (key1 || key2 || key3) {
                  p.setInteracted(key1, key2, key3);
               }
               break;

            case 6:
               ySpeed += 5;
               break;

            case 7:
               break;
            default:

               break;

         }
      }

      if (grounded) {
         canJump = true;
         canFly = true;
         flyDistance = 0;
         jumpHeight = 0;
         qKey = false;
      }

      x += xSpeed;
      y += ySpeed;

      xSpeed = 0;
      ySpeed = 0;
   }

   /**
    * Draws the character Character.
    * 
    * @param g The graphics object used for the superclass call.
    */
   public void paintComponent(Graphics g) {

      super.paintComponent(g);

      background.paintComponent(g);

      if (!fullscreen) {
         gameWall.paintComponent(g);

         for (Block p : platforms) {
            p.paintComponent(g);
         }

         deathCount.paintComponent(g, numDeaths);
         // for (Hazard h: hazard){
         // h.paintComponent(g);
         // }
         if (!flyUnlocked) {
            qKey = false;
         }

         move();

         if (flyDistance > 0 && flyDistance < maxFly) {
            if (facingRight) {
               rightSpriteFly.paintComponent(g, x - 5, y);
            } else {
               leftSpriteFly.paintComponent(g, x - 5, y);
            }
         } else {
            if (facingRight) {
               rightSprite.paintComponent(g, x - 5, y);
            } else {
               leftSprite.paintComponent(g, x - 5, y);
            }
         }
         if (qKey && canFly && flyDistance < maxFly) {
            flyDistance++;
         }
      }
   }
}