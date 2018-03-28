/**
 * @author @{user}
 */
package raytrace_double;

import java.util.Vector;

/**
 * @author luckow
 *
 */




//An object must implement a Renderable interface in order to
//be ray traced. Using this interface it is straight forward
//to add new objects
interface Renderable {
 public boolean intersect(Ray r);
 public Color Shade(Ray r, Vector lights, Vector objects, Color bgnd);
 public String toString();
}

