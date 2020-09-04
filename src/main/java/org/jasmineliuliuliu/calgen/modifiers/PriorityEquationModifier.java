package org.jasmineliuliuliu.calgen.modifiers;

import org.jasmineliuliuliu.calgen.models.equations.Equation;

/**
 * 支持优先级的算式修改器。
 *
 * @param <E> Expression的实现类
 */
public interface PriorityEquationModifier<E extends Equation> extends EquationModifier<E> {

  int getPriority();
}
