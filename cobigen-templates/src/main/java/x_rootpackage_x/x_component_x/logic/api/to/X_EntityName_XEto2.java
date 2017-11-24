/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.logic.api.to;

import java.util.Objects;

import com.capgemini.cobigen.api.annotation.CobiGenPojoFields;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;
import com.capgemini.cobigen.api.macro.CobiGenMarcoBeans;
import com.capgemini.cobigen.api.template.$_Type_$;
import com.capgemini.cobigen.api.template.CobiGenMerge;
import com.capgemini.cobigen.api.template.CobiGenPropertyType;
import com.capgemini.cobigen.api.variable.CobiGenVarPojoSuperClassEto;

import x_rootpackage_x.x_component_x.common.api.X_EntityName_X;

/**
 * Entity transport object of $_EntityName_$
 */
@CobiGenTemplate(merge = CobiGenMerge.SMART, getters = true, setters = true, option = "whatever")
public class X_EntityName_XEto2 extends CobiGenVarPojoSuperClassEto implements X_EntityName_X {

  @CobiGenPojoFields(inherit = false, source = CobiGenPropertyType.FIELD)
  private $_Type_$ $_field_$;

  {
    CobiGenMarcoBeans.copyFieldsFromPojoWithIdRefConversion();
  }

  @Override
  public boolean equals(Object obj) {

    if (obj == this) {
      return true;
    } else if (!super.equals(obj)) {
      return false;
    }
    X_EntityName_XEto2 other = (X_EntityName_XEto2) obj;
    if (!Objects.equals(this.$_field_$, other.$_field_$)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {

    return 31 * super.hashCode() + Objects.hash(this.$_field_$);
  }

}
