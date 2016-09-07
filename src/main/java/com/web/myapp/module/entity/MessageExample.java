package com.web.myapp.module.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public MessageExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNull() {
            addCriterion("SenderID is null");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNotNull() {
            addCriterion("SenderID is not null");
            return (Criteria) this;
        }

        public Criteria andSenderidEqualTo(Integer value) {
            addCriterion("SenderID =", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotEqualTo(Integer value) {
            addCriterion("SenderID <>", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThan(Integer value) {
            addCriterion("SenderID >", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SenderID >=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThan(Integer value) {
            addCriterion("SenderID <", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThanOrEqualTo(Integer value) {
            addCriterion("SenderID <=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidIn(List<Integer> values) {
            addCriterion("SenderID in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotIn(List<Integer> values) {
            addCriterion("SenderID not in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidBetween(Integer value1, Integer value2) {
            addCriterion("SenderID between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotBetween(Integer value1, Integer value2) {
            addCriterion("SenderID not between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNull() {
            addCriterion("ReceiverID is null");
            return (Criteria) this;
        }

        public Criteria andReceiveridIsNotNull() {
            addCriterion("ReceiverID is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveridEqualTo(Integer value) {
            addCriterion("ReceiverID =", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotEqualTo(Integer value) {
            addCriterion("ReceiverID <>", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThan(Integer value) {
            addCriterion("ReceiverID >", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReceiverID >=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThan(Integer value) {
            addCriterion("ReceiverID <", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridLessThanOrEqualTo(Integer value) {
            addCriterion("ReceiverID <=", value, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridIn(List<Integer> values) {
            addCriterion("ReceiverID in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotIn(List<Integer> values) {
            addCriterion("ReceiverID not in", values, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridBetween(Integer value1, Integer value2) {
            addCriterion("ReceiverID between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andReceiveridNotBetween(Integer value1, Integer value2) {
            addCriterion("ReceiverID not between", value1, value2, "receiverid");
            return (Criteria) this;
        }

        public Criteria andCopyeridIsNull() {
            addCriterion("CopyerID is null");
            return (Criteria) this;
        }

        public Criteria andCopyeridIsNotNull() {
            addCriterion("CopyerID is not null");
            return (Criteria) this;
        }

        public Criteria andCopyeridEqualTo(String value) {
            addCriterion("CopyerID =", value, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridNotEqualTo(String value) {
            addCriterion("CopyerID <>", value, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridGreaterThan(String value) {
            addCriterion("CopyerID >", value, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridGreaterThanOrEqualTo(String value) {
            addCriterion("CopyerID >=", value, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridLessThan(String value) {
            addCriterion("CopyerID <", value, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridLessThanOrEqualTo(String value) {
            addCriterion("CopyerID <=", value, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridLike(String value) {
            addCriterion("CopyerID like", value, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridNotLike(String value) {
            addCriterion("CopyerID not like", value, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridIn(List<String> values) {
            addCriterion("CopyerID in", values, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridNotIn(List<String> values) {
            addCriterion("CopyerID not in", values, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridBetween(String value1, String value2) {
            addCriterion("CopyerID between", value1, value2, "copyerid");
            return (Criteria) this;
        }

        public Criteria andCopyeridNotBetween(String value1, String value2) {
            addCriterion("CopyerID not between", value1, value2, "copyerid");
            return (Criteria) this;
        }

        public Criteria andSecreteridIsNull() {
            addCriterion("SecreterID is null");
            return (Criteria) this;
        }

        public Criteria andSecreteridIsNotNull() {
            addCriterion("SecreterID is not null");
            return (Criteria) this;
        }

        public Criteria andSecreteridEqualTo(String value) {
            addCriterion("SecreterID =", value, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridNotEqualTo(String value) {
            addCriterion("SecreterID <>", value, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridGreaterThan(String value) {
            addCriterion("SecreterID >", value, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridGreaterThanOrEqualTo(String value) {
            addCriterion("SecreterID >=", value, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridLessThan(String value) {
            addCriterion("SecreterID <", value, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridLessThanOrEqualTo(String value) {
            addCriterion("SecreterID <=", value, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridLike(String value) {
            addCriterion("SecreterID like", value, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridNotLike(String value) {
            addCriterion("SecreterID not like", value, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridIn(List<String> values) {
            addCriterion("SecreterID in", values, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridNotIn(List<String> values) {
            addCriterion("SecreterID not in", values, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridBetween(String value1, String value2) {
            addCriterion("SecreterID between", value1, value2, "secreterid");
            return (Criteria) this;
        }

        public Criteria andSecreteridNotBetween(String value1, String value2) {
            addCriterion("SecreterID not between", value1, value2, "secreterid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("Title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("Title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("Title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("Title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("Title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("Title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("Title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("Title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("Title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("Title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("Title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("Title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("Title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("Icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("Icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("Icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("Icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("Icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("Icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("Icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("Icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("Icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("Icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("Icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("Icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("Icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("Icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("Url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("Url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("Url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("Url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("Url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("Url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("Url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("Url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("Url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("Url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("Url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("Url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("Url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("Url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andIssendIsNull() {
            addCriterion("IsSend is null");
            return (Criteria) this;
        }

        public Criteria andIssendIsNotNull() {
            addCriterion("IsSend is not null");
            return (Criteria) this;
        }

        public Criteria andIssendEqualTo(Boolean value) {
            addCriterion("IsSend =", value, "issend");
            return (Criteria) this;
        }

        public Criteria andIssendNotEqualTo(Boolean value) {
            addCriterion("IsSend <>", value, "issend");
            return (Criteria) this;
        }

        public Criteria andIssendGreaterThan(Boolean value) {
            addCriterion("IsSend >", value, "issend");
            return (Criteria) this;
        }

        public Criteria andIssendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsSend >=", value, "issend");
            return (Criteria) this;
        }

        public Criteria andIssendLessThan(Boolean value) {
            addCriterion("IsSend <", value, "issend");
            return (Criteria) this;
        }

        public Criteria andIssendLessThanOrEqualTo(Boolean value) {
            addCriterion("IsSend <=", value, "issend");
            return (Criteria) this;
        }

        public Criteria andIssendIn(List<Boolean> values) {
            addCriterion("IsSend in", values, "issend");
            return (Criteria) this;
        }

        public Criteria andIssendNotIn(List<Boolean> values) {
            addCriterion("IsSend not in", values, "issend");
            return (Criteria) this;
        }

        public Criteria andIssendBetween(Boolean value1, Boolean value2) {
            addCriterion("IsSend between", value1, value2, "issend");
            return (Criteria) this;
        }

        public Criteria andIssendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsSend not between", value1, value2, "issend");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("SendTime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("SendTime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("SendTime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("SendTime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("SendTime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SendTime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("SendTime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("SendTime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("SendTime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("SendTime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("SendTime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("SendTime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNull() {
            addCriterion("SendType is null");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNotNull() {
            addCriterion("SendType is not null");
            return (Criteria) this;
        }

        public Criteria andSendtypeEqualTo(Integer value) {
            addCriterion("SendType =", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotEqualTo(Integer value) {
            addCriterion("SendType <>", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThan(Integer value) {
            addCriterion("SendType >", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SendType >=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThan(Integer value) {
            addCriterion("SendType <", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThanOrEqualTo(Integer value) {
            addCriterion("SendType <=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeIn(List<Integer> values) {
            addCriterion("SendType in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotIn(List<Integer> values) {
            addCriterion("SendType not in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeBetween(Integer value1, Integer value2) {
            addCriterion("SendType between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SendType not between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andIsreadIsNull() {
            addCriterion("IsRead is null");
            return (Criteria) this;
        }

        public Criteria andIsreadIsNotNull() {
            addCriterion("IsRead is not null");
            return (Criteria) this;
        }

        public Criteria andIsreadEqualTo(Boolean value) {
            addCriterion("IsRead =", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotEqualTo(Boolean value) {
            addCriterion("IsRead <>", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadGreaterThan(Boolean value) {
            addCriterion("IsRead >", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsRead >=", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadLessThan(Boolean value) {
            addCriterion("IsRead <", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadLessThanOrEqualTo(Boolean value) {
            addCriterion("IsRead <=", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadIn(List<Boolean> values) {
            addCriterion("IsRead in", values, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotIn(List<Boolean> values) {
            addCriterion("IsRead not in", values, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadBetween(Boolean value1, Boolean value2) {
            addCriterion("IsRead between", value1, value2, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsRead not between", value1, value2, "isread");
            return (Criteria) this;
        }

        public Criteria andReadtimeIsNull() {
            addCriterion("ReadTime is null");
            return (Criteria) this;
        }

        public Criteria andReadtimeIsNotNull() {
            addCriterion("ReadTime is not null");
            return (Criteria) this;
        }

        public Criteria andReadtimeEqualTo(Date value) {
            addCriterion("ReadTime =", value, "readtime");
            return (Criteria) this;
        }

        public Criteria andReadtimeNotEqualTo(Date value) {
            addCriterion("ReadTime <>", value, "readtime");
            return (Criteria) this;
        }

        public Criteria andReadtimeGreaterThan(Date value) {
            addCriterion("ReadTime >", value, "readtime");
            return (Criteria) this;
        }

        public Criteria andReadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ReadTime >=", value, "readtime");
            return (Criteria) this;
        }

        public Criteria andReadtimeLessThan(Date value) {
            addCriterion("ReadTime <", value, "readtime");
            return (Criteria) this;
        }

        public Criteria andReadtimeLessThanOrEqualTo(Date value) {
            addCriterion("ReadTime <=", value, "readtime");
            return (Criteria) this;
        }

        public Criteria andReadtimeIn(List<Date> values) {
            addCriterion("ReadTime in", values, "readtime");
            return (Criteria) this;
        }

        public Criteria andReadtimeNotIn(List<Date> values) {
            addCriterion("ReadTime not in", values, "readtime");
            return (Criteria) this;
        }

        public Criteria andReadtimeBetween(Date value1, Date value2) {
            addCriterion("ReadTime between", value1, value2, "readtime");
            return (Criteria) this;
        }

        public Criteria andReadtimeNotBetween(Date value1, Date value2) {
            addCriterion("ReadTime not between", value1, value2, "readtime");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteIsNull() {
            addCriterion("IsReceiverDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteIsNotNull() {
            addCriterion("IsReceiverDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteEqualTo(Integer value) {
            addCriterion("IsReceiverDelete =", value, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteNotEqualTo(Integer value) {
            addCriterion("IsReceiverDelete <>", value, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteGreaterThan(Integer value) {
            addCriterion("IsReceiverDelete >", value, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsReceiverDelete >=", value, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteLessThan(Integer value) {
            addCriterion("IsReceiverDelete <", value, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("IsReceiverDelete <=", value, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteIn(List<Integer> values) {
            addCriterion("IsReceiverDelete in", values, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteNotIn(List<Integer> values) {
            addCriterion("IsReceiverDelete not in", values, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteBetween(Integer value1, Integer value2) {
            addCriterion("IsReceiverDelete between", value1, value2, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andIsreceiverdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("IsReceiverDelete not between", value1, value2, "isreceiverdelete");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeIsNull() {
            addCriterion("ReceiverDeleteTime is null");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeIsNotNull() {
            addCriterion("ReceiverDeleteTime is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeEqualTo(Date value) {
            addCriterion("ReceiverDeleteTime =", value, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeNotEqualTo(Date value) {
            addCriterion("ReceiverDeleteTime <>", value, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeGreaterThan(Date value) {
            addCriterion("ReceiverDeleteTime >", value, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ReceiverDeleteTime >=", value, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeLessThan(Date value) {
            addCriterion("ReceiverDeleteTime <", value, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeLessThanOrEqualTo(Date value) {
            addCriterion("ReceiverDeleteTime <=", value, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeIn(List<Date> values) {
            addCriterion("ReceiverDeleteTime in", values, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeNotIn(List<Date> values) {
            addCriterion("ReceiverDeleteTime not in", values, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeBetween(Date value1, Date value2) {
            addCriterion("ReceiverDeleteTime between", value1, value2, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andReceiverdeletetimeNotBetween(Date value1, Date value2) {
            addCriterion("ReceiverDeleteTime not between", value1, value2, "receiverdeletetime");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteIsNull() {
            addCriterion("IsSenderDelete is null");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteIsNotNull() {
            addCriterion("IsSenderDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteEqualTo(Integer value) {
            addCriterion("IsSenderDelete =", value, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteNotEqualTo(Integer value) {
            addCriterion("IsSenderDelete <>", value, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteGreaterThan(Integer value) {
            addCriterion("IsSenderDelete >", value, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsSenderDelete >=", value, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteLessThan(Integer value) {
            addCriterion("IsSenderDelete <", value, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("IsSenderDelete <=", value, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteIn(List<Integer> values) {
            addCriterion("IsSenderDelete in", values, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteNotIn(List<Integer> values) {
            addCriterion("IsSenderDelete not in", values, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteBetween(Integer value1, Integer value2) {
            addCriterion("IsSenderDelete between", value1, value2, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andIssenderdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("IsSenderDelete not between", value1, value2, "issenderdelete");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeIsNull() {
            addCriterion("SenderDeleteTime is null");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeIsNotNull() {
            addCriterion("SenderDeleteTime is not null");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeEqualTo(Date value) {
            addCriterion("SenderDeleteTime =", value, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeNotEqualTo(Date value) {
            addCriterion("SenderDeleteTime <>", value, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeGreaterThan(Date value) {
            addCriterion("SenderDeleteTime >", value, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SenderDeleteTime >=", value, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeLessThan(Date value) {
            addCriterion("SenderDeleteTime <", value, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeLessThanOrEqualTo(Date value) {
            addCriterion("SenderDeleteTime <=", value, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeIn(List<Date> values) {
            addCriterion("SenderDeleteTime in", values, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeNotIn(List<Date> values) {
            addCriterion("SenderDeleteTime not in", values, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeBetween(Date value1, Date value2) {
            addCriterion("SenderDeleteTime between", value1, value2, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andSenderdeletetimeNotBetween(Date value1, Date value2) {
            addCriterion("SenderDeleteTime not between", value1, value2, "senderdeletetime");
            return (Criteria) this;
        }

        public Criteria andIsdraftIsNull() {
            addCriterion("IsDraft is null");
            return (Criteria) this;
        }

        public Criteria andIsdraftIsNotNull() {
            addCriterion("IsDraft is not null");
            return (Criteria) this;
        }

        public Criteria andIsdraftEqualTo(Boolean value) {
            addCriterion("IsDraft =", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftNotEqualTo(Boolean value) {
            addCriterion("IsDraft <>", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftGreaterThan(Boolean value) {
            addCriterion("IsDraft >", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsDraft >=", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftLessThan(Boolean value) {
            addCriterion("IsDraft <", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftLessThanOrEqualTo(Boolean value) {
            addCriterion("IsDraft <=", value, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftIn(List<Boolean> values) {
            addCriterion("IsDraft in", values, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftNotIn(List<Boolean> values) {
            addCriterion("IsDraft not in", values, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDraft between", value1, value2, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIsdraftNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDraft not between", value1, value2, "isdraft");
            return (Criteria) this;
        }

        public Criteria andIstagIsNull() {
            addCriterion("IsTag is null");
            return (Criteria) this;
        }

        public Criteria andIstagIsNotNull() {
            addCriterion("IsTag is not null");
            return (Criteria) this;
        }

        public Criteria andIstagEqualTo(Boolean value) {
            addCriterion("IsTag =", value, "istag");
            return (Criteria) this;
        }

        public Criteria andIstagNotEqualTo(Boolean value) {
            addCriterion("IsTag <>", value, "istag");
            return (Criteria) this;
        }

        public Criteria andIstagGreaterThan(Boolean value) {
            addCriterion("IsTag >", value, "istag");
            return (Criteria) this;
        }

        public Criteria andIstagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsTag >=", value, "istag");
            return (Criteria) this;
        }

        public Criteria andIstagLessThan(Boolean value) {
            addCriterion("IsTag <", value, "istag");
            return (Criteria) this;
        }

        public Criteria andIstagLessThanOrEqualTo(Boolean value) {
            addCriterion("IsTag <=", value, "istag");
            return (Criteria) this;
        }

        public Criteria andIstagIn(List<Boolean> values) {
            addCriterion("IsTag in", values, "istag");
            return (Criteria) this;
        }

        public Criteria andIstagNotIn(List<Boolean> values) {
            addCriterion("IsTag not in", values, "istag");
            return (Criteria) this;
        }

        public Criteria andIstagBetween(Boolean value1, Boolean value2) {
            addCriterion("IsTag between", value1, value2, "istag");
            return (Criteria) this;
        }

        public Criteria andIstagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsTag not between", value1, value2, "istag");
            return (Criteria) this;
        }

        public Criteria andIsreplyIsNull() {
            addCriterion("IsReply is null");
            return (Criteria) this;
        }

        public Criteria andIsreplyIsNotNull() {
            addCriterion("IsReply is not null");
            return (Criteria) this;
        }

        public Criteria andIsreplyEqualTo(Boolean value) {
            addCriterion("IsReply =", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyNotEqualTo(Boolean value) {
            addCriterion("IsReply <>", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyGreaterThan(Boolean value) {
            addCriterion("IsReply >", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsReply >=", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyLessThan(Boolean value) {
            addCriterion("IsReply <", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyLessThanOrEqualTo(Boolean value) {
            addCriterion("IsReply <=", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyIn(List<Boolean> values) {
            addCriterion("IsReply in", values, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyNotIn(List<Boolean> values) {
            addCriterion("IsReply not in", values, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyBetween(Boolean value1, Boolean value2) {
            addCriterion("IsReply between", value1, value2, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsReply not between", value1, value2, "isreply");
            return (Criteria) this;
        }

        public Criteria andReplyidIsNull() {
            addCriterion("ReplyID is null");
            return (Criteria) this;
        }

        public Criteria andReplyidIsNotNull() {
            addCriterion("ReplyID is not null");
            return (Criteria) this;
        }

        public Criteria andReplyidEqualTo(Integer value) {
            addCriterion("ReplyID =", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidNotEqualTo(Integer value) {
            addCriterion("ReplyID <>", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidGreaterThan(Integer value) {
            addCriterion("ReplyID >", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReplyID >=", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidLessThan(Integer value) {
            addCriterion("ReplyID <", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidLessThanOrEqualTo(Integer value) {
            addCriterion("ReplyID <=", value, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidIn(List<Integer> values) {
            addCriterion("ReplyID in", values, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidNotIn(List<Integer> values) {
            addCriterion("ReplyID not in", values, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidBetween(Integer value1, Integer value2) {
            addCriterion("ReplyID between", value1, value2, "replyid");
            return (Criteria) this;
        }

        public Criteria andReplyidNotBetween(Integer value1, Integer value2) {
            addCriterion("ReplyID not between", value1, value2, "replyid");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNull() {
            addCriterion("OrderNum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("OrderNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(Integer value) {
            addCriterion("OrderNum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(Integer value) {
            addCriterion("OrderNum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(Integer value) {
            addCriterion("OrderNum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderNum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(Integer value) {
            addCriterion("OrderNum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(Integer value) {
            addCriterion("OrderNum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<Integer> values) {
            addCriterion("OrderNum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<Integer> values) {
            addCriterion("OrderNum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(Integer value1, Integer value2) {
            addCriterion("OrderNum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderNum not between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
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