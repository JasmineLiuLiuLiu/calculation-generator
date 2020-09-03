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

  public static Operator getAnyOperator() {
    return Operator.getOperator(Utils.getRandom().nextInt(Operator.values().length));
  }

  public static Operator getAnyOperator(Operator... op) {
    return op[Utils.getRandom().nextInt(op.length)];
  }

}
