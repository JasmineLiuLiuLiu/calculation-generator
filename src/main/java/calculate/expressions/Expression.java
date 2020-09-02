package calculate.expressions;

import calculate.metadata.Operator;

public interface Expression<L, R, V extends Number> {

  L getLeft();

  R getRight();

  Operator getOp();

  V result();

  String print();

  default String printAll() {
    return String.format("%s = %d", print(), result());
  }
}
