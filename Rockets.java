
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Rocket {
    int x, y;
    public static List<Rocket> rockets = new ArrayList<>();
    public Rocket(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getXCoord() {
        return x;
    }
    public int getYCoord() {
        return y;
    }

    //Made this move method assuming that rockets fly from right border of the screen to the left
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 10, 10); // Draw rocket as a red square
    }
    public Rectangle getRocketBounds() {
        return new Rectangle(this.getXCoord(),this.getYCoord(),10,10); //Do I need this. keyword?
    }

    public void move() {
        x -= 5; // Move rocket leftward
        y += 1; // Move rocket downward
    }
    public static void addRocket(){
        rockets.add(new Rocket(1000, 75));
        rockets.add(new Rocket(1000, 225));
        rockets.add(new Rocket(1000, 375));
        rockets.add(new Rocket(1000, 525));
        rockets.add(new Rocket(1000, 675));
        rockets.add(new Rocket(1000, 825));

    }
    public static void drawRockets(Graphics g) {
        for (Rocket rocket : rockets) {
            rocket.draw(g);
        }
    }
}

