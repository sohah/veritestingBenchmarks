package minepump.product20;

import java.util.Random;

public  class  Main {

  private static int cleanupTimeShifts = 2;


/*
  public static boolean getBoolean() {
    Random random = new Random();
    return random.nextBoolean();		
  }
*/
  /*
  public static void performActions4(boolean action1_1, boolean action1_2, boolean action1_3, boolean action1_4,
      boolean action2_1, boolean action2_2, boolean action2_3, boolean action2_4,
      boolean action3_1, boolean action3_2, boolean action3_3, boolean action3_4,
      boolean action4_1, boolean action4_2, boolean action4_3, boolean action4_4) {

    performActions(action1_1, action1_2, action1_3, action1_4);
    performActions(action2_1, action2_2, action2_3, action2_4);
    performActions(action3_1, action3_2, action3_3, action3_4);
    performActions(action4_1, action4_2, action4_3, action4_4);
    for (int counter = 0; counter < cleanupTimeShifts; counter++) {
      a.timeShift();
    }
  }
  
*/
  public static void performActions3(boolean action1_1, boolean action1_2, boolean action1_3, boolean action1_4,
      boolean action2_1, boolean action2_2, boolean action2_3, boolean action2_4,
      boolean action3_1, boolean action3_2, boolean action3_3, boolean action3_4) {

    performActions(action1_1, action1_2, action1_3, action1_4);
    performActions(action2_1, action2_2, action2_3, action2_4);
    performActions(action3_1, action3_2, action3_3, action3_4);
    for (int counter = 0; counter < cleanupTimeShifts; counter++) {
      a.timeShift();
    }
  }
/*
  public static void performActions2(boolean action1_1, boolean action1_2, boolean action1_3, boolean action1_4,
      boolean action2_1, boolean action2_2, boolean action2_3, boolean action2_4) {

    performActions(action1_1, action1_2, action1_3, action1_4);
    performActions(action2_1, action2_2, action2_3, action2_4);
    for (int counter = 0; counter < cleanupTimeShifts; counter++) {
      a.timeShift();
    }
  }
*/
  public static void performActions(boolean action1, boolean action2, boolean action3, boolean action4) {
    if (action1) {
      a.waterRise();
    }

    if (action2) {
      a.methaneChange();
    }

    if (action3) {
      a.startSystem();
    } else if (action4) {
      a.stopSystem();
    }

    a.timeShift();
  }

  static Actions a = new Actions();
/*  public static void randomSequenceOfActions(int maxLength) {


    int counter = 0;
    while (counter < maxLength) {
      counter++;

      boolean action1 = getBoolean();
      boolean action2 = getBoolean();
      boolean action3 = getBoolean();			
      boolean action4 = getBoolean();

      performActions(action1, action2, action3, action4);
    }

    for (counter = 0; counter < cleanupTimeShifts; counter++) {
      a.timeShift();
    }
  }*/
}
