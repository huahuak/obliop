package org.kaihua.obliop;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import org.kaihua.obliop.collection.FbsVector;
import org.kaihua.obliop.data.ObliData;
import org.kaihua.obliop.interfaces.ObliJni;
import org.kaihua.obliop.interfaces.ObliOp;
import org.kaihua.obliop.operator.Sorter;

import sun.nio.ch.DirectBuffer;

/**
 * @author kahua.li
 * @email moflowerlkh@gmail.com
 * @date 2022/12/21
 **/
public class Main {
  public static void main(String[] args) {
    // System.out.println("Hello world!");
    // ObliJni.doHello("hello java here");
    // // ------------------------------------ //
    // HashMap<String, String> info = new HashMap<>();
    // info.put("key", "value");
    // RetObj obliSort = ObliOp.ObliSort(new Sorter("ObliOp Java Main"));
    // System.out.println(obliSort.obli_op_id);
    // ------------------------------------ //
    // ArrowVector vec = new ArrowVector();
    // vec.init();
    // ------------------------------------ //
    java.lang.reflect.Field address, capacity;
    try {
      address = Buffer.class.getDeclaredField("address");
      address.setAccessible(true);
      capacity = Buffer.class.getDeclaredField("capacity");
      capacity.setAccessible(true);
    } catch (NoSuchFieldException e) {
      throw new AssertionError(e);
    }
    Buffer buf = FbsVector.test();
    Object ptr = null, cap = null;
    try {
      ptr = address.get(buf);
      cap = capacity.get(buf);
    } catch (IllegalArgumentException | IllegalAccessException e) {
      e.printStackTrace();
    }
    ObliJni.ObliDataSend((ByteBuffer) buf);
    ObliOp.ObliDataSend(new ObliData(
        ((DirectBuffer) buf).address() + buf.position(),
        buf.capacity() - buf.position()));
  }
}