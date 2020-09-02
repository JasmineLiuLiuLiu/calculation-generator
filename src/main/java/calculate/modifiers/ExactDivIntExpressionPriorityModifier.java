package calculate.modifiers;

import calculate.Utils;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

public class ExactDivIntExpressionPriorityModifier implements IntExpressionPriorityModifier {

  private final int resultMin;
  private final int resultMax;

  public ExactDivIntExpressionPriorityModifier(int resultMin, int resultMax) {
    this.resultMin = resultMin;
    this.resultMax = resultMax;
  }

  @Override
  public int getPriority() {
    return 6;
  }

  @Override
  public boolean modifiable(IntExpression e) {
    return e.getOp().equals(Operator.DIV);
  }

  @Override
  public IntExpression modify(IntExpression e) {
    int factor = Utils.getRandom().nextInt(resultMin, resultMax);
    e.setRight(e.getLeft() * factor);
    return e;
  }
}
