package calculate.generators;

import static calculate.metadata.Operator.ADD;
import static calculate.metadata.Operator.SUB;

import calculate.ExpressionGenerator;
import calculate.Utils;
import calculate.expressions.Equation;
import calculate.expressions.IntEquation;
import calculate.modifiers.EquationModifier;
import calculate.modifiers.DifferencePositiveModifier;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class KindergartenEquationsGenerator implements ExpressionGenerator {

  private final int amount;
  private final EquationModifier equationModifier = new DifferencePositiveModifier();

  public KindergartenEquationsGenerator(int amount) {
    this.amount = amount;
  }

  @Override
  public Set<Equation> generate() {
    Set<Equation> equations = new HashSet<>();
    IntStream.range(0, amount).forEach(i -> equations.add(
        equationModifier.modify(new IntEquation(Utils.newFactor(20), Utils.newFactor(20),
            Utils.getAnyOperator(ADD, SUB)))));
    return equations;
  }
}
