package calculate.modifiers;

import calculate.expressions.Equation;

/**
 * 支持优先级的算式修改器。
 *
 * @param <E> Expression的实现类
 */
public interface PriorityExpressionModifier<E extends Equation> extends EquationModifier<E> {

  int getPriority();
}
