package calculate.expressions;

import static calculate.metadata.Operator.DIV;
import static calculate.metadata.Operator.SUB;

import calculate.metadata.Operator;

public class CompositeExpression<D extends Number> extends BasicExpression<D> {

  private final BasicExpression<D> be;
  private Operator op;
  private D data2;
  private boolean shouldReversed;

  public CompositeExpression(BasicExpression<D> be, D data2, Operator op) {
    super(be);
    this.be = be;
    this.data2 = data2;
    this.op = op;
    shouldReversed = false;
  }

  public BasicExpression<D> getBe() {
    return be;
  }

  public Operator getOp() {
    return op;
  }

  public void setOp(Operator op) {
    this.op = op;
  }

  @Override
  public D getData2() {
    return data2;
  }

  @Override
  public void setData2(D data2) {
    this.data2 = data2;
  }

  public boolean isShouldReversed() {
    return shouldReversed;
  }

  public void setShouldReversed(boolean shouldReversed) {
    this.shouldReversed = shouldReversed;
  }

  @Override
  public String getPrintFormat() {
    return null;
  }

  @Override
  public String print() {
    if (shouldReversed) {
      if (op.getPriority() > be.getOp().getPriority() || (
          op.getPriority() == be.getOp().getPriority() && (op.equals(SUB) || op.equals(DIV)))) {
        return String.format("%d%s(%s)", data2, op.print(), be.print());
      } else {
        return String.format("%d%s%s", data2, op.print(), be.print());
      }
    } else {
      if (op.getPriority() > be.getOp().getPriority()) {
        return String.format("(%s)%s%d", be.print(), op.print(), data2);
      } else {
        return String.format("%s%s%d", be.print(), op.print(), data2);
      }
    }
  }

  @Override
  public D result() {
    if (shouldReversed) {
      return (D) op.getCalculator().apply(data2, be.result());
    } else {
      return (D) op.getCalculator().apply(be.result(), data2);
    }
  }

}