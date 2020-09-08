package org.jasmineliuliuliu.calgen.modifiers;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.generators.EquationRequirement;
import org.jasmineliuliuliu.calgen.models.Operator;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.springframework.stereotype.Component;

/**
 * 除法算式修改器，保证能够整除。 必须在所有除法算式修改器之后执行。
 */
@Component
public class ExactDivisionModifier implements PriorityEquationModifier<IntEquation> {

  @Override
  public int getPriority() {
    return 6;
  }

  @Override
  public boolean modifiable(IntEquation e, EquationRequirement req) {
    return e.getOp().equals(Operator.DIV) && req.isExactDivision();
  }

  @Override
  public IntEquation modify(IntEquation e, EquationRequirement req) {
    e.setLeft(e.getRight() * Utils.random().nextInt(req.minRight(), req.maxRight()));
    return e;
  }
}
