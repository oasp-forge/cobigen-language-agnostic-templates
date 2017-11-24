/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.general.dataacess.api.dao;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;

import io.oasp.module.jpa.dataaccess.api.Dao;
import net.sf.mmm.util.entity.api.PersistenceEntity;

/**
 * Interface for all {@link Dao DAOs} (Data Access Object) of this application.
 *
 * @param <ENTITY> is the type of the managed entity.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.DAO)
public interface ApplicationDao<ENTITY extends PersistenceEntity<Long>> extends Dao<ENTITY> {

}
