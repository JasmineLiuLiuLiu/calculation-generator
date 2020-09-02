package calculate.modifiers;

public class TriExpressionPriorityApplier {

}
//public class TriExpressionPriorityApplier implements IntExpressionPriorityModifier {
//
//  @Override
//  public int getPriority() {
//    return 1;
//  }
//
//  @Override
//  public boolean modifiable(Expression e) {
//    return true;
//  }
//
//  @Override
//  public Expression modify(Expression e) {
//    if (e instanceof CompositeExpression ce) {
//      adjustExpression(ce);
//    }
//    return e;
//  }
//
//  private void adjustExpression(CompositeExpression ce) {
//    IntExpression be = ce.getRight();
//    // Handle MUL
//    new MultiplierRangeIntExpressionPriorityModifier().modify(ce);
//    // Handle SUB
//    if (ce.result() < 0 && ce.getOp().equals(SUB)) {
//      ce.setShouldReversed(true);
//    }
//    //Handle DIV
//    if (ce.getOp().equals(DIV)) {
//      if (be.result() > 100) {
//        ce.setLeft(Utils.getRandom().nextInt(500, 1000));
//        ce.setOp(SUB);
//        ce.setShouldReversed(true);
//      } else if (be.result() > 10) {
//        ce.setLeft(Utils.getRandom().nextInt(10, 100));
//        ce.setOp(MUL);
//      } else {
//        ce.setLeft(Utils.getRandom().nextInt(10, 100) * be.result());
//        ce.setShouldReversed(true);
//      }
//    }
//  }
//}
