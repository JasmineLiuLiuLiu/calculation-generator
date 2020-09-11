package org.jasmineliuliuliu.calgen.generators;

import org.jasmineliuliuliu.calgen.Utils;
import org.jasmineliuliuliu.calgen.models.equations.Equation;
import org.jasmineliuliuliu.calgen.modifiers.PriorityModifiers;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractEquationsGenerator implements EquationsGenerator {

  @Autowired
  private PriorityModifiers modifiers;

  protected Equation modify(Equation e, EquationRequirement req) {
    return modifiers.execute(e, req);
  }

  protected static int iLeft(EquationRequirement req) {
    return Utils.random().nextInt(req.minLeft(), req.maxLeft());
  }

  protected static int iRight(EquationRequirement req) {
    return Utils.random().nextInt(req.minRight(), req.maxRight());
  }

  protected static int iDivisor(EquationRequirement req) {
    return Utils.random().nextInt(req.minDivisor(), req.maxDivisor());
  }

  protected static float fLeft(EquationRequirement req) {
    return Utils.random().nextInt(req.minLeft(), req.maxLeft()) / (req.precision() * 10f);
  }

  protected static float fRight(EquationRequirement req) {
    return Utils.random().nextInt(req.minRight(), req.maxRight()) / (req.precision() * 10f);
  }

  protected static String fmt(EquationRequirement req) {
    return "%." + req.precision() + "f%s%." + req.precision() + "f";
  }
}