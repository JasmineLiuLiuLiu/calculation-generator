package calculate.rules;

import static calculate.metadata.Operator.ADD;

import calculate.Utils;
import calculate.expressions.CompositeExpression;
import calculate.expressions.Expression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;


public class MulRuleApplier extends AbstractRuleApplier {

  @Override
  public int getPriority() {
    return 4;
  }

  @Override
  public boolean applicable(Expression basicExpression) {
    return basicExpression.getOp().equals(Operator.MUL);
  }

  @Override
  public Expression apply(Expression e) {
    if (e instanceof IntExpression ie) {
      ie.setN1(dataAdjust(ie.getN1()));
      ie.setN2(dataAdjust(ie.getN2()));
    }
    if (e instanceof CompositeExpression ce) {
      if ((Integer) ce.getN1().result() > 100) {
        ce.setOp(ADD);
      } else {
        ce.setN2(dataAdjust((Integer) ce.getN2()));
      }
    }
    return e;
  }

  private int dataAdjust(int i) {
    int result = i;
    if (i > 100) {
      result = i % 100;
    }
    if (i < 10 || i % 10 == 0) {
      result = Utils.getRandom().nextInt(10, 100);
    }
    return result;
  }
}
