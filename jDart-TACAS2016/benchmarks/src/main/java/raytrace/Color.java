/**
 * @author @{user}
 */
package raytrace;

/**
 * @author luckow
 *
 */
class Color {
  // Simple replacement for {@link java.awt.Color} to remove the AWT
  // dependency.
  public float r, g, b;

  public Color(float r, float g, float b) {
this.r = r;
this.g = g;
this.b = b;
  }

  public float getRed() {
return r;
  }

  public float getGreen() {
return g;
  }

  public float getBlue() {
return b;
  }
}
