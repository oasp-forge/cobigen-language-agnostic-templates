/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.logic.api.to;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;
import com.capgemini.cobigen.api.macro.CobiGenMarcoBeans;
import com.capgemini.cobigen.api.variable.CobiGenVarPojoSuperClassEto;

import x_rootpackage_x.x_component_x.common.api.X_EntityName_X;

/**
 * Entity transport object of $_EntityName_$
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.TO)
public class X_EntityName_XEto extends CobiGenVarPojoSuperClassEto implements X_EntityName_X {

  {
    CobiGenMarcoBeans.copyFieldsFromPojoWithIdRefConversion();
    CobiGenMarcoBeans.generateEqualsAndHashCode();
  }

}