/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.logic.impl.x_detail_x.usecase;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;

import x_rootpackage_x.general.logic.base.AbstractUc;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XEto;
import x_rootpackage_x.x_component_x.dataaccess.api.x_detail_x.X_EntityName_XEntity;
import x_rootpackage_x.x_component_x.dataaccess.api.x_detail_x.dao.X_EntityName_XDao;
import x_rootpackage_x.x_component_x.logic.api.x_detail_x.usecase.UcManageX_EntityName_X;

/**
 * Implementation of {@link UcManageX_EntityName_X}.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.UC)
@Named
@Validated
@Transactional
public class UcManageX_EntityName_XImpl extends AbstractUc implements UcManageX_EntityName_X {

  private static final Logger LOG = LoggerFactory.getLogger(UcManageX_EntityName_XImpl.class);

  @Inject
  private X_EntityName_XDao x_entityName_xDao;

  /**
   * The constructor.
   */
  public UcManageX_EntityName_XImpl() {

    super();
  }

  @Override
  public boolean deleteX_EntityName_X(Long x_entityName_xId) {

    X_EntityName_XEntity x_entityName_x = this.x_entityName_xDao.find(x_entityName_xId);
    if (x_entityName_x == null) {
      return false;
    }
    this.x_entityName_xDao.delete(x_entityName_x);
    LOG.debug("X_EntityName_X with id '{}' has been deleted.", x_entityName_xId);
    return true;
  }

  @Override
  public X_EntityName_XEto saveX_EntityName_X(X_EntityName_XEto x_entityName_x) {

    Objects.requireNonNull(x_entityName_x, "X_EntityName_X");

    X_EntityName_XEntity x_entityName_xEntity = getBeanMapper().map(x_entityName_x, X_EntityName_XEntity.class);

    // initialize, validate x_entityName_xEntity here if necessary
    X_EntityName_XEntity resultEntity = this.x_entityName_xDao.save(x_entityName_xEntity);
    LOG.debug("X_EntityName_X with id '{}' has been saved.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, X_EntityName_XEto.class);
  }

}
