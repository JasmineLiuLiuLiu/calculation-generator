package calculate.rules;

import calculate.Utils;
import calculate.expressions.BasicExpression;
import calculate.metadata.Operator;

/**
 * Handle Subtraction: Make sure the result is not negative.
 * <p>
 * Set data1 to max(data1, data2), and set data2 to min(data1, data2).
 */
public class SubRuleApplier extends AbstractRuleApplier<BasicExpression> {

  @Override
  public int getPriority() {
    return 3;
  }

  @Override
  public boolean applicable(BasicExpression basicExpression) {
    return basicExpression.getOp().equals(Operator.SUB);
  }

  @Override
  public BasicExpression apply(BasicExpression be) {
    Number max = Utils.max(be.getData1(), be.getData2());
    Number min = Utils.min(be.getData1(), be.getData2());
    be.setData1(max);
    be.setData2(min);
    return be;
  }

}
