package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AccountExample {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected String orderByClause;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected boolean distinct;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public AccountExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("ACCOUNT_ID >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("ACCOUNT_ID <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("ACCOUNT_ID <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("ACCOUNT_ID in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("ACCOUNT_ID not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT_ID between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ACCOUNT_ID not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceIsNull() {
            addCriterion("AVAIL_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceIsNotNull() {
            addCriterion("AVAIL_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceEqualTo(Float value) {
            addCriterion("AVAIL_BALANCE =", value, "availBalance");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceNotEqualTo(Float value) {
            addCriterion("AVAIL_BALANCE <>", value, "availBalance");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceGreaterThan(Float value) {
            addCriterion("AVAIL_BALANCE >", value, "availBalance");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("AVAIL_BALANCE >=", value, "availBalance");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceLessThan(Float value) {
            addCriterion("AVAIL_BALANCE <", value, "availBalance");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceLessThanOrEqualTo(Float value) {
            addCriterion("AVAIL_BALANCE <=", value, "availBalance");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceIn(List<Float> values) {
            addCriterion("AVAIL_BALANCE in", values, "availBalance");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceNotIn(List<Float> values) {
            addCriterion("AVAIL_BALANCE not in", values, "availBalance");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceBetween(Float value1, Float value2) {
            addCriterion("AVAIL_BALANCE between", value1, value2, "availBalance");
            return (Criteria) this;
        }

        public Criteria andAvailBalanceNotBetween(Float value1, Float value2) {
            addCriterion("AVAIL_BALANCE not between", value1, value2, "availBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceIsNull() {
            addCriterion("PENDING_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceIsNotNull() {
            addCriterion("PENDING_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceEqualTo(Float value) {
            addCriterion("PENDING_BALANCE =", value, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceNotEqualTo(Float value) {
            addCriterion("PENDING_BALANCE <>", value, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceGreaterThan(Float value) {
            addCriterion("PENDING_BALANCE >", value, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("PENDING_BALANCE >=", value, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceLessThan(Float value) {
            addCriterion("PENDING_BALANCE <", value, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceLessThanOrEqualTo(Float value) {
            addCriterion("PENDING_BALANCE <=", value, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceIn(List<Float> values) {
            addCriterion("PENDING_BALANCE in", values, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceNotIn(List<Float> values) {
            addCriterion("PENDING_BALANCE not in", values, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceBetween(Float value1, Float value2) {
            addCriterion("PENDING_BALANCE between", value1, value2, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andPendingBalanceNotBetween(Float value1, Float value2) {
            addCriterion("PENDING_BALANCE not between", value1, value2, "pendingBalance");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`STATUS` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`STATUS` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`STATUS` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`STATUS` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`STATUS` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`STATUS` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`STATUS` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`STATUS` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`STATUS` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`STATUS` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`STATUS` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`STATUS` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`STATUS` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`STATUS` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("OPEN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("OPEN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(Date value) {
            addCriterionForJDBCDate("OPEN_DATE =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("OPEN_DATE <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(Date value) {
            addCriterionForJDBCDate("OPEN_DATE >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPEN_DATE >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(Date value) {
            addCriterionForJDBCDate("OPEN_DATE <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPEN_DATE <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<Date> values) {
            addCriterionForJDBCDate("OPEN_DATE in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("OPEN_DATE not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPEN_DATE between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPEN_DATE not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateIsNull() {
            addCriterion("LAST_ACTIVITY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateIsNotNull() {
            addCriterion("LAST_ACTIVITY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE =", value, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE <>", value, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateGreaterThan(Date value) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE >", value, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE >=", value, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateLessThan(Date value) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE <", value, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE <=", value, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE in", values, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE not in", values, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE between", value1, value2, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andLastActivityDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_ACTIVITY_DATE not between", value1, value2, "lastActivityDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateIsNull() {
            addCriterion("CLOSE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCloseDateIsNotNull() {
            addCriterion("CLOSE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCloseDateEqualTo(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE =", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE <>", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE >", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE >=", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateLessThan(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE <", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE <=", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateIn(List<Date> values) {
            addCriterionForJDBCDate("CLOSE_DATE in", values, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CLOSE_DATE not in", values, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CLOSE_DATE between", value1, value2, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CLOSE_DATE not between", value1, value2, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdIsNull() {
            addCriterion("customer_CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdIsNotNull() {
            addCriterion("customer_CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdEqualTo(Integer value) {
            addCriterion("customer_CUST_ID =", value, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdNotEqualTo(Integer value) {
            addCriterion("customer_CUST_ID <>", value, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdGreaterThan(Integer value) {
            addCriterion("customer_CUST_ID >", value, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_CUST_ID >=", value, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdLessThan(Integer value) {
            addCriterion("customer_CUST_ID <", value, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_CUST_ID <=", value, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdIn(List<Integer> values) {
            addCriterion("customer_CUST_ID in", values, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdNotIn(List<Integer> values) {
            addCriterion("customer_CUST_ID not in", values, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_CUST_ID between", value1, value2, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andCustomerCustIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_CUST_ID not between", value1, value2, "customerCustId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdIsNull() {
            addCriterion("branch_BRANCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdIsNotNull() {
            addCriterion("branch_BRANCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdEqualTo(Integer value) {
            addCriterion("branch_BRANCH_ID =", value, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdNotEqualTo(Integer value) {
            addCriterion("branch_BRANCH_ID <>", value, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdGreaterThan(Integer value) {
            addCriterion("branch_BRANCH_ID >", value, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("branch_BRANCH_ID >=", value, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdLessThan(Integer value) {
            addCriterion("branch_BRANCH_ID <", value, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdLessThanOrEqualTo(Integer value) {
            addCriterion("branch_BRANCH_ID <=", value, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdIn(List<Integer> values) {
            addCriterion("branch_BRANCH_ID in", values, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdNotIn(List<Integer> values) {
            addCriterion("branch_BRANCH_ID not in", values, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdBetween(Integer value1, Integer value2) {
            addCriterion("branch_BRANCH_ID between", value1, value2, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andBranchBranchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("branch_BRANCH_ID not between", value1, value2, "branchBranchId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdIsNull() {
            addCriterion("employee_EMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdIsNotNull() {
            addCriterion("employee_EMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdEqualTo(Integer value) {
            addCriterion("employee_EMP_ID =", value, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdNotEqualTo(Integer value) {
            addCriterion("employee_EMP_ID <>", value, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdGreaterThan(Integer value) {
            addCriterion("employee_EMP_ID >", value, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_EMP_ID >=", value, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdLessThan(Integer value) {
            addCriterion("employee_EMP_ID <", value, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_EMP_ID <=", value, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdIn(List<Integer> values) {
            addCriterion("employee_EMP_ID in", values, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdNotIn(List<Integer> values) {
            addCriterion("employee_EMP_ID not in", values, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_EMP_ID between", value1, value2, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andEmployeeEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_EMP_ID not between", value1, value2, "employeeEmpId");
            return (Criteria) this;
        }

        public Criteria andProductProductCdIsNull() {
            addCriterion("product_PRODUCT_CD is null");
            return (Criteria) this;
        }

        public Criteria andProductProductCdIsNotNull() {
            addCriterion("product_PRODUCT_CD is not null");
            return (Criteria) this;
        }

        public Criteria andProductProductCdEqualTo(String value) {
            addCriterion("product_PRODUCT_CD =", value, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdNotEqualTo(String value) {
            addCriterion("product_PRODUCT_CD <>", value, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdGreaterThan(String value) {
            addCriterion("product_PRODUCT_CD >", value, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdGreaterThanOrEqualTo(String value) {
            addCriterion("product_PRODUCT_CD >=", value, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdLessThan(String value) {
            addCriterion("product_PRODUCT_CD <", value, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdLessThanOrEqualTo(String value) {
            addCriterion("product_PRODUCT_CD <=", value, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdLike(String value) {
            addCriterion("product_PRODUCT_CD like", value, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdNotLike(String value) {
            addCriterion("product_PRODUCT_CD not like", value, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdIn(List<String> values) {
            addCriterion("product_PRODUCT_CD in", values, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdNotIn(List<String> values) {
            addCriterion("product_PRODUCT_CD not in", values, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdBetween(String value1, String value2) {
            addCriterion("product_PRODUCT_CD between", value1, value2, "productProductCd");
            return (Criteria) this;
        }

        public Criteria andProductProductCdNotBetween(String value1, String value2) {
            addCriterion("product_PRODUCT_CD not between", value1, value2, "productProductCd");
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