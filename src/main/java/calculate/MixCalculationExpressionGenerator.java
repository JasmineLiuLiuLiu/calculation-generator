package calculate;

import calculate.expressions.CompositeExpression;
import calculate.expressions.Expression;
import calculate.expressions.IntExpression;
import calculate.rules.DivRuleApplier;
import calculate.rules.MulRuleApplier;
import calculate.rules.OrderedRulesApplier;
import calculate.rules.SubRuleApplier;
import calculate.rules.TriExpressionApplier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MixCalculationExpressionGenerator implements CalculationTestingGenerator {

  private final int amount;
  private final OrderedRulesApplier orderedRulesApplier;

  public MixCalculationExpressionGenerator(int amount) {
    this.amount = amount;
    orderedRulesApplier = new OrderedRulesApplier(
        Arrays.asList(new DivRuleApplier(), new MulRuleApplier(), new SubRuleApplier()));
  }

  @Override
  public Set<Expression> generate() {
    Set<Expression> expressions = new HashSet<>();
    IntStream.range(0, amount).sequential().forEach(i -> {
      IntExpression ie0 = (IntExpression) orderedRulesApplier.apply(
          new IntExpression(Utils.newFactor(600), Utils.newFactor(600), Utils.getAnyOperator()));
      expressions.add(new TriExpressionApplier().apply(
          new CompositeExpression(ie0, Utils.newFactor(500),
              Utils.getAnyOperator())));
    });
    return expressions;
  }

}
