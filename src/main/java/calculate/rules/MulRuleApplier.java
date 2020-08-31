package calculate.rules;

import static calculate.metadata.Operator.ADD;

import calculate.Utils;
import calculate.expressions.BasicExpression;
import calculate.expressions.CompositeExpression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;


public class MulRuleApplier extends AbstractRuleApplier<BasicExpression> {

  @Override
  public int getPriority() {
    return 4;
  }

  @Override
  public boolean applicable(BasicExpression basicExpression) {
    return basicExpression.getOp().equals(Operator.MUL);
  }

  @Override
  public BasicExpression apply(BasicExpression be) {
    if (be instanceof IntExpression ie) {
      ie.setData1(dataAdjust(ie.getData1()));
      ie.setData2(dataAdjust(ie.getData2()));
    }
    if (be instanceof CompositeExpression ce) {
      if ((Integer) ce.getBe().result() > 100) {
        ce.setOp(ADD);
      } else {
        ce.setData2(dataAdjust((Integer) ce.getData2()));
      }
    }
    return be;
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
