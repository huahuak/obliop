package org.kaihua.obliop.operator.context;

import java.util.List;
import java.util.UUID;

import org.kaihua.obliop.data.ObliData;

public class Expression {
  // public for serialization
  // @todo uuid can't be random;
  public String id = UUID.randomUUID().toString();
  public ExprType type;
  public ObliData input;
  public ObliData output;
  public List<Expression> children;
}
