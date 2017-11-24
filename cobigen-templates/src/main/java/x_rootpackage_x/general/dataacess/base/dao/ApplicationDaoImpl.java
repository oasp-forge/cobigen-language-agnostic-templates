/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.general.dataacess.base.dao;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;

import io.oasp.module.jpa.dataaccess.base.AbstractDao;
import net.sf.mmm.util.entity.api.PersistenceEntity;
import x_rootpackage_x.general.dataacess.api.dao.ApplicationDao;

/**
 * This is the abstract base implementation of {@link ApplicationDao}.
 *
 * @param <ENTITY> is the {@link #getEntityClass() type} of the managed entity.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.DAO)
public abstract class ApplicationDaoImpl<ENTITY extends PersistenceEntity<Long>> extends AbstractDao<ENTITY> implements ApplicationDao<ENTITY> {

}
