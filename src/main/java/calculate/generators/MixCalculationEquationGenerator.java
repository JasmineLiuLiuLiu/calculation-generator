package calculate.generators;

import calculate.ExpressionGenerator;
import calculate.PriorityModifiersExecutor;
import calculate.Utils;
import calculate.expressions.Equation;
import calculate.expressions.IntEquation;
import calculate.expressions.TernaryEquation;
import calculate.modifiers.DifferencePositiveModifier;
import calculate.modifiers.DivisorRangeModifier;
import calculate.modifiers.ExactDivisionModifier;
import calculate.modifiers.MultipliersRangeModifier;
import calculate.modifiers.TernaryDivisionModifier;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

//TODO: modify
public class MixCalculationEquationGenerator implements ExpressionGenerator {

  private final int amount;
  private final PriorityModifiersExecutor<IntEquation> intExecutor;
  private final PriorityModifiersExecutor ternaryExecutor;

  public MixCalculationEquationGenerator(int amount) {
    this.amount = amount;
    intExecutor = new PriorityModifiersExecutor(
        new DifferencePositiveModifier<IntEquation>(),new ExactDivisionModifier(),
        new DivisorRangeModifier(2, 10), new MultipliersRangeModifier<IntEquation>(10, 100));
    ternaryExecutor = new PriorityModifiersExecutor(
        new DifferencePositiveModifier<TernaryEquation>(),
        new MultipliersRangeModifier<TernaryEquation>(10, 100), new TernaryDivisionModifier());
  }

  @Override
  public Set<Equation> generate() {
    Set<Equation> equations = new HashSet<>();

    IntStream.range(0, amount).sequential().forEach(i -> {
      IntEquation ie = intExecutor.execute(
          new IntEquation(Utils.newFactor(600), Utils.newFactor(600), Utils.getAnyOperator()));
      equations.add(ternaryExecutor.execute(new TernaryEquation(ie, Utils.newFactor(500),
          Utils.getAnyOperator())));
    });
    return equations;
  }

}
