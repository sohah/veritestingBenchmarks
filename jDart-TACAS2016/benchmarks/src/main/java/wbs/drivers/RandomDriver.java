package wbs.drivers;

import java.util.Random;

import wbs.etg.WBS;

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
    int count = 0;
    while((System.currentTimeMillis() - startTime) / 1000 < timeLimit) {
      int     a1 = rand.nextInt();
      boolean a2 = rand.nextBoolean();
      boolean a3 = rand.nextBoolean();

      System.err.println(a1 + "," + a2 + "," + a3);

      WBS sut = new WBS();
      sut.update(a1, a2, a3);
      count++;
    }
    System.out.println("In total, there were " + count + " invocations of the target");
  }
}
