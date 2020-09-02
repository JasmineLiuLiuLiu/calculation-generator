package calculate.metadata;

import java.util.function.BiFunction;

public enum Operator {
  ADD(0, "+", (n1, n2) -> {
    if (n1 instanceof Integer i1 && n2 instanceof Integer i2) {
      return i1 + i2;
    } else if (n1 instanceof Float f1 && n2 instanceof Float f2) {
      return f1 + f2;
    }
    throw new UnsupportedOperationException("Parameter should be Integer or Float.");
  }),
  SUB(0, "-", (n1, n2) -> {
    if (n1 instanceof Integer i1 && n2 instanceof Integer i2) {
      return i1 - i2;
    } else if (n1 instanceof Float f1 && n2 instanceof Float f2) {
      return f1 - f2;
    }
    throw new UnsupportedOperationException("Parameter should be Integer or Float.");
  }),
  MUL(1, "×", (n1, n2) -> {
    if (n1 instanceof Integer i1 && n2 instanceof Integer i2) {
      return i1 * i2;
    } else if (n1 instanceof Float f1 && n2 instanceof Float f2) {
      return f1 * f2;
    }
    throw new UnsupportedOperationException("Parameter should be Integer or Float.");
  }),
  DIV(1, "÷", (n1, n2) -> {
    if (n1 instanceof Integer i1 && n2 instanceof Integer i2) {
      return i1 / i2;
    } else if (n1 instanceof Float f1 && n2 instanceof Float f2) {
      return f1 / f2;
    }
    throw new UnsupportedOperationException("Parameter should be Integer or Float.");
  });


  private final int priority;
  private final String mathSymbol;
  private final BiFunction<Number, Number, Number> calculator;

  Operator(int priority, String mathSymbol, BiFunction<Number, Number, Number> calculator) {
    this.priority = priority;
    this.mathSymbol = mathSymbol;
    this.calculator = calculator;
  }

  public static Operator getOperator(int i) {
    int j = i % Operator.values().length;
    Operator o = Operator.values()[j];
    return o;
  }

  public int getPriority() {
    return priority;
  }

  public String print() {
    return mathSymbol;
  }

  public BiFunction<Number, Number, Number> getCalculator() {
    return calculator;
  }
}
