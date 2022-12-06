package org.kaihua.obliop.interfaces;

public class ObliJni {
  
  private static native String hello(String input);

  public static String doHello(String input) {
    return hello(input);
  }
}
