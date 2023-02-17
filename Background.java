
import java.awt.Graphics;

/**
 * This class is used to create a background image used as the background for
 * the game.
 * FUTURE IMPROVEMENTS: Not much really.
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class Background extends BasicImage {

   /**
    * Constructs a Background object and initalizes all variables as need be.
    * 
    * @param location The file location of the background images.
    * @param length   The length of the background.
    * @param height   The height of the background.
    * 
    */
   public Background(String location, int length, int height) {
      super(location, length, height);
   }

   /**
    * The method that paints the background.
    * @param g The graphics used to pint the background
    */
   public void paintComponent(Graphics g) {
      this.paintComponent(g, 0, 0);
   }

}