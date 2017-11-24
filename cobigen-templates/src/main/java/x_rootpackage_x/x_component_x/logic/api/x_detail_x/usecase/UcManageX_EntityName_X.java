/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.logic.api.x_detail_x.usecase;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;

import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XEto;

/**
 * Use-Case to modify instances of {@link x_rootpackage_x.x_component_x.common.api.x_detail_x.X_EntityName_X}.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.UC)
public interface UcManageX_EntityName_X {

  /**
   * @param x_entityName_xId the {@link X_EntityName_XEto#getId() id} of the
   *        {@link x_rootpackage_x.x_component_x.common.api.x_detail_x.X_EntityName_X} to delete
   * @return boolean {@code true} if the {@link x_rootpackage_x.x_component_x.common.api.x_detail_x.X_EntityName_X} has
   *         been deleted, {@code false} otherwise.
   */
  boolean deleteX_EntityName_X(Long x_entityName_xId);

  /**
   * @param x_entityName_x the {@link X_EntityName_XEto} to save (create or update).
   * @return the new {@link X_EntityName_XEto} that has been saved with ID and version.
   */
  X_EntityName_XEto saveX_EntityName_X(X_EntityName_XEto x_entityName_x);

}
