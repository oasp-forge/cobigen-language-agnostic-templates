/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.logic.api;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;

import x_rootpackage_x.x_component_x.logic.api.x_detail_x.usecase.UcFindX_EntityName_X;
import x_rootpackage_x.x_component_x.logic.api.x_detail_x.usecase.UcManageX_EntityName_X;

/**
 * Interface for x_component_x component.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.LOGIC)
public interface X_Component_X extends UcFindX_EntityName_X, UcManageX_EntityName_X {

}
