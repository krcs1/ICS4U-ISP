import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

/**
 * This class is used to create spikes with colliison detection.
 * FUTURE IMPROVEMENTS: Not much really.
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class Spikes extends Hazard {

   /**
    * This int keeps track of the number of spikes.
    */
   private int numSpikes;

   /**
    * This int keeps track of the spike's color.
    */
   private Color silver = new Color(192, 192, 192);

   /**
    * This int keeps track of the spike's shape.
    */
   private Polygon spikeShape;

   /**
    * Constructs a spikes object.
    * 
    * @param x         The x coordinate.
    * @param y         The y coordinate.
    * @param numSpikes The number of spikes.
    */
   public Spikes(int x, int y, int numSpikes) {
      super(x, y, 10 * numSpikes, 20);
      this.numSpikes = numSpikes;

      int[] xList = new int[numSpikes * 6];
      int[] yList = new int[numSpikes * 6];

      int a = 0;
      for (int i = 0; i < numSpikes; i++) {
         xList[a] = x + i * 10;
         yList[a] = y + 10;
         a++;
         xList[a] = x + 10 / 2 + i * 10;
         yList[a] = y;
         a++;
         xList[a] = x + 10 + i * 10;
         yList[a] = y + 10;
         a++;
      }

      for (int i = numSpikes; i > 0; i--) {

         xList[a] = x + 10 + i * 10 - 10;
         yList[a] = y + 10;
         a++;
         xList[a] = x + 10 / 2 + i * 10 - 10;
         yList[a] = y + 20;
         a++;
         xList[a] = x + i * 10 - 10;
         yList[a] = y + 10;
         a++;
      }
      spikeShape = new Polygon(xList, yList, numSpikes * 6);
   }

   /**
    * Returns length of the platform.
    * 
    * @return The length of the platform.
    */
   public int getNumSpikes() {
      return numSpikes;
   }

   /**
    * Checks for collisions
    * @param x      The x to of the player.
    * @param y      The y of the player.
    * @param length The length of the player.
    * @param height The height of the player.
    * @param xSpeed Speed of user's x.
    * @param ySpeed Speed of user's y.
    */
   public int collisionDetection(int x, int y, int xSpeed, int ySpeed, int length, int height) {
      if (x < getX() + getLength() && x + length > getX()
            && ((y + height > getY() - 10) && (y < getY() + getHeight() - 10))) {
         return 3;
      }
      return 0;
   }

   /**
    * Draws the platform.
    * 
    * @param g The graphics object used for the superclass call.
    */
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(silver);
      g.fillPolygon(spikeShape);

   }

}