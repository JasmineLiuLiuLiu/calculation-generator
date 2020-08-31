package calculate;

import static calculate.metadata.Operator.MUL;

import calculate.expressions.Expression;
import calculate.expressions.IntExpression;
import calculate.rules.MulRuleApplier;
import calculate.rules.OrderedRulesApplier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MulCalculationExpressionsGenerator implements CalculationTestingGenerator {

  private static final int factorBound = 100;
  private final int amount;
  private final OrderedRulesApplier orderedRulesApplier;

  public MulCalculationExpressionsGenerator(int amount) {
    this.amount = amount;
    orderedRulesApplier = new OrderedRulesApplier(Arrays.asList(new MulRuleApplier()));
  }

  @Override
  public Set<Expression> generate() {
    Set<Expression> expressions = new HashSet<>();
    IntStream.range(0, amount).forEach(i -> expressions.add(orderedRulesApplier.apply(
        new IntExpression(Utils.newFactor(factorBound), Utils.newFactor(factorBound), MUL))));
    return expressions;
  }
}
