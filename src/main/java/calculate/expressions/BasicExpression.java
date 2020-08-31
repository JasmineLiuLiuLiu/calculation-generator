package calculate.expressions;

import calculate.metadata.Operator;

public abstract class BasicExpression<D extends Number> implements Expression {

  private D data1;
  private D data2;
  private Operator op;

  public BasicExpression(D data1, D data2, Operator op) {
    this.data1 = data1;
    this.data2 = data2;
    this.op = op;
  }

  public BasicExpression(BasicExpression<D> be) {
    data1 = be.getData1();
    data2 = be.getData2();
    op = be.getOp();
  }

  public D getData2() {
    return data2;
  }

  public void setData2(D data2) {
    this.data2 = data2;
  }

  public Operator getOp() {
    return op;
  }

  public void setOp(Operator op) {
    this.op = op;
  }

  public abstract String getPrintFormat();

  public D getData1() {
    return data1;
  }

  public void setData1(D data1) {
    this.data1 = data1;
  }

  public D result() {
    return (D) op.getCalculator().apply(data1, data2);
  }

  @Override
  public String print() {
    return String.format(getPrintFormat(), data1, op.print(), data2);
  }

  @Override
  public String printAll() {
    return String.format("%s = %d", print(), result());
  }

  @Override
  public String toString() {
    return printAll();
  }
}
