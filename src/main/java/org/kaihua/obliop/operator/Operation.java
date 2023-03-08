package org.kaihua.obliop.operator;

import org.kaihua.obliop.data.ObliData;
import org.kaihua.obliop.operator.context.Context;
import org.kaihua.obliop.operator.context.ExprType;
import org.kaihua.obliop.operator.context.Expression;

public class Operation {
  public static ObliData hash(Context ctx, ObliData in) {
    return process(ctx, in, ExprType.HASH);
  }

  public static ObliData mod(Context ctx, ObliData in) {
    return process(ctx, in, ExprType.MOD);
  }

  public static ObliData sort(Context ctx, ObliData in) {
    return process(ctx, in, ExprType.SORT);
  }

  private static ObliData process(Context ctx, ObliData in, ExprType typ) {
    assert in != null : "input data is null";
    ObliData out = ObliData.empty();
    Expression expr = new Expression();
    expr.typ = typ;
    expr.input = in;
    expr.output = out;
    ctx.addExpr(expr);
    return out;
  }
}
