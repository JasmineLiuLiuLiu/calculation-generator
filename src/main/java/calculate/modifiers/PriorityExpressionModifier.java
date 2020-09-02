package calculate.modifiers;

import calculate.expressions.Expression;

public interface PriorityExpressionModifier<E extends Expression> extends ExpressionModifier<E> {

  int getPriority();
}
