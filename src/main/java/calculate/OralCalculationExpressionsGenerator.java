package calculate;

import static calculate.metadata.Operator.ADD;
import static calculate.metadata.Operator.SUB;

import calculate.expressions.Expression;
import calculate.expressions.FloatExpression;
import calculate.expressions.IntExpression;
import calculate.metadata.DataType;
import calculate.rules.DivRuleApplier;
import calculate.rules.MulDivExponentRuleApplier;
import calculate.rules.OralMulRuleApplier;
import calculate.rules.OrderedRulesApplier;
import calculate.rules.SubRuleApplier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class OralCalculationExpressionsGenerator implements CalculationTestingGenerator {

  private final int amount;
  private final OrderedRulesApplier orderedRulesApplier;

  public OralCalculationExpressionsGenerator(int amount) {
    this.amount = amount;
    orderedRulesApplier = new OrderedRulesApplier(Arrays.asList(new SubRuleApplier(),
        new DivRuleApplier(), new OralMulRuleApplier(), new MulDivExponentRuleApplier()));
  }

  @Override
  public Set<Expression> generate() {
    Set<Expression> expressions = new HashSet<>();
    IntStream.range(0, amount).forEach(i -> {
      DataType dataType = DataType.getDataType(Utils.getPercentageRandom(40, 0, 1));
      switch (dataType) {
        case INT:
          expressions.add(orderedRulesApplier
              .apply(new IntExpression(Utils.newFactor(100), Utils.newFactor(100),
                  Utils.getAnyOperator())));
          break;
        case FLOAT:
          expressions.add(orderedRulesApplier.apply(
              new FloatExpression(Utils.newFactor(100) * 0.1f, Utils.newFactor(100) * 0.1f,
                  Utils.getAnyOperator(ADD, SUB))));
          break;
      }
    });
    return expressions;
  }
}
