import java.awt.*;
import java.util.*;

/**
 * This class is simply used to create a text box.
 * CREDIT: https://docs.oracle.com/en/java/javase/17/docs/api/index.html
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class TextBox extends Block {

    /**
     * This boolean keeps track of if this is the first text box drawn.
     */
    private boolean first = true;
    /**
     * This int is font size.
     */
    private static int size = 18;
    /**
     * This font is used for text.
     */
    private Font font = new Font("Times New Roman", Font.PLAIN, size);
    /**
     * This is text for the game.
     */
    private ArrayList<String> text;
    /**
     * This is the x where the player stops.
     */
    private int xStop;
    /**
     * This is if the user interacted with the text.
     */
    private int interacted = 0;
    /**
     * This is the line of text where input is taken.
     */
    private int breakPoint;
    /**
     * This is length of an interaction.
     */
    private int interactionLength = 4;
    /**
     * This is the answer number.
     */
    private int answer;
    /**
     * If input is taken fromt the user.
     */
    private boolean breakpointExists;
    /**
     * This is the colors for the text.
     */
    private ArrayList<Color> colors;
    /**
     * This is the colors for the text.
     */
    private int responseLength;

    /**
     * Constructs a TextBpx object.
     * 
     * @param Stop             The x coordinate for the stop.
     * @param breakPoint       The line with the breakpoint.
     * @param breakpointExists If a breakpoint exists.
     * @param responseLength   The length of the response.
     * @param text             The text for the dialogue.
     */
    public TextBox(int xStop, int breakPoint, boolean breakpointExists, int responseLength, ArrayList<String> text,
            ArrayList<Integer> colorNums) {
        super(1000, 5 + size, 400, 0, "Images/Textbox.png");
        this.text = text;
        this.xStop = xStop;
        this.breakPoint = breakPoint;
        if (!breakpointExists) {
            interacted = 3;
        }
        this.breakpointExists = breakpointExists;
        this.responseLength = responseLength;
        colors = new ArrayList<Color>();

        for (int num : colorNums) {
            switch (num) {

                case 0:
                    colors.add(Color.WHITE);
                    break;

                case 1:
                    colors.add(Color.BLUE);
                    break;

                case 2:
                    colors.add(Color.ORANGE);
                    break;

                case 3:
                    colors.add(Color.PINK);
                    break;
                case 4:
                    colors.add(Color.GREEN);
                    break;
            }

        }
    }

    /**
     * Checks for collisions.
     * 
     * @param x      The x coordinate of the user.
     * @param y      The y coordinate of the user.
     * @param xSpeed Speed of user's x.
     * @param ySpeed Speed of user's y.
     * @param length The length of the user.
     * @param height The height of the user.
     * @return The collision that occurs.
     */
    public int collisionDetection(int x, int y, int xSpeed, int ySpeed, int length, int height) {
        if (!breakpointExists) {
            return 0;
        }
        if (answer != 0) {
            interacted = 3;
            return 0;
        }
        if (x > xStop) {
            interacted = 1;
            return 5;
        }

        return 0;
    }

    /**
     * Checks for collisions.
     * 
     * @param key1 If key 1 is pressed.
     * @param key2 If key 2 is pressed.
     * @param key3 If key 3 is pressed.
     */
    public void setInteracted(boolean key1, boolean key2, boolean key3) {
        if (key1) {
            answer = 1;
            for (int i = 0; i < responseLength; i++) {
                text.remove(breakPoint + interactionLength + 1);
                text.remove(breakPoint + interactionLength + 1);
                colors.remove(breakPoint + interactionLength + 1);
            }
            colors.remove(breakPoint + interactionLength + 1);
        } else if (key2) {
            answer = 2;
            for (int i = 0; i < responseLength; i++) {

                text.remove(breakPoint + interactionLength);
                text.remove(breakPoint + interactionLength + 1);
                colors.remove(breakPoint + interactionLength);
                colors.remove(breakPoint + interactionLength + 1);
            }
        } else if (key3) {
            answer = 3;
            for (int i = 0; i < responseLength; i++) {
                text.remove(breakPoint + interactionLength);
                text.remove(breakPoint + interactionLength);
                colors.remove(breakPoint + interactionLength);
                colors.remove(breakPoint + interactionLength);
            }
        }
    }

    /**
     * Draws the stuff.
     * 
     * @param g The graphics object used for the superclass call.
     */
    public void paintComponent(Graphics g) {
        if (first) {
            g.setFont(font);
        }
        // super.paintComponent(g);

        if (interacted < 2) {
            for (int i = 0; i < breakPoint; i++) {
                g.setColor(colors.get(i));
                g.drawString(text.get(i), getX(), size + i * 20);
            }
            if (interacted == 1) {
                for (int j = 0; j < interactionLength * responseLength; j++) {
                    g.setColor(colors.get(breakPoint + j));
                    g.drawString(text.get(breakPoint + j), getX(), size + (breakPoint + j) * 20);
                }
            }
        } else {

            for (int i = 0; i < text.size(); i++) {
                g.setColor(colors.get(i));
                g.drawString(text.get(i), getX(), size + i * 20);

            }

        }
    }
}