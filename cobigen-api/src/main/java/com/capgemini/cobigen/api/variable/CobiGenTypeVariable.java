/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package com.capgemini.cobigen.api.variable;

/**
 * A {@link CobiGenTypeVariable} is a regular Java type that acts as a variable placeholder that will be
 * resolved during template resolution.
 */
public interface CobiGenTypeVariable {

  /**
   * @return the qualified name of the resulting type. CobiGen will automatically add an import statement for
   *         it and then use the simple name in the replacement.
   */
  String resolve();

}
