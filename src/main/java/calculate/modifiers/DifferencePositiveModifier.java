package calculate.modifiers;

import calculate.expressions.Expression;
import calculate.expressions.FloatExpression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

/**
 * Handle Subtraction: Make sure the result is not negative.
 * <p>
 * Set data1 to max(data1, data2), and set data2 to min(data1, data2).
 */
public class DifferencePositiveModifier implements PriorityExpressionModifier<Expression> {

  @Override
  public int getPriority() {
    return 3;
  }

  @Override
  public boolean modifiable(Expression e) {
    return e.getOp().equals(Operator.SUB);
  }

  @Override
  public Expression modify(Expression e) {
    if (e instanceof IntExpression ne) {
      int n1 = ne.getRight();
      int n2 = ne.getLeft();
      ne.setRight(Integer.max(n1, n2));
      ne.setLeft(Integer.min(n1, n2));
    } else if (e instanceof FloatExpression fe) {
      float n1 = fe.getRight();
      float n2 = fe.getLeft();
      fe.setRight(Float.max(n1, n2));
      fe.setLeft(Float.min(n1, n2));
    }
    return e;
  }

}
