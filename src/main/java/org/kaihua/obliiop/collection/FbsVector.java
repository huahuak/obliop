package org.kaihua.obliiop.collection;

import java.nio.ByteBuffer;
import java.util.Arrays;

import org.kaihua.obliiop.collection.obliop_flatbuffer.vector.ObliVector;
import org.kaihua.obliiop.collection.obliop_flatbuffer.vector.Pair;
import org.kaihua.obliiop.collection.obliop_flatbuffer.vector.Type;

import com.google.flatbuffers.FlatBufferBuilder;


public class FbsVector implements Vector {
  FlatBufferBuilder builder = null;
  private String name = "FbsVector";
  private int[] data;
  private int cur;
  private int dataSize;

  public FbsVector() {
    init();
  }

  private void init() {
    builder = new FlatBufferBuilder(0);
    cur = 0;
    dataSize = 16;
    data = new int[dataSize];
  }

  @Override
  public void append(Object obj) {
    int value = Pair.createValueVector(builder, "hello world".getBytes());
    int pair = Pair.createPair(builder, 0, value);
    assert (cur < dataSize);
    data[this.cur++] = pair;
  }

  public void name(String name) {
    this.name = name;
  }

  public ByteBuffer getBuf() {
    // ------------------ name ------------------ //
    int name = builder.createString("TEST");
    // ------------------ data ------------------ //
    // int[] copyOfRange = Arrays.copyOfRange(data, 0, cur);
    // int pairs = ObliVector.createPairsVector(builder, copyOfRange);
    // cur = 0;
    // ------------------------------------ //
    ObliVector.startObliVector(builder);
    ObliVector.addName(builder, name);
    // ObliVector.addTyp(builder, Type.PairTyp);
    // ObliVector.addPairs(builder, pairs);
    int endObliVector = ObliVector.endObliVector(builder);
    builder.finish(endObliVector);
    ByteBuffer dataBuffer = builder.dataBuffer();
    return dataBuffer;
  }

  @Override
  public void print() {
  }
}
