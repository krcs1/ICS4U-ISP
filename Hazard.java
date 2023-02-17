import java.awt.Graphics;

/**
 * This class is used to create a hazard just collision detection.
 * FUTURE IMPROVEMENTS: Not much really.
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class Hazard extends Block {

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
     * Constructs a Platform object.
     * 
     * @param x      The x coordinate.
     * @param x      The y coordinate.
     * @param length The length of the platform.
     * @param height The height of the platform.
     */
    public Hazard(int x, int y, int length, int height) {
        super(x, y, length, height, "a");
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;

    }

    /**
     * Returns x of the platform.
     * 
     * @return The x of the platform.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y of the platform.
     * 
     * @return The y of the platform.
     */
    public int getY() {
        return y;
    }

    /**
     * Returns length of the platform.
     * 
     * @return The length of the platform.
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns height of the platform.
     * 
     * @return The height of the platform.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param h The heigth to be set.
     */
    public void setHeight(int h) {
        height = h;
    }

    /**
     * @param l The legnth to be set.
     */
    public void setLength(int l) {
        height = l;
    }

    /**
     * @param y The y to be set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param x The x to be set.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param x      The x coordinate of the user.
     * @param y      The y coordinate of the user.
     * @param xSpeed Speed of user's x.
     * @param ySpeed Speed of user's y.
     * @param length The length of the user.
     * @param height The height of the user.
     */
    public int collisionDetection(int x, int y, int xSpeed, int ySpeed, int length, int height) {
        if (x < this.x + this.length && x + length > this.x && ((y + height > this.y) && (y < this.y + this.height))) {
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

    }

}