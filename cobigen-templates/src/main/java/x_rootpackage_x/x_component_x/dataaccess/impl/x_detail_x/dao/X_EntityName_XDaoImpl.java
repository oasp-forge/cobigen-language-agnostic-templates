/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.dataaccess.impl.x_detail_x.dao;

//TODO: did not see that in freemarker stuff: com.mysema.* is old "deprecated" should be replaced with com.querydsl.*
import static com.mysema.query.alias.Alias.$;
import static com.mysema.query.alias.Alias.alias;

import javax.inject.Named;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;
import com.capgemini.cobigen.api.macro.CobiGenMacroJpa;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import x_rootpackage_x.general.dataacess.base.dao.ApplicationDaoImpl;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XSearchCriteriaTo;
import x_rootpackage_x.x_component_x.dataaccess.api.x_detail_x.X_EntityName_XEntity;
import x_rootpackage_x.x_component_x.dataaccess.api.x_detail_x.dao.X_EntityName_XDao;

/**
 * Implementation of {@link X_EntityName_XDao}.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.DAO)
@Named
public class X_EntityName_XDaoImpl extends ApplicationDaoImpl<X_EntityName_XEntity> implements X_EntityName_XDao {

  /**
   * The constructor.
   */
  public X_EntityName_XDaoImpl() {

    super();
  }

  @Override
  @CobiGenIncrement(Increments.SEARCH_CRITERIA)
  public PaginatedListTo<X_EntityName_XEntity> findX_EntityName_Xs(X_EntityName_XSearchCriteriaTo criteria) {

    X_EntityName_XEntity entity = alias(X_EntityName_XEntity.class);
    EntityPathBase<X_EntityName_XEntity> alias = $(entity);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    CobiGenMacroJpa.generateSearchCriteriaQuery(); // use naming conventions for methods returning code to inject?

    return findPaginated(criteria, query, alias);
  }

  @Override
  protected Class<X_EntityName_XEntity> getEntityClass() {

    return X_EntityName_XEntity.class;
  }

}
