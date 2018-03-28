/**
 * @author @{user}
 */
package merarbiter_v0.drivers;

import merarbiter_v0.MerArbiter;

/**
 * @author luckow
 *
 */
public class JDartSPFDriver {
  public static void main(String[] args) {
    System.out.println("********************");
    MerArbiter mer = new MerArbiter();
    mer.runMachines(0, false, 1, false,
        0, false, 1, false,
        0, false, 1, false,
        0, false, 1, false);
  }
}
