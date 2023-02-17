import java.awt.*;

/**
 * This class is used to create a thorns platform.
 * FUTURE IMPROVEMENTS: Not much really.
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class ThornPlatform extends WoodenPlatform {

    /**
     * This thorn keeps track of the thorns to be made.
     */
    private Thorns thorn;

    /**
     * Constructs a Platform object.
     * 
     * @param x      The x coordinate.
     * @param y      The y coordinate.
     * @param length The length of the platform.
     * @param height The height of the platform.
     * @param up     If thorns hit the up side if the platform.
     * @param down   If thorns hit the down side if the platform.
     * @param right  If thorns hit the right side if the platform.
     * @param left   If thorns hit the left side if the platform.
     * 
     */
    public ThornPlatform(int x, int y, int length, int height, boolean up, boolean down, boolean right, boolean left) {
        super(x, y, length, height);

        int x2 = x;
        int y2 = y;
        int length2 = length;
        int height2 = height;

        if (left) {
            x2 -= 10;
            length2 += 10;
        }
        if (right) {
            length2 += 10;
        }
        if (up) {
            y2 -= 10;
            height2 += 10;
        }
        if (down) {
            height2 += 10;
        }

        // thorn.setX(x2);
        System.out.println("X2 = " + x2);
        System.out.println("Y2 = " + y2);
        System.out.println("Height2 = " + height2);
        System.out.println("Length2 = " + length2);

        thorn = new Thorns(x2, y2, length2, height2);
    }

    /**
     * Returns thorns.
     * 
     * @return Thorns The thorns to be used.
     */
    public Thorns getThorns() {
        return thorn;
    }

    /**
     * @param g Graphics to be used for visuals.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        thorn.paintComponent(g);

    }

}
