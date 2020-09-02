package calculate;

import calculate.expressions.Expression;
import java.util.HashSet;
import java.util.Set;

//TODO: modify
public class MixCalculationExpressionGenerator implements ExpressionGenerator {

  private final int amount;
//  private final PriorityModifierExecutor priorityModifierExecutor;

  public MixCalculationExpressionGenerator(int amount) {
    this.amount = amount;
//    priorityModifierExecutor = new PriorityModifierExecutor(
//        Arrays.asList(new ExactDivIntExpressionPriorityModifier(), new MultiplierRangeIntExpressionPriorityModifier(), new DifferencePositiveModifier()));
  }

  @Override
  public Set<Expression> generate() {
    Set<Expression> expressions = new HashSet<>();
//    IntStream.range(0, amount).sequential().forEach(i -> {
//      IntExpression ie0 = (IntExpression) priorityModifierExecutor.execute(
//          new IntExpression(Utils.newFactor(600), Utils.newFactor(600), Utils.getAnyOperator()));
//      expressions.add(new TriExpressionPriorityApplier().e(
//          new CompositeExpression(ie0, Utils.newFactor(500),
//              Utils.getAnyOperator())));
//    });
    return expressions;
  }

}
