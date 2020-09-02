package calculate.modifiers;

import calculate.Utils;
import calculate.expressions.IntExpression;
import calculate.metadata.Operator;

public class OralMulExpressionPriorityModifier implements IntExpressionPriorityModifier {

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
    if (e instanceof IntExpression ie) {
      if (ie.getRight() > 10 && ie.getLeft() > 10) {
        if (Utils.getRandom().nextBoolean()) {
          ie.setRight(ie.getRight() / 10);
        } else {
          ie.setLeft(ie.getLeft() / 10);
        }
      }
      if (ie.getRight() < 10 && ie.getLeft() < 10) {
        int newData = 0;
        while (newData < 10) {
          newData = Utils.getRandom().nextInt(100);
        }
        if (Utils.getRandom().nextBoolean()) {
          ie.setRight(newData);
          ie.setLeft(ie.getLeft());
        } else {
          ie.setRight(ie.getRight());
          ie.setLeft(newData);
        }
      }
      return ie;
    }
    return e;
  }
}
