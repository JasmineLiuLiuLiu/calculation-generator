package org.jasmineliuliuliu.calgen.generators.tags;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@GeneratorTags
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Add {

}
