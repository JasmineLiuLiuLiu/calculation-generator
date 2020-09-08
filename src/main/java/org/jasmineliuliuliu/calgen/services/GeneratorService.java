package org.jasmineliuliuliu.calgen.services;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.jasmineliuliuliu.calgen.generators.EquationRequirement;
import org.jasmineliuliuliu.calgen.generators.EquationsGenerator;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {

  @Autowired
  private HashMap<Annotation, List<EquationsGenerator>> generators1;
  @Autowired
  private HashMap<String, EquationsGenerator> generators;
  @Autowired
  EquationRequirement requirement;

  public String getDescription() {
    return """
        小学生计算题<br>
        - /add?min={$n}&max={$m}&count={$c}&times10=true|false&float=0|1|2&precision={$p} - 加法计算<br>
        - /sub?min={$n}&max={$m}&count={$c}&times10=true|false&float=0|1|2 - 减法计算<br>
        - /mul?min={$n}&max={$m}&count={$c}&times10=true|false - 减法计算<br>
        - /div?min={$n}&max={$m}&count={$c}&times10=true|false - 除法计算<br>
        - /addOrSub?min={$n}&max={$m}&count={$c}&times10=true|false - 加法或减法计算<br>
        - /mulOrDiv?min={$n}&max={$m}&count={$c}&10times=true|false - 乘法或除法计算<br>
        - /mixTernary?min={$n}&max={$m}&count={$c}&10times=true|false - $n以内四则混合计算（两步）<br>
        """;
  }

  public Set<Equation> generateFloatAddEquations(int count) {
    return generators.get("floatAddEquationsGenerator").generate(count, requirement);
  }
  public Set<Equation> generateFloatSubEquations(int count) {
    return generators.get("floatSubEquationsGenerator").generate(count, requirement);
  }
  public Set<Equation> generateIntAddEquations(int count) {
    return generators.get("intAddEquationsGenerator").generate(count, requirement);
  }
  public Set<Equation> generateIntSubEquations(int count) {
    return generators.get("intSubEquationsGenerator").generate(count, requirement);
  }
  public Set<Equation> generateIntMulEquations(int count) {
    return generators.get("intMulEquationsGenerator").generate(count, requirement);
  }
  public Set<Equation> generateIntDivEquations(int count) {
    return generators.get("intDivEquationsGenerator").generate(count, requirement);
  }
  public Set<Equation> generateTernaryEquations(int count) {
    return generators.get("ternaryEquationGenerator").generate(count, requirement);
  }

}
