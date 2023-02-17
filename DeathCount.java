import javax.swing.*;
import java.awt.*;

/**
 * This class is simply used to hold the player's death count
 * CREDIT: https://docs.oracle.com/en/java/javase/17/docs/api/index.html
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class DeathCount extends JComponent {

  /**
   * The boolean controls if it is used.
   */
  private boolean first = true;

  /**
   * The image for the skull.
   */
  private BasicImage skull;

  /**
   * Makes a deathcount object.
   */
  public DeathCount() {
    skull = new BasicImage("Images/Skull.png", 50, 50);
    // height = 700;
  }

      /**
     * Draws the platform.
     * 
     * @param g The graphics object used for the superclass call.
     * @param numDeaths the number of deaths.
     */
  public void paintComponent(Graphics g, int numDeaths) {
    skull.paintComponent(g, 1000 - 75, 10);

    if (first) {
      g.setColor(Color.WHITE);
      Font font = new Font("Algerian", Font.PLAIN, 20);
      g.setFont(font);
    }

    g.drawString(Integer.toString(numDeaths), 1000 - 75, 75);
  }

}
