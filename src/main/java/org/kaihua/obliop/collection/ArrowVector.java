package org.kaihua.obliop.collection;

import org.apache.arrow.c.ArrowArray;
import org.apache.arrow.c.ArrowSchema;
import org.apache.arrow.c.Data;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BigIntVector;

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
    try (
        BufferAllocator allocator = new RootAllocator();
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
        ArrowArray arrowArray = ArrowArray.allocateNew(allocator)) {
      // CDataJavaToCppExample.FillInt64Array(arrowSchema.memoryAddress(), arrowArray.memoryAddress());
      try (
          BigIntVector bigIntVector = (BigIntVector) Data.importVector(
              allocator, arrowArray, arrowSchema, null)) {
        System.out.println("C++-allocated array: " + bigIntVector);
      }
    }
  }

}
