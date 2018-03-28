package tcas.drivers;

import java.util.Random;

import tcas.Tcas;

public class RandomDriver {

  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("A single integer argument is expected denoting time in seconds");
      return;
    }

    int timeLimit = Integer.parseInt(args[0]);
    System.out.println("Time limit: " + timeLimit + " [s]");

    final long startTime = System.currentTimeMillis();

    Random rand = new Random(42); // the parameter is a random seed
    long count = 0;

    int[] x = new int[12];

    while((System.currentTimeMillis() - startTime) / 1000 < timeLimit) {
      for(int i = 0; i < x.length; ++i) {
        x[i] = rand.nextInt();
        System.err.print(x[i]);
        if (i != x.length - 1)
          System.err.print(",");
      }
      System.err.println();

      start_symbolic(x[0], x[1], x[2], x[3], x[4], x[5], x[6], x[7], x[8], x[9], x[10], x[11]);
      count++;
    }
    System.out.println("In total, there were " + count + " invocations of the target");
  }

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
