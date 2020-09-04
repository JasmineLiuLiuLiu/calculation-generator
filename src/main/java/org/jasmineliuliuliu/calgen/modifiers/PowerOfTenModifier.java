package org.jasmineliuliuliu.calgen.modifiers;

import static org.jasmineliuliuliu.calgen.models.Operator.DIV;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 乘法或者除法算式修改器，制造整十或者整百的乘除法。
 * <p>
 * 如果是乘法算式，把任一乘数×1，或者10，或者100
 * <p>
 * 如果是除法算式，把除数×1，或者10，或者100
 */
@Component
public class PowerOfTenModifier implements PriorityEquationModifier<IntEquation> {

  private final List<Integer> powersOfTen = Arrays.asList(1, 10, 100);

  @Override
  public int getPriority() {
    return 7;
  }

  @Override
  public boolean modifiable(IntEquation e) {
    return e.getOp().getPriority() == 1;
  }

  @Override
  public IntEquation modify(IntEquation e) {
    int random = Utils.random().nextInt(powersOfTen.toArray().length);
    if (e.getOp().equals(DIV) || Utils.random().nextBoolean()) {
      e.setLeft(e.getLeft() * powersOfTen.get(random));
    } else {
      e.setRight(e.getRight() * powersOfTen.get(random));
    }
    return e;
  }
}
