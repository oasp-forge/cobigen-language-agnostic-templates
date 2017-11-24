/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package com.capgemini.cobigen.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares the increment (group of templates/template-features) that can be selected in generation UI. Shall
 * be used on type level to opt-in/-out the entire template. Additionally shall also be used on element level
 * as feature-toggle.
 */
@Target({ ElementType.TYPE, ElementType.PACKAGE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CobiGenIncrement {

  /**
   * The increment to use. Please create a type with {@link String} constants for your increments in your
   * templates project and always reference constants here.
   */
  String value();

}
