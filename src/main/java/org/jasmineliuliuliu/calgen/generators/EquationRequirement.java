package org.jasmineliuliuliu.calgen.generators;

public class EquationRequirement {

  private int minLeft;
  private int maxLeft;
  private int minRight;
  private int maxRight;
  private int minDivisor;
  private int maxDivisor;
  private int precision;
  private int times10;
  private boolean isResultPositive;
  private boolean isExactDivision;

  public EquationRequirement(EquationRequirement requirement) {
    this.minLeft = requirement.minLeft();
    this.maxLeft = requirement.maxLeft();
    this.minRight = requirement.minRight();
    this.maxRight = requirement.maxRight();
    this.minDivisor = requirement.minDivisor();
    this.maxDivisor = requirement.maxDivisor();
    this.precision = requirement.precision();
    this.times10 = requirement.times10();
    this.isExactDivision = requirement.isExactDivision;
    this.isResultPositive = requirement.isResultPositive;
  }

  private EquationRequirement(Builder builder) {
    this.minLeft = builder.minLeft;
    this.maxLeft = builder.maxLeft;
    this.minRight = builder.minRight;
    this.maxRight = builder.maxRight;
    this.minDivisor = builder.minDivisor;
    this.maxDivisor = builder.maxDivisor;
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

  public int minDivisor() {
    return minDivisor;
  }

  public int maxDivisor() {
    return maxDivisor;
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

  public void minLeft(int minLeft) {
    this.minLeft = minLeft;
  }

  public void maxLeft(int maxLeft) {
    this.maxLeft = maxLeft;
  }

  public void minRight(int minRight) {
    this.minRight = minRight;
  }

  public void maxRight(int maxRight) {
    this.maxRight = maxRight;
  }

  public void precision(int precision) {
    this.precision = precision;
  }

  public void times10(int times10) {
    this.times10 = times10;
  }

  public void resultPositive(boolean resultPositive) {
    isResultPositive = resultPositive;
  }

  public void exactDivision(boolean exactDivision) {
    isExactDivision = exactDivision;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {

    private int minLeft;
    private int maxLeft;
    private int minRight;
    private int maxRight;
    private int minDivisor;
    private int maxDivisor;
    private int precision;
    private int times10;
    private boolean isExactDivision;
    private boolean isResultPositive;

    Builder() {
      minLeft = 10;
      maxLeft = 100;
      minRight = 10;
      maxRight = 100;
      minDivisor = 2;
      maxDivisor = 10;
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

    public Builder minDivisor(int minDivisor) {
      this.minDivisor = minDivisor;
      return this;
    }

    public Builder maxDivisor(int maxDivisor) {
      this.maxDivisor = maxDivisor;
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
