package calculate.generators;

import static calculate.metadata.Operator.MUL;

import calculate.ExpressionGenerator;
import calculate.PriorityModifiersExecutor;
import calculate.Utils;
import calculate.expressions.Equation;
import calculate.expressions.IntEquation;
import calculate.modifiers.MultipliersRangeModifier;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MulCalculationExpressionsGenerator implements ExpressionGenerator {

  private static final int factorBound = 100;
  private final int amount;
  private final PriorityModifiersExecutor executor;

  public MulCalculationExpressionsGenerator(int amount) {
    this.amount = amount;
    executor = new PriorityModifiersExecutor(new MultipliersRangeModifier(10, 100));
  }

  @Override
  public Set<Equation> generate() {
    Set<Equation> equations = new HashSet<>();
    IntStream.range(0, amount).forEach(i -> equations.add(executor.execute(
        new IntEquation(Utils.newFactor(factorBound), Utils.newFactor(factorBound), MUL))));
    return equations;
  }
}
