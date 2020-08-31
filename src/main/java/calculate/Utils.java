package calculate;

import calculate.metadata.Operator;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

  private static final ThreadLocalRandom random = ThreadLocalRandom.current();

  public static ThreadLocalRandom getRandom() {
    return random;
  }

  public static int getPercentageRandom(int percentage, int defaultValue, int otherValue) {
    int a = random.nextInt(100);
    if (a > percentage) {
      a = defaultValue;
    } else {
      a = otherValue;
    }
    return a;
  }

  public static int newFactor(int bound) {
    return random.nextInt(10, bound);
  }

  public static Number max(Number n1, Number n2) {
    if (n1 instanceof Integer i1 && n2 instanceof Integer i2) {
      return Math.max(i1, i2);
    } else if (n1 instanceof Float f1 && n2 instanceof Float f2) {
      return Math.max(f1, f2);
    } else {
      return null;
    }
  }

  public static Number min(Number n1, Number n2) {
    if (n1 instanceof Integer i1 && n2 instanceof Integer i2) {
      return Math.min(i1, i2);
    } else if (n1 instanceof Float f1 && n2 instanceof Float f2) {
      return Math.min(f1, f2);
    } else {
      return null;
    }
  }

  public static Operator getAnyOperator() {
    return Operator.getOperator(Utils.getRandom().nextInt(Operator.values().length));
  }

  public static Operator getAnyOperator(Operator... op) {
    return op[Utils.getRandom().nextInt(op.length)];
  }

}
