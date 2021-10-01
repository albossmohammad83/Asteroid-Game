import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class keyDown extends KeyAdapter {
    Station station;
    private ArrayList<Rocket> rockets = new ArrayList<Rocket>( );
    public void keyPressed (KeyEvent e) {
        char key = e.getKeyChar( );
        switch (key) {
            case 'j': station.moveLeft( ); break; // turn left
            case 'k': station.moveRight( ); break; // turn right
            case ' ': station.fire(rockets); break; // space: fire
            case 'q': System.exit(0); // q: quit
        }
    }
}