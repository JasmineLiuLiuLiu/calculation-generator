package calculate;

import static calculate.metadata.Operator.ADD;
import static calculate.metadata.Operator.SUB;

import calculate.expressions.Expression;
import calculate.expressions.FloatExpression;
import calculate.expressions.IntExpression;
import calculate.metadata.DataType;
import calculate.modifiers.DifferencePositiveModifier;
import calculate.modifiers.ExactDivIntExpressionPriorityModifier;
import calculate.modifiers.OralMulExpressionPriorityModifier;
import calculate.modifiers.PowerOfTenPriorityModifier;
import calculate.modifiers.executor.PriorityModifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class OralCalculationExpressionsGenerator implements ExpressionGenerator {

  private final int amount;
  private final PriorityModifier priorityModifier;

  public OralCalculationExpressionsGenerator(int amount) {
    this.amount = amount;
    priorityModifier = new PriorityModifier(
        Arrays.asList(new DifferencePositiveModifier(),
            new ExactDivIntExpressionPriorityModifier(5, 100),
            new OralMulExpressionPriorityModifier(),
            new PowerOfTenPriorityModifier()));
  }

  @Override
  public Set<Expression> generate() {
    Set<Expression> expressions = new HashSet<>();
    IntStream.range(0, amount).forEach(i -> {
      DataType dataType = DataType.getDataType(Utils.getPercentageRandom(40, 0, 1));
      switch (dataType) {
        case INT:
          expressions.add(priorityModifier
              .modify(new IntExpression(Utils.newFactor(100), Utils.newFactor(100),
                  Utils.getAnyOperator())));
          break;
        case FLOAT:
          expressions.add(new DifferencePositiveModifier().modify(
              new FloatExpression(Utils.newFactor(100) * 0.1f, Utils.newFactor(100) * 0.1f,
                  Utils.getAnyOperator(ADD, SUB))));
          break;
      }
    });
    return expressions;
  }
}
