/**
 * @author @{user}
 */
package tsafe.drivers;

import tsafe.TurnLogic;

/**
 * @author luckow
 *
 */
public class JDartSPF {
  public static void main(String[] args) {
    // double x0 = SymbolicRealVars.getSymbolicReal(-1000.0, 1000.0, "x0");
    // double y0 = SymbolicRealVars.getSymbolicReal(-1000.0, 1000.0, "y0");
    // double x1 = SymbolicRealVars.getSymbolicReal(-1000.0, 1000.0, "x1");
    // double y1 = SymbolicRealVars.getSymbolicReal(-1000.0, 1000.0, "y1");
    // double x2 = SymbolicRealVars.getSymbolicReal(-1000.0, 1000.0, "x2");
    // double y2 = SymbolicRealVars.getSymbolicReal(-1000.0, 1000.0, "y2");
    // double gspeed = SymbolicRealVars.getSymbolicReal(-1000.0, 1000.0, "gspeed");
    // double dt = SymbolicRealVars.getSymbolicReal(-1000.0, 1000.0, "dt");
    // double x0 = 0;
    // double y0 = 1;
    // double x1 = 2;
    // double y1 = 3;
    // double x2 = 4;
    // double y2 = 5;
    // double gspeed = 6;
    // double dt = 7;

    double result = TurnLogic.snippet(0,0,0,0,0,0,0,0);
    //    SymbolicRealVars.notePathFunction("result");
  }
}
