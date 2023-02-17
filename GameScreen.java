import java.io.*;
import java.util.*;

import javax.swing.*;

/**
 * This class creates the frame where all graphic components are added into.
 * NOTE: A LOT (LIKE ALMOST EVERYTHING) in this class was moved to another class
 * to make it more optimized.
 * I just left it here in case I need to go back to this code.
 * FUTURE IMPROVEMENTS: Moving between visual components (screens).
 * 
 * @version 2022.06.14
 * @author Krish Patel & Eric Han
 */

public class GameScreen extends JFrame {

   /**
    * These visuals for the game.
    */
   private ArrayList<Visuals> visualList;
   /**
    * These visuals on the screen.
    */
   private Visuals currentVisuals;
   /**
    * Number of deaths.
    */
   private int deathNumber;
   /**
    * Number (current screen).
    */
   private int currentScreen;
   /**
    * Number of screens.
    */
   private int numScreens;

   /**
    * /* Returns the walls for the screen.
    * /* @return The walls used for this screen.
    */
   public Visuals getVisuals() {
      return currentVisuals;
   }

   /**
    * Constructs a GameScreen object.
    * 
    * @param length The length of the screen.
    * @param width  The width of the screen.
    */
   public GameScreen(int length, int height) {
      super();
      visualList = new ArrayList<Visuals>();

      try {

         BufferedReader reader = new BufferedReader(new FileReader("Levels.txt"));
         int numScreens = Integer.parseInt(reader.readLine());
         this.numScreens = numScreens - 5;
         for (int currentNum = 0; currentNum < numScreens; currentNum++) {
            reader.readLine();
            ArrayList<Block> plats = new ArrayList<Block>();
            String backgroundImage = reader.readLine();
            int numObjects = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numObjects; i++) {

               StringTokenizer st = new StringTokenizer(reader.readLine(), ",");
               Block temp;

               switch (st.nextToken()) {
                  case "WP":
                     temp = new WoodenPlatform(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                           Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                     plats.add(temp);
                     break;

                  case "TP":
                     temp = new ThornPlatform(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                           Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                           Boolean.parseBoolean(st.nextToken()), Boolean.parseBoolean(st.nextToken()),
                           Boolean.parseBoolean(st.nextToken()), Boolean.parseBoolean(st.nextToken()));
                     plats.add(temp);
                     break;

                  case "EP":
                     temp = new ExitPlatform(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                           Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                     plats.add(temp);
                     break;

                  case "S":
                     temp = new Spikes(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                           Integer.parseInt(st.nextToken()));
                     plats.add(temp);
                     break;

                  case "SS":
                     temp = new SideSpikes(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                           Integer.parseInt(st.nextToken()));
                     plats.add(temp);
                     break;

                  case "T":
                     temp = new Thorns(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                           Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                     plats.add(temp);
                     break;
                  case "BO":
                     temp = new BlueOrb(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                           Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                     plats.add(temp);
                     break;

                  case "TB":
                     int numLines = Integer.parseInt(st.nextToken());
                     int xStop = Integer.parseInt(st.nextToken());
                     int breakPoint = Integer.parseInt(st.nextToken());
                     Boolean breakpointExists = Boolean.parseBoolean(st.nextToken());
                     int responseLength = Integer.parseInt(st.nextToken());

                     ArrayList<String> lines = new ArrayList<String>();
                     ArrayList<Integer> colors = new ArrayList<Integer>();

                     for (int h = 0; h < numLines; h++) {
                        String line = reader.readLine();

                        colors.add(Integer.parseInt(line.substring(0, 1)));
                        lines.add(line.substring(2));
                     }
                     temp = new TextBox(xStop, breakPoint, breakpointExists, responseLength, lines, colors);
                     plats.add(temp);
                     break;
               }
            }
            Walls wallUsed = new Walls(length - 20, 0, 0, height - 40, 0, 0, 0);
            Character dante;
            Background back;

            if (currentNum < 5) {
               back = new Background(backgroundImage, 1400, 680);
               dante = new Character(wallUsed.getLeftWall(), wallUsed.getDownWall(), true);

            } else {
               back = new Background(backgroundImage, 1000, 680);
               dante = new Character(wallUsed.getLeftWall(), wallUsed.getDownWall(), false);

            }

            if (currentNum > 18) {
               dante.setFlyUnlocked(true);
            }
            dante.setPlatform(plats);
            dante.setWalls(wallUsed);

            dante.setBackground(back);
            Visuals vis = new Visuals(dante, wallUsed, plats);
            addKeyListener(vis);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);

            visualList.add(vis);
         }
         currentVisuals = visualList.get(currentScreen);
         reader.close();
         // getContentPane().add(currentVisuals.getCharacter());
         // addKeyListener(currentVisuals);
         // setFocusable(true);
         // setFocusTraversalKeysEnabled(false);

         // getContentPane().add(currentVisuals);

      } catch (IOException e) {
      }

   }

   /**
    * Keeps updating the screen.
    */
   public void repainter() {

      /*
       * IntroductionScreen introScreen = new IntroductionScreen();
       * getContentPane().removeAll();
       * getContentPane().add(introScreen);
       * getContentPane().revalidate();
       * 
       * while(true){
       * introScreen.repaint();
       * if (currentScreen == -5){
       * break;
       * }
       * }
       */
      getContentPane().removeAll();
      getContentPane().add(currentVisuals);
      getContentPane().revalidate();
      while (true) {

         try {
            Thread.sleep(3);
         } catch (Exception e) {
         }

         if (currentScreen < 2) {
            try {
               Thread.sleep(5000);
            } catch (Exception e) {
            }
            currentScreen++;
            currentVisuals = visualList.get(currentScreen);
            currentVisuals.getCharacter().setDeaths(deathNumber);
            // addKeyListener(currentVisuals);
            // setFocusable(true);
            // setFocusTraversalKeysEnabled(false);
            getContentPane().removeAll();
            getContentPane().add(currentVisuals);
            getContentPane().revalidate();
            currentVisuals.getCharacter().setLevelEnded(false);
         }

         else if (currentScreen == 2) {
            try {
               Thread.sleep(100);
            } catch (Exception e) {
            }
            switch (currentVisuals.getCharacter().getKeyNums()) {

               case 1:
                  currentScreen = 4;
                  currentVisuals = visualList.get(currentScreen);
                  currentVisuals.getCharacter().setDeaths(deathNumber);
                  getContentPane().removeAll();
                  getContentPane().add(currentVisuals);
                  getContentPane().revalidate();
                  currentVisuals.getCharacter().setLevelEnded(false);
                  break;
               case 2:
                  currentScreen = 5;
                  currentVisuals = visualList.get(currentScreen);
                  currentVisuals.getCharacter().setDeaths(deathNumber);
                  getContentPane().removeAll();
                  getContentPane().add(currentVisuals);
                  getContentPane().revalidate();
                  currentVisuals.getCharacter().setLevelEnded(false);
                  break;
               case 3:
                  currentScreen = 3;
                  currentVisuals = visualList.get(currentScreen);
                  currentVisuals.getCharacter().setDeaths(deathNumber);
                  getContentPane().removeAll();
                  getContentPane().add(currentVisuals);
                  getContentPane().revalidate();
                  currentVisuals.getCharacter().setLevelEnded(false);
                  break;
               default:
                  break;
            }
         }

         else if (currentScreen == 3) {
            try {
               Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.exit(0);
         }

         else if (currentScreen == 4) {

            if (currentVisuals.getCharacter().getKeyNums() == 4) {

               currentScreen = 2;
               currentVisuals = visualList.get(currentScreen);
               currentVisuals.getCharacter().setDeaths(deathNumber);
               getContentPane().removeAll();
               getContentPane().add(currentVisuals);
               getContentPane().revalidate();
               currentVisuals.getCharacter().setLevelEnded(false);
            }
         }

         if (currentVisuals.getCharacter().getLevelCompletionStatus() == true) {
            if (currentScreen < numScreens + 4) {
               deathNumber = currentVisuals.getCharacter().getDeaths();
               currentScreen++;
               currentVisuals = visualList.get(currentScreen);
               currentVisuals.getCharacter().setDeaths(deathNumber);
               // addKeyListener(currentVisuals);
               // setFocusable(true);
               // setFocusTraversalKeysEnabled(false);
               getContentPane().removeAll();
               getContentPane().add(currentVisuals);
               getContentPane().revalidate();
               currentVisuals.getCharacter().setLevelEnded(false);
            } else {
               currentScreen = 3;
               currentVisuals = visualList.get(currentScreen);
               currentVisuals.getCharacter().setDeaths(deathNumber);

               getContentPane().removeAll();
               getContentPane().add(currentVisuals);
               getContentPane().revalidate();
               currentVisuals.getCharacter().setLevelEnded(false);
            }
            // break;

         }

         currentVisuals.repaint();

      }

   }
}
