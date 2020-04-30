package com.coder520.POI.TeacherAwardrelated.entity;

public class TeacherAwardrelated extends TeacherAwardrelatedKey {
    private String relatedlab;

    private String contribution;

    private String awarduuid;

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

    public String getAwarduuid() {
        return awarduuid;
    }

    public void setAwarduuid(String awarduuid) {
        this.awarduuid = awarduuid == null ? null : awarduuid.trim();
    }
}