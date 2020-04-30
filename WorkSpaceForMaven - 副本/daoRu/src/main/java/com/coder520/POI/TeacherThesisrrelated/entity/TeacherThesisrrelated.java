package com.coder520.POI.TeacherThesisrrelated.entity;

public class TeacherThesisrrelated extends TeacherThesisrrelatedKey {
    private String relatedlab;

    private String contribution;

    private String thesisuuid;

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

    public String getThesisuuid() {
        return thesisuuid;
    }

    public void setThesisuuid(String thesisuuid) {
        this.thesisuuid = thesisuuid == null ? null : thesisuuid.trim();
    }
}