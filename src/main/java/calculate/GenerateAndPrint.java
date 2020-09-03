package calculate;

import static calculate.metadata.Operator.ADD;
import static calculate.metadata.Operator.SUB;

import calculate.expressions.Equation;
import calculate.expressions.FloatEquation;
import calculate.generators.MixCalculationEquationGenerator;
import calculate.generators.MulCalculationExpressionsGenerator;
import calculate.generators.OralCalculationExpressionsGenerator;
import calculate.modifiers.DifferencePositiveModifier;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateAndPrint {

  public static void main(String[] args) {

//    FloatEquation f = new DifferencePositiveModifier<FloatEquation>().modify(
//        new FloatEquation(39*0.1f, 82*0.1f,ADD));
//    System.out.println(f.printAll());
    IntStream.range(0, 10).sequential().forEach((i) -> {
      OralCalculationExpressionsGenerator og = new OralCalculationExpressionsGenerator(12);
      MulCalculationExpressionsGenerator mulg = new MulCalculationExpressionsGenerator(8);
      MixCalculationEquationGenerator mixg = new MixCalculationEquationGenerator(9);
      i++;
      System.out.println("\n\n\n数学计算练习 " + i);
      System.out.println("1.\t口算。");
//      printInFormat(og.generate(), "%s=\t\t\t%s=\t\t\t%s=\t\t\t%s=");
      printAllInFormat(og.generate(), "%s\t\t\t%s\t\t\t%s\t\t\t%s");
      System.out.println("2.\t用竖式计算，带*的要验算。");
//      printInFormat(mulg.generate(), "%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t* %s\n\n\n\n\n");
      printAllInFormat(mulg.generate(), "%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t* %s\n\n\n\n\n");
      System.out.println("3.\t计算下列各题。");
//      printInFormat(mixg.generate(), "%s\t\t\t\t\t\t\t%s\t\t\t\t\t\t%s\n\n\n\n\n");
      printAllInFormat(mixg.generate(), "%s\t\t\t\t\t\t\t%s\t\t\t\t\t\t%s\n\n\n\n\n");
    });

  }


  private static void printInFormat(Set<Equation> equations, String lineFormat) {
    int countPerLine = getSubStringCount(lineFormat, "%s");
    List<Equation> equationList = new ArrayList<>(equations);
    for (int i = 0; i < equationList.toArray().length; i = i + countPerLine) {
      List<Equation> ePrintInRow = new ArrayList<>();
      for (int j = 0; j < countPerLine; j++) {
        ePrintInRow.add(equationList.get(i + j));
      }
      System.out.println(String.format(lineFormat, ePrintInRow.stream().map(e -> e.print()).collect(
          Collectors.toList()).toArray()));
    }
  }


  private static void printAllInFormat(Set<Equation> equations, String lineFormat) {
    int countPerLine = getSubStringCount(lineFormat, "%s");
    List<Equation> equationList = new ArrayList<>(equations);
    for (int i = 0; i < equationList.toArray().length; i = i + countPerLine) {
      List<Equation> ePrintInRow = new ArrayList<>();
      for (int j = 0; j < countPerLine; j++) {
        ePrintInRow.add(equationList.get(i + j));
      }
      System.out.println(String.format(lineFormat, ePrintInRow.stream().map(e -> e.printAll()).collect(
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
