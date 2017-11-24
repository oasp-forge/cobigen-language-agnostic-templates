/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.logic.impl.x_detail_x.usecase;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import x_rootpackage_x.general.logic.base.AbstractUc;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XEto;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XSearchCriteriaTo;
import x_rootpackage_x.x_component_x.dataaccess.api.x_detail_x.X_EntityName_XEntity;
import x_rootpackage_x.x_component_x.dataaccess.api.x_detail_x.dao.X_EntityName_XDao;
import x_rootpackage_x.x_component_x.logic.api.x_detail_x.usecase.UcFindX_EntityName_X;

/**
 * Implementation of {@link UcFindX_EntityName_X}.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.UC)
@Named
@Validated
@Transactional
public class UcFindX_EntityName_XImpl extends AbstractUc implements UcFindX_EntityName_X {

  private static final Logger LOG = LoggerFactory.getLogger(UcFindX_EntityName_XImpl.class);

  @Inject
  private X_EntityName_XDao x_entityName_xDao;

  /**
   * The constructor.
   */
  public UcFindX_EntityName_XImpl() {

    super();
  }

  @Override
  public X_EntityName_XEto findX_EntityName_X(Long id) {

    LOG.debug("Get X_EntityName_X with id {} from database.", id);
    return getBeanMapper().map(this.x_entityName_xDao.findOne(id), X_EntityName_XEto.class);
  }

  @Override
  @CobiGenIncrement(Increments.SEARCH_CRITERIA)
  public PaginatedListTo<X_EntityName_XEto> findX_EntityName_XEtos(X_EntityName_XSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<X_EntityName_XEntity> x_entityName_xs = this.x_entityName_xDao.findX_EntityName_Xs(criteria);
    return mapPaginatedEntityList(x_entityName_xs, X_EntityName_XEto.class);
  }

}
