package org.kaihua.obliop.data;

public class ObliData {
  public String name = "DataManager";
  public int obli_op_id;
  public byte[] buf;

  public ObliData(int opId, byte[] byt) {
    this.obli_op_id = opId;
    this.buf = byt;
  }
}