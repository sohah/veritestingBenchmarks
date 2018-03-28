package raytrace.drivers;

import java.util.Random;

import raytrace.Surface;

public class RandomDriver {

    private static Random rand;
    
    private static float getRandomFloat() {
	int sign[] = { -1, 1 };

	return rand.nextFloat() * sign[rand.nextInt(2)] * Float.MAX_VALUE;
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

	float[] x = new float[26];
	int lType = 0;
	
	while((System.currentTimeMillis() - startTime) / 1000 < timeLimit) {
	    for(int i = 0; i < x.length; ++i) {
		if (i == 19) {
		    lType = rand.nextInt();
		    System.err.print(lType + ",");
		    continue;
		}
		x[i] = getRandomFloat();
		System.err.print(x[i]);
		if (i != x.length - 1)
		    System.err.print(",");
	    }
	    System.err.println();
	    
	    Surface.surfaceShade(x[0], x[1], x[2], x[3], x[4], x[5], x[6], x[7],
				     x[8], x[9], x[10], x[11], x[12], x[13], x[14], x[15],
				     x[16], x[17], x[18], lType, x[20], x[21], x[22], x[23],
				     x[24], x[25]);
	    count++;
	}
	System.out.println("In total, there were " + count + " invocations of the target");
    }
}
