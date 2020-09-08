package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.SUB;

import org.jasmineliuliuliu.calgen.generators.tags.Float;
import org.jasmineliuliuliu.calgen.generators.tags.Sub;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.FloatEquation;
import org.springframework.stereotype.Component;

@Sub
@Float
@Component
public class FloatSubEquationsGenerator extends AbstractEquationsGenerator {

  @Override
  public Equation generateOne(EquationRequirement req) {
    return modify(new FloatEquation(fLeft(req), fRight(req), SUB, fmt(req)), req);

  }
}
