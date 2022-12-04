package org.kaihua.obliop;

import org.kaihua.obliop.interfaces.ObliOp;
import org.kaihua.obliop.interfaces.RetObj;
import org.kaihua.obliop.sort.Sorter;

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
    // FbsVector fbsVector = new FbsVector();
    // fbsVector.append(null);
    // byte[] buf = new byte[32];
    // fbsVector.getBuf().array();
    // ObliOp.ObliDataSend(new ObliData(1, buf));
  }
}