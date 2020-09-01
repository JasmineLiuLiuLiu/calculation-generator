package calculate.expressions;

import calculate.metadata.Operator;

public interface Expression<R, L, V> {

  R getN1();

  L getN2();

  Operator getOp();

  V result();

  String print();

  default String printAll() {
    return String.format("%s = %d", print(), result());
  }
}
