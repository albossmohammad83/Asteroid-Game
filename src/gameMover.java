
public class gameMover extends Thread {
    AsteroidGame aGame;
    // override the run( ) method of Thread
    public void run ( ) {
        while (true) {
            aGame.movePieces( );
            aGame.repaint( );
            try {
                sleep(100);
            } catch (Exception e) { }
        }
    }
}
// we will soon learn that we call repaint( ) and the GUI toolkit calls our paint( )
// So, we override paint( ) and call the superclass’s repaint( )
// but we never override repaint( )