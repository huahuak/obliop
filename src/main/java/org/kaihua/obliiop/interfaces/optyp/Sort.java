package org.kaihua.obliiop.interfaces.optyp;

import org.kaihua.obliiop.interfaces.openum.SortEnum;

/**
 * @author kahua.li (moflowerlkh@foxmail.com)
 * @date 2022/11/30
 **/
public class Sort {
  public String name = "Sort";

  public static SortEnum produce() {
    SortEnum ret = new SortEnum();
    ret.Sort = new Sort();
    return ret;
  }
}
