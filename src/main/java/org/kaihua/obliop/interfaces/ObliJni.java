package org.kaihua.obliop.interfaces;

public class ObliJni {
  
  static {
    // System.load("/home/huahua/Projects/obliop/obliclient/target/debug/libobliclient.so");
    System.load("/root/lkh/java/libobliclient.so");
  }
  
  private static native String hello(String input);

  public static String doHello(String input) {
    return hello(input);
  }
}
