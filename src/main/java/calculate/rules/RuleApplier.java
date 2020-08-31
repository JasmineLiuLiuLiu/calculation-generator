package calculate.rules;

import calculate.expressions.Expression;

public interface RuleApplier<E extends Expression> {

  boolean applicable(E basicExpression);

  E apply(E e);
}
