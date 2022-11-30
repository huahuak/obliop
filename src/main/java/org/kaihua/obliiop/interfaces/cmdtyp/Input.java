package org.kaihua.obliiop.interfaces.cmdtyp;

import org.kaihua.obliiop.interfaces.cmdenum.InputEnum;

/**
 * @author kahua.li (moflowerlkh@foxmail.com)
 * @date 2022/11/30
 **/
public class Input {
  public String name = "Input";

  public static InputEnum produce() {
    InputEnum ret = new InputEnum();
    ret.Input = new Input();
    return ret;
  }

}

