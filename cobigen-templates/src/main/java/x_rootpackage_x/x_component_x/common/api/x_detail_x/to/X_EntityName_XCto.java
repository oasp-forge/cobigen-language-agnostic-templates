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
 * Composite transfer object of {@link X_EntityName_X}.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.TO)
public class X_EntityName_XCto extends CobiGenVarPojoSuperClassEto implements X_EntityName_X {

  private X_EntityName_XEto x_entityName_x;

  /**
   * The constructor.
   */
  public X_EntityName_XCto() {

    super();
  }

  /**
   * The constructor.
   *
   * @param x_entityName_x the {@link X_EntityName_XEto}.
   */
  public X_EntityName_XCto(X_EntityName_XEto x_entityName_x) {

    super();
    this.x_entityName_x = x_entityName_x;
  }

  /**
   * @return the master {@link X_EntityName_XEto}.
   */
  public X_EntityName_XEto getX_EntityName_X() {

    return this.x_entityName_x;
  }

  /**
   * @param x_entityName_x the new value of {@link #getX_EntityName_X()}.
   */
  public void setX_EntityName_X(X_EntityName_XEto x_entityName_x) {

    this.x_entityName_x = x_entityName_x;
  }

  public static void $generate() { // public static $generate methods are executed by CobiGen and removed from output

    CobiGenMacroJpa.copyFieldsFromPojoToCto();
    CobiGenMacroBeans.addGettersAndSetters();
    CobiGenMacroBeans.addEqualsAndHashCode();
  }

}
