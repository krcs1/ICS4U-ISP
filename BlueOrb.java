import java.awt.*;

/**
 * This class is used to create a dissapearing platform.
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */

public class BlueOrb extends Block {

    /**
     * This int keeps track of the hazard's x coordinate.
     */
    private int x;

    /**
     * This int keeps track of the hazard's y coordinate.
     */
    private int y;

    /**
     * This int keeps track of the hazard's length.
     */
    private int length;

    /**
     * This int keeps track of the hazard's height.
     */
    private int height;

    /**
     * How much of the life is used for the platform.
     */
    private int used = 0;
    /**
     * Maximum duration platform can be used.
     */
    private int maxUsed = 10;

    /**
     * Constructs a Platform object.
     * 
     * @param x      The x coordinate.
     * @param x      The y coordinate.
     * @param length The length of the platform.
     * @param height The height of the platform.
     */
    public BlueOrb(int x, int y, int length, int height) {
        super(x, y, length, height, "a");
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
    }

    /**
     * Checks for collisions
     * 
     * @param x      The x to of the player.
     * @param y      The y of the player.
     * @param length The length of the player.
     * @param height The height of the player.
     * @param xSpeed Speed of user's x.
     * @param ySpeed Speed of user's y.
     */
    public int collisionDetection(int x, int y, int xSpeed, int ySpeed, int length, int height) {
        if (used < maxUsed && (x < getX() + getLength() && x + length > getX()) && (y + height + ySpeed >= getY())
                && (y + ySpeed <= getY() + getHeight())) {
            used++;
            return 1;
        } else if (used < maxUsed && (x + length + xSpeed > getX()) && (x + xSpeed < getX() + getLength())
                && y < getY() + getHeight() && y + height > getY()) {
            return 2;

        }
        return 0;
    }

    /**
     * Sets platform as used
     */
    public void setUsed() {
        used = 0;
    }

    /**
     * Draws the platform.
     * 
     * @param g The graphics object used for the superclass call.
     */
    public void paintComponent(Graphics g) {
        if (used < maxUsed) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, length, height);
        }
    }

}
