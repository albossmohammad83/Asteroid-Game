import java.awt.*;
class Asteroid {
    public double x, y; // current position of ‘this’ asteroid
    private double dx, dy; // displacement (delta) dx & dy for next position
    public int size = 20; // initial size 20 pixels
    public Asteroid (double ix, double iy, double idx, double idy) // constructor
    { x = ix; y = iy; dx = idx; dy = idy; }
    public void move ( ) { x += dx; y += dy; } // move to next position
    public void paint (Graphics g) { // Hey asteroid, paint yourself
        g.setColor(Color.blue); // as a blue circle
        g.drawOval((int) x, (int) y, size, size); // must be int coordinates
    }
    public void hit ( ) { size = size - 4; } // been hit, shrink size
    public boolean nearTo (double tx, double ty) {
// use Pythagorean theorem to determine distance between points
        double distance = Math.sqrt( (x - tx) * (x - tx) + (y - ty) * (y - ty) );
        return distance < 10; // Is (tx, ty) too close to ‘this’?
    } // x, y are coordinates of ‘this’
}