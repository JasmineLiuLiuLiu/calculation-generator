package org.jasmineliuliuliu.calgen.generators;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.jasmineliuliuliu.calgen.models.equations.TernaryEquation;
import org.jasmineliuliuliu.calgen.modifiers.DifferencePositiveModifier;
import org.jasmineliuliuliu.calgen.modifiers.DivisorRangeModifier;
import org.jasmineliuliuliu.calgen.modifiers.ExactDivisionModifier;
import org.jasmineliuliuliu.calgen.modifiers.MultipliersRangeModifier;
import org.jasmineliuliuliu.calgen.modifiers.PriorityModifiers;
import org.jasmineliuliuliu.calgen.modifiers.TernaryDivisionModifier;

//TODO: make general
public class MixCalculationEquationGenerator implements EquationsGenerator {

  private final PriorityModifiers<IntEquation> intExecutor;
  private final PriorityModifiers ternaryExecutor;

  public MixCalculationEquationGenerator() {
    intExecutor = new PriorityModifiers(
        new DifferencePositiveModifier<IntEquation>(), new ExactDivisionModifier(),
        new DivisorRangeModifier(2, 10), new MultipliersRangeModifier<IntEquation>(11, 100));
    ternaryExecutor = new PriorityModifiers(
        new DifferencePositiveModifier<TernaryEquation>(),
        new MultipliersRangeModifier<TernaryEquation>(11, 100), new TernaryDivisionModifier());
  }

  @Override
  public Equation generateOne(int... bounds) {
    int i1 = Utils.random().nextInt(bounds[0]);
    int i2 = Utils.random().nextInt(bounds[0]);
    int i3 = Utils.random().nextInt(bounds[0]);
    IntEquation ie = new IntEquation(i1, i2, Utils.anyOperator());
    intExecutor.execute(ie);
    TernaryEquation te = new TernaryEquation(ie, i3, Utils.anyOperator());
    ternaryExecutor.execute(te);
    return te;
  }
}
