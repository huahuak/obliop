package org.kaihua.obliiop.data;

import java.nio.ByteBuffer;

public class ObliData {
  public String name = "DataManager";
  public int obli_op_id;
  public ByteBuffer buf;

  public ObliData(int opId, ByteBuffer byt) {
    this.obli_op_id = opId;
    this.buf = byt;
  }
}
