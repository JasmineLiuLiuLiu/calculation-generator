package calculate.modifiers;

import calculate.Utils;
import calculate.expressions.Equation;
import calculate.expressions.IntEquation;
import calculate.expressions.TernaryEquation;
import calculate.metadata.Operator;

/**
 * 乘法算式修改器，修改乘数的范围。
 */
public class MultipliersRangeModifier<E extends Equation> implements PriorityExpressionModifier<E> {

  private final int min;
  private final int max;

  public MultipliersRangeModifier(int min, int max) {
    this.min = min;
    this.max = max;
  }

  @Override
  public int getPriority() {
    return 4;
  }

  @Override
  public boolean modifiable(Equation e) {
    return e.getOp().equals(Operator.MUL);
  }

  @Override
  public Equation modify(Equation e) {
    if (e instanceof IntEquation ie) {
      ie.setRight(dataAdjust(ie.getRight()));
      ie.setLeft(dataAdjust(ie.getLeft()));
    } else if (e instanceof TernaryEquation te) {
      te.setRight(dataAdjust(te.getRight()));
    }
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
