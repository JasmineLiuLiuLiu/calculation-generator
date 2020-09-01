package calculate.expressions;

import calculate.metadata.Operator;

public class NumberExpression<N extends Number> extends BasicExpression<Number, Number, Number> {

  private final String printFormat = "%d%s%d";

  public NumberExpression(N d1, N d2, Operator o) {
    super(d1, d2, o);
  }

  @Override
  public String getPrintFormat() {
    return printFormat;
  }

  @Override
  public Number result() {
    return getOp().getCalculator().apply(getN1(), getN2());
  }
}
