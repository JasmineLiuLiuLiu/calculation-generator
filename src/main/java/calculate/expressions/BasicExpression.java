package calculate.expressions;

import calculate.metadata.Operator;

public abstract class BasicExpression<L, R, V extends Number> implements Expression<L, R, V> {

  private L left;
  private R right;
  private Operator op;

  public BasicExpression(L left, R right, Operator op) {
    this.left = left;
    this.right = right;
    this.op = op;
  }

  @Override
  public L getLeft() {
    return left;
  }

  @Override
  public R getRight() {
    return right;
  }

  @Override
  public Operator getOp() {
    return op;
  }

  public void setRight(R right) {
    this.right = right;
  }

  public void setLeft(L left) {
    this.left = left;
  }

  public void setOp(Operator op) {
    this.op = op;
  }

  public abstract String getPrintFormat();

  @Override
  public String print() {
    return String.format(getPrintFormat(), left, op.print(), right);
  }

  @Override
  public String toString() {
    return printAll();
  }
}
