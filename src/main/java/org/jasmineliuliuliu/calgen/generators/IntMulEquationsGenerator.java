package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.MUL;

import org.jasmineliuliuliu.calgen.generators.tags.Int;
import org.jasmineliuliuliu.calgen.generators.tags.Mul;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.springframework.stereotype.Component;

@Int
@Mul
@Component
public class IntMulEquationsGenerator extends AbstractEquationsGenerator {

  @Override
  public Equation generateOne(EquationRequirement req) {
    return modify(new IntEquation(iLeft(req), iRight(req), MUL), req);
  }
}
