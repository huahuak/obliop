package org.kaihua.obliop.interfaces;

import org.astonbitecode.j4rs.api.Instance;
import org.astonbitecode.j4rs.api.java2rust.Java2RustUtils;
import org.kaihua.obliop.data.ObliData;
import org.kaihua.obliop.data.RetObj;
import org.kaihua.obliop.sort.Sorter;

/**
 * @author kahua.li (moflowerlkh@foxmail.com)
 * @date 2022/11/30
 **/
public class ObliOp {
  static {
    // System.load("/home/huahua/Projects/obliop/obliclient/target/debug/libobliclient.so");
    System.load("/root/lkh/java/libobliclient.so");
  }

  // ------------------ obli sort ------------------ //
  private static native Instance doObliSort(Instance<Sorter> sorter);

  public static RetObj ObliSort(Sorter sorter) {
    return Java2RustUtils.getObjectCasted(
        doObliSort(Java2RustUtils.createInstance(
            sorter)));
  }

  // ------------------ obli op close ------------------ //
  private static native Instance doObliOpClose(Instance<Integer> opId);

  public static RetObj ObliOpClsoe(int opId) {
    return Java2RustUtils.getObjectCasted(
        doObliOpClose(Java2RustUtils.createInstance(
            opId)));
  }

  // ------------------ obli data send------------------ //
  private static native Instance doObliDataSend(Instance<ObliData> data);

  public static RetObj ObliDataSend(ObliData data) {
    return Java2RustUtils.getObjectCasted(
        doObliDataSend(Java2RustUtils.createInstance(
            data)));
  }
}
