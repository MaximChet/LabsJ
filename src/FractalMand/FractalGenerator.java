package FractalMand;
import java.awt.geom.Rectangle2D;

public abstract class FractalGenerator {

    public static double getCoord(double rangeMin, double rangeMax, int size, int coord) {

        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }


    /**
     * Sets the specified rectangle to contain the initial range suitable for
     * the fractal being generated.
     */
    public abstract void getInitialRange(Rectangle2D.Double range);


    /**
     * Updates the current range to be centered at the specified coordinates,
     * and to be zoomed in or out by the specified scaling factor.
     */
    public void recenterAndZoomRange(Rectangle2D.Double range, double centerX, double centerY, double scale) {

        double newWidth = range.width * scale;
        double newHeight = range.height * scale;

        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }


    /**
     * Given a coordinate <em>x</em> + <em>iy</em> in the complex plane,
     * computes and returns the number of iterations before the fractal
     * function escapes the bounding area for that point.  A point that
     * doesn't escape before the iteration limit is reached is indicated
     * with a result of -1.
     */
    public abstract int numIterations(double x, double y);
}
