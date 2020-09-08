package org.jasmineliuliuliu.calgen.web;

import java.util.Set;
import java.util.stream.Collectors;
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
    return generatorService.getDescription();
  }

  @GetMapping("/add/int/{count}")
  public Set<String> addInt(@PathVariable int count) {
    return generatorService.generateIntAddEquations(count).stream().map(e -> e.print()).collect(
        Collectors.toSet());
  }

  @GetMapping("/add/float/{count}")
  public Set<String> addFloat(@PathVariable int count) {
    return generatorService.generateFloatAddEquations(count).stream().map(e -> e.print()).collect(
        Collectors.toSet());
  }

  @GetMapping("/sub/int/{count}")
  public Set<String> subInt(@PathVariable int count) {
    return generatorService.generateIntSubEquations(count).stream().map(e -> e.print()).collect(
        Collectors.toSet());
  }

  @GetMapping("/sub/float/{count}")
  public Set<String> subFloat(@PathVariable int count) {
    return generatorService.generateFloatSubEquations(count).stream().map(e -> e.print()).collect(
        Collectors.toSet());
  }

  @GetMapping("/mul/int/{count}")
  public Set<String> mulInt(@PathVariable int count) {
    return generatorService.generateIntMulEquations(count).stream().map(e -> e.print()).collect(
        Collectors.toSet());
  }

  @GetMapping("/div/int/{count}")
  public Set<String> divInt(@PathVariable int count) {
    return generatorService.generateIntDivEquations(count).stream().map(e -> e.print()).collect(
        Collectors.toSet());
  }

  @GetMapping("/ter/int/{count}")
  public Set<String> terInt(@PathVariable int count) {
    return generatorService.generateTernaryEquations(count).stream().map(e -> e.print()).collect(
        Collectors.toSet());
  }
}
