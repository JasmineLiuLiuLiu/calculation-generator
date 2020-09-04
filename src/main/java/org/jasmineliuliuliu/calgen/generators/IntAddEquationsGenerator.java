package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.ADD;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;

public class IntAddEquationsGenerator implements EquationsGenerator {

  @Override
  public Equation generateOne(int... bounds) {
    int i1 = Utils.random().nextInt(bounds[0], bounds[1]);
    int i2 = Utils.random().nextInt(bounds[0], bounds[1]);
    return new IntEquation(i1, i2, ADD);
  }
}
