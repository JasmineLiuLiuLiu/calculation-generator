package calculate.expressions;

import static calculate.metadata.Operator.DIV;
import static calculate.metadata.Operator.SUB;

import calculate.metadata.Operator;

public class CompositeExpression implements Expression<IntExpression, Integer, Integer> {

  private final IntExpression n1;
  private Operator op;
  private Integer n2;
  private boolean shouldReversed;

  public CompositeExpression(IntExpression n1, Integer n2, Operator op) {
    this.n1 = n1;
    this.n2 = n2;
    this.op = op;
    shouldReversed = false;
  }

  @Override
  public IntExpression getN1() {
    return n1;
  }

  @Override
  public Integer getN2() {
    return n2;
  }

  @Override
  public Operator getOp() {
    return op;
  }

  public void setOp(Operator op) {
    this.op = op;
  }

  public void setN2(Integer n2) {
    this.n2 = n2;
  }

  public boolean isShouldReversed() {
    return shouldReversed;
  }

  public void setShouldReversed(boolean shouldReversed) {
    this.shouldReversed = shouldReversed;
  }

  @Override
  public Integer result() {
    if (shouldReversed) {
      return (Integer) op.getCalculator().apply(n2, n1.result());
    } else {
      return (Integer) op.getCalculator().apply(n1.result(), n2);
    }
  }

  @Override
  public String print() {
    if (shouldReversed) {
      if (op.getPriority() > n1.getOp().getPriority() || (
          op.getPriority() == n1.getOp().getPriority() && (op.equals(SUB) || op.equals(DIV)))) {
        return String.format("%d%s(%s)", n2, op.print(), n1.print());
      } else {
        return String.format("%d%s%s", n2, op.print(), n1.print());
      }
    } else {
      if (op.getPriority() > n1.getOp().getPriority()) {
        return String.format("(%s)%s%d", n1.print(), op.print(), n2);
      } else {
        return String.format("%s%s%d", n1.print(), op.print(), n2);
      }
    }
  }

  @Override
  public String toString() {
    return print();
  }
}