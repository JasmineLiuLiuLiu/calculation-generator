package calculate.expressions;

import calculate.metadata.Operator;

public class IntExpression extends BasicExpression<Integer> {

  private final String printFormat = "%d%s%d";

  public IntExpression(int d1, int d2, Operator o) {
    super(d1, d2, o);
  }

  @Override
  public String getPrintFormat() {
    return printFormat;
  }

  @Override
  public Integer result() {
    return (Integer) getOp().getCalculator().apply(getData1(), getData2());
  }
}
