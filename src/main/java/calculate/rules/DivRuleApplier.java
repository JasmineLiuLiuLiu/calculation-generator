package calculate.rules;

import calculate.Utils;
import calculate.expressions.BasicExpression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

public class DivRuleApplier extends AbstractRuleApplier<BasicExpression> {

  @Override
  public int getPriority() {
    return 5;
  }

  @Override
  public boolean applicable(BasicExpression basicExpression) {
    return basicExpression.getOp().equals(Operator.DIV);
  }

  @Override
  public BasicExpression apply(BasicExpression basicExpression) {
    if (basicExpression instanceof IntExpression intExpression) {
      int d2 = intExpression.getData2() % 10;
      if (d2 < 3) {
        d2 = Utils.getRandom().nextInt(3, 10);
      }
      intExpression.setData2(d2);
      int factor = Utils.getRandom().nextInt(10, 100);
      intExpression.setData1(intExpression.getData2() * factor);
    }
    return basicExpression;
  }
}
