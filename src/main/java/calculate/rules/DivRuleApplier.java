package calculate.rules;

import calculate.Utils;
import calculate.expressions.Expression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

public class DivRuleApplier extends AbstractRuleApplier {

  @Override
  public int getPriority() {
    return 5;
  }

  @Override
  public boolean applicable(Expression e) {
    return e.getOp().equals(Operator.DIV);
  }

  @Override
  public Expression apply(Expression basicExpression) {
    if (basicExpression instanceof IntExpression ie) {
      int d2 = ie.getN2() % 10;
      if (d2 < 3) {
        d2 = Utils.getRandom().nextInt(3, 10);
      }
      ie.setN2(d2);
      int factor = Utils.getRandom().nextInt(10, 100);
      ie.setN1(ie.getN2() * factor);
    }
    return basicExpression;
  }
}
