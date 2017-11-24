/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.logic.api.x_detail_x.usecase;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XEto;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XSearchCriteriaTo;

/**
 * Use-Case to find instances of {@link x_rootpackage_x.x_component_x.common.api.x_detail_x.X_EntityName_X}.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.UC)
public interface UcFindX_EntityName_X {

  /**
   * @param id The {@link X_EntityName_XEto#getId()} of the requested
   *        {@link x_rootpackage_x.x_component_x.common.api.x_detail_x.X_EntityName_X}.
   * @return the {@link X_EntityName_XEto} with given {@code id} or {@code null} if not found.
   */
  X_EntityName_XEto findX_EntityName_X(Long id);

  /**
   * @param criteria the {@link X_EntityName_XSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} of matching {@link X_EntityName_XEto}s.
   */
  PaginatedListTo<X_EntityName_XEto> findX_EntityName_XEtos(X_EntityName_XSearchCriteriaTo criteria);

}
