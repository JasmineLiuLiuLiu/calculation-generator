package calculate.expressions;

import calculate.metadata.Operator;

public class FloatExpression extends BasicExpression<Float, Float, Float> {

  private final String printFormat = "%.1f%s%.1f";

  public FloatExpression(float left, float right, Operator op) {
    super(left, right, op);
  }

  @Override
  public String getPrintFormat() {
    return printFormat;
  }

  @Override
  public Float result() {
    return (Float) getOp().getCalculator().apply(getRight(), getLeft());
  }
}
