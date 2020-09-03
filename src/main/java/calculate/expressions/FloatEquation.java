package calculate.expressions;

import calculate.metadata.Operator;

public class FloatEquation extends NumberEquation<Float> {

  private final String printFormat = "%.1f%s%.1f";

  public FloatEquation(float left, float right, Operator op) {
    super(left, right, op);
  }

  @Override
  public String getPrintFormat() {
    return printFormat;
  }

  @Override
  public Float result() {
    return (Float) getOp().getCalculator().apply(getLeft(), getRight());
  }

  @Override
  public String printAll() {
    return String.format("%s = %.1f", print(), result());
  }
}
