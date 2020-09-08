package org.jasmineliuliuliu.calgen.services;

import java.util.Set;
import org.jasmineliuliuliu.calgen.generators.EquationsGenerator;
import org.jasmineliuliuliu.calgen.generators.IntSubEquationsGenerator;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {

  @Autowired
  private IntSubEquationsGenerator generators;

  public String getDescription(){
    return """
        小学生计算题<br>
        1. /add/{$n} - $n以内加法计算<br>
        2. /sub/{$n} - $n以内减法计算<br>
        3. /mul/{$n} - $n以内乘法计算<br>
        4. /div/{$n} - $n以内除法计算<br>
        5. /addOrSub/{$n} - $n以内加法或减法计算<br>
        6. /mulOrDiv/{$n} - $n以内乘法或除法计算<br>
        6. /mixTernary/{$n} - $n以内四则混合计算（两步）<br>
        """;
  }

  public Set<Equation> generate3BOral(int count) {
    return generators.generate(100,10,20);
  }
}
