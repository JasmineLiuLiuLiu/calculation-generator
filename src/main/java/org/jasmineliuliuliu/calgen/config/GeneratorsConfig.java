package org.jasmineliuliuliu.calgen.config;

import java.util.HashMap;
import org.jasmineliuliuliu.calgen.generators.EquationRequirement;
import org.jasmineliuliuliu.calgen.generators.EquationsGenerator;
import org.jasmineliuliuliu.calgen.generators.Generator;
import org.jasmineliuliuliu.calgen.modifiers.DifferencePositiveModifier;
import org.jasmineliuliuliu.calgen.modifiers.PriorityModifiers;
import org.jasmineliuliuliu.calgen.modifiers.TernaryDivisionModifier;
import org.jasmineliuliuliu.calgen.modifiers.TimesTenModifier;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorsConfig implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Bean
  public HashMap<String, EquationsGenerator> generators() {
    HashMap<String, EquationsGenerator> generators = new HashMap<>();
    applicationContext.getBeansWithAnnotation(Generator.class).forEach((name, g) -> {
      if (g instanceof EquationsGenerator eg) {
        generators.put(name, eg);
      }
    });
    return generators;
  }

  @Bean
  public EquationRequirement defaultEquationRequirement() {
    return EquationRequirement.builder().build();
  }

  @Bean
  public PriorityModifiers defaultModifiers() {
    return new PriorityModifiers(new DifferencePositiveModifier<>(), new TimesTenModifier(),
        new TernaryDivisionModifier());
  }


}
