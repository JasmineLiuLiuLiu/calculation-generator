package calculate.modifiers;

import calculate.Utils;
import calculate.expressions.IntEquation;
import calculate.metadata.Operator;

/**
 * 除法算式修改器，保证能够整除。 必须在所有除法算式修改器之后执行。
 */
public class ExactDivisionModifier implements
    PriorityExpressionModifier<IntEquation> {

  @Override
  public int getPriority() {
    return 6;
  }

  @Override
  public boolean modifiable(IntEquation e) {
    return e.getOp().equals(Operator.DIV);
  }

  @Override
  public IntEquation modify(IntEquation e) {
    e.setLeft(e.getRight() * Utils.getRandom().nextInt(10, 100));
    return e;
  }
}
