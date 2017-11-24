package x_rootpackage_x.general.dataacess.api;

import javax.persistence.MappedSuperclass;

import x_rootpackage_x.general.common.api.ApplicationEntity;

/**
 * Abstract Entity for all Entities with an id and a version field.
 */
@MappedSuperclass
public abstract class ApplicationPersistenceEntity extends AbstractPersistenceEntity implements ApplicationEntity {

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   */
  public ApplicationPersistenceEntity() {

    super();
  }

}
