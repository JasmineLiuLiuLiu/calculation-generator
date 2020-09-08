package org.jasmineliuliuliu.calgen.config;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.jasmineliuliuliu.calgen.generators.EquationRequirement;
import org.jasmineliuliuliu.calgen.generators.EquationsGenerator;
import org.jasmineliuliuliu.calgen.generators.tags.GeneratorTags;
import org.jasmineliuliuliu.calgen.modifiers.DifferencePositiveModifier;
import org.jasmineliuliuliu.calgen.modifiers.EquationModifier;
import org.jasmineliuliuliu.calgen.modifiers.PriorityModifiers;
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
  public HashMap<Annotation, List<EquationsGenerator>> generatorsWithTag() {
    HashMap<Annotation, List<EquationsGenerator>> generators = new HashMap<>();
    applicationContext
        .getBeansWithAnnotation(GeneratorTags.class)
        .forEach((name, g) -> {
          Arrays.stream(g.getClass().getAnnotations()).forEach(a -> {
            if (a.annotationType().getAnnotation(GeneratorTags.class) != null) {
              if (generators.get(a) == null) {
                generators.put(a, new ArrayList<>());
              }
              generators.get(a).add((EquationsGenerator) g);
            }
          });
        });
    return generators;
  }

  @Bean
  public HashMap<String, EquationsGenerator> generators() {
    HashMap<String, EquationsGenerator> generators = new HashMap<>();
    applicationContext.getBeansWithAnnotation(GeneratorTags.class).forEach((name, g) -> {
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
  public PriorityModifiers defaultModifiers(){
    return new PriorityModifiers(new DifferencePositiveModifier<>(), new TimesTenModifier());
  }


}
