package calculate.rules;

import static calculate.metadata.Operator.MUL;

import calculate.Utils;
import calculate.expressions.BasicExpression;
import calculate.expressions.IntExpression;
import java.util.Arrays;
import java.util.Random;


public class MulDivExponentRuleApplier extends AbstractRuleApplier<BasicExpression> {

  private final int modifier = Arrays.asList(1, 10, 100).get(new Random().nextInt(3));

  @Override
  public int getPriority() {
    return 4;
  }

  @Override
  public boolean applicable(BasicExpression basicExpression) {
    return basicExpression.getOp().getPriority() == 1;
  }

  @Override
  public BasicExpression apply(BasicExpression be) {
    if (be instanceof IntExpression ie) {
      if (ie.getOp().equals(MUL)) {
        if (Utils.getRandom().nextBoolean()) {
          ie.setData1(ie.getData1() * modifier);
        } else {
          ie.setData2(ie.getData2() * modifier);
        }
      } else {
        ie.setData1(ie.getData1() * modifier);
      }
    }
    return be;
  }
}
