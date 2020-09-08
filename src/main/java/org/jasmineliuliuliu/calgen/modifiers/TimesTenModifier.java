package org.jasmineliuliuliu.calgen.modifiers;

import static org.jasmineliuliuliu.calgen.models.Operator.DIV;
import static org.jasmineliuliuliu.calgen.models.Operator.SUB;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.generators.EquationRequirement;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.springframework.stereotype.Component;

/**
 * 算式修改器，制造整十或者整百。
 */
@Component
public class TimesTenModifier implements PriorityEquationModifier<IntEquation> {

  @Override
  public int getPriority() {
    return 7;
  }

  @Override
  public boolean modifiable(IntEquation e, EquationRequirement req) {
    return req.times10() > 1;
  }

  @Override
  public IntEquation modify(IntEquation e, EquationRequirement req) {
    if (e.getOp().equals(SUB) || e.getOp().equals(DIV)) {
      e.setLeft((int) (Math.pow(10, Utils.random().nextInt(req.times10())) * e.getLeft()));
    } else if (Utils.random().nextBoolean()) {
      e.setLeft((int) (Math.pow(10, Utils.random().nextInt(req.times10())) * e.getLeft()));
    } else if (Utils.random().nextBoolean()) {
      e.setRight((int) (Math.pow(10, Utils.random().nextInt(req.times10())) * e.getRight()));
    }
    return e;
  }
}
