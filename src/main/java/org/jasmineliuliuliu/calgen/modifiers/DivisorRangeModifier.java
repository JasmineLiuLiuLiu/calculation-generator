package org.jasmineliuliuliu.calgen.modifiers;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.IntEquation;
import org.jasmineliuliuliu.calgen.models.Operator;
import org.springframework.stereotype.Component;

/**
 * 除法算式修改器，修改除数的范围。
 */
public class DivisorRangeModifier implements PriorityEquationModifier<IntEquation> {

    private final int min;
    private final int max;

    public DivisorRangeModifier(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public boolean modifiable(IntEquation e) {
        return e.getOp().equals(Operator.DIV);
    }

    @Override
    public IntEquation modify(IntEquation e) {
        if (e.getRight() < min || e.getRight() >= max) {
            e.setRight(Utils.random().nextInt(min, max));
        }
        return e;
    }
}
