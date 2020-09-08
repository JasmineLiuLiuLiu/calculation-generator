package org.jasmineliuliuliu.calgen.generators;

public class EquationRequirement {

  private final int minLeft;
  private final int maxLeft;
  private final int minRight;
  private final int maxRight;
  private final int precision;
  private final int times10;
  private final boolean isResultPositive;
  private final boolean isExactDivision;

  private EquationRequirement(Builder builder) {
    this.minLeft = builder.minLeft;
    this.maxLeft = builder.maxLeft;
    this.minRight = builder.minRight;
    this.maxRight = builder.maxRight;
    this.precision = builder.precision;
    this.times10 = builder.times10;
    this.isExactDivision = builder.isExactDivision;
    this.isResultPositive = builder.isResultPositive;
  }

  public int minLeft() {
    return minLeft;
  }

  public int maxLeft() {
    return maxLeft;
  }

  public int minRight() {
    return minRight;
  }

  public int maxRight() {
    return maxRight;
  }

  public int precision() {
    return precision;
  }

  public int times10() {
    return times10;
  }

  public boolean isExactDivision() {
    return isExactDivision;
  }

  public boolean isResultPositive() {
    return isResultPositive;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private int minLeft;
    private int maxLeft;
    private int minRight;
    private int maxRight;
    private int precision;
    private int times10;
    private boolean isExactDivision;
    private boolean isResultPositive;

    Builder() {
      minLeft = 10;
      maxLeft = 100;
      minRight = 10;
      maxRight = 100;
      precision = 1;
      times10 = 2;
      isExactDivision = true;
      isResultPositive = true;
    }

    public Builder minLeft(int minLeft) {
      this.minLeft = minLeft;
      return this;
    }

    public Builder maxLeft(int maxLeft) {
      this.maxLeft = maxLeft;
      return this;
    }

    public Builder minRight(int minRight) {
      this.minRight = minRight;
      return this;
    }

    public Builder maxRight(int maxRight) {
      this.maxRight = maxRight;
      return this;
    }

    public Builder precision(int precision) {
      this.precision = precision;
      return this;
    }

    public Builder exactDivision(boolean exactDivision) {
      isExactDivision = exactDivision;
      return this;
    }

    public Builder times10(int times10) {
      this.times10 = times10;
      return this;
    }

    public Builder resultPositive(boolean resultPositive) {
      isResultPositive = resultPositive;
      return this;
    }

    public EquationRequirement build() {
      return new EquationRequirement(this);
    }

  }
}
