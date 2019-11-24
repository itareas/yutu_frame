package com.yutu.entity.table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSysLandinglogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSysLandinglogExample() {
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

        public Criteria andLoginUseridIsNull() {
            addCriterion("login_userid is null");
            return (Criteria) this;
        }

        public Criteria andLoginUseridIsNotNull() {
            addCriterion("login_userid is not null");
            return (Criteria) this;
        }

        public Criteria andLoginUseridEqualTo(String value) {
            addCriterion("login_userid =", value, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridNotEqualTo(String value) {
            addCriterion("login_userid <>", value, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridGreaterThan(String value) {
            addCriterion("login_userid >", value, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridGreaterThanOrEqualTo(String value) {
            addCriterion("login_userid >=", value, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridLessThan(String value) {
            addCriterion("login_userid <", value, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridLessThanOrEqualTo(String value) {
            addCriterion("login_userid <=", value, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridLike(String value) {
            addCriterion("login_userid like", value, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridNotLike(String value) {
            addCriterion("login_userid not like", value, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridIn(List<String> values) {
            addCriterion("login_userid in", values, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridNotIn(List<String> values) {
            addCriterion("login_userid not in", values, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridBetween(String value1, String value2) {
            addCriterion("login_userid between", value1, value2, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginUseridNotBetween(String value1, String value2) {
            addCriterion("login_userid not between", value1, value2, "loginUserid");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIsNull() {
            addCriterion("login_account is null");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIsNotNull() {
            addCriterion("login_account is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAccountEqualTo(String value) {
            addCriterion("login_account =", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotEqualTo(String value) {
            addCriterion("login_account <>", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountGreaterThan(String value) {
            addCriterion("login_account >", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountGreaterThanOrEqualTo(String value) {
            addCriterion("login_account >=", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLessThan(String value) {
            addCriterion("login_account <", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLessThanOrEqualTo(String value) {
            addCriterion("login_account <=", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLike(String value) {
            addCriterion("login_account like", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotLike(String value) {
            addCriterion("login_account not like", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIn(List<String> values) {
            addCriterion("login_account in", values, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotIn(List<String> values) {
            addCriterion("login_account not in", values, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountBetween(String value1, String value2) {
            addCriterion("login_account between", value1, value2, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotBetween(String value1, String value2) {
            addCriterion("login_account not between", value1, value2, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("login_ip =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("login_ip <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("login_ip >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("login_ip >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("login_ip <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("login_ip <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("login_ip like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("login_ip not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("login_ip in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("login_ip not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("login_ip between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("login_ip not between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidIsNull() {
            addCriterion("login_sessionid is null");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidIsNotNull() {
            addCriterion("login_sessionid is not null");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidEqualTo(String value) {
            addCriterion("login_sessionid =", value, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidNotEqualTo(String value) {
            addCriterion("login_sessionid <>", value, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidGreaterThan(String value) {
            addCriterion("login_sessionid >", value, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("login_sessionid >=", value, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidLessThan(String value) {
            addCriterion("login_sessionid <", value, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidLessThanOrEqualTo(String value) {
            addCriterion("login_sessionid <=", value, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidLike(String value) {
            addCriterion("login_sessionid like", value, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidNotLike(String value) {
            addCriterion("login_sessionid not like", value, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidIn(List<String> values) {
            addCriterion("login_sessionid in", values, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidNotIn(List<String> values) {
            addCriterion("login_sessionid not in", values, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidBetween(String value1, String value2) {
            addCriterion("login_sessionid between", value1, value2, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginSessionidNotBetween(String value1, String value2) {
            addCriterion("login_sessionid not between", value1, value2, "loginSessionid");
            return (Criteria) this;
        }

        public Criteria andLoginDateIsNull() {
            addCriterion("login_date is null");
            return (Criteria) this;
        }

        public Criteria andLoginDateIsNotNull() {
            addCriterion("login_date is not null");
            return (Criteria) this;
        }

        public Criteria andLoginDateEqualTo(Date value) {
            addCriterion("login_date =", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotEqualTo(Date value) {
            addCriterion("login_date <>", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateGreaterThan(Date value) {
            addCriterion("login_date >", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("login_date >=", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateLessThan(Date value) {
            addCriterion("login_date <", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateLessThanOrEqualTo(Date value) {
            addCriterion("login_date <=", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateIn(List<Date> values) {
            addCriterion("login_date in", values, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotIn(List<Date> values) {
            addCriterion("login_date not in", values, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateBetween(Date value1, Date value2) {
            addCriterion("login_date between", value1, value2, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotBetween(Date value1, Date value2) {
            addCriterion("login_date not between", value1, value2, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNull() {
            addCriterion("login_type is null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIsNotNull() {
            addCriterion("login_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeEqualTo(String value) {
            addCriterion("login_type =", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotEqualTo(String value) {
            addCriterion("login_type <>", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThan(String value) {
            addCriterion("login_type >", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeGreaterThanOrEqualTo(String value) {
            addCriterion("login_type >=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThan(String value) {
            addCriterion("login_type <", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLessThanOrEqualTo(String value) {
            addCriterion("login_type <=", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeLike(String value) {
            addCriterion("login_type like", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotLike(String value) {
            addCriterion("login_type not like", value, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIn(List<String> values) {
            addCriterion("login_type in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotIn(List<String> values) {
            addCriterion("login_type not in", values, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeBetween(String value1, String value2) {
            addCriterion("login_type between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginTypeNotBetween(String value1, String value2) {
            addCriterion("login_type not between", value1, value2, "loginType");
            return (Criteria) this;
        }

        public Criteria andLoginResultIsNull() {
            addCriterion("login_result is null");
            return (Criteria) this;
        }

        public Criteria andLoginResultIsNotNull() {
            addCriterion("login_result is not null");
            return (Criteria) this;
        }

        public Criteria andLoginResultEqualTo(Integer value) {
            addCriterion("login_result =", value, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginResultNotEqualTo(Integer value) {
            addCriterion("login_result <>", value, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginResultGreaterThan(Integer value) {
            addCriterion("login_result >", value, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_result >=", value, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginResultLessThan(Integer value) {
            addCriterion("login_result <", value, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginResultLessThanOrEqualTo(Integer value) {
            addCriterion("login_result <=", value, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginResultIn(List<Integer> values) {
            addCriterion("login_result in", values, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginResultNotIn(List<Integer> values) {
            addCriterion("login_result not in", values, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginResultBetween(Integer value1, Integer value2) {
            addCriterion("login_result between", value1, value2, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginResultNotBetween(Integer value1, Integer value2) {
            addCriterion("login_result not between", value1, value2, "loginResult");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameIsNull() {
            addCriterion("login_appname is null");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameIsNotNull() {
            addCriterion("login_appname is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameEqualTo(String value) {
            addCriterion("login_appname =", value, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameNotEqualTo(String value) {
            addCriterion("login_appname <>", value, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameGreaterThan(String value) {
            addCriterion("login_appname >", value, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameGreaterThanOrEqualTo(String value) {
            addCriterion("login_appname >=", value, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameLessThan(String value) {
            addCriterion("login_appname <", value, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameLessThanOrEqualTo(String value) {
            addCriterion("login_appname <=", value, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameLike(String value) {
            addCriterion("login_appname like", value, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameNotLike(String value) {
            addCriterion("login_appname not like", value, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameIn(List<String> values) {
            addCriterion("login_appname in", values, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameNotIn(List<String> values) {
            addCriterion("login_appname not in", values, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameBetween(String value1, String value2) {
            addCriterion("login_appname between", value1, value2, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAppnameNotBetween(String value1, String value2) {
            addCriterion("login_appname not between", value1, value2, "loginAppname");
            return (Criteria) this;
        }

        public Criteria andLoginAddressIsNull() {
            addCriterion("login_address is null");
            return (Criteria) this;
        }

        public Criteria andLoginAddressIsNotNull() {
            addCriterion("login_address is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAddressEqualTo(String value) {
            addCriterion("login_address =", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotEqualTo(String value) {
            addCriterion("login_address <>", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressGreaterThan(String value) {
            addCriterion("login_address >", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressGreaterThanOrEqualTo(String value) {
            addCriterion("login_address >=", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressLessThan(String value) {
            addCriterion("login_address <", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressLessThanOrEqualTo(String value) {
            addCriterion("login_address <=", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressLike(String value) {
            addCriterion("login_address like", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotLike(String value) {
            addCriterion("login_address not like", value, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressIn(List<String> values) {
            addCriterion("login_address in", values, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotIn(List<String> values) {
            addCriterion("login_address not in", values, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressBetween(String value1, String value2) {
            addCriterion("login_address between", value1, value2, "loginAddress");
            return (Criteria) this;
        }

        public Criteria andLoginAddressNotBetween(String value1, String value2) {
            addCriterion("login_address not between", value1, value2, "loginAddress");
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