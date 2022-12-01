package org.kaihua.obliiop;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.HashMap;

import org.kaihua.obliiop.collection.obliop_flatbuffer.vector.ObliVector;
import org.kaihua.obliiop.collection.obliop_flatbuffer.vector.Pair;
import org.kaihua.obliiop.collection.obliop_flatbuffer.vector.Type;
import org.kaihua.obliiop.data.ObliData;
import org.kaihua.obliiop.interfaces.ObliJni;
import org.kaihua.obliiop.interfaces.ObliOp;
import org.kaihua.obliiop.interfaces.RetObj;
import org.kaihua.obliiop.sort.Sorter;

import com.google.flatbuffers.FlatBufferBuilder;

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
    FlatBufferBuilder builder = new FlatBufferBuilder(0);
    int name = builder.createString("java vector");
    int v = Pair.createValueVector(builder, "hello world".getBytes());
    int p = Pair.createPair(builder, 1, v);
    int ps = ObliVector.createPairsVector(builder, new int[] { p });
    ObliVector.startObliVector(builder);
    ObliVector.addName(builder, name);
    ObliVector.addTyp(builder, Type.PairTyp);
    ObliVector.addPairs(builder, ps);
    int javaVec = ObliVector.endObliVector(builder);
    builder.finish(javaVec);
    ByteBuffer dataBuffer = builder.dataBuffer();
    printByte(dataBuffer.array());
    ObliData obliData = new ObliData(1, dataBuffer);
    // ------------------------------------ //
    byte[] ret = ObliJni.ObliDataSend(obliData);
    printByte(ret);
    ObliVector n = ObliVector.getRootAsObliVector(dataBuffer);
    // n.pairs(0).mutateKey(100);
    ObliJni.ObliDataSend(new ObliData(0, n.getByteBuffer()));
    System.out.println(n.name());
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