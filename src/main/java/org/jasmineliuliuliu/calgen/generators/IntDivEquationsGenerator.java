package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.DIV;

import org.jasmineliuliuliu.calgen.generators.tags.Div;
import org.jasmineliuliuliu.calgen.generators.tags.Int;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.springframework.stereotype.Component;

@Int
@Div
@Component
public class IntDivEquationsGenerator extends AbstractEquationsGenerator {

  @Override
  public Equation generateOne(EquationRequirement req) {
    return modify(new IntEquation(iLeft(req), iRight(req), DIV), req);
  }
}
