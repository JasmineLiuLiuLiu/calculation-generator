package calculate.expressions;

import calculate.metadata.Operator;

public interface Equation<L, R, V> {

  L getLeft();

  R getRight();

  Operator getOp();

  V result();

  String print();

  default String printAll() {
    return String.format("%s = %s", print(), result());
  }
}
