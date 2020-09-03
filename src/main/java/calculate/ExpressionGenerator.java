package calculate;

import calculate.expressions.Equation;
import java.util.Set;

public interface ExpressionGenerator {

  Set<Equation> generate();
}
