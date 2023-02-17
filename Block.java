import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * This class is used to create a barebones platform with minimal functionality.
 * FUTURE IMPROVEMENTS: Not much really.
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class Block extends JComponent {

   /**
    * This int keeps track of the platform's x coordinate.
    */
   private int x;

   /**
    * This int keeps track of the platform's y coordinate.
    */
   private int y;

   /**
    * This int keeps track of the platform's length.
    */
   private int length;

   /**
    * This int keeps track of the platform's height.
    */
   private int height;

   /**
    * This is the image for the platform.
    */
   private BasicImage img;

   /**
    * Constructs a Platform object.
    * 
    * @param x        The x coordinate.
    * @param y        The y coordinate.
    * @param length   The length of the platform.
    * @param height   The height of the platform.
    * @param location The location of the image.
    */
   public Block(int x, int y, int length, int height, String location) {
      this.x = x;
      this.y = y;
      this.length = length;
      this.height = height;
      img = new BasicImage(location, length, height);
   }

   /**
    * This sets the locaation ofr the image.
    * 
    * @param location The location of the image file.
    */
   public void setLocation(String location) {
      img = new BasicImage(location, length, height);
   }

   /**
    * Returns length of the platform.
    * 
    * @return The length of the platform.
    */
   public int getLength() {
      return length;
   }

   /**
    * eeturns height of the platform.
    * 
    * @return The height of the platform.
    */
   public int getHeight() {
      return height;
   }

   /**
    * Returns x of the platform.
    * 
    * @return The x of the platform.
    */
   public int getX() {
      return x;
   }

   /**
    * Returns y of the platform.
    * 
    * @return The y of the platform.
    */
   public int getY() {
      return y;
   }

   /**
    * Returns thorns of the platform.
    * 
    * @return The thorns of the platform.
    */
   public Thorns getThorns() {
      Thorns t = new Thorns(1, 1, 1, 1);
      return t;
   }

   /**
    * Checks colllision detection with platform.
    * 
    * @param x      X of the player.
    * @param y      Y of the player.
    * @param xSpeed X speed of the player.
    * @param ySpeed Y speed of the player.
    * @param height Height of the player.
    * @param length Length of the player.
    * 
    */
   public int collisionDetection(int x, int y, int xSpeed, int ySpeed, int height, int length) {
      if ((x < getX() + getLength() && x + length > getX()) && (y + ySpeed == getY() + getHeight())) {
         return 6;
      }

      else if ((x < getX() + getLength() && x + length > getX()) && (y + height + ySpeed > getY())
            && (y + ySpeed < getY() + getHeight())) {
         return 1;
      } else if ((x + length + xSpeed > getX()) && (x + xSpeed < getX() + getLength()) && y < getY() + getHeight()
            && y + height > getY()) {
         return 2;

      }
      return 0;
   }

   /**
    * Not used in this class (used in subclasses)
    */
   public void setInteracted(boolean key1, boolean key2, boolean key3) {

   }

   /**
    * Not used in this class (used in subclasses)
    */
   public void setUsed() {
   }

   /**
    * Draws the platform.
    * 
    * @param g The graphics object used for the superclass call.
    */
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      img.paintComponent(g, x, y);
   }

}