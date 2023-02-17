import java.awt.Graphics;

/**
 * This class is used to create a platform used to exit.
 * FUTURE IMPROVEMENTS: Exit function.
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class ExitPlatform extends WoodenPlatform {

   /**
    * This BasicImage keeps track of the lamp's image.
    */
   private BasicImage img = new BasicImage("Images/Lamp.png", 20, 60);
   /**
    * This int keeps track of the lamp's x coordinate.
    */
   private int lampX;
   /**
    * This int keeps track of the lamp's y coordinate.
    */
   private int lampY;

   /**
    * Constructs a WoodenPlatform object (literally just super constructor).
    * 
    * @param x      The x coordinate.
    * @param x      The y coordinate.
    * @param length The length of the platform.
    * @param height The height of the platform.
    */
   public ExitPlatform(int x, int y, int length, int height) {
      super(x, y, length, height);
      lampX = x + length - 20;
      lampY = y - 60;
   }

   /**
    * The collsion detection happens here.
    * 
    * @param x      The x coordinate of the user.
    * @param y      The y coordinate of the user.
    * @param xSpeed Speed of user's x.
    * @param ySpeed Speed of user's y.
    * @param length The length of the user.
    * @param height The height of the user.
    * @return The collision that occurs.
    */
   public int collisionDetection(int x, int y, int xSpeed, int ySpeed, int height, int length) {
      if (x < lampX + 20 && x + length > lampX && ((y + height > lampY) && (y < lampY + 60))) {
         return 4;
      } else if ((x < getX() + getLength() && x + length > getX()) && (y + height + ySpeed > getY())
            && (y + ySpeed < getY() + getHeight())) {
         return 1;
      } else if ((x + length + xSpeed > getX()) && (x + xSpeed < getX() + getLength()) && y < getY() + getHeight()
            && y + height > getY()) {
         return 2;

      }
      return 0;
   }

   /**
    * Draws the platform.
    * 
    * @param g The graphics object used for the superclass call.
    */
   public void paintComponent(Graphics g) {

      /*
       * Color platEdge = new Color (119,62,40);
       * Color platCol = new Color(59,41,22);
       * g.setColor(platCol);
       * g.fillRect(getX(), getY(), getLength(), getHeight());
       * g.setColor(platEdge);
       * g.drawRect(getX(), getY(), getLength(), getHeight());
       */
      super.paintComponent(g);
      img.paintComponent(g, lampX, lampY);
   }

}