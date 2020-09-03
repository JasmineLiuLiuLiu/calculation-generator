package calculate.expressions;

import calculate.metadata.Operator;

public class IntEquation extends NumberEquation<Integer> {

  private final String printFormat = "%d%s%d";

  public IntEquation(int left, int right, Operator op) {
    super(left, right, op);
  }

  @Override
  public String getPrintFormat() {
    return printFormat;
  }

  @Override
  public Integer result() {
    return (Integer) getOp().getCalculator().apply(getLeft(), getRight());
  }

}
