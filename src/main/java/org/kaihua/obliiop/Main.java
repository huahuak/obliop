package org.kaihua.obliiop;

import org.kaihua.obliiop.interfaces.ObliOp;
import org.kaihua.obliiop.interfaces.RetObj;
import org.kaihua.obliiop.interfaces.cmdtyp.Create;
import org.kaihua.obliiop.interfaces.cmdtyp.Input;
import org.kaihua.obliiop.interfaces.optyp.Sort;

import java.util.HashMap;

/**
 * @author kahua.li (moflowerlkh@foxmail.com)
 * @date ${YEAR}/${MONTH}/${DAY}
 **/
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    HashMap<String, String> info = new HashMap<>();
    info.put("key", "value");
    RetObj retObj = ObliOp.ObliOpCommand(Input.produce());
    ObliOp.ObliOpCommand(Create.produce(Sort.produce(), info));
    System.out.println(retObj.typ.Create.op.getClass());
  }
}