package calculate.modifiers;

import calculate.expressions.Expression;

public interface ExpressionModifier<E extends Expression> {

  boolean modifiable(E e);

  E modify(E e);
}
