package org.kaihua.obliop.collection;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.kaihua.obliop.collection.fbs.*;
import com.google.flatbuffers.FlatBufferBuilder;

/**
 * @author kahua.li
 * @email moflowerlkh@gmail.com
 * @date 2023/01/12
 **/
public class FbsVector {
  private ByteBuffer directBuffer;
  private FlatBufferBuilder builder;
  private int offset;
  private List<Integer> fieldOffset;
  private List<Integer> rowOffset;

  FbsVector(int cap) {
    offset = 0;
    fieldOffset = new ArrayList<>(1);
    rowOffset = new ArrayList<>(1);
    directBuffer = ByteBuffer.allocateDirect(cap);
    builder = new FlatBufferBuilder(directBuffer);
  }

  public static ByteBuffer test() {
    ByteBuffer directBuf = ByteBuffer.allocateDirect(1024);
    FlatBufferBuilder builder = new FlatBufferBuilder(directBuf);
    int intValueOffset = IntValue.createIntValue(builder, 1024);
    int fieldOffset = Field.createField(builder, FieldUnion.IntValue, intValueOffset, false);
    int fieldVecOffset = Row.createFieldsVector(builder, new int[]{fieldOffset});
    int rowOffset = Row.createRow(builder, fieldVecOffset);
    int rowVecOffset = Vec.createRowsVector(builder, new int[]{rowOffset});
    int rowsOffset = Vec.createVec(builder, rowVecOffset);
    builder.finish(rowsOffset);
    ByteBuffer buffer = builder.dataBuffer();
    return buffer;
    // Rows rowsObj = Rows.getRootAsRows(buffer);
    // Row rowObj = rowsObj.rows(0);
    // Field fieldObj = rowObj.fields(0);
    // IntValue valueObj = (IntValue) fieldObj.value(new IntValue());
    // System.out.println("value is " + valueObj.value());
  }


  public static FbsVector createVec() {
    return new FbsVector(1024);
  }

  public static class Cell {
    Object value;
    Class clz;

    public boolean isNull() {
      return value == null;
    }
  }

  public static Cell createCell(Object value, Class clz) {
    Cell cell = new Cell();
    cell.value = value;
    cell.clz = clz;
    return cell;
  }


  public void append(List<Cell> record) {
    record.forEach(r -> {
      if (r.clz == String.class) {
        offset = builder.createString((String) r.value);
        offset = StringValue.createStringValue(builder, offset);
        Field.createField(builder, FieldUnion.StringValue, offset, r.isNull());
        fieldOffset.add(offset);
      }
      if (r.clz == Integer.class) {
        offset = IntValue.createIntValue(builder, (Integer) r.value);
        offset = Field.createField(builder, FieldUnion.IntValue, offset, r.isNull());
        fieldOffset.add(offset);
      }
    });
    int[] arr = new int[fieldOffset.size()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = fieldOffset.get(i);
    }
    offset = Row.createFieldsVector(builder, arr);
    offset = Row.createRow(builder, offset);
    rowOffset.add(offset);
  }

  public ByteBuffer finish() {
    int[] arr = new int[rowOffset.size()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = rowOffset.get(i);
    }
    offset = Vec.createRowsVector(builder, arr);
    offset = Vec.createVec(builder, offset);
    builder.finish(offset);
    return builder.dataBuffer();
  }
}
