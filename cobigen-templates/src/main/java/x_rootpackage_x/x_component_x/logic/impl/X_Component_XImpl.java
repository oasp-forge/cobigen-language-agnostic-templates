/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XEto;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XSearchCriteriaTo;
import x_rootpackage_x.x_component_x.logic.api.X_Component_X;
import x_rootpackage_x.x_component_x.logic.api.x_detail_x.usecase.UcFindX_EntityName_X;
import x_rootpackage_x.x_component_x.logic.api.x_detail_x.usecase.UcManageX_EntityName_X;

/**
 * Implementation of {@link X_Component_X}.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.LOGIC)
@Named
public class X_Component_XImpl implements X_Component_X {

  @Inject
  private UcFindX_EntityName_X ucFindX_EntityName_X;

  @Inject
  private UcManageX_EntityName_X ucManageX_EntityName_X;

  /**
   * The constructor.
   */
  public X_Component_XImpl() {

    super();
  }

  @Override
  public boolean deleteX_EntityName_X(Long x_entityName_xId) {

    return this.ucManageX_EntityName_X.deleteX_EntityName_X(x_entityName_xId);
  }

  @Override
  public X_EntityName_XEto saveX_EntityName_X(X_EntityName_XEto x_entityName_x) {

    return this.ucManageX_EntityName_X.saveX_EntityName_X(x_entityName_x);
  }

  @Override
  public X_EntityName_XEto findX_EntityName_X(Long id) {

    return this.ucFindX_EntityName_X.findX_EntityName_X(id);
  }

  @Override
  @CobiGenIncrement(Increments.SEARCH_CRITERIA)
  public PaginatedListTo<X_EntityName_XEto> findX_EntityName_XEtos(X_EntityName_XSearchCriteriaTo criteria) {

    return this.ucFindX_EntityName_X.findX_EntityName_XEtos(criteria);
  }

}
