package calculate.rules;

import calculate.Utils;
import calculate.expressions.Expression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

public class OralMulRuleApplier extends AbstractRuleApplier {

  @Override
  public int getPriority() {
    return 4;
  }

  @Override
  public boolean applicable(Expression e) {
    return e.getOp().equals(Operator.MUL);
  }

  @Override
  public Expression apply(Expression e) {
    if (e instanceof IntExpression ie) {
      if (ie.getN1() > 10 && ie.getN2() > 10) {
        if (Utils.getRandom().nextBoolean()) {
          ie.setN1(ie.getN1() / 10);
        } else {
          ie.setN2(ie.getN2() / 10);
        }
      }
      if (ie.getN1() < 10 && ie.getN2() < 10) {
        int newData = 0;
        while (newData < 10) {
          newData = Utils.getRandom().nextInt(100);
        }
        if (Utils.getRandom().nextBoolean()) {
          ie.setN1(newData);
          ie.setN2(ie.getN2());
        } else {
          ie.setN1(ie.getN1());
          ie.setN2(newData);
        }
      }
      return ie;
    }
    return e;
  }
}
