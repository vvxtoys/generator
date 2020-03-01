/**
 *    Copyright 2006-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.model;

import com.mysql.jdbc.StringUtils;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.config.PropertyRegistry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mybatis.generator.internal.util.JavaBeansUtil.getGetterMethodName;
import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

public class ExampleGenerator extends AbstractJavaGenerator {

    public ExampleGenerator(String project) {
        super(project);
    }

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
        progressCallback.startTask(getString(
                "Progress.6", table.toString())); //$NON-NLS-1$
        CommentGenerator commentGenerator = context.getCommentGenerator();

        String associate = introspectedTable.getTableConfiguration().getProperty(PropertyRegistry.TABLE_ASSOCIATE);
        boolean useAssociate = false;
        if (!StringUtils.isNullOrEmpty(associate)) {
            useAssociate = Boolean.parseBoolean(associate);
        }

        FullyQualifiedJavaType type = new FullyQualifiedJavaType(
                introspectedTable.getExampleType());
        TopLevelClass topLevelClass = new TopLevelClass(type);
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        commentGenerator.addJavaFileComment(topLevelClass);

        // add default constructor
        Method method = new Method(type.getShortName());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setConstructor(true);
        if (context.isJava8Targeted()) {
            method.addBodyLine("oredCriteria = new ArrayList<>();"); //$NON-NLS-1$
            if (useAssociate) {
                method.addBodyLine("associationCriteria = new ArrayList<>();");
            }
        } else {
            method.addBodyLine("oredCriteria = new ArrayList<Criteria>();"); //$NON-NLS-1$
            if (useAssociate) {
                method.addBodyLine("associationCriteria = new ArrayList<AssociationCriteria>();");
            }
        }

        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        if (useAssociate) {
            Field field = new Field("tableName", FullyQualifiedJavaType.getStringInstance()); //$NON-NLS-1$
            field.setVisibility(JavaVisibility.PROTECTED);
            commentGenerator.addFieldComment(field, introspectedTable);
            field.setInitializationString("\"" + introspectedTable.getTableConfiguration().getTableName() + "\"");
            topLevelClass.addField(field);
        }

        // add field, getter, setter for orderby clause
        Field field = new Field("orderByClause", FullyQualifiedJavaType.getStringInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PROTECTED);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        method = new Method("setOrderByClause"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "orderByClause")); //$NON-NLS-1$
        if (useAssociate) {
            method.addBodyLine("this.orderByClause = appendTableName(orderByClause);"); //$NON-NLS-1$
        }else {
            method.addBodyLine("this.orderByClause = orderByClause;"); //$NON-NLS-1$
        }
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method("getOrderByClause"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());
        method.addBodyLine("return orderByClause;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        // add field, getter, setter for groupby clause
        field = new Field("groupByClause", FullyQualifiedJavaType.getStringInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PROTECTED);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        method = new Method("setGroupByClause"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "groupByClause")); //$NON-NLS-1$
        if (useAssociate) {
            method.addBodyLine("this.groupByClause = appendTableName(groupByClause);"); //$NON-NLS-1$
        }else {
            method.addBodyLine("this.groupByClause = groupByClause;"); //$NON-NLS-1$
        }
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method("getGroupByClause"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());
        method.addBodyLine("return groupByClause;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        // add field, getter, setter for dynamicColumn clause
        field = new Field("dynamicFields", FullyQualifiedJavaType.getStringInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PROTECTED);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        method = new Method("setDynamicFields"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "dynamicFields")); //$NON-NLS-1$
        if (useAssociate) {
            method.addBodyLine("this.dynamicFields = appendTableName(dynamicFields);"); //$NON-NLS-1$
        }else {
            method.addBodyLine("this.dynamicFields = dynamicFields;"); //$NON-NLS-1$
        }
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method("getDynamicFields"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());
        method.addBodyLine("return dynamicFields;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);


        // add field, getter, setter for distinct
        field = new Field("distinct", FullyQualifiedJavaType.getBooleanPrimitiveInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PROTECTED);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        method = new Method("setDistinct"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getBooleanPrimitiveInstance(), "distinct")); //$NON-NLS-1$
        method.addBodyLine("this.distinct = distinct;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method("isDistinct"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType
                .getBooleanPrimitiveInstance());
        method.addBodyLine("return distinct;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        // add field and methods for the list of ored criteria
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(
                "java.util.List<Criteria>"); //$NON-NLS-1$
        field = new Field("oredCriteria", fqjt); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PROTECTED);

        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        method = new Method("getOredCriteria"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(fqjt);
        method.addBodyLine("return oredCriteria;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        if (useAssociate) {
            // add field and methods for the list of association criteria
            fqjt = new FullyQualifiedJavaType(
                    "java.util.List<AssociationCriteria>"); //$NON-NLS-1$
            field = new Field("associationCriteria", fqjt); //$NON-NLS-1$
            field.setVisibility(JavaVisibility.PROTECTED);

            commentGenerator.addFieldComment(field, introspectedTable);
            topLevelClass.addField(field);

            method = new Method("getAssociationCriteria"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(fqjt);
            method.addBodyLine("return associationCriteria;"); //$NON-NLS-1$
            commentGenerator.addGeneralMethodComment(method, introspectedTable);
            topLevelClass.addMethod(method);
        }
        method = new Method("or"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getCriteriaInstance(), "criteria")); //$NON-NLS-1$
        method.addBodyLine("oredCriteria.add(criteria);"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method("or"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        method.addBodyLine("Criteria criteria = createCriteriaInternal();"); //$NON-NLS-1$
        method.addBodyLine("oredCriteria.add(criteria);"); //$NON-NLS-1$
        method.addBodyLine("return criteria;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method("createCriteria"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        method.addBodyLine("Criteria criteria = createCriteriaInternal();"); //$NON-NLS-1$
        method.addBodyLine("if (oredCriteria.size() == 0) {"); //$NON-NLS-1$
        method.addBodyLine("oredCriteria.add(criteria);"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$
        method.addBodyLine("return criteria;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        if (useAssociate) {
            method = new Method("createAssociationCriteria"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(FullyQualifiedJavaType.getNewAssociationCriteriaInstance());
            method.addBodyLine("AssociationCriteria criteria = createAssociationCriteriaInternal();"); //$NON-NLS-1$
            method.addBodyLine("if (associationCriteria.size() == 0) {"); //$NON-NLS-1$
            method.addBodyLine("associationCriteria.add(criteria);"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
            method.addBodyLine("return criteria;"); //$NON-NLS-1$
            commentGenerator.addGeneralMethodComment(method, introspectedTable);
            topLevelClass.addMethod(method);
        }

        method = new Method("createCriteriaInternal"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        method.addBodyLine("Criteria criteria = new Criteria();"); //$NON-NLS-1$
        method.addBodyLine("return criteria;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        if (useAssociate) {
            method = new Method("createAssociationCriteriaInternal"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PROTECTED);
            method.setReturnType(FullyQualifiedJavaType.getNewAssociationCriteriaInstance());
            method.addBodyLine("AssociationCriteria criteria = new AssociationCriteria();"); //$NON-NLS-1$
            method.addBodyLine("return criteria;"); //$NON-NLS-1$
            commentGenerator.addGeneralMethodComment(method, introspectedTable);
            topLevelClass.addMethod(method);
        }

        method = new Method("clear"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addBodyLine("oredCriteria.clear();"); //$NON-NLS-1$
        if (useAssociate) {
            method.addBodyLine("associationCriteria.clear();");
        }
        method.addBodyLine("orderByClause = null;"); //$NON-NLS-1$
        method.addBodyLine("distinct = false;"); //$NON-NLS-1$
        method.addBodyLine("groupByClause = null;");
        method.addBodyLine("dynamicFields = null;");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        if (useAssociate) {
            method = new Method("appendTableName"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PRIVATE);
            method.setReturnType(FullyQualifiedJavaType.getStringInstance());
            method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "str")); //$NON-NLS-1$
            method.addBodyLine("StringBuilder sb = new StringBuilder();");
            method.addBodyLine("if (str != null) {");
            method.addBodyLine("String[] fields = str.split(\",\");");
            method.addBodyLine("for (String field:fields) {");
            method.addBodyLine("sb.append(\",\");");
            method.addBodyLine("if (!field.contains(\".\")) {");
            method.addBodyLine("sb.append(tableName);");
            method.addBodyLine("sb.append(\".\");");
            method.addBodyLine("sb.append(field);");
            method.addBodyLine("}else {");
            method.addBodyLine("sb.append(field);");
            method.addBodyLine("}");
            method.addBodyLine("}");
            method.addBodyLine("}");
            method.addBodyLine("return sb.substring(1);");
            commentGenerator.addGeneralMethodComment(method, introspectedTable);
            topLevelClass.addMethod(method);
        }

        // now generate the inner class that holds the AND conditions
        topLevelClass.addInnerClass(getGeneratedCriteriaInnerClass(topLevelClass,FullyQualifiedJavaType
                        .getGeneratedCriteriaInstance()));
        topLevelClass.addInnerClass(getCriteriaInnerClass(FullyQualifiedJavaType
                .getCriteriaInstance(),FullyQualifiedJavaType.getGeneratedCriteriaInstance()));
        if (useAssociate) {
            topLevelClass.addInnerClass(getGeneratedCriteriaInnerClass(topLevelClass,FullyQualifiedJavaType
                    .getNewGeneratedAssociationCriteriaInstance()));
            topLevelClass.addInnerClass(getCriteriaInnerClass(FullyQualifiedJavaType
                    .getNewAssociationCriteriaInstance(),FullyQualifiedJavaType.getNewGeneratedAssociationCriteriaInstance()));
        }
        topLevelClass.addInnerClass(getCriterionInnerClass());

        List<CompilationUnit> answer = new ArrayList<>();
        if (context.getPlugins().modelExampleClassGenerated(
                topLevelClass, introspectedTable)) {
            answer.add(topLevelClass);
        }
        return answer;
    }

    private InnerClass getCriterionInnerClass() {
        InnerClass answer = new InnerClass(new FullyQualifiedJavaType(
                "Criterion")); //$NON-NLS-1$
        answer.setVisibility(JavaVisibility.PUBLIC);
        answer.setStatic(true);
        context.getCommentGenerator().addClassComment(answer,
                introspectedTable);

        Field field = new Field("condition", FullyQualifiedJavaType.getStringInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field("value", FullyQualifiedJavaType.getObjectInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field("secondValue", FullyQualifiedJavaType.getObjectInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field("noValue", FullyQualifiedJavaType.getBooleanPrimitiveInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field("singleValue", FullyQualifiedJavaType.getBooleanPrimitiveInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field("betweenValue", FullyQualifiedJavaType.getBooleanPrimitiveInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field("listValue", FullyQualifiedJavaType.getBooleanPrimitiveInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field("typeHandler", FullyQualifiedJavaType.getStringInstance()); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        Method method = new Method("Criterion"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addBodyLine("super();"); //$NON-NLS-1$
        method.addBodyLine("this.condition = condition;"); //$NON-NLS-1$
        method.addBodyLine("this.typeHandler = null;"); //$NON-NLS-1$
        method.addBodyLine("this.noValue = true;"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method("Criterion"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "typeHandler")); //$NON-NLS-1$
        method.addBodyLine("super();"); //$NON-NLS-1$
        method.addBodyLine("this.condition = condition;"); //$NON-NLS-1$
        method.addBodyLine("this.value = value;"); //$NON-NLS-1$
        method.addBodyLine("this.typeHandler = typeHandler;"); //$NON-NLS-1$
        method.addBodyLine("if (value instanceof List<?>) {"); //$NON-NLS-1$
        method.addBodyLine("this.listValue = true;"); //$NON-NLS-1$
        method.addBodyLine("} else {"); //$NON-NLS-1$
        method.addBodyLine("this.singleValue = true;"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method("Criterion"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addBodyLine("this(condition, value, null);"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method("Criterion"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "secondValue")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "typeHandler")); //$NON-NLS-1$
        method.addBodyLine("super();"); //$NON-NLS-1$
        method.addBodyLine("this.condition = condition;"); //$NON-NLS-1$
        method.addBodyLine("this.value = value;"); //$NON-NLS-1$
        method.addBodyLine("this.secondValue = secondValue;"); //$NON-NLS-1$
        method.addBodyLine("this.typeHandler = typeHandler;"); //$NON-NLS-1$
        method.addBodyLine("this.betweenValue = true;"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method("Criterion"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "secondValue")); //$NON-NLS-1$
        method.addBodyLine("this(condition, value, secondValue, null);"); //$NON-NLS-1$
        answer.addMethod(method);

        return answer;
    }

    private InnerClass getCriteriaInnerClass(FullyQualifiedJavaType type, FullyQualifiedJavaType superType) {
        InnerClass answer = new InnerClass(type);

        answer.setVisibility(JavaVisibility.PUBLIC);
        answer.setStatic(true);
        answer.setSuperClass(superType);

        context.getCommentGenerator().addClassComment(answer,
                introspectedTable, true);

        Method method = new Method(type.getShortName()); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setConstructor(true);
        method.addBodyLine("super();"); //$NON-NLS-1$
        answer.addMethod(method);

        return answer;
    }

    private InnerClass getGeneratedCriteriaInnerClass(
            TopLevelClass topLevelClass,FullyQualifiedJavaType type) {
        Field field;
        boolean isDefault = type.getShortName().equalsIgnoreCase(FullyQualifiedJavaType.getGeneratedCriteriaInstance().getShortName());
        InnerClass answer = new InnerClass(type);

        answer.setVisibility(JavaVisibility.PROTECTED);
        answer.setStatic(true);
        answer.setAbstract(true);
        context.getCommentGenerator().addClassComment(answer,
                introspectedTable);

        Method method = new Method(type.getShortName()); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setConstructor(true);
        method.addBodyLine("super();"); //$NON-NLS-1$
        if (context.isJava8Targeted()) {
            method.addBodyLine("criteria = new ArrayList<>();"); //$NON-NLS-1$
        } else {
            method.addBodyLine("criteria = new ArrayList<Criterion>();"); //$NON-NLS-1$
        }
        answer.addMethod(method);

        List<String> criteriaLists = new ArrayList<>();
        criteriaLists.add("criteria"); //$NON-NLS-1$

        if (isDefault) {
            for (IntrospectedColumn introspectedColumn : introspectedTable
                    .getNonBLOBColumns()) {
                if (stringHasValue(introspectedColumn
                        .getTypeHandler())) {
                    String name = addtypeHandledObjectsAndMethods(
                            introspectedColumn, method, answer);
                    criteriaLists.add(name);
                }
            }
        }
        // now generate the isValid method
        method = new Method("isValid"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType
                .getBooleanPrimitiveInstance());
        StringBuilder sb = new StringBuilder();
        Iterator<String> strIter = criteriaLists.iterator();
        sb.append("return "); //$NON-NLS-1$
        sb.append(strIter.next());
        sb.append(".size() > 0"); //$NON-NLS-1$
        if (!strIter.hasNext()) {
            sb.append(';');
        }
        method.addBodyLine(sb.toString());
        while (strIter.hasNext()) {
            sb.setLength(0);
            OutputUtilities.javaIndent(sb, 1);
            sb.append("|| "); //$NON-NLS-1$
            sb.append(strIter.next());
            sb.append(".size() > 0"); //$NON-NLS-1$
            if (!strIter.hasNext()) {
                sb.append(';');
            }
            method.addBodyLine(sb.toString());
        }
        answer.addMethod(method);

        // now generate the getAllCriteria method
        if (criteriaLists.size() > 1) {
            field = new Field("allCriteria", //$NON-NLS-1$
                    new FullyQualifiedJavaType("List<Criterion>")); //$NON-NLS-1$                    
            field.setVisibility(JavaVisibility.PROTECTED);
            answer.addField(field);
        }
        
        method = new Method("getAllCriteria"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("List<Criterion>")); //$NON-NLS-1$
        if (criteriaLists.size() < 2) {
            method.addBodyLine("return criteria;"); //$NON-NLS-1$
        } else {
            method.addBodyLine("if (allCriteria == null) {"); //$NON-NLS-1$
            if (context.isJava8Targeted()) {
                method.addBodyLine("allCriteria = new ArrayList<>();"); //$NON-NLS-1$
            } else {
                method.addBodyLine("allCriteria = new ArrayList<Criterion>();"); //$NON-NLS-1$
            }

            strIter = criteriaLists.iterator();
            while (strIter.hasNext()) {
                method.addBodyLine(String.format("allCriteria.addAll(%s);", strIter.next())); //$NON-NLS-1$
            }

            method.addBodyLine("}"); //$NON-NLS-1$
            method.addBodyLine("return allCriteria;"); //$NON-NLS-1$
        }
        answer.addMethod(method);

        // now we need to generate the methods that will be used in the SqlMap
        // to generate the dynamic where clause
        topLevelClass.addImportedType(FullyQualifiedJavaType
                .getNewListInstance());
        topLevelClass.addImportedType(FullyQualifiedJavaType
                .getNewArrayListInstance());

        if (!isDefault) {
            field = new Field("onCondition",FullyQualifiedJavaType.getBooleanPrimitiveInstance());
            field.setVisibility(JavaVisibility.PROTECTED);
            field.setInitializationString("false");
            answer.addField(field);
        }

        FullyQualifiedJavaType listOfCriterion = new FullyQualifiedJavaType(
                "java.util.List<Criterion>"); //$NON-NLS-1$
        field = new Field("criteria", listOfCriterion); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PROTECTED);
        answer.addField(field);

        method = new Method(getGetterMethodName(field.getName(), field
                .getType()));
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(field.getType());
        method.addBodyLine("return criteria;"); //$NON-NLS-1$
        answer.addMethod(method);

        // now add the methods for simplifying the individual field set methods
        method = new Method("addCriterion"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addBodyLine("if (condition == null) {"); //$NON-NLS-1$
        method
                .addBodyLine("throw new RuntimeException(\"Value for condition cannot be null\");"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$
        method.addBodyLine("criteria.add(new Criterion(condition));"); //$NON-NLS-1$
        if (criteriaLists.size() > 1) {
            method.addBodyLine("allCriteria = null;"); //$NON-NLS-1$
        }
        answer.addMethod(method);

        method = new Method("addCriterion"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "property")); //$NON-NLS-1$
        method.addBodyLine("if (value == null) {"); //$NON-NLS-1$
        method.addBodyLine(
                "throw new RuntimeException(\"Value for \" + property + \" cannot be null\");"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$
        method.addBodyLine("criteria.add(new Criterion(condition, value));"); //$NON-NLS-1$
        if (criteriaLists.size() > 1) {
            method.addBodyLine("allCriteria = null;"); //$NON-NLS-1$
        }
        answer.addMethod(method);

        method = new Method("addCriterion"); //$NON-NLS-1$
        method.setVisibility(JavaVisibility.PROTECTED);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value1")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value2")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "property")); //$NON-NLS-1$
        method.addBodyLine("if (value1 == null || value2 == null) {"); //$NON-NLS-1$
        method.addBodyLine(
                "throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$
        method
                .addBodyLine("criteria.add(new Criterion(condition, value1, value2));"); //$NON-NLS-1$
        if (criteriaLists.size() > 1) {
            method.addBodyLine("allCriteria = null;"); //$NON-NLS-1$
        }
        answer.addMethod(method);

        FullyQualifiedJavaType listOfDates = new FullyQualifiedJavaType(
                "java.util.List<java.util.Date>"); //$NON-NLS-1$

        if (introspectedTable.hasJDBCDateColumns() && isDefault) {
            topLevelClass.addImportedType(FullyQualifiedJavaType
                    .getDateInstance());
            topLevelClass.addImportedType(FullyQualifiedJavaType
                    .getNewIteratorInstance());
            method = new Method("addCriterionForJDBCDate"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PROTECTED);
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "condition")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getDateInstance(), "value")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "property")); //$NON-NLS-1$
            method.addBodyLine("if (value == null) {"); //$NON-NLS-1$
            method.addBodyLine(
                    "throw new RuntimeException(\"Value for \" + property + \" cannot be null\");"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
            method.addBodyLine(
                    "addCriterion(condition, new java.sql.Date(value.getTime()), property);"); //$NON-NLS-1$
            answer.addMethod(method);

            method = new Method("addCriterionForJDBCDate"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PROTECTED);
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "condition")); //$NON-NLS-1$
            method.addParameter(new Parameter(listOfDates, "values")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "property")); //$NON-NLS-1$
            method.addBodyLine("if (values == null || values.size() == 0) {"); //$NON-NLS-1$
            method.addBodyLine(
                    "throw new RuntimeException(\"Value list for \" + property + \"" //$NON-NLS-1$
                    + " cannot be null or empty\");"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
            if (context.isJava8Targeted()) {
                method.addBodyLine("List<java.sql.Date> dateList = new ArrayList<>();"); //$NON-NLS-1$
            } else {
                method.addBodyLine("List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();"); //$NON-NLS-1$
            }
            method.addBodyLine("Iterator<Date> iter = values.iterator();"); //$NON-NLS-1$
            method.addBodyLine("while (iter.hasNext()) {"); //$NON-NLS-1$
            method
                    .addBodyLine("dateList.add(new java.sql.Date(iter.next().getTime()));"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
            method.addBodyLine("addCriterion(condition, dateList, property);"); //$NON-NLS-1$
            answer.addMethod(method);

            method = new Method("addCriterionForJDBCDate"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PROTECTED);
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "condition")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getDateInstance(), "value1")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getDateInstance(), "value2")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "property")); //$NON-NLS-1$
            method.addBodyLine("if (value1 == null || value2 == null) {"); //$NON-NLS-1$
            method.addBodyLine(
                    "throw new RuntimeException(\"Between values for \" + property + \"" //$NON-NLS-1$
                    + " cannot be null\");"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
            method.addBodyLine(
                    "addCriterion(condition, new java.sql.Date(value1.getTime())," //$NON-NLS-1$
                    + " new java.sql.Date(value2.getTime()), property);"); //$NON-NLS-1$
            answer.addMethod(method);
        }

        if (introspectedTable.hasJDBCTimeColumns() && isDefault) {
            topLevelClass.addImportedType(FullyQualifiedJavaType
                    .getDateInstance());
            topLevelClass.addImportedType(FullyQualifiedJavaType
                    .getNewIteratorInstance());
            method = new Method("addCriterionForJDBCTime"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PROTECTED);
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "condition")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getDateInstance(), "value")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "property")); //$NON-NLS-1$
            method.addBodyLine("if (value == null) {"); //$NON-NLS-1$
            method.addBodyLine(
                    "throw new RuntimeException(\"Value for \" + property + \" cannot be null\");"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
            method.addBodyLine(
                    "addCriterion(condition, new java.sql.Time(value.getTime()), property);"); //$NON-NLS-1$
            answer.addMethod(method);

            method = new Method("addCriterionForJDBCTime"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PROTECTED);
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "condition")); //$NON-NLS-1$
            method.addParameter(new Parameter(listOfDates, "values")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "property")); //$NON-NLS-1$
            method.addBodyLine("if (values == null || values.size() == 0) {"); //$NON-NLS-1$
            method.addBodyLine(
                    "throw new RuntimeException(\"Value list for \" + property + \"" //$NON-NLS-1$
                    + " cannot be null or empty\");"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
            if (context.isJava8Targeted()) {
                method.addBodyLine("List<java.sql.Time> timeList = new ArrayList<>();"); //$NON-NLS-1$
            } else {
                method.addBodyLine("List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();"); //$NON-NLS-1$
            }
            method.addBodyLine("Iterator<Date> iter = values.iterator();"); //$NON-NLS-1$
            method.addBodyLine("while (iter.hasNext()) {"); //$NON-NLS-1$
            method
                    .addBodyLine("timeList.add(new java.sql.Time(iter.next().getTime()));"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
            method.addBodyLine("addCriterion(condition, timeList, property);"); //$NON-NLS-1$
            answer.addMethod(method);

            method = new Method("addCriterionForJDBCTime"); //$NON-NLS-1$
            method.setVisibility(JavaVisibility.PROTECTED);
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "condition")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getDateInstance(), "value1")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getDateInstance(), "value2")); //$NON-NLS-1$
            method.addParameter(new Parameter(FullyQualifiedJavaType
                    .getStringInstance(), "property")); //$NON-NLS-1$
            method.addBodyLine("if (value1 == null || value2 == null) {"); //$NON-NLS-1$
            method.addBodyLine(
                    "throw new RuntimeException(\"Between values for \" + property + \"" //$NON-NLS-1$
                    + " cannot be null\");"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
            method.addBodyLine(
                    "addCriterion(condition, new java.sql.Time(value1.getTime())," //$NON-NLS-1$
                    + " new java.sql.Time(value2.getTime()), property);"); //$NON-NLS-1$
            answer.addMethod(method);
        }
        FullyQualifiedJavaType returnType = null;
        if (isDefault) {
            returnType = FullyQualifiedJavaType.getCriteriaInstance();
            for (IntrospectedColumn introspectedColumn : introspectedTable
                    .getNonBLOBColumns()) {
                topLevelClass.addImportedType(introspectedColumn
                        .getFullyQualifiedJavaType());

                // here we need to add the individual methods for setting the
                // conditions for a field
                answer.addMethod(getSetNullMethod(introspectedColumn));
                answer.addMethod(getSetNotNullMethod(introspectedColumn));
                answer.addMethod(getSetEqualMethod(introspectedColumn));
                answer.addMethod(getSetNotEqualMethod(introspectedColumn));
                answer.addMethod(getSetGreaterThanMethod(introspectedColumn));
                answer.addMethod(getSetGreaterThenOrEqualMethod(introspectedColumn));
                answer.addMethod(getSetLessThanMethod(introspectedColumn));
                answer.addMethod(getSetLessThanOrEqualMethod(introspectedColumn));

                if (introspectedColumn.isJdbcCharacterColumn()) {
                    answer.addMethod(getSetLikeMethod(introspectedColumn));
                    answer.addMethod(getSetNotLikeMethod(introspectedColumn));
                }

                if (introspectedColumn.isJdbcNumberColumn()) {
                    answer.addMethod(getSetNumberLikeMethod(introspectedColumn));
                    answer.addMethod(getSetNumberNotLikeMethod(introspectedColumn));
                }

                answer.addMethod(getSetInOrNotInMethod(introspectedColumn, true));
                answer.addMethod(getSetInOrNotInMethod(introspectedColumn, false));
                answer.addMethod(getSetBetweenOrNotBetweenMethod(
                        introspectedColumn, true));
                answer.addMethod(getSetBetweenOrNotBetweenMethod(
                        introspectedColumn, false));
            }
        } else {
            returnType = FullyQualifiedJavaType.getNewAssociationCriteriaInstance();
            answer.addMethod(getLeftJoinMethod());
            answer.addMethod(getRightJoinMethod());
            answer.addMethod(getInnerJoinMethod());
            answer.addMethod(getAssociateEqualMethod(true));
            answer.addMethod(getAssociateEqualMethod(false));
            answer.addMethod(getAssociateLikeMethod(true));
            answer.addMethod(getAssociateLikeMethod(false));
            answer.addMethod(getAssociateLessThenMethod(true));
            answer.addMethod(getAssociateLessThenMethod(false));
            answer.addMethod(getAssociateGreaterThenMethod(true));
            answer.addMethod(getAssociateGreaterThenMethod(false));
        }

        // add customise method
        boolean useAssociate = false;
        String associate = introspectedTable.getTableConfiguration().getProperty(PropertyRegistry.TABLE_ASSOCIATE);
        if (!StringUtils.isNullOrEmpty(associate) && Boolean.parseBoolean(associate)) {
            useAssociate = true;
        }
        if (useAssociate) {
            answer.addMethod(getEqualConditionMethod(returnType,true));
            answer.addMethod(getEqualConditionMethod(returnType,false));
            answer.addMethod(getLessThenConditionMethod(returnType,true));
            answer.addMethod(getLessThenConditionMethod(returnType,false));
            answer.addMethod(getGreaterThanConditionMethod(returnType,true));
            answer.addMethod(getGreaterThanConditionMethod(returnType,false));
            answer.addMethod(getBetweenConditionMethod(returnType,true));
            answer.addMethod(getBetweenConditionMethod(returnType,false));
            answer.addMethod(getLikeConditionMethod(returnType,true));
            answer.addMethod(getLikeConditionMethod(returnType,false));
            answer.addMethod(getInConditionMethod(returnType,true));
            answer.addMethod(getInConditionMethod(returnType,false));
            answer.addMethod(getNullConditionMethod(returnType,true));
            answer.addMethod(getNullConditionMethod(returnType,false));
        }
        return answer;
    }

    private Method getSetNullMethod(IntrospectedColumn introspectedColumn) {
        return getNoValueMethod(introspectedColumn, "IsNull", "is null"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetNotNullMethod(IntrospectedColumn introspectedColumn) {
        return getNoValueMethod(introspectedColumn, "IsNotNull", "is not null"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetEqualMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "EqualTo", "="); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetNotEqualMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "NotEqualTo", "<>"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetGreaterThanMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "GreaterThan", ">"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetGreaterThenOrEqualMethod(
            IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn,
                "GreaterThanOrEqualTo", ">="); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetLessThanMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "LessThan", "<"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetLessThanOrEqualMethod(
            IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn,
                "LessThanOrEqualTo", "<="); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetLikeMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "Like", "like"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetNotLikeMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "NotLike", "not like"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetNumberLikeMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "Like", "like",true); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSetNumberNotLikeMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "NotLike", "not like",true); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private Method getSingleValueMethod(IntrospectedColumn introspectedColumn,
                                        String nameFragment, String operator) {
        return getSingleValueMethod(introspectedColumn, nameFragment, operator, false);
    }

    private Method getSingleValueMethod(IntrospectedColumn introspectedColumn,
            String nameFragment, String operator, boolean isNumber) {
        String tableName = null;
        String associate = introspectedTable.getTableConfiguration().getProperty(PropertyRegistry.TABLE_ASSOCIATE);
        if (!StringUtils.isNullOrEmpty(associate) && Boolean.valueOf(associate)) {
            tableName = introspectedTable.getTableConfiguration().getTableName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(introspectedColumn.getJavaProperty());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.insert(0, "and"); //$NON-NLS-1$
        sb.append(nameFragment);

        Method method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(introspectedColumn
                .getFullyQualifiedJavaType(), "value")); //$NON-NLS-1$
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        sb.setLength(0);

        if (introspectedColumn.isJDBCDateColumn()) {
            sb.append("addCriterionForJDBCDate(\""); //$NON-NLS-1$
        } else if (introspectedColumn.isJDBCTimeColumn()) {
            sb.append("addCriterionForJDBCTime(\""); //$NON-NLS-1$
        } else if (stringHasValue(introspectedColumn
                .getTypeHandler())) {
            sb.append("add"); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
            sb.append("Criterion(\""); //$NON-NLS-1$
        } else {
            sb.append("addCriterion(\""); //$NON-NLS-1$
        }
        sb.append(MyBatis3FormattingUtilities
                .getAliasedActualColumnName(introspectedColumn, tableName));
        sb.append(' ');
        sb.append(operator);
        sb.append("\", "); //$NON-NLS-1$
        if (isNumber) {
            sb.append("\"%\" + value + \"%\""); //$NON-NLS-1$
        }else {
            sb.append("value"); //$NON-NLS-1$
        }
        sb.append(", \""); //$NON-NLS-1$
        sb.append(introspectedColumn.getJavaProperty());
        sb.append("\");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$

        return method;
    }

    /**
     * Generates methods that set between and not between conditions.
     * 
     * @param introspectedColumn the introspected column
     * @param betweenMethod true if between, else not between
     * @return a generated method for the between or not between method
     */
    private Method getSetBetweenOrNotBetweenMethod(
            IntrospectedColumn introspectedColumn, boolean betweenMethod) {
        String tableName = null;
        String associate = introspectedTable.getTableConfiguration().getProperty(PropertyRegistry.TABLE_ASSOCIATE);
        if (!StringUtils.isNullOrEmpty(associate) && Boolean.valueOf(associate)) {
            tableName = introspectedTable.getTableConfiguration().getTableName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(introspectedColumn.getJavaProperty());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.insert(0, "and"); //$NON-NLS-1$
        if (betweenMethod) {
            sb.append("Between"); //$NON-NLS-1$
        } else {
            sb.append("NotBetween"); //$NON-NLS-1$
        }
        Method method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType type = introspectedColumn
                .getFullyQualifiedJavaType();

        method.addParameter(new Parameter(type, "value1")); //$NON-NLS-1$
        method.addParameter(new Parameter(type, "value2")); //$NON-NLS-1$
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());

        sb.setLength(0);
        if (introspectedColumn.isJDBCDateColumn()) {
            sb.append("addCriterionForJDBCDate(\""); //$NON-NLS-1$
        } else if (introspectedColumn.isJDBCTimeColumn()) {
            sb.append("addCriterionForJDBCTime(\""); //$NON-NLS-1$
        } else if (stringHasValue(introspectedColumn
                .getTypeHandler())) {
            sb.append("add"); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
            sb.append("Criterion(\""); //$NON-NLS-1$
        } else {
            sb.append("addCriterion(\""); //$NON-NLS-1$
        }

        sb.append(MyBatis3FormattingUtilities
                .getAliasedActualColumnName(introspectedColumn, tableName));
        if (betweenMethod) {
            sb.append(" between"); //$NON-NLS-1$
        } else {
            sb.append(" not between"); //$NON-NLS-1$
        }
        sb.append("\", "); //$NON-NLS-1$
        sb.append("value1, value2"); //$NON-NLS-1$
        sb.append(", \""); //$NON-NLS-1$
        sb.append(introspectedColumn.getJavaProperty());
        sb.append("\");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$

        return method;
    }

    /**
     * Generates an In or NotIn method.
     * 
     * @param introspectedColumn the introspected column
     * @param inMethod
     *            if true generates an "in" method, else generates a "not in"
     *            method
     * @return a generated method for the in or not in method
     */
    private Method getSetInOrNotInMethod(IntrospectedColumn introspectedColumn,
            boolean inMethod) {
        String tableName = null;
        String associate = introspectedTable.getTableConfiguration().getProperty(PropertyRegistry.TABLE_ASSOCIATE);
        if (!StringUtils.isNullOrEmpty(associate) && Boolean.valueOf(associate)) {
            tableName = introspectedTable.getTableConfiguration().getTableName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(introspectedColumn.getJavaProperty());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.insert(0, "and"); //$NON-NLS-1$
        if (inMethod) {
            sb.append("In"); //$NON-NLS-1$
        } else {
            sb.append("NotIn"); //$NON-NLS-1$
        }
        Method method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType type = FullyQualifiedJavaType
                .getNewListInstance();
        if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
            type.addTypeArgument(introspectedColumn.getFullyQualifiedJavaType()
                    .getPrimitiveTypeWrapper());
        } else {
            type
                    .addTypeArgument(introspectedColumn
                            .getFullyQualifiedJavaType());
        }

        method.addParameter(new Parameter(type, "values")); //$NON-NLS-1$
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());

        sb.setLength(0);
        if (introspectedColumn.isJDBCDateColumn()) {
            sb.append("addCriterionForJDBCDate(\""); //$NON-NLS-1$
        } else if (introspectedColumn.isJDBCTimeColumn()) {
            sb.append("addCriterionForJDBCTime(\""); //$NON-NLS-1$
        } else if (stringHasValue(introspectedColumn
                .getTypeHandler())) {
            sb.append("add"); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
            sb.append("Criterion(\""); //$NON-NLS-1$
        } else {
            sb.append("addCriterion(\""); //$NON-NLS-1$
        }

        sb.append(MyBatis3FormattingUtilities
                .getAliasedActualColumnName(introspectedColumn, tableName));
        if (inMethod) {
            sb.append(" in"); //$NON-NLS-1$
        } else {
            sb.append(" not in"); //$NON-NLS-1$
        }
        sb.append("\", values, \""); //$NON-NLS-1$
        sb.append(introspectedColumn.getJavaProperty());
        sb.append("\");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$

        return method;
    }

    private Method getNoValueMethod(IntrospectedColumn introspectedColumn,
            String nameFragment, String operator) {
        String tableName = null;
        String associate = introspectedTable.getTableConfiguration().getProperty(PropertyRegistry.TABLE_ASSOCIATE);
        if (!StringUtils.isNullOrEmpty(associate) && Boolean.valueOf(associate)) {
            tableName = introspectedTable.getTableConfiguration().getTableName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(introspectedColumn.getJavaProperty());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.insert(0, "and"); //$NON-NLS-1$
        sb.append(nameFragment);
        Method method = new Method(sb.toString());
        
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        
        sb.setLength(0);
        sb.append("addCriterion(\""); //$NON-NLS-1$
        sb.append(MyBatis3FormattingUtilities
                .getAliasedActualColumnName(introspectedColumn, tableName));
        sb.append(' ');
        sb.append(operator);
        sb.append("\");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$

        return method;
    }

    /**
     * This method adds all the extra methods and fields required to support a
     * user defined type handler on some column.
     * 
     * @param introspectedColumn the introspected column
     * @param constructor the constructor
     * @param innerClass the enclosing class
     * @return the name of the List added to the class by this method
     */
    private String addtypeHandledObjectsAndMethods(
            IntrospectedColumn introspectedColumn, Method constructor,
            InnerClass innerClass) {
        StringBuilder sb = new StringBuilder();

        // add new private field and public accessor in the class
        sb.setLength(0);
        sb.append(introspectedColumn.getJavaProperty());
        sb.append("Criteria"); //$NON-NLS-1$
        String answer = sb.toString();

        Field field = new Field(answer, new FullyQualifiedJavaType("java.util.List<Criterion>")); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PROTECTED);
        innerClass.addField(field);

        Method method = new Method(getGetterMethodName(field.getName(), field
                .getType()));
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(field.getType());
        sb.insert(0, "return "); //$NON-NLS-1$
        sb.append(';');
        method.addBodyLine(sb.toString());
        innerClass.addMethod(method);

        // add constructor initialization
        sb.setLength(0);
        sb.append(field.getName());
        if (context.isJava8Targeted()) {
            sb.append(" = new ArrayList<>();"); //$NON-NLS-1$
        } else {
            sb.append(" = new ArrayList<Criterion>();"); //$NON-NLS-1$
        }
        constructor.addBodyLine(sb.toString());

        // now add the methods for simplifying the individual field set methods
        sb.setLength(0);
        sb.append("add"); //$NON-NLS-1$
        sb.append(introspectedColumn.getJavaProperty());
        sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
        sb.append("Criterion"); //$NON-NLS-1$
        method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PROTECTED);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "property")); //$NON-NLS-1$
        method.addBodyLine("if (value == null) {"); //$NON-NLS-1$
        method.addBodyLine(
                "throw new RuntimeException(\"Value for \" + property + \" cannot be null\");"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$

        method.addBodyLine(
                String.format("%s.add(new Criterion(condition, value, \"%s\"));", //$NON-NLS-1$
                        field.getName(), introspectedColumn.getTypeHandler()));
        method.addBodyLine("allCriteria = null;"); //$NON-NLS-1$
        innerClass.addMethod(method);

        sb.setLength(0);
        sb.append("add"); //$NON-NLS-1$
        sb.append(introspectedColumn.getJavaProperty());
        sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
        sb.append("Criterion"); //$NON-NLS-1$

        method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PROTECTED);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(introspectedColumn
                .getFullyQualifiedJavaType(), "value1")); //$NON-NLS-1$
        method.addParameter(new Parameter(introspectedColumn
                .getFullyQualifiedJavaType(), "value2")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "property")); //$NON-NLS-1$
        if (!introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
            method.addBodyLine("if (value1 == null || value2 == null) {"); //$NON-NLS-1$
            method.addBodyLine(
                    "throw new RuntimeException(\"Between values for \" + property + \"" //$NON-NLS-1$
                    + " cannot be null\");"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
        }

        method.addBodyLine(
                String.format("%s.add(new Criterion(condition, value1, value2, \"%s\"));", //$NON-NLS-1$
                        field.getName(), introspectedColumn.getTypeHandler()));
        
        method.addBodyLine("allCriteria = null;"); //$NON-NLS-1$
        innerClass.addMethod(method);

        return answer;
    }

    private Method getNullConditionMethod(FullyQualifiedJavaType returnType, boolean isNull) {
        StringBuilder sb = new StringBuilder();
        if (isNull) {
            sb.append("andConditionIsNull");
        } else {
            sb.append("andConditionIsNotNull");
        }

        String shortName = returnType.getShortName();

        Method method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(returnType);

        FullyQualifiedJavaType type = FullyQualifiedJavaType.getStringInstance();
        method.addParameter(new Parameter(type, "tableName")); //$NON-NLS-1$
        method.addParameter(new Parameter(type, "field")); //$NON-NLS-1$

        sb.setLength(0);
        sb.append("addCriterion("); //$NON-NLS-1$
        if (shortName.length() > 8) {
            sb.append("\"and \" + ");
        }
        sb.append("tableName + ");
        sb.append("\".\" + ");
        sb.append("field +");
        if (isNull) {
            sb.append("\" is null");
        } else {
            sb.append("\" is not null");
        }
        sb.append("\");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("return (" + shortName + ") this;"); //$NON-NLS-1$
        return method;
    }

    private Method getBetweenConditionMethod(FullyQualifiedJavaType returnType, boolean isBetween) {
        StringBuilder sb = new StringBuilder();
        if (isBetween) {
            sb.append("andConditionBetween");
        } else {
            sb.append("andConditionNotBetween");
        }

        String shortName = returnType.getShortName();

        Method method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PUBLIC_GENERIC);
        method.setReturnType(returnType);

        FullyQualifiedJavaType type = FullyQualifiedJavaType.getStringInstance();
        FullyQualifiedJavaType generic = FullyQualifiedJavaType.getNewGenericInstance();
        method.addParameter(new Parameter(type, "tableName")); //$NON-NLS-1$
        method.addParameter(new Parameter(type, "field")); //$NON-NLS-1$
        method.addParameter(new Parameter(generic, "value1")); //$NON-NLS-1$
        method.addParameter(new Parameter(generic, "value2")); //$NON-NLS-1$

        sb.setLength(0);
        sb.append("addCriterion("); //$NON-NLS-1$
        if (shortName.length() > 8) {
            sb.append("\"and \" + ");
        }
        sb.append("tableName + ");
        sb.append("\".\" + ");
        sb.append("field +");
        if (isBetween) {
            sb.append("\" between");
        } else {
            sb.append("\" not between");
        }
        sb.append("\", "); //$NON-NLS-1$
        sb.append("value1, value2"); //$NON-NLS-1$
        sb.append(", \""); //$NON-NLS-1$
        sb.append("field");
        sb.append("\");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("return (" + shortName + ") this;"); //$NON-NLS-1$
        return method;
    }

    private Method getInConditionMethod(FullyQualifiedJavaType returnType, boolean isIn) {
        StringBuilder sb = new StringBuilder();
        if (isIn) {
            sb.append("andConditionIn");
        } else {
            sb.append("andConditionNotIn");
        }

        String shortName = returnType.getShortName();

        Method method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PUBLIC_GENERIC);
        method.setReturnType(returnType);

        FullyQualifiedJavaType type = FullyQualifiedJavaType.getStringInstance();
        FullyQualifiedJavaType generic = FullyQualifiedJavaType
                .getNewListInstance();
        generic.addTypeArgument(FullyQualifiedJavaType.getNewGenericInstance());

        method.addParameter(new Parameter(type, "tableName")); //$NON-NLS-1$
        method.addParameter(new Parameter(type, "field")); //$NON-NLS-1$
        method.addParameter(new Parameter(generic, "values")); //$NON-NLS-1$

        sb.setLength(0);
        sb.append("addCriterion("); //$NON-NLS-1$
        if (shortName.length() > 8) {
            sb.append("\"and \" + ");
        }
        sb.append("tableName + ");
        sb.append("\".\" + ");
        sb.append("field +");
        if (isIn) {
            sb.append("\" in");
        } else {
            sb.append("\" not in");
        }
        sb.append("\", "); //$NON-NLS-1$
        sb.append("values"); //$NON-NLS-1$
        sb.append(", \""); //$NON-NLS-1$
        sb.append("field");
        sb.append("\");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("return (" + shortName + ") this;"); //$NON-NLS-1$
        return method;
    }

    private Method getEqualConditionMethod(FullyQualifiedJavaType returnType, boolean isEqual) {
        if (isEqual) {
            return getSingleValueConditionMethod(returnType,"EqualTo","=");
        }
        return getSingleValueConditionMethod(returnType,"NotEqualTo","<>");
    }

    private Method getLessThenConditionMethod(FullyQualifiedJavaType returnType, boolean isEqual) {
        if (isEqual) {
            return getSingleValueConditionMethod(returnType,"LessThenOrEqualTo","<=");
        }
        return getSingleValueConditionMethod(returnType,"LessThen","<");
    }

    private Method getGreaterThanConditionMethod(FullyQualifiedJavaType returnType, boolean isEqual) {
        if (isEqual) {
            return getSingleValueConditionMethod(returnType,"GreaterThenOrEqualTo",">=");
        }
        return getSingleValueConditionMethod(returnType, "GreaterThan",">");
    }

    private Method getLikeConditionMethod(FullyQualifiedJavaType returnType, boolean isLike) {
        if (isLike) {
            return getSingleValueConditionMethod(returnType,"Like","like");
        }
        return getSingleValueConditionMethod(returnType,"NotLike","not like");
    }

    private Method getSingleValueConditionMethod(FullyQualifiedJavaType returnType, String suffix, String operator) {
        StringBuilder sb = new StringBuilder();
        sb.append("andCondition");
        sb.append(suffix);

        String shortName = returnType.getShortName();

        Method method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PUBLIC_GENERIC);
        method.setReturnType(returnType);

        FullyQualifiedJavaType type = FullyQualifiedJavaType.getStringInstance();
        FullyQualifiedJavaType generic = FullyQualifiedJavaType.getNewGenericInstance();
        method.addParameter(new Parameter(type, "tableName")); //$NON-NLS-1$
        method.addParameter(new Parameter(type, "field")); //$NON-NLS-1$
        method.addParameter(new Parameter(generic, "value")); //$NON-NLS-1$

        sb.setLength(0);
        sb.append("addCriterion("); //$NON-NLS-1$
        if (shortName.length() > 8) {
            sb.append("\"and \" + ");
        }
        sb.append("tableName + ");
        sb.append("\".\" + ");
        sb.append("field +");
        sb.append("\" ");
        sb.append(operator);
        sb.append("\", "); //$NON-NLS-1$
        sb.append("value"); //$NON-NLS-1$
        sb.append(", \""); //$NON-NLS-1$
        sb.append("field");
        sb.append("\");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("return (" + shortName + ") this;"); //$NON-NLS-1$
        return method;
    }

    private Method getLeftJoinMethod() {
        return getJoinMethod("LeftJoin","left join");
    }

    private Method getRightJoinMethod() {
        return getJoinMethod("RightJoin","right join");
    }

    private Method getInnerJoinMethod() {
        return getJoinMethod("InnerJoin","inner join");
    }

    private Method getJoinMethod(String suffix, String operator) {
        StringBuilder sb = new StringBuilder();
        sb.append("and");
        sb.append(suffix);

        Method method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getNewAssociationCriteriaInstance());

        FullyQualifiedJavaType type = FullyQualifiedJavaType.getStringInstance();
        method.addParameter(new Parameter(type, "tableName")); //$NON-NLS-1$

        sb.setLength(0);
        sb.append("addCriterion(\"");
        sb.append(operator);
        sb.append("\" + ");
        sb.append("tableName"); //$NON-NLS-1$
        sb.append(");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("onCondition = true;");
        method.addBodyLine("return (AssociationCriteria) this;"); //$NON-NLS-1$
        return method;
    }

    private Method getAssociateEqualMethod(boolean isEqual) {
        if (isEqual) {
            return getAssociateOnConditionMethod("EqualTo","=");
        }
        return getAssociateOnConditionMethod("NotEqualTo","<>");
    }

    private Method getAssociateLessThenMethod(boolean isEqual) {
        if (isEqual) {
            return getAssociateOnConditionMethod("LessThenOrEqualTo","<=");
        }
        return getAssociateOnConditionMethod("LessThen","<");
    }

    private Method getAssociateGreaterThenMethod(boolean isEqual) {
        if (isEqual) {
            return getAssociateOnConditionMethod("GraterThenOrEqualTo",">=");
        }
        return getAssociateOnConditionMethod("GraterThen",">");
    }

    private Method getAssociateLikeMethod(boolean isLike) {
        if (isLike) {
            return getAssociateOnConditionMethod("Like","like");
        }
        return getAssociateOnConditionMethod("NotLike","not like");
    }

    private Method getAssociateOnConditionMethod(String suffix, String operator) {
        StringBuilder sb = new StringBuilder();
        sb.append("andAssociateOnCondition");
        sb.append(suffix);

        Method method = new Method(sb.toString());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getNewAssociationCriteriaInstance());

        FullyQualifiedJavaType type = FullyQualifiedJavaType.getStringInstance();
        method.addParameter(new Parameter(type, "tableName1")); //$NON-NLS-1$
        method.addParameter(new Parameter(type, "field1")); //$NON-NLS-1$
        method.addParameter(new Parameter(type, "tableName2")); //$NON-NLS-1$
        method.addParameter(new Parameter(type, "field2")); //$NON-NLS-1$

        sb.setLength(0);
        method.addBodyLine("if (isValid()) {");
        method.addBodyLine("if (onCondition) {");
        method.addBodyLine("onCondition = false;");
        sb.append("addCriterion(\"");
        sb.append("on");
        sb.append("\" + ");
        sb.append("tableName1");
        sb.append(" + ");
        sb.append("\".\" + ");
        sb.append("field1 + ");
        sb.append("\"");
        sb.append(operator);
        sb.append("\" + ");
        sb.append("tableName2");
        sb.append(" + ");
        sb.append("\".\" + ");
        sb.append("field2");
        sb.append(");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("}else {");
        sb.setLength(0);
        sb.append("addCriterion(\"");
        sb.append("and");
        sb.append("\" + ");
        sb.append("tableName1");
        sb.append(" + ");
        sb.append("\".\" + ");
        sb.append("field1 + ");
        sb.append("\"");
        sb.append(operator);
        sb.append("\" + ");
        sb.append("tableName2");
        sb.append(" + ");
        sb.append("\".\" + ");
        sb.append("field2");
        sb.append(");"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());
        method.addBodyLine("}");
        method.addBodyLine("}");
        method.addBodyLine("return (AssociationCriteria) this;"); //$NON-NLS-1$
        return method;
    }
}
