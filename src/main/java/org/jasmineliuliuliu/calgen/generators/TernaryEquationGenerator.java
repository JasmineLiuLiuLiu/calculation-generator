package org.jasmineliuliuliu.calgen.generators;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.generators.tags.Int;
import org.jasmineliuliuliu.calgen.generators.tags.Ternary;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.jasmineliuliuliu.calgen.models.equations.TernaryEquation;
import org.springframework.stereotype.Component;

//TODO: make general
@Ternary
@Int
@Component
public class TernaryEquationGenerator extends AbstractEquationsGenerator {

  @Override
  public Equation generateOne(EquationRequirement req) {
    IntEquation ie = new IntEquation(iLeft(req), iLeft(req), Utils.anyOperator());
    modify(ie, req);
    TernaryEquation te = new TernaryEquation(ie, iRight(req), Utils.anyOperator());
    return modify(ie, req);
  }
}
