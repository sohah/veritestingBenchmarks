package tsafe.drivers;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import tsafe.TurnLogic;

public class RandomDriver {

  private static int sign[] = { -1, 1 };

  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("A single integer argument is expected denoting time in seconds");
      return;
    }

    int timeLimit = Integer.parseInt(args[0]);
    System.out.println("Time limit: " + timeLimit + " [s]");

    final long startTime = System.currentTimeMillis();

    Random rand = new Random(42); // the parameter is a random seed
    int count = 0;

    double[] x = new double[8];

    while((System.currentTimeMillis() - startTime) / 1000 < timeLimit) {
      for(int i = 0; i < x.length; ++i) {
        x[i] = rand.nextDouble() * sign[rand.nextInt(2)] * Double.MAX_VALUE;
        System.err.print(x[i]);
        if (i != x.length - 1)
          System.err.print(",");
      }
      System.err.println();

      TurnLogic.snippet(x[0], x[1], x[2], x[3], x[4], x[5], x[6], x[7]);
      count++;
    }
    System.out.println("In total, there were " + count + " invocations of the target");
  }
}
