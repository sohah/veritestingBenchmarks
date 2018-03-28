/**
 * @author @{user}
 */
package raytrace;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author luckow
 *
 */
public class Surface {
  public float ir, ig, ib;        // surface's intrinsic color
  public float ka, kd, ks, ns;    // constants for phong model
  public float kt, kr, nt;
  private static final float TINY = 0.001f;
  private static final float I255 = 0.00392156f;  // 1/255

  public static void surfaceShade(float rval, float gval, float bval, float a,
      float d, float s, float n, float r, float t, float index, float pX,
      float pY, float pZ, float nX, float nY, float nZ, float vX, float vY,
      float vZ, int lType, float lX, float lY, float lZ, float lR, float lG,
      float lB) {
    Surface surface = new Surface(rval, gval, bval, a, d, s, n, r, t, index);
    Vector3D pVec = new Vector3D(pX, pY, pZ);
    Vector3D nVec = new Vector3D(nX, nY, nZ);
    Vector3D vVec = new Vector3D(vX, vY, vZ);

    Light l = new Light(lType, new Vector3D(lX, lY, lZ), lR, lG, lB);
    Vector<Light> lights = new Vector<Light>();
    lights.add(l);

    surface.Shade(pVec, nVec, vVec, lights, new Vector<Renderable>(), new Color(1, 1, 1));
  }

  public Surface(float rval, float gval, float bval, float a, float d, float s, float n, float r, float t, float index) {
    ir = rval; ig = gval; ib = bval;
    ka = a; kd = d; ks = s; ns = n;
    kr = r*I255; kt = t; nt = index;
  }

  public Color Shade(Vector3D p, Vector3D n, Vector3D v, Vector lights, Vector objects, Color bgnd) {
    Enumeration lightSources = lights.elements();

    float r = 0;
    float g = 0;
    float b = 0;
    while (lightSources.hasMoreElements()) {
      Light light = (Light) lightSources.nextElement();
      if (light.lightType == Light.AMBIENT) {
        r += ka*ir*light.ir;
        g += ka*ig*light.ig;
        b += ka*ib*light.ib;
      } else {
        Vector3D l;
        if (light.lightType == Light.POINT) {
          l = new Vector3D(light.lvec.x - p.x, light.lvec.y - p.y, light.lvec.z - p.z);
          l.normalize();
        } else {
          l = new Vector3D(-light.lvec.x, -light.lvec.y, -light.lvec.z);
        }

        // Check if the surface point is in shadow
        Vector3D poffset = new Vector3D(p.x + TINY*l.x, p.y + TINY*l.y, p.z + TINY*l.z);
        Ray shadowRay = new Ray(poffset, l);
        if (shadowRay.trace(objects))
          break;

        float lambert = Vector3D.dot(n,l);
        if (lambert > 0) {
          if (kd > 0) {
            float diffuse = kd*lambert;
            r += diffuse*ir*light.ir;
            g += diffuse*ig*light.ig;
            b += diffuse*ib*light.ib;
          }
          if (ks > 0) {
            lambert *= 2;
            float spec = v.dot(lambert*n.x - l.x, lambert*n.y - l.y, lambert*n.z - l.z);
            if (spec > 0) {
              spec = ks*((float) Math.pow((double) spec, (double) ns));
              r += spec*light.ir;
              g += spec*light.ig;
              b += spec*light.ib;
            }
          }
        }
      }
    }

    // Compute illumination due to reflection
    if (kr > 0) {
      float t = v.dot(n);
      if (t > 0) {
        t *= 2;
        Vector3D reflect = new Vector3D(t*n.x - v.x, t*n.y - v.y, t*n.z - v.z);
        Vector3D poffset = new Vector3D(p.x + TINY*reflect.x, p.y + TINY*reflect.y, p.z + TINY*reflect.z);
        Ray reflectedRay = new Ray(poffset, reflect);
        if (reflectedRay.trace(objects)) {
          Color rcolor = reflectedRay.Shade(lights, objects, bgnd);
          r += kr*rcolor.getRed();
          g += kr*rcolor.getGreen();
          b += kr*rcolor.getBlue();
        } else {
          r += kr*bgnd.getRed();
          g += kr*bgnd.getGreen();
          b += kr*bgnd.getBlue();
        }
      }
    }

    // Add code for refraction here

    r = (r > 1f) ? 1f : r;
    g = (g > 1f) ? 1f : g;
    b = (b > 1f) ? 1f : b;
    return new Color(r, g, b);
  }
}
