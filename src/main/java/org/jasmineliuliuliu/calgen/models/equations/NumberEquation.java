package org.jasmineliuliuliu.calgen.models.equations;

import org.jasmineliuliuliu.calgen.models.Operator;

public abstract class NumberEquation<N extends Number> extends BasicEquation<N, N, N> {

  public NumberEquation(N left, N right, Operator op) {
    super(left, right, op);
  }
}
