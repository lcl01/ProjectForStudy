package com.coder520.POI.TeacherStandardrelated.entity;

public class TeacherStandardrelated extends TeacherStandardrelatedKey {
    private String relatedlab;

    private String contribution;

    private String standarduuid;

    public String getRelatedlab() {
        return relatedlab;
    }

    public void setRelatedlab(String relatedlab) {
        this.relatedlab = relatedlab;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution == null ? null : contribution.trim();
    }

    public String getStandarduuid() {
        return standarduuid;
    }

    public void setStandarduuid(String standarduuid) {
        this.standarduuid = standarduuid == null ? null : standarduuid.trim();
    }
}