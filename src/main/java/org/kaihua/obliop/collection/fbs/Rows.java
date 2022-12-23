// automatically generated by the FlatBuffers compiler, do not modify

package org.kaihua.obliop.collection.fbs;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class Rows extends Table {
  public static void ValidateVersion() {
    Constants.FLATBUFFERS_22_12_06();
  }

  public static Rows getRootAsRows(ByteBuffer _bb) {
    return getRootAsRows(_bb, new Rows());
  }

  public static Rows getRootAsRows(ByteBuffer _bb, Rows obj) {
    _bb.order(ByteOrder.LITTLE_ENDIAN);
    return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
  }

  public void __init(int _i, ByteBuffer _bb) {
    __reset(_i, _bb);
  }

  public Rows __assign(int _i, ByteBuffer _bb) {
    __init(_i, _bb);
    return this;
  }

  public org.kaihua.obliop.collection.fbs.Row rows(int j) {
    return rows(new org.kaihua.obliop.collection.fbs.Row(), j);
  }

  public org.kaihua.obliop.collection.fbs.Row rows(org.kaihua.obliop.collection.fbs.Row obj, int j) {
    int o = __offset(4);
    return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null;
  }

  public int rowsLength() {
    int o = __offset(4);
    return o != 0 ? __vector_len(o) : 0;
  }

  public org.kaihua.obliop.collection.fbs.Row.Vector rowsVector() {
    return rowsVector(new org.kaihua.obliop.collection.fbs.Row.Vector());
  }

  public org.kaihua.obliop.collection.fbs.Row.Vector rowsVector(org.kaihua.obliop.collection.fbs.Row.Vector obj) {
    int o = __offset(4);
    return o != 0 ? obj.__assign(__vector(o), 4, bb) : null;
  }

  public static int createRows(FlatBufferBuilder builder,
      int rowsOffset) {
    builder.startTable(1);
    Rows.addRows(builder, rowsOffset);
    return Rows.endRows(builder);
  }

  public static void startRows(FlatBufferBuilder builder) {
    builder.startTable(1);
  }

  public static void addRows(FlatBufferBuilder builder, int rowsOffset) {
    builder.addOffset(0, rowsOffset, 0);
  }

  public static int createRowsVector(FlatBufferBuilder builder, int[] data) {
    builder.startVector(4, data.length, 4);
    for (int i = data.length - 1; i >= 0; i--)
      builder.addOffset(data[i]);
    return builder.endVector();
  }

  public static void startRowsVector(FlatBufferBuilder builder, int numElems) {
    builder.startVector(4, numElems, 4);
  }

  public static int endRows(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) {
      __reset(_vector, _element_size, _bb);
      return this;
    }

    public Rows get(int j) {
      return get(new Rows(), j);
    }

    public Rows get(Rows obj, int j) {
      return obj.__assign(__indirect(__element(j), bb), bb);
    }
  }
}
