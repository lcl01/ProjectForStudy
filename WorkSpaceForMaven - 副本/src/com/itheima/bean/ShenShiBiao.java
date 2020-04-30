package com.itheima.bean;

public class ShenShiBiao {
    private Integer id;

    private Integer provinceId;

    private String provinceName;

    private Integer cityId;

    private String region3CityName;

    private Integer region3TownId;

    private String region3TownName;

    private Integer region3ProvinceId;

    private String region3ProvinceName;

    private Integer region3CityId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getRegion3CityName() {
        return region3CityName;
    }

    public void setRegion3CityName(String region3CityName) {
        this.region3CityName = region3CityName == null ? null : region3CityName.trim();
    }

    public Integer getRegion3TownId() {
        return region3TownId;
    }

    public void setRegion3TownId(Integer region3TownId) {
        this.region3TownId = region3TownId;
    }

    public String getRegion3TownName() {
        return region3TownName;
    }

    public void setRegion3TownName(String region3TownName) {
        this.region3TownName = region3TownName == null ? null : region3TownName.trim();
    }

    public Integer getRegion3ProvinceId() {
        return region3ProvinceId;
    }

    public void setRegion3ProvinceId(Integer region3ProvinceId) {
        this.region3ProvinceId = region3ProvinceId;
    }

    public String getRegion3ProvinceName() {
        return region3ProvinceName;
    }

    public void setRegion3ProvinceName(String region3ProvinceName) {
        this.region3ProvinceName = region3ProvinceName == null ? null : region3ProvinceName.trim();
    }

    public Integer getRegion3CityId() {
        return region3CityId;
    }

    public void setRegion3CityId(Integer region3CityId) {
        this.region3CityId = region3CityId;
    }
}