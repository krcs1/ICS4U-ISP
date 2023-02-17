import java.awt.*;

/**
* This class is used to create a vertical spikes with collision detection.
* FUTURE IMPROVEMENTS: Not much really.
* @version 2022.06.14
* @author Krish Patel
*/
public class SideSpikes extends Hazard{
    
   /**
   *This int keeps track of the number of spikes.
   */
    private int numSpikes;

       /**
   *This int keeps track of the spike's color.
   */
    private Color silver = new Color(192, 192, 192);
 
       /**
   *This int keeps track of the spike's shape.
   */
    private Polygon spikeShape;

    	/**
	* Constructs a SideSpikes object.
   * @param x The x coordinate.
   * @param y The y coordinate.
   * @param numSpikes The number of spikes.
	*/
    public SideSpikes(int x, int y, int numSpikes){
        super(x, y, 20, 10*numSpikes);

        this.numSpikes = numSpikes;

        int[] xList = new int[numSpikes * 6];
        int[] yList = new int[numSpikes * 6];
  
        int a = 0;
        for (int i = 0; i < numSpikes; i++) {
           yList[a] = y + i * 10;
           xList[a] = x;
           a++;
           yList[a] = y + 10 / 2 + i * 10;
           xList[a] = x+10;
           a++;
           yList[a] = y + 10 + i * 10;
           xList[a] = x;
           a++;
        }
  
        for (int i = numSpikes; i > 0; i--) {
  
           yList[a] = y + 10 + i * 10-10;
           xList[a] = x + 10;
           a++;
           yList[a] = y + 10 / 2 + i * 10-10;
           xList[a] = x+20;
           a++;
           yList[a] = y + i * 10 -10;
           xList[a] = x + 10;
           a++;
        }
        spikeShape = new Polygon(xList, yList, numSpikes * 6);
     }
    
      /**
    * Returns number of spikes of the platform.
    * 
    * @return The number of spikes.
    */
   public int getNumSpikes() {
    return numSpikes;
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
