package calculate;

import static calculate.metadata.Operator.MUL;

import calculate.expressions.Expression;
import calculate.expressions.IntExpression;
import calculate.modifiers.MultiplierRangeIntExpressionPriorityModifier;
import calculate.modifiers.executor.PriorityModifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MulCalculationExpressionsGenerator implements ExpressionGenerator {

  private static final int factorBound = 100;
  private final int amount;
  private final PriorityModifier priorityModifier;

  public MulCalculationExpressionsGenerator(int amount) {
    this.amount = amount;
    priorityModifier = new PriorityModifier(
        Arrays.asList(new MultiplierRangeIntExpressionPriorityModifier(10, 100)));
  }

  @Override
  public Set<Expression> generate() {
    Set<Expression> expressions = new HashSet<>();
    IntStream.range(0, amount).forEach(i -> expressions.add(priorityModifier.modify(
        new IntExpression(Utils.newFactor(factorBound), Utils.newFactor(factorBound), MUL))));
    return expressions;
  }
}
