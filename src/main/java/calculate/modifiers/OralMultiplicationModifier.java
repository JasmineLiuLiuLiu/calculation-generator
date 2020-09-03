package calculate.modifiers;

import calculate.Utils;
import calculate.expressions.IntEquation;
import calculate.metadata.Operator;

/**
 * 乘法算式修改器，用于口算乘法，避免出现多位数×多位数，或者简单的个位数×个位数。
 */
public class OralMultiplicationModifier implements PriorityExpressionModifier<IntEquation> {

  @Override
  public int getPriority() {
    return 4;
  }

  @Override
  public boolean modifiable(IntEquation e) {
    return e.getOp().equals(Operator.MUL);
  }

  @Override
  public IntEquation modify(IntEquation e) {
    if (e.getRight() > 10 && e.getLeft() > 10) {
      if (Utils.getRandom().nextBoolean()) {
        e.setRight(e.getRight() / 10);
      } else {
        e.setLeft(e.getLeft() / 10);
      }
    } else if (e.getRight() < 10 && e.getLeft() < 10) {
      int newData = 0;
      while (newData < 10) {
        newData = Utils.getRandom().nextInt(100);
      }
      if (Utils.getRandom().nextBoolean()) {
        e.setRight(newData);
      } else {
        e.setRight(e.getRight());
        e.setLeft(newData);
      }
    }
    return e;
  }
}
