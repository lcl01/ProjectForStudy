package com.health.pojo;

import java.io.Serializable;

public class ShengShiBiao implements Serializable {
    private int id;
    private int province_id;
    private String province_name;
    private int city_id;
    private String region3_city_name;
    private int region3_town_id;
    private String region3_town_name;
    private int region3_province_id;
    private String region3_province_name;
    private int region3_city_id;

    @Override
    public String toString() {
        return "ShengShiBiao{" +
                "id=" + id +
                ", province_id=" + province_id +
                ", province_name='" + province_name + '\'' +
                ", city_id=" + city_id +
                ", region3_city_name='" + region3_city_name + '\'' +
                ", region3_town_id=" + region3_town_id +
                ", region3_town_name='" + region3_town_name + '\'' +
                ", region3_province_id=" + region3_province_id +
                ", region3_province_name='" + region3_province_name + '\'' +
                ", region3_city_id=" + region3_city_id +
                '}';
    }

    public int getRegion3_province_id() {
        return region3_province_id;
    }

    public void setRegion3_province_id(int region3_province_id) {
        this.region3_province_id = region3_province_id;
    }

    public String getRegion3_province_name() {
        return region3_province_name;
    }

    public void setRegion3_province_name(String region3_province_name) {
        this.region3_province_name = region3_province_name;
    }

    public int getRegion3_city_id() {
        return region3_city_id;
    }

    public void setRegion3_city_id(int region3_city_id) {
        this.region3_city_id = region3_city_id;
    }

    public ShengShiBiao(int id, int province_id, String province_name, int city_id, String region3_city_name, int region3_town_id, String region3_town_name, int region3_province_id, String region3_province_name, int region3_city_id) {
        this.id = id;
        this.province_id = province_id;
        this.province_name = province_name;
        this.city_id = city_id;
        this.region3_city_name = region3_city_name;
        this.region3_town_id = region3_town_id;
        this.region3_town_name = region3_town_name;
        this.region3_province_id = region3_province_id;
        this.region3_province_name = region3_province_name;
        this.region3_city_id = region3_city_id;
    }

    public ShengShiBiao() {
    }

    public ShengShiBiao(int id, int province_id, String province_name, int city_id, String region3_city_name, int region3_town_id, String region3_town_name) {
        this.id = id;
        this.province_id = province_id;
        this.province_name = province_name;
        this.city_id = city_id;
        this.region3_city_name = region3_city_name;
        this.region3_town_id = region3_town_id;
        this.region3_town_name = region3_town_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getRegion3_city_name() {
        return region3_city_name;
    }

    public void setRegion3_city_name(String region3_city_name) {
        this.region3_city_name = region3_city_name;
    }

    public int getRegion3_town_id() {
        return region3_town_id;
    }

    public void setRegion3_town_id(int region3_town_id) {
        this.region3_town_id = region3_town_id;
    }

    public String getRegion3_town_name() {
        return region3_town_name;
    }

    public void setRegion3_town_name(String region3_town_name) {
        this.region3_town_name = region3_town_name;
    }

}
