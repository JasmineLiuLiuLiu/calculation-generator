package calculate.modifiers;

import calculate.expressions.Equation;

/**
 * 算式修改器，在算式上应用规则，使算式符合要求。
 *
 * @param <E> Equation的实现类
 */
public interface EquationModifier<E extends Equation> {

  boolean modifiable(E e);

  E modify(E e);
}
