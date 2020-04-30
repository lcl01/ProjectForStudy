package com.coder520.POI.TeacherConferencerelated.entity;

public class TeacherConferencerelated extends TeacherConferencerelatedKey {
    private String relatedlab;

    private String contribution;

    private String conferenceuuid;

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

    public String getConferenceuuid() {
        return conferenceuuid;
    }

    public void setConferenceuuid(String conferenceuuid) {
        this.conferenceuuid = conferenceuuid == null ? null : conferenceuuid.trim();
    }
}