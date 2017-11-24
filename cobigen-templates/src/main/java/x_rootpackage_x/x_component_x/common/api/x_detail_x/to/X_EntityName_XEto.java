/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.common.api.x_detail_x.to;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;
import com.capgemini.cobigen.api.macro.CobiGenMacroBeans;
import com.capgemini.cobigen.api.macro.CobiGenMacroJpa;
import com.capgemini.cobigen.api.variable.CobiGenVarPojoSuperClassEto;

import x_rootpackage_x.x_component_x.common.api.x_detail_x.X_EntityName_X;

/**
 * Entity transfer object of {@link X_EntityName_X}.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.TO)
public class X_EntityName_XEto extends CobiGenVarPojoSuperClassEto implements X_EntityName_X {

  public static void $generate() { // public static $generate methods are executed by CobiGen and removed from output

    CobiGenMacroJpa.copyFieldsFromPojoWithIdRefConversion();
    CobiGenMacroBeans.addEqualsAndHashCode();
  }

}
