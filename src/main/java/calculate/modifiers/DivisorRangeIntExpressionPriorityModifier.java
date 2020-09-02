package calculate.modifiers;

import calculate.Utils;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

public class DivisorRangeIntExpressionPriorityModifier implements IntExpressionPriorityModifier {

  private final int max;
  private final int min;

  public DivisorRangeIntExpressionPriorityModifier(int max, int min) {
    this.max = max;
    this.min = min;
  }

  @Override
  public int getPriority() {
    return 5;
  }

  @Override
  public boolean modifiable(IntExpression e) {
    return e.getOp().equals(Operator.DIV);
  }

  @Override
  public IntExpression modify(IntExpression e) {
    if (e.getLeft() < min || e.getLeft() > max) {
      e.setLeft(Utils.getRandom().nextInt(min, max));
    }
    return e;
  }
}
