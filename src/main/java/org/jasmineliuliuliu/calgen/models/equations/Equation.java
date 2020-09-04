package org.jasmineliuliuliu.calgen.models.equations;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.jasmineliuliuliu.calgen.models.Operator;

public interface Equation<L, R, V> {

    L getLeft();

    R getRight();

    Operator getOp();

    V result();

    @JsonInclude
    String print();

    default String printAll() {
        return String.format("%s = %s", print(), result());
    }
}
