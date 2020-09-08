package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.SUB;

import org.jasmineliuliuliu.calgen.generators.tags.Int;
import org.jasmineliuliuliu.calgen.generators.tags.Sub;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.springframework.stereotype.Component;

@Int
@Sub
@Component
public class IntSubEquationsGenerator extends AbstractEquationsGenerator {

  @Override
  public Equation generateOne(EquationRequirement req) {
    return modify(new IntEquation(iLeft(req), iRight(req), SUB), req);
  }
}