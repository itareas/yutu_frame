package com.yutu.entity.table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSysOperationlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSysOperationlogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
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

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andOperateDbIsNull() {
            addCriterion("operate_db is null");
            return (Criteria) this;
        }

        public Criteria andOperateDbIsNotNull() {
            addCriterion("operate_db is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDbEqualTo(String value) {
            addCriterion("operate_db =", value, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbNotEqualTo(String value) {
            addCriterion("operate_db <>", value, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbGreaterThan(String value) {
            addCriterion("operate_db >", value, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbGreaterThanOrEqualTo(String value) {
            addCriterion("operate_db >=", value, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbLessThan(String value) {
            addCriterion("operate_db <", value, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbLessThanOrEqualTo(String value) {
            addCriterion("operate_db <=", value, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbLike(String value) {
            addCriterion("operate_db like", value, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbNotLike(String value) {
            addCriterion("operate_db not like", value, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbIn(List<String> values) {
            addCriterion("operate_db in", values, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbNotIn(List<String> values) {
            addCriterion("operate_db not in", values, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbBetween(String value1, String value2) {
            addCriterion("operate_db between", value1, value2, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDbNotBetween(String value1, String value2) {
            addCriterion("operate_db not between", value1, value2, "operateDb");
            return (Criteria) this;
        }

        public Criteria andOperateDtIsNull() {
            addCriterion("operate_dt is null");
            return (Criteria) this;
        }

        public Criteria andOperateDtIsNotNull() {
            addCriterion("operate_dt is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDtEqualTo(String value) {
            addCriterion("operate_dt =", value, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtNotEqualTo(String value) {
            addCriterion("operate_dt <>", value, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtGreaterThan(String value) {
            addCriterion("operate_dt >", value, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtGreaterThanOrEqualTo(String value) {
            addCriterion("operate_dt >=", value, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtLessThan(String value) {
            addCriterion("operate_dt <", value, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtLessThanOrEqualTo(String value) {
            addCriterion("operate_dt <=", value, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtLike(String value) {
            addCriterion("operate_dt like", value, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtNotLike(String value) {
            addCriterion("operate_dt not like", value, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtIn(List<String> values) {
            addCriterion("operate_dt in", values, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtNotIn(List<String> values) {
            addCriterion("operate_dt not in", values, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtBetween(String value1, String value2) {
            addCriterion("operate_dt between", value1, value2, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateDtNotBetween(String value1, String value2) {
            addCriterion("operate_dt not between", value1, value2, "operateDt");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNull() {
            addCriterion("operate_type is null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIsNotNull() {
            addCriterion("operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTypeEqualTo(String value) {
            addCriterion("operate_type =", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotEqualTo(String value) {
            addCriterion("operate_type <>", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThan(String value) {
            addCriterion("operate_type >", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("operate_type >=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThan(String value) {
            addCriterion("operate_type <", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLessThanOrEqualTo(String value) {
            addCriterion("operate_type <=", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeLike(String value) {
            addCriterion("operate_type like", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotLike(String value) {
            addCriterion("operate_type not like", value, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeIn(List<String> values) {
            addCriterion("operate_type in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotIn(List<String> values) {
            addCriterion("operate_type not in", values, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeBetween(String value1, String value2) {
            addCriterion("operate_type between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperateTypeNotBetween(String value1, String value2) {
            addCriterion("operate_type not between", value1, value2, "operateType");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyIsNull() {
            addCriterion("operate_primarykey is null");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyIsNotNull() {
            addCriterion("operate_primarykey is not null");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyEqualTo(String value) {
            addCriterion("operate_primarykey =", value, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyNotEqualTo(String value) {
            addCriterion("operate_primarykey <>", value, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyGreaterThan(String value) {
            addCriterion("operate_primarykey >", value, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyGreaterThanOrEqualTo(String value) {
            addCriterion("operate_primarykey >=", value, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyLessThan(String value) {
            addCriterion("operate_primarykey <", value, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyLessThanOrEqualTo(String value) {
            addCriterion("operate_primarykey <=", value, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyLike(String value) {
            addCriterion("operate_primarykey like", value, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyNotLike(String value) {
            addCriterion("operate_primarykey not like", value, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyIn(List<String> values) {
            addCriterion("operate_primarykey in", values, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyNotIn(List<String> values) {
            addCriterion("operate_primarykey not in", values, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyBetween(String value1, String value2) {
            addCriterion("operate_primarykey between", value1, value2, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePrimarykeyNotBetween(String value1, String value2) {
            addCriterion("operate_primarykey not between", value1, value2, "operatePrimarykey");
            return (Criteria) this;
        }

        public Criteria andOperatePersonIsNull() {
            addCriterion("operate_person is null");
            return (Criteria) this;
        }

        public Criteria andOperatePersonIsNotNull() {
            addCriterion("operate_person is not null");
            return (Criteria) this;
        }

        public Criteria andOperatePersonEqualTo(String value) {
            addCriterion("operate_person =", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonNotEqualTo(String value) {
            addCriterion("operate_person <>", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonGreaterThan(String value) {
            addCriterion("operate_person >", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("operate_person >=", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonLessThan(String value) {
            addCriterion("operate_person <", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonLessThanOrEqualTo(String value) {
            addCriterion("operate_person <=", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonLike(String value) {
            addCriterion("operate_person like", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonNotLike(String value) {
            addCriterion("operate_person not like", value, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonIn(List<String> values) {
            addCriterion("operate_person in", values, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonNotIn(List<String> values) {
            addCriterion("operate_person not in", values, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonBetween(String value1, String value2) {
            addCriterion("operate_person between", value1, value2, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperatePersonNotBetween(String value1, String value2) {
            addCriterion("operate_person not between", value1, value2, "operatePerson");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeIsNull() {
            addCriterion("operate_datetime is null");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeIsNotNull() {
            addCriterion("operate_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeEqualTo(Date value) {
            addCriterion("operate_datetime =", value, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeNotEqualTo(Date value) {
            addCriterion("operate_datetime <>", value, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeGreaterThan(Date value) {
            addCriterion("operate_datetime >", value, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operate_datetime >=", value, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeLessThan(Date value) {
            addCriterion("operate_datetime <", value, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("operate_datetime <=", value, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeIn(List<Date> values) {
            addCriterion("operate_datetime in", values, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeNotIn(List<Date> values) {
            addCriterion("operate_datetime not in", values, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeBetween(Date value1, Date value2) {
            addCriterion("operate_datetime between", value1, value2, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andOperateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("operate_datetime not between", value1, value2, "operateDatetime");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("log_type like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<String> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<String> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
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