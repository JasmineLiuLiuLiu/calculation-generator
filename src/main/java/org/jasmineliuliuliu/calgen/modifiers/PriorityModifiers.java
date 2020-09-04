package org.jasmineliuliuliu.calgen.modifiers;

import org.jasmineliuliuliu.calgen.models.equations.Equation;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityModifiers<E extends Equation> {

    private final PriorityEquationModifier[] modifiers;

    public PriorityModifiers(PriorityEquationModifier... modifiers) {
        this.modifiers = modifiers;
        Arrays.sort(modifiers, Comparator.comparingInt(PriorityEquationModifier::getPriority));
    }

    public E execute(E equation) {
        Arrays.stream(modifiers).sequential().forEach(m -> {
            if (m.modifiable(equation)) {
                m.modify(equation);
            }
        });
        return equation;
    }
}
