/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package com.capgemini.cobigen.api.macro;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.capgemini.cobigen.api.CobiGen;

import net.sf.mmm.code.api.arg.CodeParameter;
import net.sf.mmm.code.api.member.CodeField;
import net.sf.mmm.code.api.member.CodeFields;
import net.sf.mmm.code.api.member.CodeMember;
import net.sf.mmm.code.api.member.CodeMethod;
import net.sf.mmm.code.api.type.CodeGenericType;
import net.sf.mmm.code.api.type.CodeType;
import net.sf.mmm.code.base.statement.BaseTextStatement;
import net.sf.mmm.util.io.api.IoMode;
import net.sf.mmm.util.io.api.RuntimeIoException;

/**
 * Macro for JPA.
 */
public class CobiGenMacroJpa {

  public static void addGettersAndSettersWithIdReferenceForEntity() {

    CobiGenMacroBeans.addGettersAndSetters();
    CobiGenMacroBeans.addGettersAndSetters(CobiGen.in().getProperties().getDeclared(), CobiGenMacroJpa::idGetter, CobiGenMacroJpa::idSetter, true);
  }

  public static void addGettersAndSettersWithIdReferenceForEto() {

    CobiGenMacroBeans.addGettersAndSetters(CobiGen.in().getProperties().getDeclared(), CobiGenMacroJpa::idGetter, CobiGenMacroJpa::idSetter, false);
  }

  public static void addGettersAndSettersWithIdReferenceForInterface() {

    CobiGenMacroBeans.addGettersAndSetters(CobiGen.in().getProperties().getDeclared(), CobiGenMacroJpa::idGetter, CobiGenMacroJpa::idSetter, false);
  }

  private static CodeMethod idGetter(CodeMember member) {

    CodeGenericType type = member.getType();
    if (type.getSimpleName().endsWith("Entity")) {
      CodeType outType = CobiGen.out();
      CodeMethod getter = outType.getMethods().add("get" + StringUtils.capitalize(member.getName()) + "Id");
      getter.getReturns().setType(outType.getContext().getType("java.lang.Long"));
      if (outType.isClass() || outType.isEnumeration()) {
        getter.getBody().getStatements().add(new BaseTextStatement("return this." + member.getName() + "Id;"));
      } else {
        getter.getReturns().getDoc().merge(member.getDoc());
      }
      return getter;
    }
    return null;
  }

  private static CodeMethod idSetter(CodeMember member) {

    CodeGenericType type = member.getType();
    if (type.getSimpleName().endsWith("Entity")) {
      CodeType outType = CobiGen.out();
      CodeMethod setter = outType.getMethods().add("set" + StringUtils.capitalize(member.getName()) + "Id");
      CodeParameter arg = setter.getParameters().add(member.getName());
      arg.setType(outType.getContext().getType("java.lang.Long"));
      if (outType.isClass() || outType.isEnumeration()) {
        setter.getBody().getStatements().add(new BaseTextStatement("this." + member.getName() + " = " + member.getName() + ";"));
      } else {
        arg.getDoc().merge(member.getDoc());
      }
      return setter;
    }
    return null;
  }

  public static void copyFieldsFromPojoToSearchCriteria() {

    copyFieldsFromPojoWithIdRefConversion();
  }

  public static void copyFieldsFromPojoWithIdRefConversion() {

    CodeFields outFields = CobiGen.out().getFields();
    for (CodeField field : CobiGen.in().getFields().getDeclared()) {
      field = field.copy(outFields);
      if (field.getType().getSimpleName().endsWith("Entity")) {
        field.setType(field.getContext().getType("java.lang.Long"));
        field.setName(field.getName() + "Id");
      }
      // outFields.add(field);
      outFields.getDeclared().add(field);
    }
  }

  public static void copyFieldsFromPojoToCto() {

    CodeFields outFields = CobiGen.out().getFields();
    for (CodeField field : CobiGen.in().getFields().getDeclared()) {
      if (field.getType().getSimpleName().endsWith("Entity")) {
        field = field.copy(outFields);
        String etoTypeName = field.getType().getQualifiedName();
        etoTypeName = etoTypeName.substring(0, etoTypeName.length() - "Entity".length()) + "Eto";
        // for this type resolution, CobiGen.in() has to refer to an already resolved template set so the
        // context can actually find this type, further the generating project with its dependencies has to be
        // on the classpath of cobigen during execution.
        field.setType(field.getContext().getType(etoTypeName));
        // outFields.add(field);
        outFields.getDeclared().add(field);
      }
      // TODO also handle collections... (N:M)
    }
  }

  /**
   * TODO: javadoc
   */
  public static String generateSearchCriteriaQuery() {

    StringBuilder sb = new StringBuilder();
    for (CodeField field : CobiGen.in().getFields().getDeclared()) {
      CodeGenericType type = field.getType();
      CodeType rawType = type.asType();
      String fieldName = field.getName();
      String propertyName = StringUtils.capitalize(fieldName);
      if (rawType.isPrimitive()) {
        String prefix;
        if (rawType.isBoolean()) {
          prefix = "is";
        } else {
          prefix = "get";
        }
        sb.append("query.where($(entity.");
        sb.append(prefix);
        sb.append(propertyName);
        sb.append("()).eq(criteria.");
        sb.append(prefix);
        sb.append(propertyName);
        sb.append("());");
      } else {
        if (rawType.getSimpleName().endsWith("Entity")) {
          propertyName = propertyName + "Id";
          fieldName = fieldName + "Id";
          sb.append("Long");
        } else {
          CobiGen.out().getFile().getImports().add(rawType);
          try {
            type.writeReference(sb, true);
          } catch (IOException e) {
            throw new RuntimeIoException(e, IoMode.WRITE);
          }
        }
        sb.append(" ");
        sb.append(fieldName);
        sb.append(" = criteria.get");
        sb.append(propertyName);
        sb.append("();\n");
        sb.append("if (");
        sb.append(propertyName);
        sb.append(" != null) {\n");
        sb.append("  query.where($(entity.get");
        sb.append(propertyName);
        sb.append("()).eq(");
        sb.append(fieldName);
        sb.append("));\n");
        sb.append("}\n");
      }
    }
    return sb.toString();
  }

}
