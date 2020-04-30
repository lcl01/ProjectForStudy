package com.coder520.POI.DictDateInput.entity;

import java.math.BigDecimal;

public class DictDateInput {
    private Long fieldseqno;

    private String fieldcode;

    private String fieldname;

    private String fieldvalue;

    private BigDecimal rankid;

    private String classcode;

    public Long getFieldseqno() {
        return fieldseqno;
    }

    public void setFieldseqno(Long fieldseqno) {
        this.fieldseqno = fieldseqno;
    }

    public String getFieldcode() {
        return fieldcode;
    }

    public void setFieldcode(String fieldcode) {
        this.fieldcode = fieldcode == null ? null : fieldcode.trim();
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname == null ? null : fieldname.trim();
    }

    public String getFieldvalue() {
        return fieldvalue;
    }

    public void setFieldvalue(String fieldvalue) {
        this.fieldvalue = fieldvalue == null ? null : fieldvalue.trim();
    }

    public BigDecimal getRankid() {
        return rankid;
    }

    public void setRankid(BigDecimal rankid) {
        this.rankid = rankid;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode == null ? null : classcode.trim();
    }
}