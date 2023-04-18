package org.kaihua.obliop.operator.context;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Context {
  // public for serialization
  public List<Expression> expressions = new ArrayList<>();

  public void addExpr(Expression expr) {
    // if input data of expression is not prepared, find the dependency.
    if (!expr.input.prepared) {
      boolean found = false;
      for (Expression root : expressions) {
        Expression head = root.children.get(0);
        // find input data from first layer
        if (head.output.id.equals(expr.input.id)) {
          expr.children.add(head);
          root.children.set(0, expr);
          found = true;
          break;
        }

        // find input data from deep layer
        Optional<Expression> foundChild = find(head, expr, (a, b) -> {
          if (a.output.id.equals(b.input.id)) {
            return 0;
          }
          return -1;
        });
        if (foundChild.isPresent()) {
          // create new tree
          Expression dummy = Expression.dummy();
          expr.children.add(foundChild.get());
          dummy.children.add(expr);
          break;
        }
      }
      assert found == true : "can't found oblidata dependency when add expression";
    } else {
      // expressions hold root that is dummy node.
      Expression root = Expression.dummy();
      root.children.add(expr);
      expressions.add(root);
    }

  }

  private static Optional<Expression> find(
      Expression root,
      Expression target,
      Comparator<Expression> cmp) {
    if (cmp.compare(root, target) == 0) {
      return Optional.of(root);
    }
    Expression cur = root;
    for (Expression child : cur.children) {
      Optional<Expression> ans = find(child, target, cmp);
      if (ans.isPresent()) {
        return ans;
      }
    }
    return Optional.empty();
  }

  public static Context empty() {
    Context ctx = new Context();
    return ctx;
  }

  public Context removeDummyRoot() {
    for (int i = 0; i < expressions.size(); i++) {
      expressions.set(i, expressions.get(i).children.get(0));
    }
    return this;
  }
}
