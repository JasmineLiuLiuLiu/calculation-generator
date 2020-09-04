package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.SUB;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.jasmineliuliuliu.calgen.modifiers.DifferencePositiveModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntSubEquationsGenerator implements EquationsGenerator {

  @Autowired
  private DifferencePositiveModifier<IntEquation> modifier;

  @Override
  public Equation generateOne(int... bounds) {
    int i1 = Utils.random().nextInt(bounds[0], bounds[1]);
    int i2 = Utils.random().nextInt(bounds[0], bounds[1]);
    return modifier.modify(new IntEquation(i1, i2, SUB));
  }
}