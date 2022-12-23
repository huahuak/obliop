package org.kaihua.obliop.collection;

import java.nio.ByteBuffer;

import org.kaihua.obliop.collection.fbs.*;
import com.google.flatbuffers.FlatBufferBuilder;

public class FbsVector {
  public static ByteBuffer test() {
    FlatBufferBuilder builder = new FlatBufferBuilder(0);
    int intValueOffset = IntValue.createIntValue(builder, 1024);
    int fieldOffset = Field.createField(builder, FieldUnion.IntValue, intValueOffset, false);
    int fieldVecOffset = Row.createFieldsVector(builder, new int[] { fieldOffset });
    int rowOffset = Row.createRow(builder, fieldVecOffset);
    int rowVecOffset = Rows.createRowsVector(builder, new int[] { rowOffset });
    int rowsOffset = Rows.createRows(builder, rowVecOffset);
    System.out.println(rowOffset);
    ByteBuffer buffer = builder.dataBuffer();
    return buffer;
    // Rows rowsObj = Rows.getRootAsRows(buffer);
    // Row rowObj = rowsObj.rows(0);
    // Field fieldObj = rowObj.fields(0);
    // IntValue valueObj = (IntValue) fieldObj.value(new IntValue());
    // System.out.println("value is " + valueObj.value());
  }
}
