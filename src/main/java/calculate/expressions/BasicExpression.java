package calculate.expressions;

import calculate.metadata.Operator;

public abstract class BasicExpression<R, L, V> implements Expression<R, L, V> {

  private R n1;
  private L n2;
  private Operator op;

  public BasicExpression(R n1, L n2, Operator op) {
    this.n1 = n1;
    this.n2 = n2;
    this.op = op;
  }

  @Override
  public R getN1() {
    return n1;
  }

  @Override
  public L getN2() {
    return n2;
  }

  @Override
  public Operator getOp() {
    return op;
  }

  public void setN1(R n1) {
    this.n1 = n1;
  }

  public void setN2(L n2) {
    this.n2 = n2;
  }

  public void setOp(Operator op) {
    this.op = op;
  }

  public abstract String getPrintFormat();

  @Override
  public String print() {
    return String.format(getPrintFormat(), n1, op.print(), n2);
  }

  @Override
  public String toString() {
    return printAll();
  }
}
