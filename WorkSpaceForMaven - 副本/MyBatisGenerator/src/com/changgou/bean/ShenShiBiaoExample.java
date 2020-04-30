package com.itheima.bean;

import java.util.ArrayList;
import java.util.List;

public class ShenShiBiaoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShenShiBiaoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("province_name is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("province_name is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("province_name =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("province_name <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("province_name >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("province_name >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("province_name <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("province_name <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("province_name like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("province_name not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("province_name in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("province_name not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("province_name between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("province_name not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameIsNull() {
            addCriterion("region3_city_name is null");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameIsNotNull() {
            addCriterion("region3_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameEqualTo(String value) {
            addCriterion("region3_city_name =", value, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameNotEqualTo(String value) {
            addCriterion("region3_city_name <>", value, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameGreaterThan(String value) {
            addCriterion("region3_city_name >", value, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameGreaterThanOrEqualTo(String value) {
            addCriterion("region3_city_name >=", value, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameLessThan(String value) {
            addCriterion("region3_city_name <", value, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameLessThanOrEqualTo(String value) {
            addCriterion("region3_city_name <=", value, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameLike(String value) {
            addCriterion("region3_city_name like", value, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameNotLike(String value) {
            addCriterion("region3_city_name not like", value, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameIn(List<String> values) {
            addCriterion("region3_city_name in", values, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameNotIn(List<String> values) {
            addCriterion("region3_city_name not in", values, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameBetween(String value1, String value2) {
            addCriterion("region3_city_name between", value1, value2, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityNameNotBetween(String value1, String value2) {
            addCriterion("region3_city_name not between", value1, value2, "region3CityName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdIsNull() {
            addCriterion("region3_town_id is null");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdIsNotNull() {
            addCriterion("region3_town_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdEqualTo(Integer value) {
            addCriterion("region3_town_id =", value, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdNotEqualTo(Integer value) {
            addCriterion("region3_town_id <>", value, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdGreaterThan(Integer value) {
            addCriterion("region3_town_id >", value, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("region3_town_id >=", value, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdLessThan(Integer value) {
            addCriterion("region3_town_id <", value, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdLessThanOrEqualTo(Integer value) {
            addCriterion("region3_town_id <=", value, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdIn(List<Integer> values) {
            addCriterion("region3_town_id in", values, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdNotIn(List<Integer> values) {
            addCriterion("region3_town_id not in", values, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdBetween(Integer value1, Integer value2) {
            addCriterion("region3_town_id between", value1, value2, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownIdNotBetween(Integer value1, Integer value2) {
            addCriterion("region3_town_id not between", value1, value2, "region3TownId");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameIsNull() {
            addCriterion("region3_town_name is null");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameIsNotNull() {
            addCriterion("region3_town_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameEqualTo(String value) {
            addCriterion("region3_town_name =", value, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameNotEqualTo(String value) {
            addCriterion("region3_town_name <>", value, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameGreaterThan(String value) {
            addCriterion("region3_town_name >", value, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameGreaterThanOrEqualTo(String value) {
            addCriterion("region3_town_name >=", value, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameLessThan(String value) {
            addCriterion("region3_town_name <", value, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameLessThanOrEqualTo(String value) {
            addCriterion("region3_town_name <=", value, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameLike(String value) {
            addCriterion("region3_town_name like", value, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameNotLike(String value) {
            addCriterion("region3_town_name not like", value, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameIn(List<String> values) {
            addCriterion("region3_town_name in", values, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameNotIn(List<String> values) {
            addCriterion("region3_town_name not in", values, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameBetween(String value1, String value2) {
            addCriterion("region3_town_name between", value1, value2, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3TownNameNotBetween(String value1, String value2) {
            addCriterion("region3_town_name not between", value1, value2, "region3TownName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdIsNull() {
            addCriterion("region3_province_id is null");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdIsNotNull() {
            addCriterion("region3_province_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdEqualTo(Integer value) {
            addCriterion("region3_province_id =", value, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdNotEqualTo(Integer value) {
            addCriterion("region3_province_id <>", value, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdGreaterThan(Integer value) {
            addCriterion("region3_province_id >", value, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("region3_province_id >=", value, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdLessThan(Integer value) {
            addCriterion("region3_province_id <", value, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("region3_province_id <=", value, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdIn(List<Integer> values) {
            addCriterion("region3_province_id in", values, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdNotIn(List<Integer> values) {
            addCriterion("region3_province_id not in", values, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("region3_province_id between", value1, value2, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("region3_province_id not between", value1, value2, "region3ProvinceId");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameIsNull() {
            addCriterion("region3_province_name is null");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameIsNotNull() {
            addCriterion("region3_province_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameEqualTo(String value) {
            addCriterion("region3_province_name =", value, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameNotEqualTo(String value) {
            addCriterion("region3_province_name <>", value, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameGreaterThan(String value) {
            addCriterion("region3_province_name >", value, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("region3_province_name >=", value, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameLessThan(String value) {
            addCriterion("region3_province_name <", value, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("region3_province_name <=", value, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameLike(String value) {
            addCriterion("region3_province_name like", value, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameNotLike(String value) {
            addCriterion("region3_province_name not like", value, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameIn(List<String> values) {
            addCriterion("region3_province_name in", values, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameNotIn(List<String> values) {
            addCriterion("region3_province_name not in", values, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameBetween(String value1, String value2) {
            addCriterion("region3_province_name between", value1, value2, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3ProvinceNameNotBetween(String value1, String value2) {
            addCriterion("region3_province_name not between", value1, value2, "region3ProvinceName");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdIsNull() {
            addCriterion("region3_city_id is null");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdIsNotNull() {
            addCriterion("region3_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdEqualTo(Integer value) {
            addCriterion("region3_city_id =", value, "region3CityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdNotEqualTo(Integer value) {
            addCriterion("region3_city_id <>", value, "region3CityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdGreaterThan(Integer value) {
            addCriterion("region3_city_id >", value, "region3CityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("region3_city_id >=", value, "region3CityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdLessThan(Integer value) {
            addCriterion("region3_city_id <", value, "region3CityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdLessThanOrEqualTo(Integer value) {
            addCriterion("region3_city_id <=", value, "region3CityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdIn(List<Integer> values) {
            addCriterion("region3_city_id in", values, "region3CityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdNotIn(List<Integer> values) {
            addCriterion("region3_city_id not in", values, "region3CityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdBetween(Integer value1, Integer value2) {
            addCriterion("region3_city_id between", value1, value2, "region3CityId");
            return (Criteria) this;
        }

        public Criteria andRegion3CityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("region3_city_id not between", value1, value2, "region3CityId");
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