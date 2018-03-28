/**
 * @author @{user}
 */
package merarbiter_v0.drivers;

import merarbiter_v0.MerArbiter;
import catg.CATG;

/**
 * @author luckow
 *
 */
public class JanalaDriver {

  public static void main(String[] args) {
    System.out.println("********************");
    MerArbiter mer = new MerArbiter();

    mer.runMachines(CATG.readInt(0), CATG.readBool(false), CATG.readInt(1), CATG.readBool(false),
        CATG.readInt(0), CATG.readBool(false), CATG.readInt(1), CATG.readBool(false),
        CATG.readInt(0), CATG.readBool(false), CATG.readInt(1), CATG.readBool(false),
        CATG.readInt(0), CATG.readBool(false), CATG.readInt(1), CATG.readBool(false));
  }

}
