package calculate.rules;

import calculate.expressions.Expression;
import java.util.List;

public class OrderedRulesApplier implements RuleApplier {

  private final List<RuleApplier> appliers;

  public OrderedRulesApplier(List<RuleApplier> appliers) {
    this.appliers = appliers;
  }

  @Override
  public boolean applicable(Expression basicExpression) {
    return true;
  }

  @Override
  public Expression apply(Expression expression) {
    appliers.stream().sequential().forEach(applier -> {
      if (applier.applicable(expression)) {
        applier.apply(expression);
      }
    });
    return expression;
  }
}
