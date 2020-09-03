package calculate.generators;

import static calculate.metadata.Operator.ADD;
import static calculate.metadata.Operator.SUB;

import calculate.ExpressionGenerator;
import calculate.PriorityModifiersExecutor;
import calculate.Utils;
import calculate.expressions.Equation;
import calculate.expressions.FloatEquation;
import calculate.expressions.IntEquation;
import calculate.metadata.DataType;
import calculate.modifiers.DifferencePositiveModifier;
import calculate.modifiers.DivisorRangeModifier;
import calculate.modifiers.ExactDivisionModifier;
import calculate.modifiers.OralMultiplicationModifier;
import calculate.modifiers.PowerOfTenModifier;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class OralCalculationExpressionsGenerator implements ExpressionGenerator {

  private final int amount;
  private final PriorityModifiersExecutor priorityModifier;

  public OralCalculationExpressionsGenerator(int amount) {
    this.amount = amount;
    priorityModifier = new PriorityModifiersExecutor(
        new DifferencePositiveModifier(),
        new ExactDivisionModifier(),
        new DivisorRangeModifier(2, 10),
        new OralMultiplicationModifier(),
        new PowerOfTenModifier());
  }

  @Override
  public Set<Equation> generate() {
    Set<Equation> equations = new HashSet<>();
    IntStream.range(0, amount).forEach(i -> {
      DataType dataType = DataType.getDataType(Utils.getPercentageRandom(40, 0, 1));
      switch (dataType) {
        case INT:
          equations.add(priorityModifier
              .execute(new IntEquation(Utils.newFactor(100), Utils.newFactor(100),
                  Utils.getAnyOperator())));
          break;
        case FLOAT:
          equations.add(new DifferencePositiveModifier<FloatEquation>().modify(
              new FloatEquation(Utils.newFactor(100) * 0.1f, Utils.newFactor(100) * 0.1f,
                  Utils.getAnyOperator(ADD, SUB))));
          break;
      }
    });
    return equations;
  }
}
