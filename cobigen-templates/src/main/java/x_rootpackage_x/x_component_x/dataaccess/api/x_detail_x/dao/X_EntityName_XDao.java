package x_rootpackage_x.x_component_x.dataaccess.api.x_detail_x.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;
import com.capgemini.cobigen.api.macro.CobiGenMacroJpa;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.dataaccess.api.Dao;
import x_rootpackage_x.general.dataacess.api.dao.ApplicationDao;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.to.X_EntityName_XSearchCriteriaTo;
import x_rootpackage_x.x_component_x.dataaccess.api.x_detail_x.X_EntityName_XEntity;

/**
 * {@link Dao DAOs} for {@link X_EntityName_XEntity}.
 */
@Entity
@Table(name = "X_EntityName_X")
@CobiGenTemplate
@CobiGenIncrement(Increments.ENTITY_INFRASTRUCTURE)
public interface X_EntityName_XDao extends ApplicationDao<X_EntityName_XEntity> {

  /**
   * Finds the {@link X_EntityName_XEntity} matching the given {@link X_EntityName_XSearchCriteriaTo}.
   *
   * @param criteria is the {@link X_EntityName_XSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link X_EntityName_XEntity} objects.
   */
  @CobiGenIncrement(Increments.SEARCH_CRITERIA)
  PaginatedListTo<X_EntityName_XEntity> findX_EntityName_Xs(X_EntityName_XSearchCriteriaTo criteria);

  static void $generate() {// public static $generate methods are executed by CobiGen and removed from output

    CobiGenMacroJpa.addGettersAndSettersWithIdReferenceForEntity();
  }

}
