package com.web.myapp.module.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public MemberExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("NickName is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("NickName is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("NickName =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("NickName <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("NickName >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("NickName >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("NickName <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("NickName <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("NickName like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("NickName not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("NickName in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("NickName not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("NickName between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("NickName not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("Gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("Gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Boolean value) {
            addCriterion("Gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Boolean value) {
            addCriterion("Gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Boolean value) {
            addCriterion("Gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("Gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Boolean value) {
            addCriterion("Gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Boolean value) {
            addCriterion("Gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Boolean> values) {
            addCriterion("Gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Boolean> values) {
            addCriterion("Gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Boolean value1, Boolean value2) {
            addCriterion("Gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("Gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("Birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("Birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("Birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("Birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("Birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("Birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("Birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("Birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("Birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("Birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("Birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("Birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andHeadpicIsNull() {
            addCriterion("HeadPic is null");
            return (Criteria) this;
        }

        public Criteria andHeadpicIsNotNull() {
            addCriterion("HeadPic is not null");
            return (Criteria) this;
        }

        public Criteria andHeadpicEqualTo(String value) {
            addCriterion("HeadPic =", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicNotEqualTo(String value) {
            addCriterion("HeadPic <>", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicGreaterThan(String value) {
            addCriterion("HeadPic >", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicGreaterThanOrEqualTo(String value) {
            addCriterion("HeadPic >=", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicLessThan(String value) {
            addCriterion("HeadPic <", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicLessThanOrEqualTo(String value) {
            addCriterion("HeadPic <=", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicLike(String value) {
            addCriterion("HeadPic like", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicNotLike(String value) {
            addCriterion("HeadPic not like", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicIn(List<String> values) {
            addCriterion("HeadPic in", values, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicNotIn(List<String> values) {
            addCriterion("HeadPic not in", values, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicBetween(String value1, String value2) {
            addCriterion("HeadPic between", value1, value2, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicNotBetween(String value1, String value2) {
            addCriterion("HeadPic not between", value1, value2, "headpic");
            return (Criteria) this;
        }

        public Criteria andSpacepicIsNull() {
            addCriterion("SpacePic is null");
            return (Criteria) this;
        }

        public Criteria andSpacepicIsNotNull() {
            addCriterion("SpacePic is not null");
            return (Criteria) this;
        }

        public Criteria andSpacepicEqualTo(String value) {
            addCriterion("SpacePic =", value, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicNotEqualTo(String value) {
            addCriterion("SpacePic <>", value, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicGreaterThan(String value) {
            addCriterion("SpacePic >", value, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicGreaterThanOrEqualTo(String value) {
            addCriterion("SpacePic >=", value, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicLessThan(String value) {
            addCriterion("SpacePic <", value, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicLessThanOrEqualTo(String value) {
            addCriterion("SpacePic <=", value, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicLike(String value) {
            addCriterion("SpacePic like", value, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicNotLike(String value) {
            addCriterion("SpacePic not like", value, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicIn(List<String> values) {
            addCriterion("SpacePic in", values, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicNotIn(List<String> values) {
            addCriterion("SpacePic not in", values, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicBetween(String value1, String value2) {
            addCriterion("SpacePic between", value1, value2, "spacepic");
            return (Criteria) this;
        }

        public Criteria andSpacepicNotBetween(String value1, String value2) {
            addCriterion("SpacePic not between", value1, value2, "spacepic");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNull() {
            addCriterion("Passwd is null");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNotNull() {
            addCriterion("Passwd is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdEqualTo(String value) {
            addCriterion("Passwd =", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotEqualTo(String value) {
            addCriterion("Passwd <>", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThan(String value) {
            addCriterion("Passwd >", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("Passwd >=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThan(String value) {
            addCriterion("Passwd <", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThanOrEqualTo(String value) {
            addCriterion("Passwd <=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLike(String value) {
            addCriterion("Passwd like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotLike(String value) {
            addCriterion("Passwd not like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdIn(List<String> values) {
            addCriterion("Passwd in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotIn(List<String> values) {
            addCriterion("Passwd not in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdBetween(String value1, String value2) {
            addCriterion("Passwd between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotBetween(String value1, String value2) {
            addCriterion("Passwd not between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("Mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("Mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("Mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("Mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("Mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("Mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("Mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("Mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("Mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("Mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("Mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("Mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("Mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("Mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("QQ is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("QQ is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("QQ =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("QQ <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("QQ >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("QQ >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("QQ <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("QQ <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("QQ like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("QQ not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("QQ in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("QQ not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("QQ between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("QQ not between", value1, value2, "qq");
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

        public Criteria andAddressIsNull() {
            addCriterion("Address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("Address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("Address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("Address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("Address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("Address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("Address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("Address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("Address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("Address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("Address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("Address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("Address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("PostCode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("PostCode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("PostCode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("PostCode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("PostCode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PostCode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("PostCode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("PostCode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("PostCode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("PostCode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("PostCode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("PostCode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("PostCode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("PostCode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("Level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("Level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Byte value) {
            addCriterion("Level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Byte value) {
            addCriterion("Level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Byte value) {
            addCriterion("Level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("Level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Byte value) {
            addCriterion("Level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Byte value) {
            addCriterion("Level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Byte> values) {
            addCriterion("Level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Byte> values) {
            addCriterion("Level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Byte value1, Byte value2) {
            addCriterion("Level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("Level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNull() {
            addCriterion("LastLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIsNotNull() {
            addCriterion("LastLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeEqualTo(Date value) {
            addCriterion("LastLoginTime =", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotEqualTo(Date value) {
            addCriterion("LastLoginTime <>", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThan(Date value) {
            addCriterion("LastLoginTime >", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LastLoginTime >=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThan(Date value) {
            addCriterion("LastLoginTime <", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("LastLoginTime <=", value, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeIn(List<Date> values) {
            addCriterion("LastLoginTime in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotIn(List<Date> values) {
            addCriterion("LastLoginTime not in", values, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeBetween(Date value1, Date value2) {
            addCriterion("LastLoginTime between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andLastlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("LastLoginTime not between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }

        public Criteria andIslockIsNull() {
            addCriterion("IsLock is null");
            return (Criteria) this;
        }

        public Criteria andIslockIsNotNull() {
            addCriterion("IsLock is not null");
            return (Criteria) this;
        }

        public Criteria andIslockEqualTo(Boolean value) {
            addCriterion("IsLock =", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockNotEqualTo(Boolean value) {
            addCriterion("IsLock <>", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockGreaterThan(Boolean value) {
            addCriterion("IsLock >", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsLock >=", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockLessThan(Boolean value) {
            addCriterion("IsLock <", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockLessThanOrEqualTo(Boolean value) {
            addCriterion("IsLock <=", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockIn(List<Boolean> values) {
            addCriterion("IsLock in", values, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockNotIn(List<Boolean> values) {
            addCriterion("IsLock not in", values, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockBetween(Boolean value1, Boolean value2) {
            addCriterion("IsLock between", value1, value2, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsLock not between", value1, value2, "islock");
            return (Criteria) this;
        }

        public Criteria andIsloginIsNull() {
            addCriterion("IsLogin is null");
            return (Criteria) this;
        }

        public Criteria andIsloginIsNotNull() {
            addCriterion("IsLogin is not null");
            return (Criteria) this;
        }

        public Criteria andIsloginEqualTo(Boolean value) {
            addCriterion("IsLogin =", value, "islogin");
            return (Criteria) this;
        }

        public Criteria andIsloginNotEqualTo(Boolean value) {
            addCriterion("IsLogin <>", value, "islogin");
            return (Criteria) this;
        }

        public Criteria andIsloginGreaterThan(Boolean value) {
            addCriterion("IsLogin >", value, "islogin");
            return (Criteria) this;
        }

        public Criteria andIsloginGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsLogin >=", value, "islogin");
            return (Criteria) this;
        }

        public Criteria andIsloginLessThan(Boolean value) {
            addCriterion("IsLogin <", value, "islogin");
            return (Criteria) this;
        }

        public Criteria andIsloginLessThanOrEqualTo(Boolean value) {
            addCriterion("IsLogin <=", value, "islogin");
            return (Criteria) this;
        }

        public Criteria andIsloginIn(List<Boolean> values) {
            addCriterion("IsLogin in", values, "islogin");
            return (Criteria) this;
        }

        public Criteria andIsloginNotIn(List<Boolean> values) {
            addCriterion("IsLogin not in", values, "islogin");
            return (Criteria) this;
        }

        public Criteria andIsloginBetween(Boolean value1, Boolean value2) {
            addCriterion("IsLogin between", value1, value2, "islogin");
            return (Criteria) this;
        }

        public Criteria andIsloginNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsLogin not between", value1, value2, "islogin");
            return (Criteria) this;
        }

        public Criteria andLocktimeIsNull() {
            addCriterion("LockTime is null");
            return (Criteria) this;
        }

        public Criteria andLocktimeIsNotNull() {
            addCriterion("LockTime is not null");
            return (Criteria) this;
        }

        public Criteria andLocktimeEqualTo(Date value) {
            addCriterion("LockTime =", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeNotEqualTo(Date value) {
            addCriterion("LockTime <>", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeGreaterThan(Date value) {
            addCriterion("LockTime >", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LockTime >=", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeLessThan(Date value) {
            addCriterion("LockTime <", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeLessThanOrEqualTo(Date value) {
            addCriterion("LockTime <=", value, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeIn(List<Date> values) {
            addCriterion("LockTime in", values, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeNotIn(List<Date> values) {
            addCriterion("LockTime not in", values, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeBetween(Date value1, Date value2) {
            addCriterion("LockTime between", value1, value2, "locktime");
            return (Criteria) this;
        }

        public Criteria andLocktimeNotBetween(Date value1, Date value2) {
            addCriterion("LockTime not between", value1, value2, "locktime");
            return (Criteria) this;
        }

        public Criteria andEncryptedidIsNull() {
            addCriterion("EncryptedID is null");
            return (Criteria) this;
        }

        public Criteria andEncryptedidIsNotNull() {
            addCriterion("EncryptedID is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptedidEqualTo(String value) {
            addCriterion("EncryptedID =", value, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidNotEqualTo(String value) {
            addCriterion("EncryptedID <>", value, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidGreaterThan(String value) {
            addCriterion("EncryptedID >", value, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidGreaterThanOrEqualTo(String value) {
            addCriterion("EncryptedID >=", value, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidLessThan(String value) {
            addCriterion("EncryptedID <", value, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidLessThanOrEqualTo(String value) {
            addCriterion("EncryptedID <=", value, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidLike(String value) {
            addCriterion("EncryptedID like", value, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidNotLike(String value) {
            addCriterion("EncryptedID not like", value, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidIn(List<String> values) {
            addCriterion("EncryptedID in", values, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidNotIn(List<String> values) {
            addCriterion("EncryptedID not in", values, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidBetween(String value1, String value2) {
            addCriterion("EncryptedID between", value1, value2, "encryptedid");
            return (Criteria) this;
        }

        public Criteria andEncryptedidNotBetween(String value1, String value2) {
            addCriterion("EncryptedID not between", value1, value2, "encryptedid");
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