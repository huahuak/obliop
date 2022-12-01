package org.kaihua.obliiop.interfaces;

import java.nio.charset.StandardCharsets;

import org.kaihua.obliiop.data.ObliData;

public class ObliJni {
  // ------------------ obli data ------------------ //
  static native void doObliDataSend(ObliData data, byte[] byt);

  public static void ObliDataSend(ObliData data) {
    doObliDataSend(data, data.buf.array());
  }
}
