package calculate.rules;

import calculate.Utils;
import calculate.expressions.BasicExpression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

public class AddRuleApplier extends AbstractRuleApplier<BasicExpression> {

  @Override
  public int getPriority() {
    return 1;
  }

  @Override
  public boolean applicable(BasicExpression basicExpression) {
    return basicExpression.getOp().equals(Operator.ADD);
  }

  @Override
  public BasicExpression apply(BasicExpression basicExpression) {
    if (basicExpression instanceof IntExpression ie) {

      if (ie.getData1() > 10 && ie.getData2() > 10) {
        if (Utils.getRandom().nextBoolean()) {
          ie.setData1(ie.getData1() % 10);
        } else {
          ie.setData2(ie.getData2() % 10);
        }
      }
    }
    return basicExpression;
  }
}
