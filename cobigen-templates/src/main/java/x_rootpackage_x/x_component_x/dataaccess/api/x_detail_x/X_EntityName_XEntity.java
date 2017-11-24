package x_rootpackage_x.x_component_x.dataaccess.api.x_detail_x;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;
import com.capgemini.cobigen.api.macro.CobiGenMacroJpa;

import x_rootpackage_x.general.dataacess.api.ApplicationPersistenceEntity;
import x_rootpackage_x.x_component_x.common.api.x_detail_x.X_EntityName_X;

/**
 * Implementation of {@link X_EntityName_X} as {@link ApplicationPersistenceEntity}.
 */
@Entity
@Table(name = "X_EntityName_X")
@CobiGenTemplate
@CobiGenIncrement(Increments.ENTITY_INFRASTRUCTURE)
public class X_EntityName_XEntity extends ApplicationPersistenceEntity implements X_EntityName_X {

  private static final long serialVersionUID = 1L;

  public static void $generate() {// public static $generate methods are executed by CobiGen and removed from output

    CobiGenMacroJpa.addGettersAndSettersWithIdReferenceForEntity();
  }

}
