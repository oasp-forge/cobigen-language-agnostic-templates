/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package com.capgemini.cobigen.api.variable;

import com.capgemini.cobigen.api.CobiGen;

import net.sf.mmm.code.api.type.CodeGenericType;

public class CobiGenVarPojoSuperClass implements CobiGenTypeVariable {

  @Override
  public String resolve() {

    CodeGenericType superClass = CobiGen.in().getSuperTypes().getSuperClass();
    if (superClass != null) {
      return superClass.getQualifiedName();
    }
    return Object.class.getName();
  }

}
