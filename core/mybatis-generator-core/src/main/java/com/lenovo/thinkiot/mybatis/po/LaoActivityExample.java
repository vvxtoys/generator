package com.lenovo.thinkiot.mybatis.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LaoActivityExample {
    protected String tableName = "lao_activity";

    protected String orderByClause;

    protected String groupByClause;

    protected String dynamicFields;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected List<AssociationCriteria> associationCriteria;

    public LaoActivityExample() {
        oredCriteria = new ArrayList<>();
        associationCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = appendTableName(orderByClause);
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setGroupByClause(String groupByClause) {
        this.groupByClause = appendTableName(groupByClause);
    }

    public String getGroupByClause() {
        return groupByClause;
    }

    public void setDynamicFields(String dynamicFields) {
        this.dynamicFields = appendTableName(dynamicFields);
    }

    public String getDynamicFields() {
        return dynamicFields;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public List<AssociationCriteria> getAssociationCriteria() {
        return associationCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    public AssociationCriteria createAssociationCriteria() {
        AssociationCriteria criteria = createAssociationCriteriaInternal();
        if (associationCriteria.size() == 0) {
            associationCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    protected AssociationCriteria createAssociationCriteriaInternal() {
        AssociationCriteria criteria = new AssociationCriteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        associationCriteria.clear();
        orderByClause = null;
        distinct = false;
        groupByClause = null;
        dynamicFields = null;
    }

    private String appendTableName(String str) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            String[] fields = str.split(",");
            for (String field:fields) {
                sb.append(",");
                if (!field.contains(".")) {
                    sb.append(tableName);
                    sb.append(".");
                    sb.append(field);
                }else {
                    sb.append(field);
                }
            }
        }
        return sb.substring(1);
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("lao_activity.ACTIVITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("lao_activity.ACTIVITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Long value) {
            addCriterion("lao_activity.ACTIVITY_ID =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Long value) {
            addCriterion("lao_activity.ACTIVITY_ID <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Long value) {
            addCriterion("lao_activity.ACTIVITY_ID >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("lao_activity.ACTIVITY_ID >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Long value) {
            addCriterion("lao_activity.ACTIVITY_ID <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("lao_activity.ACTIVITY_ID <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLike(Long value) {
            addCriterion("lao_activity.ACTIVITY_ID like", "%" + value + "%", "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotLike(Long value) {
            addCriterion("lao_activity.ACTIVITY_ID not like", "%" + value + "%", "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Long> values) {
            addCriterion("lao_activity.ACTIVITY_ID in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Long> values) {
            addCriterion("lao_activity.ACTIVITY_ID not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Long value1, Long value2) {
            addCriterion("lao_activity.ACTIVITY_ID between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("lao_activity.ACTIVITY_ID not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNull() {
            addCriterion("lao_activity.ACTIVITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("lao_activity.ACTIVITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_NAME =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_NAME <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("lao_activity.ACTIVITY_NAME >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_NAME >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("lao_activity.ACTIVITY_NAME <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_NAME <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("lao_activity.ACTIVITY_NAME like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("lao_activity.ACTIVITY_NAME not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("lao_activity.ACTIVITY_NAME in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("lao_activity.ACTIVITY_NAME not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("lao_activity.ACTIVITY_NAME between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("lao_activity.ACTIVITY_NAME not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIsNull() {
            addCriterion("lao_activity.ACTIVITY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIsNotNull() {
            addCriterion("lao_activity.ACTIVITY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_TYPE =", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_TYPE <>", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThan(String value) {
            addCriterion("lao_activity.ACTIVITY_TYPE >", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_TYPE >=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThan(String value) {
            addCriterion("lao_activity.ACTIVITY_TYPE <", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThanOrEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_TYPE <=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLike(String value) {
            addCriterion("lao_activity.ACTIVITY_TYPE like", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotLike(String value) {
            addCriterion("lao_activity.ACTIVITY_TYPE not like", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIn(List<String> values) {
            addCriterion("lao_activity.ACTIVITY_TYPE in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotIn(List<String> values) {
            addCriterion("lao_activity.ACTIVITY_TYPE not in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeBetween(String value1, String value2) {
            addCriterion("lao_activity.ACTIVITY_TYPE between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotBetween(String value1, String value2) {
            addCriterion("lao_activity.ACTIVITY_TYPE not between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andSubTypeIsNull() {
            addCriterion("lao_activity.SUB_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSubTypeIsNotNull() {
            addCriterion("lao_activity.SUB_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSubTypeEqualTo(String value) {
            addCriterion("lao_activity.SUB_TYPE =", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotEqualTo(String value) {
            addCriterion("lao_activity.SUB_TYPE <>", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThan(String value) {
            addCriterion("lao_activity.SUB_TYPE >", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lao_activity.SUB_TYPE >=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThan(String value) {
            addCriterion("lao_activity.SUB_TYPE <", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThanOrEqualTo(String value) {
            addCriterion("lao_activity.SUB_TYPE <=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLike(String value) {
            addCriterion("lao_activity.SUB_TYPE like", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotLike(String value) {
            addCriterion("lao_activity.SUB_TYPE not like", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeIn(List<String> values) {
            addCriterion("lao_activity.SUB_TYPE in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotIn(List<String> values) {
            addCriterion("lao_activity.SUB_TYPE not in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeBetween(String value1, String value2) {
            addCriterion("lao_activity.SUB_TYPE between", value1, value2, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotBetween(String value1, String value2) {
            addCriterion("lao_activity.SUB_TYPE not between", value1, value2, "subType");
            return (Criteria) this;
        }

        public Criteria andSuitObjIsNull() {
            addCriterion("lao_activity.SUIT_OBJ is null");
            return (Criteria) this;
        }

        public Criteria andSuitObjIsNotNull() {
            addCriterion("lao_activity.SUIT_OBJ is not null");
            return (Criteria) this;
        }

        public Criteria andSuitObjEqualTo(String value) {
            addCriterion("lao_activity.SUIT_OBJ =", value, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjNotEqualTo(String value) {
            addCriterion("lao_activity.SUIT_OBJ <>", value, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjGreaterThan(String value) {
            addCriterion("lao_activity.SUIT_OBJ >", value, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjGreaterThanOrEqualTo(String value) {
            addCriterion("lao_activity.SUIT_OBJ >=", value, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjLessThan(String value) {
            addCriterion("lao_activity.SUIT_OBJ <", value, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjLessThanOrEqualTo(String value) {
            addCriterion("lao_activity.SUIT_OBJ <=", value, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjLike(String value) {
            addCriterion("lao_activity.SUIT_OBJ like", value, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjNotLike(String value) {
            addCriterion("lao_activity.SUIT_OBJ not like", value, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjIn(List<String> values) {
            addCriterion("lao_activity.SUIT_OBJ in", values, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjNotIn(List<String> values) {
            addCriterion("lao_activity.SUIT_OBJ not in", values, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjBetween(String value1, String value2) {
            addCriterion("lao_activity.SUIT_OBJ between", value1, value2, "suitObj");
            return (Criteria) this;
        }

        public Criteria andSuitObjNotBetween(String value1, String value2) {
            addCriterion("lao_activity.SUIT_OBJ not between", value1, value2, "suitObj");
            return (Criteria) this;
        }

        public Criteria andTagId1IsNull() {
            addCriterion("lao_activity.TAG_ID1 is null");
            return (Criteria) this;
        }

        public Criteria andTagId1IsNotNull() {
            addCriterion("lao_activity.TAG_ID1 is not null");
            return (Criteria) this;
        }

        public Criteria andTagId1EqualTo(Long value) {
            addCriterion("lao_activity.TAG_ID1 =", value, "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1NotEqualTo(Long value) {
            addCriterion("lao_activity.TAG_ID1 <>", value, "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1GreaterThan(Long value) {
            addCriterion("lao_activity.TAG_ID1 >", value, "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1GreaterThanOrEqualTo(Long value) {
            addCriterion("lao_activity.TAG_ID1 >=", value, "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1LessThan(Long value) {
            addCriterion("lao_activity.TAG_ID1 <", value, "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1LessThanOrEqualTo(Long value) {
            addCriterion("lao_activity.TAG_ID1 <=", value, "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1Like(Long value) {
            addCriterion("lao_activity.TAG_ID1 like", "%" + value + "%", "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1NotLike(Long value) {
            addCriterion("lao_activity.TAG_ID1 not like", "%" + value + "%", "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1In(List<Long> values) {
            addCriterion("lao_activity.TAG_ID1 in", values, "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1NotIn(List<Long> values) {
            addCriterion("lao_activity.TAG_ID1 not in", values, "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1Between(Long value1, Long value2) {
            addCriterion("lao_activity.TAG_ID1 between", value1, value2, "tagId1");
            return (Criteria) this;
        }

        public Criteria andTagId1NotBetween(Long value1, Long value2) {
            addCriterion("lao_activity.TAG_ID1 not between", value1, value2, "tagId1");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("lao_activity.MODEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("lao_activity.MODEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(String value) {
            addCriterion("lao_activity.MODEL_ID =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(String value) {
            addCriterion("lao_activity.MODEL_ID <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(String value) {
            addCriterion("lao_activity.MODEL_ID >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("lao_activity.MODEL_ID >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(String value) {
            addCriterion("lao_activity.MODEL_ID <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(String value) {
            addCriterion("lao_activity.MODEL_ID <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLike(String value) {
            addCriterion("lao_activity.MODEL_ID like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotLike(String value) {
            addCriterion("lao_activity.MODEL_ID not like", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<String> values) {
            addCriterion("lao_activity.MODEL_ID in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<String> values) {
            addCriterion("lao_activity.MODEL_ID not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(String value1, String value2) {
            addCriterion("lao_activity.MODEL_ID between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(String value1, String value2) {
            addCriterion("lao_activity.MODEL_ID not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("lao_activity.START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("lao_activity.START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("lao_activity.START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("lao_activity.START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("lao_activity.START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("lao_activity.START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("lao_activity.START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("lao_activity.START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("lao_activity.START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("lao_activity.START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("lao_activity.START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("lao_activity.START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("lao_activity.END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("lao_activity.END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("lao_activity.END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("lao_activity.END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("lao_activity.END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("lao_activity.END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("lao_activity.END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("lao_activity.END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("lao_activity.END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("lao_activity.END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("lao_activity.END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("lao_activity.END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNull() {
            addCriterion("lao_activity.ACTIVITY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNotNull() {
            addCriterion("lao_activity.ACTIVITY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_STATUS =", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_STATUS <>", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThan(String value) {
            addCriterion("lao_activity.ACTIVITY_STATUS >", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThanOrEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_STATUS >=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThan(String value) {
            addCriterion("lao_activity.ACTIVITY_STATUS <", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThanOrEqualTo(String value) {
            addCriterion("lao_activity.ACTIVITY_STATUS <=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLike(String value) {
            addCriterion("lao_activity.ACTIVITY_STATUS like", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotLike(String value) {
            addCriterion("lao_activity.ACTIVITY_STATUS not like", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIn(List<String> values) {
            addCriterion("lao_activity.ACTIVITY_STATUS in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotIn(List<String> values) {
            addCriterion("lao_activity.ACTIVITY_STATUS not in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusBetween(String value1, String value2) {
            addCriterion("lao_activity.ACTIVITY_STATUS between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotBetween(String value1, String value2) {
            addCriterion("lao_activity.ACTIVITY_STATUS not between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andDescrIsNull() {
            addCriterion("lao_activity.DESCR is null");
            return (Criteria) this;
        }

        public Criteria andDescrIsNotNull() {
            addCriterion("lao_activity.DESCR is not null");
            return (Criteria) this;
        }

        public Criteria andDescrEqualTo(String value) {
            addCriterion("lao_activity.DESCR =", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotEqualTo(String value) {
            addCriterion("lao_activity.DESCR <>", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThan(String value) {
            addCriterion("lao_activity.DESCR >", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThanOrEqualTo(String value) {
            addCriterion("lao_activity.DESCR >=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThan(String value) {
            addCriterion("lao_activity.DESCR <", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThanOrEqualTo(String value) {
            addCriterion("lao_activity.DESCR <=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLike(String value) {
            addCriterion("lao_activity.DESCR like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotLike(String value) {
            addCriterion("lao_activity.DESCR not like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrIn(List<String> values) {
            addCriterion("lao_activity.DESCR in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotIn(List<String> values) {
            addCriterion("lao_activity.DESCR not in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrBetween(String value1, String value2) {
            addCriterion("lao_activity.DESCR between", value1, value2, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotBetween(String value1, String value2) {
            addCriterion("lao_activity.DESCR not between", value1, value2, "descr");
            return (Criteria) this;
        }

        public Criteria andHasGroupIsNull() {
            addCriterion("lao_activity.HAS_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andHasGroupIsNotNull() {
            addCriterion("lao_activity.HAS_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andHasGroupEqualTo(String value) {
            addCriterion("lao_activity.HAS_GROUP =", value, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupNotEqualTo(String value) {
            addCriterion("lao_activity.HAS_GROUP <>", value, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupGreaterThan(String value) {
            addCriterion("lao_activity.HAS_GROUP >", value, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupGreaterThanOrEqualTo(String value) {
            addCriterion("lao_activity.HAS_GROUP >=", value, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupLessThan(String value) {
            addCriterion("lao_activity.HAS_GROUP <", value, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupLessThanOrEqualTo(String value) {
            addCriterion("lao_activity.HAS_GROUP <=", value, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupLike(String value) {
            addCriterion("lao_activity.HAS_GROUP like", value, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupNotLike(String value) {
            addCriterion("lao_activity.HAS_GROUP not like", value, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupIn(List<String> values) {
            addCriterion("lao_activity.HAS_GROUP in", values, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupNotIn(List<String> values) {
            addCriterion("lao_activity.HAS_GROUP not in", values, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupBetween(String value1, String value2) {
            addCriterion("lao_activity.HAS_GROUP between", value1, value2, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andHasGroupNotBetween(String value1, String value2) {
            addCriterion("lao_activity.HAS_GROUP not between", value1, value2, "hasGroup");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("lao_activity.CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("lao_activity.CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("lao_activity.CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("lao_activity.CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("lao_activity.CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lao_activity.CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("lao_activity.CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("lao_activity.CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("lao_activity.CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("lao_activity.CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("lao_activity.CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("lao_activity.CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("lao_activity.UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("lao_activity.UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("lao_activity.UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("lao_activity.UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("lao_activity.UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lao_activity.UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("lao_activity.UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("lao_activity.UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("lao_activity.UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("lao_activity.UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("lao_activity.UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("lao_activity.UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public <T> Criteria andConditionEqualTo(String tableName, String field, T value) {
            addCriterion(tableName + "." + field +" =", value, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionNotEqualTo(String tableName, String field, T value) {
            addCriterion(tableName + "." + field +" <>", value, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionLessThenOrEqualTo(String tableName, String field, T value) {
            addCriterion(tableName + "." + field +" <=", value, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionLessThen(String tableName, String field, T value) {
            addCriterion(tableName + "." + field +" <", value, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionGreaterThenOrEqualTo(String tableName, String field, T value) {
            addCriterion(tableName + "." + field +" >=", value, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionGreaterThan(String tableName, String field, T value) {
            addCriterion(tableName + "." + field +" >", value, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionBetween(String tableName, String field, T value1, T value2) {
            addCriterion(tableName + "." + field +" between", value1, value2, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionNotBetween(String tableName, String field, T value1, T value2) {
            addCriterion(tableName + "." + field +" not between", value1, value2, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionLike(String tableName, String field, T value) {
            addCriterion(tableName + "." + field +" like", value, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionNotLike(String tableName, String field, T value) {
            addCriterion(tableName + "." + field +" not like", value, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionIn(String tableName, String field, List<T> values) {
            addCriterion(tableName + "." + field +" in", values, "field");
            return (Criteria) this;
        }

        public <T> Criteria andConditionNotIn(String tableName, String field, List<T> values) {
            addCriterion(tableName + "." + field +" not in", values, "field");
            return (Criteria) this;
        }

        public Criteria andConditionIsNull(String tableName, String field) {
            addCriterion(tableName + "." + field +" is null");
            return (Criteria) this;
        }

        public Criteria andConditionIsNotNull(String tableName, String field) {
            addCriterion(tableName + "." + field +" is not null");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    protected abstract static class GeneratedAssociationCriteria {
        protected boolean onCondition = false;

        protected List<Criterion> criteria;

        protected GeneratedAssociationCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public AssociationCriteria andLeftJoin(String tableName) {
            addCriterion("left join" + tableName);
            onCondition = true;
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andRightJoin(String tableName) {
            addCriterion("right join" + tableName);
            onCondition = true;
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andInnerJoin(String tableName) {
            addCriterion("inner join" + tableName);
            onCondition = true;
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andAssociateOnConditionEqualTo(String tableName1, String field1, String tableName2, String field2) {
            if (isValid()) {
                if (onCondition) {
                    onCondition = false;
                    addCriterion("on" + tableName1 + "." + field1 + "=" + tableName2 + "." + field2);
                }else {
                    addCriterion("and" + tableName1 + "." + field1 + "=" + tableName2 + "." + field2);
                }
            }
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andAssociateOnConditionNotEqualTo(String tableName1, String field1, String tableName2, String field2) {
            if (isValid()) {
                if (onCondition) {
                    onCondition = false;
                    addCriterion("on" + tableName1 + "." + field1 + "<>" + tableName2 + "." + field2);
                }else {
                    addCriterion("and" + tableName1 + "." + field1 + "<>" + tableName2 + "." + field2);
                }
            }
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andAssociateOnConditionLike(String tableName1, String field1, String tableName2, String field2) {
            if (isValid()) {
                if (onCondition) {
                    onCondition = false;
                    addCriterion("on" + tableName1 + "." + field1 + "like" + tableName2 + "." + field2);
                }else {
                    addCriterion("and" + tableName1 + "." + field1 + "like" + tableName2 + "." + field2);
                }
            }
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andAssociateOnConditionNotLike(String tableName1, String field1, String tableName2, String field2) {
            if (isValid()) {
                if (onCondition) {
                    onCondition = false;
                    addCriterion("on" + tableName1 + "." + field1 + "not like" + tableName2 + "." + field2);
                }else {
                    addCriterion("and" + tableName1 + "." + field1 + "not like" + tableName2 + "." + field2);
                }
            }
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andAssociateOnConditionLessThenOrEqualTo(String tableName1, String field1, String tableName2, String field2) {
            if (isValid()) {
                if (onCondition) {
                    onCondition = false;
                    addCriterion("on" + tableName1 + "." + field1 + "<=" + tableName2 + "." + field2);
                }else {
                    addCriterion("and" + tableName1 + "." + field1 + "<=" + tableName2 + "." + field2);
                }
            }
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andAssociateOnConditionLessThen(String tableName1, String field1, String tableName2, String field2) {
            if (isValid()) {
                if (onCondition) {
                    onCondition = false;
                    addCriterion("on" + tableName1 + "." + field1 + "<" + tableName2 + "." + field2);
                }else {
                    addCriterion("and" + tableName1 + "." + field1 + "<" + tableName2 + "." + field2);
                }
            }
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andAssociateOnConditionGraterThenOrEqualTo(String tableName1, String field1, String tableName2, String field2) {
            if (isValid()) {
                if (onCondition) {
                    onCondition = false;
                    addCriterion("on" + tableName1 + "." + field1 + ">=" + tableName2 + "." + field2);
                }else {
                    addCriterion("and" + tableName1 + "." + field1 + ">=" + tableName2 + "." + field2);
                }
            }
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andAssociateOnConditionGraterThen(String tableName1, String field1, String tableName2, String field2) {
            if (isValid()) {
                if (onCondition) {
                    onCondition = false;
                    addCriterion("on" + tableName1 + "." + field1 + ">" + tableName2 + "." + field2);
                }else {
                    addCriterion("and" + tableName1 + "." + field1 + ">" + tableName2 + "." + field2);
                }
            }
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionEqualTo(String tableName, String field, T value) {
            addCriterion("and " + tableName + "." + field +" =", value, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionNotEqualTo(String tableName, String field, T value) {
            addCriterion("and " + tableName + "." + field +" <>", value, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionLessThenOrEqualTo(String tableName, String field, T value) {
            addCriterion("and " + tableName + "." + field +" <=", value, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionLessThen(String tableName, String field, T value) {
            addCriterion("and " + tableName + "." + field +" <", value, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionGreaterThenOrEqualTo(String tableName, String field, T value) {
            addCriterion("and " + tableName + "." + field +" >=", value, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionGreaterThan(String tableName, String field, T value) {
            addCriterion("and " + tableName + "." + field +" >", value, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionBetween(String tableName, String field, T value1, T value2) {
            addCriterion("and " + tableName + "." + field +" between", value1, value2, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionNotBetween(String tableName, String field, T value1, T value2) {
            addCriterion("and " + tableName + "." + field +" not between", value1, value2, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionLike(String tableName, String field, T value) {
            addCriterion("and " + tableName + "." + field +" like", value, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionNotLike(String tableName, String field, T value) {
            addCriterion("and " + tableName + "." + field +" not like", value, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionIn(String tableName, String field, List<T> values) {
            addCriterion("and " + tableName + "." + field +" in", values, "field");
            return (AssociationCriteria) this;
        }

        public <T> AssociationCriteria andConditionNotIn(String tableName, String field, List<T> values) {
            addCriterion("and " + tableName + "." + field +" not in", values, "field");
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andConditionIsNull(String tableName, String field) {
            addCriterion("and " + tableName + "." + field +" is null");
            return (AssociationCriteria) this;
        }

        public AssociationCriteria andConditionIsNotNull(String tableName, String field) {
            addCriterion("and " + tableName + "." + field +" is not null");
            return (AssociationCriteria) this;
        }
    }

    public static class AssociationCriteria extends GeneratedAssociationCriteria {
        protected AssociationCriteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}