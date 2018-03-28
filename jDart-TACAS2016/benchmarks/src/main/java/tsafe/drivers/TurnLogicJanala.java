package tsafe.drivers;

import tsafe.TurnLogic;
import catg.CATG;


public class TurnLogicJanala {

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

	  
	  int x0 = CATG.readInt(0);
	  int y0 = CATG.readInt(0);
	  int gspeed = CATG.readInt(0);
	  int x1 = CATG.readInt(0);
	  int y1 = CATG.readInt(0);
	  int x2 = CATG.readInt(0);
	  int y2 = CATG.readInt(0);
	  int dt = CATG.readInt(0);
		double result = TurnLogic.snippet(x0,y0,gspeed,x1,y1,x2,y2,dt);
		//		SymbolicRealVars.notePathFunction("result");
	}
}
