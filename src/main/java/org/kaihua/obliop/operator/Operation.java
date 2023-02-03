package org.kaihua.obliop.operator;

import org.kaihua.obliop.data.ObliData;
import org.kaihua.obliop.operator.context.Context;
import org.kaihua.obliop.operator.context.ExprType;
import org.kaihua.obliop.operator.context.Expression;

public class Operation {
  public static ObliData mod(Context ctx, ObliData in) {
    ObliData out = ObliData.empty();
    Expression expr = new Expression();
    expr.type = ExprType.MOD;
    expr.input = in;
    expr.output = out;
    ctx.addExpr(expr);
    return out;
  }
}
