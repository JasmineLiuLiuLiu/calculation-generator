package calculate.expressions;

import calculate.metadata.Operator;

public class FloatExpression extends BasicExpression<Float> {

  private final String printFormat = "%.1f%s%.1f";

  public FloatExpression(float d1, float d2, Operator o) {
    super(d1, d2, o);
  }

  @Override
  public String getPrintFormat() {
    return printFormat;
  }

  @Override
  public Float result() {
    return null;
  }
}
