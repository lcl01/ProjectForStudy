package com.coder520.POI.LabEquipmentList.entity;

public class LabEquipmentList {
    private Long no;

    private String labseqno;

    private String year;

    private String labno;

    private String equipname;

    private String specification;

    private String manufactory;

    private String origin;

    private String rawvalue;

    private String accountinglab;

    private String accountingdate;

    private String flag;

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getLabseqno() {
        return labseqno;
    }

    public void setLabseqno(String labseqno) {
        this.labseqno = labseqno == null ? null : labseqno.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getLabno() {
        return labno;
    }

    public void setLabno(String labno) {
        this.labno = labno == null ? null : labno.trim();
    }

    public String getEquipname() {
        return equipname;
    }

    public void setEquipname(String equipname) {
        this.equipname = equipname == null ? null : equipname.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getRawvalue() {
        return rawvalue;
    }

    public void setRawvalue(String rawvalue) {
        this.rawvalue = rawvalue == null ? null : rawvalue.trim();
    }

    public String getAccountinglab() {
        return accountinglab;
    }

    public void setAccountinglab(String accountinglab) {
        this.accountinglab = accountinglab == null ? null : accountinglab.trim();
    }

    public String getAccountingdate() {
        return accountingdate;
    }

    public void setAccountingdate(String accountingdate) {
        this.accountingdate = accountingdate == null ? null : accountingdate.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}