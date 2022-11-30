package org.kaihua.obliiop.interfaces.cmdtyp;

import org.kaihua.obliiop.interfaces.cmdenum.CreateEnum;

import java.util.HashMap;

/**
 * @author kahua.li (moflowerlkh@foxmail.com)
 * @date 2022/11/30
 **/
public class Create extends CmdBase {
  public String name = "Create";
  // TODO let rust enum mapping to java object precisely
  /**
   * now object is sortEnum/joinEnum/... when send to rust,
   * and object is linkedHashMap when return from rust
   */
  public Object op;
  public HashMap info;

  public static CreateEnum produce(Object op, HashMap info) {
    CreateEnum ret = new CreateEnum();
    Create create = new Create();
    create.op = op;
    create.info = info;
    ret.Create = create;
    return ret;
  }
}