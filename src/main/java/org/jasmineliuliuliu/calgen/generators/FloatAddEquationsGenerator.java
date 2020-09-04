package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.ADD;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.FloatEquation;

public class FloatAddEquationsGenerator implements EquationsGenerator {

  @Override
  public Equation generateOne(int... bounds) {
    float f1 = Utils.random().nextInt(bounds[0]) / (bounds[1] * 10f);
    float f2 = Utils.random().nextInt(bounds[0]) / (bounds[1] * 10f);
    if (bounds.length > 2) {
      return new FloatEquation(f1, f2, ADD, String.format("%.%df%s%.%df", bounds[2], bounds[2]));
    } else {
      return new FloatEquation(f1, f2, ADD);
    }
  }
}
