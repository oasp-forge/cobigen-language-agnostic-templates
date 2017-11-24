/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.common.api.x_detail_x;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;
import com.capgemini.cobigen.api.macro.CobiGenMacroJpa;

import x_rootpackage_x.general.common.api.ApplicationEntity;

/**
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.ENTITY_INFRASTRUCTURE)
public interface X_EntityName_X extends ApplicationEntity {

  static void $generate() { // public static $generate methods are executed by CobiGen and removed from output

    CobiGenMacroJpa.addGettersAndSettersWithIdReferenceForEto();
  }

}
