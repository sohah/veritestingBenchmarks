/**
 * @author @{user}
 */
package jembench.lift;

/**
 * @author luckow
 *
 */
public class Driver {

  public static void main(String[] args) {
    boolean[] in = new boolean[10];
    boolean[] out = new boolean[4];
    int[] analog = new int[3];
    boolean[] led = new boolean[14];
    for (int i=0; i<10; ++i) in[i]  = false;  
    for (int i=0; i<4; ++i) out[i]  = false;  
    for (int i=0; i<3; ++i) analog[i] = 0;  
    for (int i=0; i<14; ++i) led[i] = false;
   
    run(in, out, analog, led);
  }
  
  public static void run(boolean[] in, boolean[] out, int[] analog, boolean[] led) {
    LiftControl ctrl = new LiftControl();
    TalIo io = new TalIo(in, out, analog, led);
    
    ctrl.setVals();
    ctrl.getVals();
    ctrl.loop(io);
    
  }
}
