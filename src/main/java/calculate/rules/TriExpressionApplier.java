package calculate.rules;

import static calculate.metadata.Operator.DIV;
import static calculate.metadata.Operator.MUL;
import static calculate.metadata.Operator.SUB;

import calculate.Utils;
import calculate.expressions.BasicExpression;
import calculate.expressions.CompositeExpression;

public class TriExpressionApplier extends AbstractRuleApplier<CompositeExpression<Integer>> {

  @Override
  public int getPriority() {
    return 1;
  }

  @Override
  public boolean applicable(CompositeExpression<Integer> compositeExpression) {
    return true;
  }

  @Override
  public CompositeExpression apply(CompositeExpression<Integer> compositeExpression) {
    adjustExpression(compositeExpression);
    return compositeExpression;
  }

  private void adjustExpression(CompositeExpression<Integer> ce) {
    BasicExpression<Integer> be = ce.getBe();
    // Handle MUL
    new MulRuleApplier().apply(ce);
    // Handle SUB
    if (ce.result() < 0 && ce.getOp().equals(SUB)) {
      ce.setShouldReversed(true);
    }
    //Handle DIV
    if (ce.getOp().equals(DIV)) {
      if (be.result() > 100) {
        ce.setData2(Utils.getRandom().nextInt(500, 1000));
        ce.setOp(SUB);
        ce.setShouldReversed(true);
      } else if (be.result() > 10) {
        ce.setData2(Utils.getRandom().nextInt(10, 100));
        ce.setOp(MUL);
      } else {
        ce.setData2(Utils.getRandom().nextInt(10, 100) * be.result());
        ce.setShouldReversed(true);
      }
    }
  }
}
