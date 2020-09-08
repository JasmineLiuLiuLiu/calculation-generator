package org.jasmineliuliuliu.calgen.web;

import java.util.Set;
import java.util.stream.Collectors;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.services.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorRestController {

  @Autowired
  private GeneratorService generatorService;

  @GetMapping("/")
  public String description() {
    return "";
  }

  @GetMapping("/3b/oral/{count}")
  public Set<String> get3bOral(@PathVariable int count) {
    return generatorService.generate3BOral(count).stream().map(Equation::print)
        .collect(Collectors.toSet());
  }
}
