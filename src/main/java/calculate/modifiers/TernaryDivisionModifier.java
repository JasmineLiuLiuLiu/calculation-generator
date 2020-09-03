package calculate.modifiers;

import static calculate.metadata.Operator.ADD;
import static calculate.metadata.Operator.DIV;
import static calculate.metadata.Operator.MUL;
import static calculate.metadata.Operator.SUB;

import calculate.Utils;
import calculate.expressions.TernaryEquation;

public class TernaryDivisionModifier implements
    PriorityExpressionModifier<TernaryEquation> {

  @Override
  public int getPriority() {
    return 1;
  }

  @Override
  public boolean modifiable(TernaryEquation e) {
    return e.getOp().equals(DIV);
  }

  @Override
  public TernaryEquation modify(TernaryEquation e) {
    int leftResult = e.getLeft().result();
    if (leftResult > 100) {
      // 如果左边等式结果大于100，无法进行除法算式的生成
      // 那么重新生成一个500到1000之间的数作为右操作数，然后把操作符变成加法或者减法
      // 再将三元等式的反向flag置成true
      e.setRight(Utils.getRandom().nextInt(500, 1000));
      e.setOp(Utils.getAnyOperator(ADD, SUB));
      if (e.result() < 0) {
        e.setShouldReversed(true);
      }
    } else if (leftResult > 10) {
      //如果左边等式结果小于100且大于10，无法进行除法算式的生成
      //那么重新生成一个10到100之间的数，再将操作符变成乘法
      e.setRight(Utils.getRandom().nextInt(10, 100));
      e.setOp(MUL);
    } else {
      // 如果左边等式结果小于10，那个此时左边等式可做除数
      // 重新生成一个10到100之间的数做商，计算出被除数，将被除数设置成右操作数
      // 再将三元等式的反向flag置成true
      e.setRight(Utils.getRandom().nextInt(10, 100) * leftResult);
      e.setShouldReversed(true);
    }
    return e;
  }

}
