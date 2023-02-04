package org.kaihua.obliop.operator;

import org.kaihua.obliop.data.ObliData;
import org.kaihua.obliop.operator.context.Context;
import org.kaihua.obliop.operator.context.ExprType;
import org.kaihua.obliop.operator.context.Expression;

public class Operation {
  public static ObliData hash(Context ctx, ObliData in) {
    assert in != null : "input data is null";
    ObliData out = ObliData.empty();
    Expression expr = new Expression();
    expr.typ = ExprType.HASH;
    expr.input = in;
    expr.output = out;
    ctx.addExpr(expr);
    return out;
  }

  public static ObliData mod(Context ctx, ObliData in) {
    assert in != null : "input data is null";
    ObliData out = ObliData.empty();
    Expression expr = new Expression();
    expr.typ = ExprType.MOD;
    expr.input = in;
    expr.output = out;
    ctx.addExpr(expr);
    return out;
  }
}
