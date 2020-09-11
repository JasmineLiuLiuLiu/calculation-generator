package org.jasmineliuliuliu.calgen.modifiers;

import org.jasmineliuliuliu.calgen.generators.EquationRequirement;
import org.jasmineliuliuliu.calgen.models.equations.Equation;

/**
 * 算式修改器，在算式上应用规则，使算式符合要求。
 *
 * @param <E> Equation的实现类
 */
public interface EquationModifier<E extends Equation> {

  boolean modifiable(Equation e, EquationRequirement req);

  E modify(E e, EquationRequirement req);
}
