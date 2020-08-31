package calculate.metadata;

import java.util.function.BiFunction;

public enum Operator {
  ADD(0, "+", (f1, f2) -> f1 + f2),
  SUB(0, "-", (f1, f2) -> f1 - f2),
  MUL(1, "×", (f1, f2) -> f1 * f2),
  DIV(1, "÷", (f1, f2) -> f1 / f2);


  private final int priority;
  private final String mathSymbol;
  private final BiFunction calculator;

  Operator(int priority, String mathSymbol, BiFunction<Integer, Integer, Integer> calculator) {
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
