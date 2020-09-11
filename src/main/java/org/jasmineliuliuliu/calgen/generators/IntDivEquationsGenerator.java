package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.DIV;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;

@Generator
public class IntDivEquationsGenerator extends AbstractEquationsGenerator {

  @Override
  public Equation generateOne(EquationRequirement req) {
    int iDivisor = iDivisor(req);
    int iLeft = iLeft(req) * iDivisor;
    if (!req.isExactDivision()) {
      iLeft += Utils.random().nextInt(0, iDivisor);
    }
    return modify(new IntEquation(iLeft, iDivisor, DIV), req);
  }
}
