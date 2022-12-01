package org.kaihua.obliiop;

import java.util.Base64;
import java.util.HashMap;

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
  }

  public static void printByte(byte[] byt) {
    System.out.println("// ------------------ print byte ------------------ //");
    byte[] encode = Base64.getEncoder().encode(byt);
    // System.out.println(new String(encode));
    for (byte c : byt) {
      System.out.print(String.format("%02x", c) + ' ');
    }
    System.out.println();
    for (byte c : byt) {
      System.out.print((char) c);
    }
    System.out.println();
    System.out.println("// ------------------ print byte ------------------ //");
  }
}