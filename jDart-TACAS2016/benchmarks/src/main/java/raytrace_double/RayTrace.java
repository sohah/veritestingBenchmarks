package raytrace_double;
import java.util.*;

/***************************************************
*
*   An instructional Ray-Tracing Renderer written
*   for MIT 6.837  Fall '98 by Leonard McMillan.
*
*   A fairly primitive Ray-Tracing program written
*   on a Sunday afternoon before Monday's class.
*   Everything is contained in a single file. The
*   structure should be fairly easy to extend, with
*   new primitives, features and other such stuff.
*
*   I tend to write things bottom up (old K&R C
*   habits die slowly). If you want the big picture
*   scroll to the applet code at the end and work
*   your way back here.
*
****************************************************/






// An example "Renderable" object
/*class Sphere implements Renderable {
    Surface surface;
    Vector3D center;
    double radius;
    double radSqr;

    public Sphere(Surface s, Vector3D c, double r) {
        surface = s;
        center = c;
        radius = r;
        radSqr = r*r;
    }

    public boolean intersect(Ray ray) {
        double dx = center.x - ray.origin.x;
        double dy = center.y - ray.origin.y;
        double dz = center.z - ray.origin.z;
        double v = ray.direction.dot(dx, dy, dz);

        // Do the following quick check to see if there is even a chance
        // that an intersection here might be closer than a previous one
        if (v - radius > ray.t)
            return false;

        // Test if the ray actually intersects the sphere
        double t = radSqr + v*v - dx*dx - dy*dy - dz*dz;
        if (t < 0)
            return false;

        // Test if the intersection is in the positive
        // ray direction and it is the closest so far
        t = v - ((float) Math.sqrt(t));
        if ((t > ray.t) || (t < 0))
            return false;

        ray.t = t;
        ray.object = this;
        return true;
    }

    public Color Shade(Ray ray, Vector lights, Vector objects, Color bgnd) {
        // An object shader doesn't really do too much other than
        // supply a few critical bits of geometric information
        // for a surface shader. It must must compute:
        //
        //   1. the point of intersection (p)
        //   2. a unit-length surface normal (n)
        //   3. a unit-length vector towards the ray's origin (v)
        //
        double px = ray.origin.x + ray.t*ray.direction.x;
        double py = ray.origin.y + ray.t*ray.direction.y;
        double pz = ray.origin.z + ray.t*ray.direction.z;

        Vector3D p = new Vector3D(px, py, pz);
        Vector3D v = new Vector3D(-ray.direction.x, -ray.direction.y, -ray.direction.z);
        Vector3D n = new Vector3D(px - center.x, py - center.y, pz - center.z);
        n.normalize();

        // The illumination model is applied
        // by the surface's Shade() method
        return surface.Shade(p, n, v, lights, objects, bgnd);
    }

    public String toString() {
        return ("sphere "+center+" "+radius);
    }
}*/

