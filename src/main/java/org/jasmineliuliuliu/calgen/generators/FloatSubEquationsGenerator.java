package org.jasmineliuliuliu.calgen.generators;

import static org.jasmineliuliuliu.calgen.models.Operator.ADD;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.FloatEquation;
import org.jasmineliuliuliu.calgen.modifiers.DifferencePositiveModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FloatSubEquationsGenerator implements EquationsGenerator {

  @Autowired
  private DifferencePositiveModifier<FloatEquation> modifier;

  @Override
  public Equation generateOne(int... bounds) {
    float f1 = Utils.random().nextInt(bounds[0]) / (bounds[1] * 10f);
    float f2 = Utils.random().nextInt(bounds[0]) / (bounds[1] * 10f);
    FloatEquation fe;
    if (bounds.length > 2) {
      fe = new FloatEquation(f1, f2, ADD, String.format("%.%df%s%.%df", bounds[2], bounds[2]));
    } else {
      fe = new FloatEquation(f1, f2, ADD);
    }
    return modifier.modify(fe);
  }
}
