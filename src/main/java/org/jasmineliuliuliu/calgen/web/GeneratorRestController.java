package org.jasmineliuliuliu.calgen.web;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.services.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorRestController {

  @Autowired
  private GeneratorService generatorService;

  @GetMapping("/")
  public String description() {
    return generatorService.getDescription();
  }

  @GetMapping("/add/int/{count}")
  public Set<String> addInt(@PathVariable int count,
      @RequestParam(defaultValue = "false") boolean all) {
    return getEquations("intAddEquationsGenerator", count, getPrintFunc(all));
  }

  @GetMapping("/add/float/{count}")
  public Set<String> addFloat(@PathVariable int count,
      @RequestParam(defaultValue = "false") boolean all) {
    return getEquations("floatAddEquationsGenerator", count, getPrintFunc(all));
  }

  @GetMapping("/sub/int/{count}")
  public Set<String> subInt(@PathVariable int count,
      @RequestParam(defaultValue = "false") boolean all) {
    return getEquations("intSubEquationsGenerator", count, getPrintFunc(all));
  }

  @GetMapping("/sub/float/{count}")
  public Set<String> subFloat(@PathVariable int count,
      @RequestParam(defaultValue = "false") boolean all) {
    return getEquations("floatSubEquationsGenerator", count, getPrintFunc(all));

  }

  @GetMapping("/mul/int/{count}")
  public Set<String> mulInt(@PathVariable int count,
      @RequestParam(defaultValue = "false") boolean all) {
    return getEquations("intMulEquationsGenerator", count, getPrintFunc(all));
  }

  @GetMapping("/div/int/{count}")
  public Set<String> divInt(@PathVariable int count,
      @RequestParam(defaultValue = "false") boolean all) {
    return getEquations("intDivEquationsGenerator", count, getPrintFunc(all));
  }

  @GetMapping("/ter/int/{count}")
  public Set<String> terInt(@PathVariable int count,
      @RequestParam(defaultValue = "false") boolean all) {
    return getEquations("intTernaryEquationGenerator", count, getPrintFunc(all));
  }

  private Function<Equation, String> getPrintFunc(boolean isAll) {
    if (isAll) {
      return Equation::printAll;
    } else {
      return Equation::print;
    }
  }

  private Set<String> getEquations(String generatorName, int count,
      Function<Equation, String> mapFunction) {
    return generatorService.getEquations(generatorName, count)
        .stream()
        .map(mapFunction)
        .collect(Collectors.toSet());
  }
}
