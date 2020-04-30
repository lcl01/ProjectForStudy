package com.coder520.POI.TeacherPatentrelated.entity;

public class TeacherPatentrelated extends TeacherPatentrelatedKey {
    private String relatedlab;

    private String contribution;

    private String patentuuid;

    public String getRelatedlab() {
        return relatedlab;
    }

    public void setRelatedlab(String relatedlab) {
        this.relatedlab = relatedlab == null ? null : relatedlab.trim();
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution == null ? null : contribution.trim();
    }

    public String getPatentuuid() {
        return patentuuid;
    }

    public void setPatentuuid(String patentuuid) {
        this.patentuuid = patentuuid == null ? null : patentuuid.trim();
    }
}