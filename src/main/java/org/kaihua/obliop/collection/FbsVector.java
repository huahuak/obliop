package org.kaihua.obliop.collection;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.kaihua.obliop.collection.fbs.Field;
import org.kaihua.obliop.collection.fbs.FieldUnion;
import org.kaihua.obliop.collection.fbs.IntValue;
import org.kaihua.obliop.collection.fbs.Row;
import org.kaihua.obliop.collection.fbs.RowTable;
import org.kaihua.obliop.collection.fbs.StringValue;
import org.kaihua.obliop.data.ObliData;

import com.google.flatbuffers.FlatBufferBuilder;

import sun.nio.ch.DirectBuffer;

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
    fieldOffset = new ArrayList<>(0);
    rowOffset = new ArrayList<>(0);
    directBuffer = ByteBuffer.allocateDirect(cap);
    builder = new FlatBufferBuilder(directBuffer);
  }

  public static ByteBuffer test() {
    ByteBuffer directBuf = ByteBuffer.allocateDirect(1024);
    FlatBufferBuilder builder = new FlatBufferBuilder(directBuf);
    int strOffset = builder.createString("hello world! here is java test");
    int strValueOffset = StringValue.createStringValue(builder, strOffset);
    int fieldOffset = Field.createField(builder, FieldUnion.StringValue, strValueOffset, false);
    int fieldVecOffset = Row.createFieldsVector(builder, new int[] { fieldOffset });
    int rowOffset = Row.createRow(builder, fieldVecOffset);
    int rowVecOffset = RowTable.createRowsVector(builder, new int[] { rowOffset });
    int rowsOffset = RowTable.createRowTable(builder, rowVecOffset);
    builder.finish(rowsOffset);
    ByteBuffer buffer = builder.dataBuffer();
    RowTable rowsObj = RowTable.getRootAsRowTable(buffer);
    Row rowObj = rowsObj.rows(0);
    Field fieldObj = rowObj.fields(0);
    StringValue valueObj = (StringValue) fieldObj.value(new StringValue());
    System.out.println("[FbsVector.java] value is " + valueObj.value());
    return buffer;
  }

  public static FbsVector createVec() {
    return new FbsVector(1024);
  }

  public static class Cell {
    Object value;
    String clz;

    public boolean isNull() {
      return value == null;
    }
  }

  public static Cell createCell(Object value, String clz) {
    Cell cell = new Cell();
    cell.value = value;
    cell.clz = clz;
    return cell;
  }

  public void append(List<Cell> record) {
    record.forEach(r -> {
      if (r.clz.equals("StringType")) {
        offset = builder.createString((String) r.value);
        offset = StringValue.createStringValue(builder, offset);
        offset = Field.createField(builder, FieldUnion.StringValue, offset, r.isNull());
        fieldOffset.add(offset);
      }
      if (r.clz.equals("IntegerType")) {
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
    offset = RowTable.createRowsVector(builder, arr);
    offset = RowTable.createRowTable(builder, offset);
    builder.finish(offset);
    return builder.dataBuffer();
  }

  public static ObliData toObliData(ByteBuffer buf) {
    return new ObliData(
        ((DirectBuffer) buf).address() + buf.position(),
        buf.capacity() - buf.position());
  }
}
