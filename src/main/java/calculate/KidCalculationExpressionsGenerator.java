package calculate;

import static calculate.metadata.Operator.ADD;
import static calculate.metadata.Operator.SUB;

import calculate.expressions.Expression;
import calculate.expressions.NumberExpression;
import calculate.rules.AddRuleApplier;
import calculate.rules.OrderedRulesApplier;
import calculate.rules.SubRuleApplier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class KidCalculationExpressionsGenerator implements CalculationTestingGenerator {

  private final int amount;

  public KidCalculationExpressionsGenerator(int amount) {
    this.amount = amount;
  }

  @Override
  public Set<Expression> generate() {
    Set<Expression> expressions = new HashSet<>();
    IntStream.range(0, amount).parallel().forEach(i ->
        expressions.add(
            new OrderedRulesApplier(Arrays.asList(new AddRuleApplier(), new SubRuleApplier()))
                .apply(new NumberExpression(Utils.newFactor(20), Utils.newFactor(20),
                    Utils.getAnyOperator(ADD, SUB)))));
    return expressions;
  }
}
