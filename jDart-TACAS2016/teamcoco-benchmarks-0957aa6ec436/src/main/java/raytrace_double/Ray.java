/**
 * @author @{user}
 */
package raytrace_double;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author luckow
 *
 */

class Ray {
    public static final double MAX_T = Float.MAX_VALUE;
    Vector3D origin;
    Vector3D direction;
    double t;
    Renderable object;

    public Ray(Vector3D eye, Vector3D dir) {
        origin = new Vector3D(eye);
        direction = Vector3D.normalize(dir);
    }

    public boolean trace(Vector objects) {
        Enumeration objList = objects.elements();
        t = MAX_T;
        object = null;
        while (objList.hasMoreElements()) {
            Renderable object = (Renderable) objList.nextElement();
            object.intersect(this);
        }
        return (object != null);
    }

    // The following method is not strictly needed, and most likely
    // adds unnecessary overhead, but I prefered the syntax
    //
    //            ray.Shade(...)
    // to
    //            ray.object.Shade(ray, ...)
    //
    public final Color Shade(Vector lights, Vector objects, Color bgnd) {
        return object.Shade(this, lights, objects, bgnd);
    }
/*
    public String toString() {
        return ("ray origin = "+origin+"  direction = "+direction+"  t = "+t);
    }*/
}
