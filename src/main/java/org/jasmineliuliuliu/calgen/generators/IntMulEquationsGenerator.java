package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.MUL;

import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;

@Generator
public class IntMulEquationsGenerator extends AbstractEquationsGenerator {

  @Override
  public Equation generateOne(EquationRequirement req) {
    return modify(new IntEquation(iLeft(req), iRight(req), MUL), req);
  }
}
