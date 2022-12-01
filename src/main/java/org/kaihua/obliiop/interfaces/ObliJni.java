package org.kaihua.obliiop.interfaces;

import org.kaihua.obliiop.data.ObliData;

public class ObliJni {
  // ------------------ obli data ------------------ //
  static native byte[] doObliDataSend(ObliData data, byte[] byt);

  public static byte[] ObliDataSend(ObliData data) {
    return doObliDataSend(data, data.buf.array());
  }
}
