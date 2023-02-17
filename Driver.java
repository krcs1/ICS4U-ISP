import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * This class is simply used to run the entire program, not much else.
 * FUTURE IMPROVEMENTS: Rest of the game would be nice.
 * CREDIT: https://docs.oracle.com/en/java/javase/17/docs/api/index.html
 * @version 2022.06.14
 * @author Krish Patel
 */

public class Driver {

   /**
    * The length of the screen.
    */
   private static final int length = 1400;

   /**
    * The height of the screen.
    */
   private static final int height = 700;

   /**
    * The screen.
    */
   private static GameScreen frame = new GameScreen(1000, height);

   //The constructor (not used)
   public Driver() {
   }

   /**
    * @param args
    */
   public static void main(String[] args) {
      frame.setResizable(false);
      frame.setSize(length, height);
      frame.setMinimumSize(new Dimension(length, height));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

      frame.pack();
      frame.setVisible(true);

      frame.repainter();
  }
}
