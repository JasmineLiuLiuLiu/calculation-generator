package org.jasmineliuliuliu.calgen;

import java.util.concurrent.ThreadLocalRandom;
import org.jasmineliuliuliu.calgen.models.Operator;

public class Utils {

  private static final ThreadLocalRandom random = ThreadLocalRandom.current();

  public static ThreadLocalRandom random() {
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

  public static Operator anyOperator() {
    return Operator.getOperator(Utils.random().nextInt(Operator.values().length));
  }

  public static Operator anyOperator(Operator... op) {
    return op[Utils.random().nextInt(op.length)];
  }

}
