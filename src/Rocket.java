import java.awt.*;
import java.util.ArrayList;

class Rocket {
    public double x, y; // current position coordinates
    private double dx, dy; // idx & idy computed from canon direction
    public Rocket (double ix, double iy, double idx, double idy) // constructor
    { x = ix; y = iy; dx = idx; dy = idy; }
    public void move ( ArrayList<Asteroid> asteroids) {
        x += dx; y += dy; // move ‘this’ rocket
        Asteroid firstAsteroid = asteroids.get(0);
        while ((asteroids).iterator().hasNext()) {
            Asteroid rock = (Asteroid)(asteroids).iterator().next(); // must (cast)
            if (rock.nearTo(x, y))
                rock.hit( ); // hit if too close
        }
    }
    public void paint (Graphics g) {
        g.setColor(Color.red); // draw self: red circle inside
        g.fillOval((int) x, (int) y, 5, 5); // a 5 by 5 bounding rectangle
    } // (x, y) is the upper left corner
}