package org.kaihua.obliiop.interfaces.openum;

import org.kaihua.obliiop.interfaces.optyp.Sort;

/**
 * @author kahua.li (moflowerlkh@foxmail.com)
 * @date 2022/11/30
 **/

public class ObliOpTypEnum {
  public org.kaihua.obliiop.interfaces.optyp.Sort Sort;
  public org.kaihua.obliiop.interfaces.optyp.Aggregate Aggregate;
  public org.kaihua.obliiop.interfaces.optyp.Join Join;

  public static Sort Sort() {
    org.kaihua.obliiop.interfaces.optyp.Sort ret = new Sort();
    return ret;
  }
}
