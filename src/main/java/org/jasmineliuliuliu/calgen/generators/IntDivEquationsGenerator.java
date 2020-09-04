package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.DIV;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.jasmineliuliuliu.calgen.modifiers.ExactDivisionModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntDivEquationsGenerator implements EquationsGenerator {

  @Autowired
  ExactDivisionModifier modifier;

  @Override
  public Equation generateOne(int... bounds) {
    int i1 = Utils.random().nextInt(bounds[0], bounds[1]);
    int i2 = Utils.random().nextInt(bounds[0], bounds[1]);
    return modifier.modify(new IntEquation(i1, i2, DIV));
  }
}
