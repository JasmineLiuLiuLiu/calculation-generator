package calculate.modifiers;

import calculate.Utils;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

public class MultiplierRangeIntExpressionPriorityModifier implements IntExpressionPriorityModifier {

  private final int min;
  private final int max;

  public MultiplierRangeIntExpressionPriorityModifier(int min, int max) {
    this.min = min;
    this.max = max;
  }

  @Override
  public int getPriority() {
    return 4;
  }

  @Override
  public boolean modifiable(IntExpression e) {
    return e.getOp().equals(Operator.MUL);
  }

  @Override
  public IntExpression modify(IntExpression e) {
    e.setRight(dataAdjust(e.getRight()));
    e.setLeft(dataAdjust(e.getLeft()));
    return e;
  }

  private int dataAdjust(int i) {
    int result = i;
    if (i > max) {
      result = i % max;
    }
    if (i < min) {
      result = Utils.getRandom().nextInt(min, max);
    }
    return result;
  }
}
