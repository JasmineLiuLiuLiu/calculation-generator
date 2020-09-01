package calculate.rules;

import calculate.expressions.Expression;
import calculate.expressions.FloatExpression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

/**
 * Handle Subtraction: Make sure the result is not negative.
 * <p>
 * Set data1 to max(data1, data2), and set data2 to min(data1, data2).
 */
public class SubRuleApplier extends AbstractRuleApplier {

  @Override
  public int getPriority() {
    return 3;
  }

  @Override
  public boolean applicable(Expression e) {
    return e.getOp().equals(Operator.SUB);
  }

  @Override
  public Expression apply(Expression e) {
    if (e instanceof IntExpression ne) {
      int n1 = ne.getN1();
      int n2 = ne.getN2();
      ne.setN1(Integer.max(n1, n2));
      ne.setN2(Integer.min(n1, n2));
    } else if (e instanceof FloatExpression fe) {
      float n1 = fe.getN1();
      float n2 = fe.getN2();
      fe.setN1(Float.max(n1, n2));
      fe.setN2(Float.min(n1, n2));
    }
    return e;
  }

}
