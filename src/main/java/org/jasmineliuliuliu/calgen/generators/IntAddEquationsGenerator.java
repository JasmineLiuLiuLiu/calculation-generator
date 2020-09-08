package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.ADD;

import org.jasmineliuliuliu.calgen.generators.tags.Add;
import org.jasmineliuliuliu.calgen.generators.tags.Int;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.springframework.stereotype.Component;

@Int
@Add
@Component
public class IntAddEquationsGenerator extends AbstractEquationsGenerator {

  @Override
  public Equation generateOne(EquationRequirement req) {
    return modify(new IntEquation(iLeft(req), iRight(req), ADD), req);
  }
}