package calculate.rules;

import calculate.Utils;
import calculate.expressions.Expression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

public class AddRuleApplier extends AbstractRuleApplier {

  @Override
  public int getPriority() {
    return 1;
  }

  @Override
  public boolean applicable(Expression e) {
    return e.getOp().equals(Operator.ADD);
  }

  @Override
  public Expression apply(Expression e) {
    if (e instanceof IntExpression ie) {

      if (ie.getN1() > 10 && ie.getN2() > 10) {
        if (Utils.getRandom().nextBoolean()) {
          ie.setN1(ie.getN1() % 10);
        } else {
          ie.setN2(ie.getN2() % 10);
        }
      }
    }
    return e;
  }
}
