package org.jasmineliuliuliu.calgen.models.equations;

import org.jasmineliuliuliu.calgen.models.Operator;

public abstract class BasicEquation<L, R, V> implements Equation<L, R, V> {

  private L left;
  private R right;
  private Operator op;

  public BasicEquation(L left, R right, Operator op) {
    this.left = left;
    this.right = right;
    this.op = op;
  }

  @Override
  public L getLeft() {
    return left;
  }

  public void setLeft(L left) {
    this.left = left;
  }

  @Override
  public R getRight() {
    return right;
  }

  public void setRight(R right) {
    this.right = right;
  }

  @Override
  public Operator getOp() {
    return op;
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
