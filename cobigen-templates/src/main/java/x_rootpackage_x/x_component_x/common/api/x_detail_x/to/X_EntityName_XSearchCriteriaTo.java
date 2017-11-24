/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package x_rootpackage_x.x_component_x.common.api.x_detail_x.to;

import com.capgemini.cobigen.api.Increments;
import com.capgemini.cobigen.api.annotation.CobiGenIncrement;
import com.capgemini.cobigen.api.annotation.CobiGenTemplate;
import com.capgemini.cobigen.api.macro.CobiGenMacroBeans;
import com.capgemini.cobigen.api.macro.CobiGenMacroJpa;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria}
 * {@link net.sf.mmm.util.transferobject.api.TransferObject TO} used to find
 * {@link x_rootpackage_x.x_component_x.common.api.x_detail_x.X_EntityName_X}s.
 */
@CobiGenTemplate
@CobiGenIncrement(Increments.SEARCH_CRITERIA)
public class X_EntityName_XSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   */
  public X_EntityName_XSearchCriteriaTo() {

    super();
  }

  public static void $generate() { // public static $generate methods are executed by CobiGen and removed from output

    CobiGenMacroJpa.copyFieldsFromPojoToSearchCriteria();
    CobiGenMacroBeans.addGettersAndSetters();
  }

}
