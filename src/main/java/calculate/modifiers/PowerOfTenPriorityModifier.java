package calculate.modifiers;

import static calculate.metadata.Operator.DIV;

import calculate.Utils;
import calculate.expressions.IntExpression;
import java.util.Arrays;
import java.util.List;


public class PowerOfTenPriorityModifier implements IntExpressionPriorityModifier {

  private final List<Integer> powersOfTen = Arrays.asList(1, 10, 100);

  @Override
  public int getPriority() {
    return 7;
  }

  @Override
  public boolean modifiable(IntExpression e) {
    return e.getOp().getPriority() == 1;
  }

  @Override
  public IntExpression modify(IntExpression e) {
    int random = Utils.getRandom().nextInt(powersOfTen.toArray().length);
    if (e.getOp().equals(DIV) || Utils.getRandom().nextBoolean()) {
      e.setLeft(e.getLeft() * powersOfTen.get(random));
    } else {
      e.setRight(e.getRight() * powersOfTen.get(random));
    }
    return e;
  }
}
