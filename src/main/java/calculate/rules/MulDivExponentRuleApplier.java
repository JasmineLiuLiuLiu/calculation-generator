package calculate.rules;

import static calculate.metadata.Operator.MUL;

import calculate.Utils;
import calculate.expressions.Expression;
import calculate.expressions.IntExpression;
import java.util.Arrays;
import java.util.Random;


public class MulDivExponentRuleApplier extends AbstractRuleApplier {

  private final int modifier = Arrays.asList(1, 10, 100).get(new Random().nextInt(3));

  @Override
  public int getPriority() {
    return 4;
  }

  @Override
  public boolean applicable(Expression e) {
    return e.getOp().getPriority() == 1;
  }

  @Override
  public Expression apply(Expression be) {
    if (be instanceof IntExpression ie) {
      if (ie.getOp().equals(MUL)) {
        if (Utils.getRandom().nextBoolean()) {
          ie.setN1(ie.getN1() * modifier);
        } else {
          ie.setN2(ie.getN2() * modifier);
        }
      } else {
        ie.setN1(ie.getN1() * modifier);
      }
    }
    return be;
  }
}
