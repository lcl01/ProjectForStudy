package com.coder520.POI.TeacherConferences.entity;

public class TeacherConferences extends TeacherConferencesKey {
    private String conferencename;

    private String sponsor;

    private String type1;

    private String type2;

    private String chairman;

    private String holdingtime;

    private String numbersofattending;

    private String conferenceaccessories;

    private String lastmodifiedtime;

    private String lastmodifiedman;

    private String status;

    private String conferenceuuid;

    private String lastmodifiedmanid;

    private Long personhelpregisterseqno;

    private String tempstate;

    private String iskcw;

    public String getConferencename() {
        return conferencename;
    }

    public void setConferencename(String conferencename) {
        this.conferencename = conferencename == null ? null : conferencename.trim();
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1 == null ? null : type1.trim();
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2 == null ? null : type2.trim();
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman == null ? null : chairman.trim();
    }

    public String getHoldingtime() {
        return holdingtime;
    }

    public void setHoldingtime(String holdingtime) {
        this.holdingtime = holdingtime == null ? null : holdingtime.trim();
    }

    public String getNumbersofattending() {
        return numbersofattending;
    }

    public void setNumbersofattending(String numbersofattending) {
        this.numbersofattending = numbersofattending == null ? null : numbersofattending.trim();
    }

    public String getConferenceaccessories() {
        return conferenceaccessories;
    }

    public void setConferenceaccessories(String conferenceaccessories) {
        this.conferenceaccessories = conferenceaccessories;
    }

    public String getLastmodifiedtime() {
        return lastmodifiedtime;
    }

    public void setLastmodifiedtime(String lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime == null ? null : lastmodifiedtime.trim();
    }

    public String getLastmodifiedman() {
        return lastmodifiedman;
    }

    public void setLastmodifiedman(String lastmodifiedman) {
        this.lastmodifiedman = lastmodifiedman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getConferenceuuid() {
        return conferenceuuid;
    }

    public void setConferenceuuid(String conferenceuuid) {
        this.conferenceuuid = conferenceuuid == null ? null : conferenceuuid.trim();
    }

    public String getLastmodifiedmanid() {
        return lastmodifiedmanid;
    }

    public void setLastmodifiedmanid(String lastmodifiedmanid) {
        this.lastmodifiedmanid = lastmodifiedmanid == null ? null : lastmodifiedmanid.trim();
    }

    public Long getPersonhelpregisterseqno() {
        return personhelpregisterseqno;
    }

    public void setPersonhelpregisterseqno(Long personhelpregisterseqno) {
        this.personhelpregisterseqno = personhelpregisterseqno;
    }

    public String getTempstate() {
        return tempstate;
    }

    public void setTempstate(String tempstate) {
        this.tempstate = tempstate == null ? null : tempstate.trim();
    }

    public String getIskcw() {
        return iskcw;
    }

    public void setIskcw(String iskcw) {
        this.iskcw = iskcw == null ? null : iskcw.trim();
    }

    @Override
    public String toString() {
        return "TeacherConferences{" +
                "conferencename='" + conferencename + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", chairman='" + chairman + '\'' +
                ", holdingtime='" + holdingtime + '\'' +
                ", numbersofattending='" + numbersofattending + '\'' +
                ", conferenceaccessories='" + conferenceaccessories + '\'' +
                ", lastmodifiedtime='" + lastmodifiedtime + '\'' +
                ", lastmodifiedman='" + lastmodifiedman + '\'' +
                ", status='" + status + '\'' +
                ", conferenceuuid='" + conferenceuuid + '\'' +
                ", lastmodifiedmanid='" + lastmodifiedmanid + '\'' +
                ", personhelpregisterseqno=" + personhelpregisterseqno +
                ", tempstate='" + tempstate + '\'' +
                ", iskcw='" + iskcw + '\'' +
                '}';
    }
}