package com.coder520.POI.TeacherProjectrelated.entity;

public class TeacherProjectrelated extends TeacherProjectrelatedKey {
    private String relatedlab;

    private String contribution;

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
}