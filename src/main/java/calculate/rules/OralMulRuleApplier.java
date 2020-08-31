package calculate.rules;

import calculate.expressions.BasicExpression;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;
import java.util.Random;

public class OralMulRuleApplier extends AbstractRuleApplier<BasicExpression> {

  @Override
  public int getPriority() {
    return 4;
  }

  @Override
  public boolean applicable(BasicExpression basicExpression) {
    return basicExpression.getOp().equals(Operator.MUL);
  }

  @Override
  public BasicExpression apply(BasicExpression basicExpression) {
    Random random = new Random();
    if (basicExpression instanceof IntExpression intExpression) {
      if (intExpression.getData1() > 10 && intExpression.getData2() > 10) {
        if (random.nextBoolean()) {
          intExpression.setData1(intExpression.getData1() / 10);
        } else {
          intExpression.setData2(intExpression.getData2() / 10);
        }
      }
      if (intExpression.getData1() < 10 && intExpression.getData2() < 10) {
        int newData = 0;
        while (newData < 10) {
          newData = random.nextInt(100);
        }
        if (random.nextBoolean()) {
          intExpression.setData1(newData);
          intExpression.setData2(intExpression.getData2());
        } else {
          intExpression.setData1(intExpression.getData1());
          intExpression.setData2(newData);
        }
      }
      return intExpression;
    }
    return basicExpression;
  }
}
