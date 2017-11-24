/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package com.capgemini.cobigen.api.macro;

import java.util.List;
import java.util.function.Function;

import org.springframework.util.StringUtils;

import com.capgemini.cobigen.api.CobiGen;

import net.sf.mmm.code.api.CodeContext;
import net.sf.mmm.code.api.arg.CodeParameter;
import net.sf.mmm.code.api.member.CodeField;
import net.sf.mmm.code.api.member.CodeFields;
import net.sf.mmm.code.api.member.CodeMember;
import net.sf.mmm.code.api.member.CodeMethod;
import net.sf.mmm.code.api.member.CodeMethods;
import net.sf.mmm.code.api.statement.CodeStatement;
import net.sf.mmm.code.api.type.CodeGenericType;
import net.sf.mmm.code.api.type.CodeType;
import net.sf.mmm.code.base.statement.BaseTextStatement;

/**
 * Macro for Java Beans.
 */
public class CobiGenMacroBeans {

  public static void copyFieldsFromPojo() {

    CodeFields outFields = CobiGen.out().getFields();
    for (CodeField field : CobiGen.in().getFields().getDeclared()) {
      // outFields.add(field);
      outFields.getDeclared().add(field);
    }
  }

  public static void addGettersAndSetters() {

    addGettersAndSetters(CobiGen.out().getFields().getDeclared());
  }

  static void addGettersAndSetters(Iterable<? extends CodeMember> members) {

    addGettersAndSetters(members, null, null, false);
  }

  static void addGettersAndSetters(Iterable<? extends CodeMember> members, Function<CodeMember, CodeMethod> getterCustomizer,
      Function<CodeMember, CodeMethod> setterCustomizer, boolean omittDefaultIfNull) {

    CodeType outType = CobiGen.out();
    CodeMethods<?> methods = outType.getMethods();
    for (CodeMember member : members) {
      String propertyName = StringUtils.capitalize(member.getName());
      CodeGenericType type = member.getType();
      // getter
      String prefix = "get";
      if (type.asType().isBoolean()) {
        prefix = "is";
      }
      String getterName = prefix + propertyName;
      CodeMethod getter = methods.getFirst(getterName);
      if ((getter == null) && (getterCustomizer != null)) {
        getter = getterCustomizer.apply(member);
      }
      if ((getter == null) && !omittDefaultIfNull) {
        getter = methods.add(getterName);
        getter.getReturns().setType(type);
        if (outType.isClass() || outType.isEnumeration()) {
          getter.getBody().getStatements().add(new BaseTextStatement("return this." + member.getName() + ";"));
        } else {
          getter.getReturns().getDoc().merge(member.getDoc());
        }
      }
      // setter
      String setterName = "set" + propertyName;
      CodeMethod setter = methods.getFirst(setterName);
      if ((setter == null) && (setterCustomizer != null)) {
        setter = setterCustomizer.apply(member);
      }
      if ((setter == null) && !omittDefaultIfNull) {
        setter = methods.add(setterName);
        CodeParameter arg = setter.getParameters().add(member.getName());
        arg.setType(type);
        if (outType.isClass() || outType.isEnumeration()) {
          setter.getBody().getStatements().add(new BaseTextStatement("this." + member.getName() + " = " + member.getName() + ";"));
        } else {
          arg.getDoc().merge(member.getDoc());
        }
      }
    }
  }

  public static void addGettersAndSettersFromPojo() {

    addGettersAndSetters(CobiGen.in().getProperties().getDeclared());
  }

  public static void addEqualsAndHashCode() {

    addEquals();
    addHashCode();
  }

  public static void addEquals() {

    CodeType outType = CobiGen.out();
    CodeMethod equals = outType.getMethods().add("equals");
    CodeContext context = equals.getContext();
    equals.getReturns().setType(context.getType("boolean"));
    CodeParameter param = equals.getParameters().add("other");
    param.setType(context.getRootType());
    equals.getAnnotations().add(context.getType("java.lang.Override"));
    List<CodeStatement> statements = equals.getBody().getStatements();
    statements.add(statement("if (other == this) {"));
    statements.add(statement("  return true;"));
    statements.add(statement("} else if (!super.equals(other) {"));
    statements.add(statement("  return false;"));
    statements.add(statement("}"));
    statements.add(statement(outType.getSimpleName() + " o = (" + outType.getSimpleName() + ") other;"));
    for (CodeField field : outType.getFields().getDeclared()) {
      statements.add(statement("if (!Objects.equals(this." + field.getName() + ", o." + field.getName() + ") {"));
      statements.add(statement("  return false;"));
      statements.add(statement("}"));
    }
    statements.add(statement("return true;"));
  }

  public static void addHashCode() {

    CodeType outType = CobiGen.out();
    CodeMethod hashCode = outType.getMethods().add("hashCode");
    CodeContext context = hashCode.getContext();
    hashCode.getReturns().setType(context.getType("int"));
    hashCode.getAnnotations().add(context.getType("java.lang.Override"));
    List<CodeStatement> statements = hashCode.getBody().getStatements();
    StringBuilder sb = new StringBuilder("return Objects.hash(");
    String prefix = "";
    for (CodeField field : outType.getFields().getDeclared()) {
      sb.append(prefix);
      sb.append("this.");
      sb.append(field.getName());
      prefix = ", ";
    }
    sb.append(");");
    statements.add(statement(sb.toString()));
  }

  private static CodeStatement statement(String string) {

    return new BaseTextStatement(string);
  }

}
