/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package AbstractUc.java;

import javax.inject.Inject;

import io.oasp.module.beanmapping.common.api.BeanMapper;

/**
 * Abstract base class providing access to the {@link BeanMapper}.
 */
public class AbstractBeanMapperSupport {

  @Inject
  private BeanMapper beanMapper;

  /**
   * @return the {@link BeanMapper} instance.
   */
  protected BeanMapper getBeanMapper() {

    return this.beanMapper;
  }

}
