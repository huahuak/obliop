package org.kaihua.obliiop;

import org.kaihua.obliiop.collection.ArrowVector;
import org.kaihua.obliiop.interfaces.ObliOp;
import org.kaihua.obliiop.interfaces.RetObj;
import org.kaihua.obliiop.sort.Sorter;

import java.util.HashMap;

/**
 * @author kahua.li (moflowerlkh@foxmail.com)
 * @date ${YEAR}/${MONTH}/${DAY}
 **/
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    // ------------------------------------ //
    HashMap<String, String> info = new HashMap<>();
    info.put("key", "value");
    RetObj obliSort = ObliOp.ObliSort(new Sorter("ObliOp Java Main"));
    System.out.println(obliSort.obli_op_id);
    // ------------------------------------ //
    ArrowVector.Init();
  }
}