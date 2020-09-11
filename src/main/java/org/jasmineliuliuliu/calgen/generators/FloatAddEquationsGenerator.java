package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.ADD;

import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.FloatEquation;

@Generator
public class FloatAddEquationsGenerator extends AbstractEquationsGenerator {

  @Override
  public Equation generateOne(EquationRequirement req) {
    return modify(new FloatEquation(fLeft(req), fRight(req), ADD, fmt(req)), req);
  }
}
