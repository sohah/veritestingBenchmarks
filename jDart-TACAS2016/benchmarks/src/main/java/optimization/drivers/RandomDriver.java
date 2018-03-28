package optimization.drivers;

import java.util.Random;

public class RandomDriver {

    private static Random rand;
    
    private static double getRandomDouble() {
	int sign[] = { -1, 1 };

	return rand.nextDouble() * sign[rand.nextInt(2)] * (Double.MAX_VALUE / 2);
    }
    
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

	double[] x = new double[4];
	
	while((System.currentTimeMillis() - startTime) / 1000 < timeLimit) {
	    for(int i = 0; i < x.length; ++i) {
		x[i] = getRandomDouble();
		System.err.print(x[i] + " ");
	    }
	    System.err.println();

	    //Optimization.runAll(x[0], x[1], x[2], x[3]);
	    count++;
	}
	System.out.println("In total, there were " + count + " invocations of the target");
    }
}
