/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package com.capgemini.cobigen.api.macro;

import java.util.List;

import com.capgemini.cobigen.api.CobiGen;

import net.sf.mmm.code.api.CodeContext;
import net.sf.mmm.code.api.arg.CodeParameter;
import net.sf.mmm.code.api.member.CodeField;
import net.sf.mmm.code.api.member.CodeFields;
import net.sf.mmm.code.api.member.CodeMethod;
import net.sf.mmm.code.api.statement.CodeStatement;
import net.sf.mmm.code.api.type.CodeType;

/**
 * TODO: this class ...
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since dev
 */
public class CobiGenMarcoBeans {

  public static void copyFieldsFromPojo() {

    CodeFields outFields = CobiGen.out().getFields();
    for (CodeField field : CobiGen.in().getFields().getDeclared()) {
      // outFields.add(field);
      outFields.getDeclared().add(field);
    }
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

  public static String generateGettersAndSetters() {

    // TODO
    return null;
  }

  public static void generateEqualsAndHashCode() {

    generateEquals();
    generateHashCode();
  }

  public static void generateEquals() {

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

  public static void generateHashCode() {

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

    return null;
  }

}
