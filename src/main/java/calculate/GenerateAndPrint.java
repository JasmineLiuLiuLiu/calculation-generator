package calculate;

import calculate.expressions.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateAndPrint {

  public static void main(String[] args) {
    IntStream.range(0, 10).sequential().forEach((i) -> {
      OralCalculationExpressionsGenerator og = new OralCalculationExpressionsGenerator(12);
      MulCalculationExpressionsGenerator mulg = new MulCalculationExpressionsGenerator(8);
      MixCalculationExpressionGenerator mixg = new MixCalculationExpressionGenerator(9);
      i = i + 1;
      System.out.println("\n\n\n数学计算练习 " + i);
      System.out.println("1.\t口算");
      printInFormat(og.generate(), "%s=\t\t\t%s=\t\t\t%s=\t\t\t%s=");
      System.out.println("2.\t用竖式计算带*的要验算");
      printInFormat(mulg.generate(), "%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t* %s\n\n\n\n\n");
      System.out.println("3.\t计算下列各题");
      printInFormat(mixg.generate(), "%s\t\t\t\t\t\t\t%s\t\t\t\t\t\t%s\n\n\n\n\n");
    });
//    KidCalculationExpressionsGenerator k = new KidCalculationExpressionsGenerator(100);
//    k.generate().forEach(e -> System.out.println(e));

  }

  private static void printInFormat(Set<Expression> expressions, String lineFormat) {
    int countPerLine = getSubStringCount(lineFormat, "%s");
    List<Expression> expressionList = new ArrayList<>(expressions);
    for (int i = 0; i < expressionList.toArray().length; i = i + countPerLine) {
      List<Expression> ePrintInRow = new ArrayList<>();
      for (int j = 0; j < countPerLine; j++) {
        ePrintInRow.add(expressionList.get(i + j));
      }
      System.out.println(String.format(lineFormat, ePrintInRow.stream().map(e -> e.print()).collect(
          Collectors.toList()).toArray()));
    }
  }

  private static int getSubStringCount(String s, String sub) {
    int count = 0;
    int offset = 0;
    while ((offset = s.indexOf(sub, offset)) != -1) {
      offset += sub.length();
      count++;
    }
    return count;
  }
}
