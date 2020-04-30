package com.coder520.POI.TeacherLiteraturerelated.entity;

public class TeacherLiteraturerelated extends TeacherLiteraturerelatedKey {
    private String relatedlab;

    private String contribution;

    private String literatureuuid;

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

    public String getLiteratureuuid() {
        return literatureuuid;
    }

    public void setLiteratureuuid(String literatureuuid) {
        this.literatureuuid = literatureuuid == null ? null : literatureuuid.trim();
    }
}