import java.awt.*;
import java.util.*;


public class AsteroidGame extends Frame {
    private int FrameWidth = 500;
    private int FrameHeight = 400;

    static public void main (String [ ] args) {
        AsteroidGame world = new AsteroidGame( );
        world.setVisible(true);
        world.run( );
    }
    public AsteroidGame ( ) {
        setTitle("Asteroid Game");
        setSize(FrameWidth, FrameHeight);
        setSize(500, 400);
        addKeyListener (new keyDown( ));
        //addWindowListener(new CloseQuit( ));
    }
    public void run ( ) { // move pieces
        while (true) {
            movePieces( );
            repaint( );
            try { // pause 100 milliseconds in order
                Thread.sleep(100); // to create animation illusion
            } catch (Exception e) { } // must be in try-catch
        } // more details later...
    }
    private ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>( );
    private ArrayList<Rocket> rockets = new ArrayList<Rocket>( );
    // Station position middle of baseline
    private Station station = new Station (FrameWidth/2, FrameHeight-20);
    public void paint (Graphics g) {
        station.paint(g);
        Asteroid firstAsteroid = asteroids.get(0);

        while ((asteroids).iterator().hasNext()) {
            Asteroid rock = (Asteroid)(asteroids).iterator().next(); // must (cast)
            rock.paint(g);
        }
        Rocket firstRocket = rockets.get(0);
        while ((rockets).iterator().hasNext()) {
            Rocket rock1 = (Rocket) (rockets).iterator().next(); // must (cast)
            rock1.paint(g);
        }
    }
    public void movePieces ( ) {
// create a random new asteroid – 30% of the time
        if (Math.random( ) < 0.3) {
            Asteroid newRock = new Asteroid(
                    FrameWidth * Math.random( ), 20,
                    10 * Math.random( ) - 5, 3 + 3 * Math.random( ));
            asteroids.add(newRock);
        }
// then move everything
        Asteroid firstAsteroid = asteroids.get(0);
        while ((asteroids).iterator().hasNext()) {
            Asteroid rock = (Asteroid)(asteroids).iterator().next();
            rock.move( );
            station.checkHit(rock);
        }
        Rocket firstRocket = rockets.get(0);
        while ((rockets).iterator().hasNext()) {
            Rocket rock = (Rocket)(rockets).iterator().next();
            rock.move(asteroids);
        }
    }
}