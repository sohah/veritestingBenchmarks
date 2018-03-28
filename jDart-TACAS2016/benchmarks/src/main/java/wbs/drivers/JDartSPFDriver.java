package wbs.drivers;

import wbs.etg.WBS;
import catg.CATG;

public class JDartSPFDriver {

	public static void main(String[] args) {
		WBS wBS_orig = new WBS();

		//int PedalPos = Debug.getSymbolicInteger(0, 4, "PedalPos_1");
		//boolean AutoBrake = Debug.getSymbolicBoolean("AutoBrake_1");
		//boolean Skid = Debug.getSymbolicBoolean("Skid_1");

		//new code
    int PedalPos = 0;
    boolean AutoBrake = true;
    boolean Skid = true;

		wBS_orig.update(PedalPos, AutoBrake, Skid);
		System.out.println("done");
	}
}
