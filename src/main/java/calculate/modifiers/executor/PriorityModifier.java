package calculate.modifiers.executor;

import calculate.expressions.Expression;
import calculate.modifiers.ExpressionModifier;
import java.util.List;

//TODO: add priority support
public class PriorityModifier implements ExpressionModifier<Expression> {

  private final List<ExpressionModifier> modifiers;

  public PriorityModifier(List<ExpressionModifier> modifiers) {
    this.modifiers = modifiers;
  }

  @Override
  public boolean modifiable(Expression expression) {
    return true;
  }

  @Override
  public Expression modify(Expression expression) {
    modifiers.stream().sequential().forEach(applier -> {
      if (applier.modifiable(expression)) {
        applier.modify(expression);
      }
    });
    return expression;
  }
}
