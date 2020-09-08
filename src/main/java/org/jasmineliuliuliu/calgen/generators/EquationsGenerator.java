package org.jasmineliuliuliu.calgen.generators;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.jasmineliuliuliu.calgen.models.equations.Equation;

public interface EquationsGenerator {

  Equation generateOne(EquationRequirement requirement);

  default Set<Equation> generate(int count, EquationRequirement requirement) {
    return IntStream.range(0, count)
        .mapToObj(i -> generateOne(requirement))
        .collect(Collectors.toSet());
  }
}
