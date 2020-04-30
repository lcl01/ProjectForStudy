package com.itheima.bean;

import java.io.Serializable;

public class Customer implements Serializable {
    private Long custId;
    private String custName;
    private String custSource;
    private String custLevel;
    private String custIndustry;
    private String custMobile;
    private String custPhone;

    public Customer() {
    }

    public Customer(Long custId, String custName, String custSource, String custLevel, String custIndustry, String custMobile, String custPhone) {
        this.custId = custId;
        this.custName = custName;
        this.custSource = custSource;
        this.custLevel = custLevel;
        this.custIndustry = custIndustry;
        this.custMobile = custMobile;
        this.custPhone = custPhone;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custMobile='" + custMobile + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
