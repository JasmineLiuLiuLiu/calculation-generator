package calculate.rules;

import static calculate.metadata.Operator.DIV;
import static calculate.metadata.Operator.MUL;
import static calculate.metadata.Operator.SUB;

import calculate.Utils;
import calculate.expressions.CompositeExpression;
import calculate.expressions.Expression;
import calculate.expressions.IntExpression;

public class TriExpressionApplier extends AbstractRuleApplier {

  @Override
  public int getPriority() {
    return 1;
  }

  @Override
  public boolean applicable(Expression e) {
    return true;
  }

  @Override
  public Expression apply(Expression e) {
    if (e instanceof CompositeExpression ce) {
      adjustExpression(ce);
    }
    return e;
  }

  private void adjustExpression(CompositeExpression ce) {
    IntExpression be = ce.getN1();
    // Handle MUL
    new MulRuleApplier().apply(ce);
    // Handle SUB
    if (ce.result() < 0 && ce.getOp().equals(SUB)) {
      ce.setShouldReversed(true);
    }
    //Handle DIV
    if (ce.getOp().equals(DIV)) {
      if (be.result() > 100) {
        ce.setN2(Utils.getRandom().nextInt(500, 1000));
        ce.setOp(SUB);
        ce.setShouldReversed(true);
      } else if (be.result() > 10) {
        ce.setN2(Utils.getRandom().nextInt(10, 100));
        ce.setOp(MUL);
      } else {
        ce.setN2(Utils.getRandom().nextInt(10, 100) * be.result());
        ce.setShouldReversed(true);
      }
    }
  }
}
