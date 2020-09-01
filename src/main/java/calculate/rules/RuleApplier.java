package calculate.rules;

import calculate.expressions.Expression;

public interface RuleApplier {

  boolean applicable(Expression e);

  Expression apply(Expression e);
}
