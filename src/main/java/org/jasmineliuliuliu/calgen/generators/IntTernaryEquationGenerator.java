package org.jasmineliuliuliu.calgen.generators;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.Operator;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.jasmineliuliuliu.calgen.models.equations.TernaryEquation;
import org.springframework.beans.factory.annotation.Autowired;

@Generator
public class IntTernaryEquationGenerator extends AbstractEquationsGenerator {

  @Autowired
  IntAddEquationsGenerator addGenerator;
  @Autowired
  IntSubEquationsGenerator subGenerator;
  @Autowired
  IntMulEquationsGenerator mulGenerator;
  @Autowired
  IntDivEquationsGenerator divGenerator;

  @Override
  public Equation generateOne(EquationRequirement req) {
    Operator op1 = Utils.anyOperator();
    IntEquation ie;
    switch (op1) {
      case ADD -> ie = (IntEquation) addGenerator.generateOne(req);
      case SUB -> ie = (IntEquation) subGenerator.generateOne(req);
      case MUL -> ie = (IntEquation) mulGenerator.generateOne(req);
      case DIV -> ie = (IntEquation) divGenerator.generateOne(req);
      default -> ie = new IntEquation(iLeft(req), iRight(req), op1);
    }
    TernaryEquation te = new TernaryEquation(ie, iRight(req), Utils.anyOperator());
    return modify(te, req);
  }
}
