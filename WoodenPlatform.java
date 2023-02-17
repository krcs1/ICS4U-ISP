import java.awt.Graphics;


/**
* This class is used to create a wooden platform.
* FUTURE IMPROVEMENTS: Not much really.
* @version 2022.06.14
* @author Krish Patel
*/
public class WoodenPlatform extends Block{

	/**
	* Constructs a WoodenPlatform object (literally just super constructor).
   * @param x The x coordinate.
   * @param x The y coordinate.
   * @param length The length of the platform.
   * @param height The height of the platform.
	*/
   public WoodenPlatform(int x, int y, int length, int height){
      super(x,y,length,height, "Images/WoodenPlatform.png");
   }

   /**
	* Draws the FANCY platform.
	* @param g The graphics object used for the superclass call.
	*/
   public void paintComponent(Graphics g) {
   
  /*    Color platEdge = new Color (119,62,40);
      Color platCol = new Color(59,41,22);
      g.setColor(platCol);
      g.fillRect(getX(), getY(), getLength(), getHeight());      
      g.setColor(platEdge);
      g.drawRect(getX(), getY(), getLength(), getHeight());     
 */ 
  super.paintComponent(g);
   }

}