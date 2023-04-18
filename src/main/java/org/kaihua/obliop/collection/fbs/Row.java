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
public final class Row extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_22_12_06(); }
  public static Row getRootAsRow(ByteBuffer _bb) { return getRootAsRow(_bb, new Row()); }
  public static Row getRootAsRow(ByteBuffer _bb, Row obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Row __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public org.kaihua.obliop.collection.fbs.Field fields(int j) { return fields(new org.kaihua.obliop.collection.fbs.Field(), j); }
  public org.kaihua.obliop.collection.fbs.Field fields(org.kaihua.obliop.collection.fbs.Field obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int fieldsLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public org.kaihua.obliop.collection.fbs.Field.Vector fieldsVector() { return fieldsVector(new org.kaihua.obliop.collection.fbs.Field.Vector()); }
  public org.kaihua.obliop.collection.fbs.Field.Vector fieldsVector(org.kaihua.obliop.collection.fbs.Field.Vector obj) { int o = __offset(4); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }

  public static int createRow(FlatBufferBuilder builder,
      int fieldsOffset) {
    builder.startTable(1);
    Row.addFields(builder, fieldsOffset);
    return Row.endRow(builder);
  }

  public static void startRow(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addFields(FlatBufferBuilder builder, int fieldsOffset) { builder.addOffset(0, fieldsOffset, 0); }
  public static int createFieldsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startFieldsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endRow(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Row get(int j) { return get(new Row(), j); }
    public Row get(Row obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

