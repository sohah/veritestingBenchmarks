package merarbiter_v0.drivers;

import java.util.Random;

import merarbiter_v0.MerArbiter;

public class RandomDriver {

    private static Random rand;
    
    public static void main(String[] args) {
	if (args.length != 1) {
	    System.err.println("A single integer argument is expected denoting time in seconds");
	    return;
	}

	int timeLimit = Integer.parseInt(args[0]);
	System.out.println("Time limit: " + timeLimit + " [s]");

	final long startTime = System.currentTimeMillis();

	rand = new Random(42); // the parameter is a random seed
	int count = 0;

	int[] x = new int[8];
	boolean[] y = new boolean[8];
	
	while((System.currentTimeMillis() - startTime) / 1000 < timeLimit) {
	    for(int i = 0; i < x.length; ++i) {
		x[i] = rand.nextInt();
		System.err.print(x[i] + ",");
		y[i] = rand.nextBoolean();
		System.err.print(y[i]);
		if (i != x.length - 1)
		    System.err.print(",");
	    }
	    System.err.println();

	    MerArbiter sut = new MerArbiter();
	    sut.runMachines(x[0], y[0], x[1], y[1],
					x[2], y[2], x[3], y[3],
					x[4], y[4], x[5], y[5],
					x[6], y[6], x[7], y[7]);
	    count++;
	}
	System.out.println("In total, there were " + count + " invocations of the target");
    }
}
