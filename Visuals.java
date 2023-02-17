import javax.swing.JComponent;
import java.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is used to create a level's visuals.
 * FUTURE IMPROVEMENTS: Exits.
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class Visuals extends JComponent implements KeyListener {

   /**
    * This Character is the one on the screen.
    */
   private Character dave;

   /**
    * The Walls on the screen.
    */
   private Walls wall;

   /**
    * The platforms on the screen.
    */
   private ArrayList<Block> plats;

   /**
    * This boolean keeps track of the state of the up arrow key (pressed or not).
    */
   private boolean rightKey;

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
    *This boolean checks if the q key is pressed (for flight).
    */
   private boolean qKey;

   /**
    * This boolean checks if the 1 key is pressed .
    */
   private boolean key1;

   /**
    * This boolean checks if the 2 key is pressed .
    */
   private boolean key2;

   /**
    * This boolean checks if the 3 key is pressed .
    */
   private boolean key3;

   /**
    * /*This boolean checks if the e key is pressed .
    */
   private boolean eKey;

   /**
    * Constructs a Visuals object.
    * 
    * @param dave  The character.
    * @param wall  The walls.
    * @param plats The platforms.
    */
   public Visuals(Character dave, Walls wall, ArrayList<Block> plats) {
      this.dave = dave;
      this.wall = wall;
      this.plats = plats;
      // addKeyListener(this);
      // setFocusable(true);
      // setFocusTraversalKeysEnabled(false);
      // background.repaint();
   }

   /**
    * Constructs a Visuals object.
    */
   public Visuals() {
   }

   /*
    * /**
    * Checks if a key is pressed as input, and takes correspondng action to change
    * Character.
    * 
    * @param e The key event which occured, used to find the key which was pressed.
    */
   public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_UP) {
         upKey = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         rightKey = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         leftKey = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
         downKey = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_Q) {
         qKey = true;
         dave.setQKey(qKey);
      }
      if (e.getKeyCode() == KeyEvent.VK_1) {
         key1 = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_2) {
         key2 = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_3) {
         key3 = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_E) {
         eKey = true;
      }
      dave.setKeys(leftKey, rightKey, upKey, downKey, key1, key2, key3, eKey);
      // qKey = false;
   }

   /**
    * Checks if a key is released as input, and takes correspondng action to change
    * Character.
    * 
    * @param e The key event which occured, used to find the key which was relesed.
    */
   public void keyReleased(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_UP) {
         upKey = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
         downKey = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         rightKey = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         leftKey = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_1) {
         key1 = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_2) {
         key2 = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_3) {
         key3 = false;
      }
      if (e.getKeyCode() == KeyEvent.VK_E) {
         eKey = false;
      }
      dave.setKeys(leftKey, rightKey, upKey, downKey, key1, key2, key3, eKey);

   }

   /**
    * NOT USED FOR MY CODE
    * 
    * @param e The key event which occured, used to find the key which was typed.
    */
   public void keyTyped(KeyEvent e) {

   }

   /**
    * Sets the character.
    * 
    * @param dave The character to be added.
    */
   public void setCharacter(Character dave) {
      this.dave = dave;
   }

   /**
    * Sets the walls.
    * 
    * @param wall The walls to be added.
    */
   public void setWalls(Walls wall) {
      this.wall = wall;
   }

   /**
    * Sets the platforms.
    * 
    * @param plats The platforms to be added.
    */
   public void setPlats(ArrayList<Block> plats) {
      this.plats = plats;
   }

   /**
    * Gets the character.
    * 
    * @return The character.
    */
   public Character getCharacter() {
      return dave;
   }

   /**
    * Gets the walls.
    * 
    * @return The walls.
    */
   public Walls getWalls() {
      return wall;
   }

   /**
    * Gets the platforms.
    * 
    * @return The platforms.
    */
   public ArrayList<Block> getPlats() {
      return plats;
   }

   /**
    * Draws the graphics together.
    * 
    * @param g The graphics object used for the superclass call.
    */
   public void paintComponent(Graphics g) {
      // background.paintComponent(g);
      super.paintComponent(g);
      dave.paintComponent(g);

   }

}