package calculate;

import calculate.expressions.Expression;
import java.util.Set;

public interface ExpressionGenerator {

  Set<Expression> generate();
}
