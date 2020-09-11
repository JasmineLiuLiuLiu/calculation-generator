package org.jasmineliuliuliu.calgen.modifiers;

import org.jasmineliuliuliu.calgen.generators.EquationRequirement;
import org.jasmineliuliuliu.calgen.models.Operator;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.FloatEquation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.jasmineliuliuliu.calgen.models.equations.TernaryEquation;

/**
 * 减法算式修改器，保证差为正数。
 *
 * @param <E> Equation的子类，可能是{@code IntEquation}，{@code FloatEquation}或{@code TernaryEquation}
 */
public class DifferencePositiveModifier<E extends Equation> implements
    PriorityEquationModifier<E> {

  @Override
  public int getPriority() {
    return 3;
  }

  @Override
  public boolean modifiable(Equation e, EquationRequirement req) {
    return e.getOp().equals(Operator.SUB) && req.isResultPositive();
  }

  @Override
  public E modify(E e, EquationRequirement req) {
    if (e instanceof IntEquation ne && ne.result() < 0) {
      int right = ne.getRight();
      ne.setRight(ne.getLeft());
      ne.setLeft(right);
    } else if (e instanceof FloatEquation fe && fe.result() < 0) {
      float right = fe.getRight();
      fe.setRight(fe.getLeft());
      fe.setLeft(right);
    } else if (e instanceof TernaryEquation ce && ce.result() < 0) {
      ce.setShouldReversed(true);
    }
    return e;
  }

}
