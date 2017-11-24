/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package com.capgemini.cobigen.api.variable;

import com.capgemini.cobigen.api.CobiGen;

import net.sf.mmm.code.api.type.CodeGenericType;
import x_rootpackage_x.general.common.api.ApplicationEntity;
import x_rootpackage_x.general.common.api.to.AbstractEto;

public class CobiGenVarPojoSuperClassEto extends AbstractEto implements CobiGenTypeVariable, ApplicationEntity {

  @Override
  public String resolve() {

    CodeGenericType superClass = CobiGen.in().getSuperTypes().getSuperClass();
    if ((superClass == null) || (superClass.getQualifiedName().equals("java.lang.Object"))) {
      return AbstractEto.class.getName();
    }
    String qualifiedName = superClass.getQualifiedName();
    if (qualifiedName.endsWith("Entity")) {
      qualifiedName = qualifiedName.substring(0, qualifiedName.length() - "Entity".length());
    }
    qualifiedName = qualifiedName + "Eto";
    return qualifiedName.replace(".dataaccess.", ".common.");
  }

}
