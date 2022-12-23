package org.kaihua.obliop.interfaces;

import java.nio.ByteBuffer;
import java.util.Arrays;

import org.kaihua.obliop.util.Util;

public class ObliJni {

  static {
    // System.load("/home/huahua/Projects/obliop/obliclient/target/debug/libobliclient.so");
    System.load("/root/lkh/java/libobliclient.so");
  }

  private static native String hello(String input);

  private static native void doObliDataSend(byte[] buf, long ptr, int len);

  public static void ObliDataSend(ByteBuffer buf, Object ptr, Object len) {
    doObliDataSend(
        Arrays.copyOfRange(buf.array(), buf.position(), buf.capacity()),
        (Long) ptr, (Integer) len);
  }

  public static String doHello(String input) {
    return hello(input);
  }
}
