import javax.swing.JComponent;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * This class is used to create a BasicImage object which creates an image.
 * FUTURE IMPROVEMENTS: Not much really.
 * https://www.tutorialspoint.com/java_dip/java_buffered_image.htm for the image
 * tutorial
 * https://docs.oracle.com/javase/tutorial/2d/images/loadimage.html for IMAGEIO
 * tutorial
 * 
 * @version 2022.06.14
 * @author Krish Patel
 */
public class BasicImage extends JComponent {

  /**
   * This Image keeps track of the image being used.
   */
  private Image img;
  /**
   * This int keeps track of the image's length.
   */
  private int length;

  /**
   * This int keeps track of the image's height.
   */
  private int height;

  /**
   * Constructs a BasicImage object and initalizes all variables as need be.
   * 
   * @param location The file location of the background images.
   * @param length   The length of the background.
   * @param height   The height of the background.
   * 
   */
  public BasicImage(String location, int length, int height) {
    this.img = imageFromFile(location);
    this.length = length;
    this.height = height;

  }

  /**
   * @return Image the Image used.
   */
  public Image getImage() {
    return img;
  }

  /**
   * @return int The length of the image.
   */
  public int getLength() {
    return length;
  }

  /**
   * @return int The height of the image.
   */
  public int getHeight() {
    return height;
  }

  /**
   * @param path The path of the image
   * @return BufferedImage The image to be used.
   */
  public BufferedImage imageFromFile(String path) {
    try {
      URL url = Visuals.class.getClassLoader().getResource(path);
      if (url == null)
        throw new NullPointerException();
      return ImageIO.read(url);
    } catch (IOException | NullPointerException e) {
    }
    return null;
  }

  /**
   * @param g The graphics being used to output visuals.
   * @param x The x coordinate of the image.
   * @param y The y coordinate of the image.
   */
  public void paintComponent(Graphics g, int x, int y) {

    g.drawImage(img, x, y, length, height, null);
  }

}