/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package com.capgemini.cobigen.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.capgemini.cobigen.api.template.CobiGenMerge;

/**
 * TODO clarify...
 */
@Target({ ElementType.TYPE, ElementType.PACKAGE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CobiGenTemplate {

  /**
   * @deprecated use {@link CobiGenIncrement} instead.
   */
  String increment() default "";

  // TODO: do we need to configure this at all anymore?
  CobiGenMerge merge() default CobiGenMerge.SMART;

  /**
   * @deprecated such features should be separated. Use macros or separate mix-in-templates instead.
   */
  boolean getters() default false;

  /**
   * @deprecated such features should be separated. Use macros or separate mix-in-templates instead.
   */
  boolean setters() default false;

  String option() default "";

}
