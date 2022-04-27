package com.dingdongding.note.po;

import java.util.Scanner;

public class InputCheck {
  public static int inputInt() {

    int i = 0;
    while (true) {
      Scanner si = new Scanner(System.in);
      if (si.hasNextInt()) {
        i = si.nextInt();
        break;
      } else {
        System.out.println("input integer ONLY! Input again please");
      }
    }
    return i;
  }

  public static String inputString() {
    String s = null;
    while (true) {
      Scanner si = new Scanner(System.in);
      if (si.hasNextLine()) {
        s = si.nextLine();
        break;
      } else {
        System.out.println("input String ONLY! Input again please");
      }
    }
    return s;
  }
}
