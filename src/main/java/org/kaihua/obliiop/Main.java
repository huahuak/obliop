package org.kaihua.obliiop;

import java.util.HashMap;

import org.kaihua.obliiop.collection.FbsVector;
import org.kaihua.obliiop.collection.obliop_flatbuffer.vector.ObliVector;
import org.kaihua.obliiop.data.ObliData;
import org.kaihua.obliiop.interfaces.ObliJni;
import org.kaihua.obliiop.interfaces.ObliOp;
import org.kaihua.obliiop.interfaces.RetObj;
import org.kaihua.obliiop.sort.Sorter;

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
    FbsVector fbsVector = new FbsVector();
    // fbsVector.append(null);
    ObliData obliData = new ObliData(1, fbsVector.getBuf());
    ObliJni.ObliDataSend(obliData);
    // ------------------------------------ //
    ObliVector n = ObliVector.getRootAsObliVector(obliData.buf);
    System.out.println(n.name());
  }
}