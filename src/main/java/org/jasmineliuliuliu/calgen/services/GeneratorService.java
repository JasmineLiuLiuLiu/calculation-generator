package org.jasmineliuliuliu.calgen.services;

import java.util.HashMap;
import java.util.Set;
import org.jasmineliuliuliu.calgen.generators.EquationRequirement;
import org.jasmineliuliuliu.calgen.generators.EquationsGenerator;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {

  @Autowired
  private HashMap<String, EquationsGenerator> generators;

  @Autowired
  EquationRequirement req;

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

  public Set<Equation> getEquations(String generatorName, int count) {
    return generators.get(generatorName).generate(count, req);
  }

}
