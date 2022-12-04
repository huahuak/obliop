package org.kaihua.obliop.data;

public class ObliData {
  public String name = "DataManager";
  public int obli_op_id;
  public long array_addr;
  public long shcema_addr;

  public ObliData(int opId, long array_addr, long shcema_addr) {
    this.obli_op_id = opId;
    this.array_addr = array_addr;
    this.shcema_addr = shcema_addr;
  }
}