package org.kaihua.obliop.operator.context;

import java.util.ArrayList;
import java.util.List;

public class Context {
  // public for serialization
  public List<Expression> expressions = new ArrayList<>();

  public void addExpr(Expression expr) {
    // if input data of expression is not prepared, find the dependency.
    if (!expr.input.prepared) {
      boolean found = false;
      for (Expression e : expressions) {
        if (e.output.id.equals(expr.input.id)) {
          e.children.add(expr);
          found = true;
          break;
        }
      }
      assert found == true : "can't found oblidata dependency when add expression";
    } else {
      expressions.add(expr);
    }

  }

  public static Context empty() {
    Context ctx = new Context();
    return ctx;
  }
}
