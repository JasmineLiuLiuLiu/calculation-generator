package calculate.rules;

import calculate.expressions.Expression;

public abstract class AbstractRuleApplier<D extends Expression> implements RuleApplier<D> {

  public abstract int getPriority();
}
