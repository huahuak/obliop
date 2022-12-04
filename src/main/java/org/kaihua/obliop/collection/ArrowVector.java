package org.kaihua.obliop.collection;

import org.apache.arrow.c.ArrowArray;
import org.apache.arrow.c.ArrowSchema;
import org.apache.arrow.c.Data;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.IntVector;
import org.kaihua.obliop.data.ObliData;
import org.kaihua.obliop.interfaces.ObliOp;

public class ArrowVector {
  public void init() {
    // BufferAllocator allocator = new RootAllocator();
    // IntVector intVector = new IntVector("fixed-size-primitive-layout",
    // allocator);
    // intVector.allocateNew(3);
    // intVector.set(0, 1);
    // intVector.setNull(1);
    // intVector.set(2, 2);
    // intVector.setValueCount(3);
    // System.out.println("Vector created in memory: " + intVector);
    BufferAllocator allocator = new RootAllocator();
    ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
    ArrowArray arrowArray = ArrowArray.allocateNew(allocator);
    long arrayAddr = arrowArray.memoryAddress();
    long schemaAddr = arrowSchema.memoryAddress();
    IntVector intVector = new IntVector("int-to-export", allocator);
    intVector.allocateNew(3);
    intVector.setSafe(0, 1);
    intVector.setSafe(1, 2);
    intVector.setSafe(2, 3);
    intVector.setValueCount(3);
    System.out.println("[Java] FieldVector: \n" + intVector);
    Data.exportVector(allocator, intVector, null, ArrowArray.wrap(arrayAddr), ArrowSchema.wrap(schemaAddr));

    // allocator.close();
    // arrowSchema.close();
    // arrowArray.close();
    ObliOp.ObliDataSend(new ObliData(0, arrayAddr, schemaAddr));
    // FieldVector vec = Data.importVector(allocator, arrowArray, arrowSchema, null);
    // System.out.println("rust-allocated array: " + vec);

    // CDataJavaToCppExample.FillInt64Array(arrowSchema.memoryAddress(),
    // try (
    // BigIntVector bigIntVector = (BigIntVector) Data.importVector(
    // allocator, arrowArray, arrowSchema, null)) {
    // System.out.println("C++-allocated array: " + bigIntVector);
    // }
  }

}
