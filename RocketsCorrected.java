import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
This code uses sample canvas of auto generated for me by ChatGPT, so we still need to readjust stuff for our own canvas
*/
public class Rockets {

    /*
    initialize ArrayList for rockets as part of the game
    initialize ArrayList for platforms
    initialize timer that's responsible for sending a rocket once in 5 seconds
     */
    private static List<Rocket> rockets = new ArrayList<>();
    private static List<Platform> platforms = new ArrayList<>();
    private static Timer timer;

    //Class for platforms (imagine it's there)

    //class for rockets object
    private static class Rocket {
        int x, y;

        public Rocket(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //Made this move method assuming that rockets fly from right border of the screen to the left
        public void move() {
            x -= 5; // Move rocket leftward
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x, y, 10, 10); // Draw rocket as a red square
        }
    }


            // We will need the enhanced for loop for drawing rockets from this part
            JPanel gamePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    for (Platform platform : platforms) {
                        platform.draw(g);
                    }
                    for (Rocket rocket : rockets) {
                        rocket.draw(g);
                    }
                }
            };
            frame.add(gamePanel);


            /*line starting with "rockets.add" is responsible
            for sending rockets 20 pixels ABOVE THE LEVEL OF THE HIGHEST PLATFORM using getHighestPlatformLevel() method
            Still need to readjust code so that rockets are sent ±20 pixels above the level of ArrayList of platforms
            */
            // Timer that sends rockets 20 pixels above platform level every 5 seconds
            timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rockets.add(new Rocket(frame.getContentPane().getSize().width - 10, /*getPlatformLevel()*/ - 20));
                    /*JPanel name*/.repaint();
                }
            });
            timer.start();

            // Game loop where the screen is repainted every 30 milliseconds to reflect rocket movements
            new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Rocket rocket : rockets) {
                        rocket.move();
                    }
                    /*JPanel name*/.repaint();
                }
            }).start();

        });
    }
}
