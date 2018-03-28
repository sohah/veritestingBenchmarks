package wbs.drivers;

import wbs.etg.WBS;
import catg.CATG;

public class JanalaDriver {

	public static void main(String[] args) {
		WBS wBS_orig = new WBS();

		//int PedalPos = Debug.getSymbolicInteger(0, 4, "PedalPos_1");
		//boolean AutoBrake = Debug.getSymbolicBoolean("AutoBrake_1");
		//boolean Skid = Debug.getSymbolicBoolean("Skid_1");

		//new code

    int PedalPos = CATG.readInt(0);
    boolean AutoBrake = CATG.readBool(true);
    boolean Skid = CATG.readBool(true);

		wBS_orig.update(PedalPos, AutoBrake, Skid);
		System.out.println("done");
	}
}
