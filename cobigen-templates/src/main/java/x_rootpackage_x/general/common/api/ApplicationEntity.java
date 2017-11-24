/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.general.common.api;

import net.sf.mmm.util.entity.api.MutableGenericEntity;

/**
 * This is the abstract interface for a {@link MutableGenericEntity} of the restaurant. We are using
 * {@link Long} for all {@link #getId() primary keys}.
 */
public abstract interface ApplicationEntity extends MutableGenericEntity<Long> {

}
