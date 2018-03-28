/**
 * @author @{user}
 */
package tcas.drivers;

import catg.CATG;
import tcas.Tcas;

/**
 * @author luckow
 *
 */
public class JanalaDriver {

  public static void main ( String[] argv ) {
    /*if ( argv.length < 12 ) {
      System.out.println ("Error: Command line arguments are");
      System.out.println ("Cur_Vertical_Sep, High_Confidence, Two_of_Three_Reports_Valid");
      System.out.println ("Own_Tracked_Alt, Own_Tracked_Alt_Rate, Other_Tracked_Alt");
      System.out.println ("Alt_Layer_Value, Up_Separation, Down_Separation");
      System.out.println ("Other_RAC, Other_Capability, Climb_Inhibit");
      System.exit(1);
    }
    start(argv);
    System.exit(0);*/
    start_symbolic(CATG.readInt(0), CATG.readInt(0), CATG.readInt(0), CATG.readInt(0), CATG.readInt(0), CATG.readInt(0), CATG.readInt(0), CATG.readInt(0), CATG.readInt(0), CATG.readInt(0), CATG.readInt(0), CATG.readInt(0));
  }

  // Added by pdinges
  public static void start_symbolic (int cur_vertical_sep,
             int high_confidence,
             int two_of_three_reports_valid,
             int own_tracked_alt,
             int own_tracked_alt_rate,
             int other_tracked_alt,
             int alt_layer_value,
             int up_separation,
             int down_separation,
             int other_rac,
             int other_capability,
             int climb_inhibit) {
    Tcas.initialize();
    Tcas.Cur_Vertical_Sep = cur_vertical_sep;
    Tcas.High_Confidence = high_confidence;
    Tcas.Two_of_Three_Reports_Valid = two_of_three_reports_valid;
    Tcas.Own_Tracked_Alt = own_tracked_alt;
    Tcas.Own_Tracked_Alt_Rate = own_tracked_alt_rate;
    Tcas.Other_Tracked_Alt = other_tracked_alt;
    Tcas.Alt_Layer_Value = alt_layer_value;
    Tcas.Up_Separation = up_separation;
    Tcas.Down_Separation = down_separation;
    Tcas.Other_RAC = other_rac;
    Tcas.Other_Capability = other_capability;
    Tcas.Climb_Inhibit = climb_inhibit;
    Tcas.alt_sep_test();
  }
}
