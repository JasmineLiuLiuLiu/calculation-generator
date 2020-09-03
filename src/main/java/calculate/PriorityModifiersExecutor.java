package calculate;

import calculate.expressions.Equation;
import calculate.modifiers.PriorityExpressionModifier;
import java.util.Arrays;
import java.util.Comparator;

//TODO: add priority support
public class PriorityModifiersExecutor<E extends Equation> {

  private final PriorityExpressionModifier[] modifiers;

  public PriorityModifiersExecutor(PriorityExpressionModifier... modifiers) {
    this.modifiers = modifiers;
  }

  public E execute(E equation) {
    Arrays.sort(modifiers, Comparator.comparingInt(PriorityExpressionModifier::getPriority));
    Arrays.stream(modifiers).sequential().forEach(m -> {
      if (m.modifiable(equation)) {
        m.modify(equation);
      }
    });
    return equation;
  }
}
