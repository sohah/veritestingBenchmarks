/**
 * @author @{user}
 */
package raytrace_double;

/**
 * @author luckow
 *
 */
class Color {
  // Simple replacement for {@link java.awt.Color} to remove the AWT
  // dependency.
  public double r, g, b;

  public Color(double r, double g, double b) {
this.r = r;
this.g = g;
this.b = b;
  }

  public double getRed() {
return r;
  }

  public double getGreen() {
return g;
  }

  public double getBlue() {
return b;
  }
}
