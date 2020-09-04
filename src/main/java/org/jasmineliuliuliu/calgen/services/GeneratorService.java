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

  public Set<Equation> generate3BOral(int count) {
    return generators.generate(100,10,20);
  }
}
