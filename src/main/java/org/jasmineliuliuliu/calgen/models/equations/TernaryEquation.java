package org.jasmineliuliuliu.calgen.models.equations;

import static org.jasmineliuliuliu.calgen.models.Operator.DIV;
import static org.jasmineliuliuliu.calgen.models.Operator.SUB;

import org.jasmineliuliuliu.calgen.models.Operator;

public class TernaryEquation extends BasicEquation<IntEquation, Integer, Integer> {

  private boolean shouldReversed;

  public TernaryEquation(IntEquation left, Integer right, Operator op) {
    super(left, right, op);
    shouldReversed = false;
  }

  public boolean isShouldReversed() {
    return shouldReversed;
  }

  public void setShouldReversed(boolean shouldReversed) {
    this.shouldReversed = shouldReversed;
  }

  @Override
  public Integer result() {
    if (isShouldReversed()) {
      return (Integer) getOp().getCalculator().apply(getRight(), getLeft().result());
    } else {
      return (Integer) getOp().getCalculator().apply(getLeft().result(), getRight());
    }
  }

  @Override
  public String print() {
    if (isShouldReversed()) {
      if (getOp().getPriority() > getLeft().getOp().getPriority() || (
          getOp().getPriority() == getLeft().getOp().getPriority() && (getOp().equals(SUB)
              || getOp().equals(DIV)))) {
        return String.format("%d%s(%s)", getRight(), getOp().print(), getLeft().print());
      } else {
        return String.format("%d%s%s", getRight(), getOp().print(), getLeft().print());
      }
    } else {
      if (getOp().getPriority() > getLeft().getOp().getPriority()) {
        return String.format("(%s)%s%d", getLeft().print(), getOp().print(), getRight());
      } else {
        return String.format("%s%s%d", getLeft().print(), getOp().print(), getRight());
      }
    }
  }

  @Override
  public String getPrintFormat() {
    return null;
  }
}