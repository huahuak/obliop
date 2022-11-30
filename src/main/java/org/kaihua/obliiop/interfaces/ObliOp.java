package org.kaihua.obliiop.interfaces;

import org.astonbitecode.j4rs.api.Instance;
import org.astonbitecode.j4rs.api.java2rust.Java2RustUtils;
import org.kaihua.obliiop.interfaces.cmdenum.CmdEnumBase;

/**
 * @author kahua.li (moflowerlkh@foxmail.com)
 * @date 2022/11/30
 **/
public class ObliOp {
  static {
    System.load("/Users/huahua/IdeaProjects/obliclient/target/debug/libobliclient.dylib");
  }

  private static native Instance doObliOpCommand(Instance oblivCmdTyp);

  public static RetObj ObliOpCommand(CmdEnumBase obj) {
    System.out.printf("%s", Java2RustUtils.createInstance(obj).getJson());
    return Java2RustUtils.getObjectCasted(
        doObliOpCommand(Java2RustUtils.createInstance(
            obj
        )));

  }
}
