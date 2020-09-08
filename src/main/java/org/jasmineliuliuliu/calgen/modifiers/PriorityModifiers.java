package org.jasmineliuliuliu.calgen.modifiers;

import java.util.Arrays;
import java.util.Comparator;
import org.jasmineliuliuliu.calgen.generators.EquationRequirement;
import org.jasmineliuliuliu.calgen.models.equations.Equation;

public class PriorityModifiers<E extends Equation> {

  private final PriorityEquationModifier[] modifiers;

  public PriorityModifiers(PriorityEquationModifier... modifiers) {
    this.modifiers = modifiers;
    Arrays.sort(modifiers, Comparator.comparingInt(PriorityEquationModifier::getPriority));
  }

  public E execute(E equation, EquationRequirement req) {
    Arrays.stream(modifiers).sequential().forEach(m -> {
      if (m.modifiable(equation, req)) {
        m.modify(equation, req);
      }
    });
    return equation;
  }
}
