package calculate;

import static calculate.metadata.Operator.ADD;
import static calculate.metadata.Operator.SUB;

import calculate.expressions.Expression;
import calculate.expressions.IntExpression;
import calculate.modifiers.ExpressionModifier;
import calculate.modifiers.DifferencePositiveModifier;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class KidCalculationExpressionsGenerator implements ExpressionGenerator {

  private final int amount;
  private final ExpressionModifier expressionModifier = new DifferencePositiveModifier();

  public KidCalculationExpressionsGenerator(int amount) {
    this.amount = amount;
  }

  @Override
  public Set<Expression> generate() {
    Set<Expression> expressions = new HashSet<>();
    IntStream.range(0, amount).forEach(i -> expressions.add(
        expressionModifier.modify(new IntExpression(Utils.newFactor(20), Utils.newFactor(20),
            Utils.getAnyOperator(ADD, SUB)))));
    return expressions;
  }
}
