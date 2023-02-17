import java.awt.*;

/**
 * This class is used to create a thorns object.
 * FUTURE IMPROVEMENTS: Not much really.
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class Thorns extends Hazard {

   /**
    * This image keeps track of the thorns image (visuals).
    */
   private BasicImage thorns;

   /**
    * Constructs a Platform object.
    * 
    * @param x      The x coordinate.
    * @param x      The y coordinate.
    * @param length The length of the thorns.
    * @param height The height of the thorns.
    */
   public Thorns(int x, int y, int length, int height) {
      super(x, y, length, height);
      thorns = new BasicImage("Images/Thorns.png", length+20, height);

   }

   /**
    * Draws the thorns.
    * 
    * @param g The graphics object used for the superclass call.
    */
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      thorns.paintComponent(g, getX()-10, getY());

   }

}
