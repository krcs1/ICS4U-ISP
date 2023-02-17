import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
* This class is used to create walls for the game.
* FUTURE IMPROVEMENTS: its pretty good how it is.
* @version 2022.06.14
* @author Krish Patel
*/

public class Walls extends JComponent{

   /**
   *This int keeps track of the how far right, the right wall extends.
   */
   private int rightWall;
   
   /**
   *This int keeps track of the how far left, the left wall extends.
   */
   private int leftWall;
   
   /**
   *This int keeps track of the how far up, the up wall extends.
   */
   private int upWall;
   
   /**
   *This int keeps track of the how far down, the down wall extends.
   */
   private int downWall;

   /**
   *This color is the color used for the walls in the program.
   */
   private Color wallColor;
   
   /**
	 * Constructs a Dave object
	 * @param rightWall The coordinate for the right wall to go until.
	 * @param leftWall The coordinate for the left wall to go until.
	 * @param upWall The coordinate for the top wall to go until.
	 * @param downWall The coordinate for the bottom wall to go until.
    * @param r The red color value in the rgb for the wall color.
    * @param g The green color value in the rgb for the wall color.
    * @param b The blue color value in the rgb for the wall color.
	 */
   public Walls(int rightWall, int leftWall, int upWall, int downWall, int r, int g, int b){
      this.rightWall = rightWall;
      this.leftWall = leftWall;
      this.upWall = upWall;
      this.downWall = downWall;
      wallColor = new Color (r,g,b);
   }
   
   
   /**
   * Default constructor for walls.
   */
   public Walls(){
      rightWall =955;
      leftWall = 30;
      upWall = 30;
      downWall = 520;
      wallColor = new Color (35,51,66);
      
   }

	/**
	 * Draws the walls
	 * @param g The graphics object used for the superclass call.
	 */
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(wallColor);
      g.fillRect(0, 0, leftWall, downWall); //Left wall
      g.fillRect(rightWall, 0, rightWall, downWall + 10); //Right wall
      g.fillRect(0, 0, rightWall, upWall); //Top wall
      g.fillRect(0, downWall, rightWall, downWall); //Bottom wall
   
 
   }

   /**
   /* Returns the left wall for the screen.
   /* @return The left wall's coordinate used for this screen.
   */ 
   public int getLeftWall(){
      return leftWall;
   }

   /**
   /* Returns the right wall for the screen.
   /* @return The right wall's coordinate used for this screen.
   */ 
   public int getRightWall(){
      return rightWall;
   }

   /**
   /* Returns the top wall for the screen.
   /* @return The top wall's coordinate used for this screen.
   */ 
   public int getUpWall(){
      return upWall;
   }

   /**
   /* Returns the top wall for the screen.
   /* @return The top wall's coordinate used for this screen.
   */ 
   public int getDownWall(){
      return downWall;
   }

}