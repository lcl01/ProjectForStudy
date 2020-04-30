package com.coder520.POI.TeacherStandard.entity;

public class TeacherStandard extends TeacherStandardKey {
    private String standardname;

    private String standardabstract;

    private String releasedate;

    private String standardtype;

    private String issecrect;

    private String accessories;

    private String lastmodifiedtime;

    private Long lastmodifiedmanid;

    private String lastmodifiedman;

    private String standarduuid;

    private String approvestatus;

    private String isrelease;

    private Long personhelpregisterseqno;

    private String istrans;

    private String tempstate;

    private String iskcw;

    public String getStandardname() {
        return standardname;
    }

    public void setStandardname(String standardname) {
        this.standardname = standardname == null ? null : standardname.trim();
    }

    public String getStandardabstract() {
        return standardabstract;
    }

    public void setStandardabstract(String standardabstract) {
        this.standardabstract = standardabstract;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate == null ? null : releasedate.trim();
    }

    public String getStandardtype() {
        return standardtype;
    }

    public void setStandardtype(String standardtype) {
        this.standardtype = standardtype;
    }

    public String getIssecrect() {
        return issecrect;
    }

    public void setIssecrect(String issecrect) {
        this.issecrect = issecrect == null ? null : issecrect.trim();
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getLastmodifiedtime() {
        return lastmodifiedtime;
    }

    public void setLastmodifiedtime(String lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime == null ? null : lastmodifiedtime.trim();
    }

    public Long getLastmodifiedmanid() {
        return lastmodifiedmanid;
    }

    public void setLastmodifiedmanid(Long lastmodifiedmanid) {
        this.lastmodifiedmanid = lastmodifiedmanid;
    }

    public String getLastmodifiedman() {
        return lastmodifiedman;
    }

    public void setLastmodifiedman(String lastmodifiedman) {
        this.lastmodifiedman = lastmodifiedman == null ? null : lastmodifiedman.trim();
    }

    public String getStandarduuid() {
        return standarduuid;
    }

    public void setStandarduuid(String standarduuid) {
        this.standarduuid = standarduuid == null ? null : standarduuid.trim();
    }

    public String getApprovestatus() {
        return approvestatus;
    }

    public void setApprovestatus(String approvestatus) {
        this.approvestatus = approvestatus == null ? null : approvestatus.trim();
    }

    public String getIsrelease() {
        return isrelease;
    }

    public void setIsrelease(String isrelease) {
        this.isrelease = isrelease == null ? null : isrelease.trim();
    }

    public Long getPersonhelpregisterseqno() {
        return personhelpregisterseqno;
    }

    public void setPersonhelpregisterseqno(Long personhelpregisterseqno) {
        this.personhelpregisterseqno = personhelpregisterseqno;
    }

    public String getIstrans() {
        return istrans;
    }

    public void setIstrans(String istrans) {
        this.istrans = istrans == null ? null : istrans.trim();
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
        return "TeacherStandard{" +
                "standardname='" + standardname + '\'' +
                ", standardabstract='" + standardabstract + '\'' +
                ", releasedate='" + releasedate + '\'' +
                ", standardtype='" + standardtype + '\'' +
                ", issecrect='" + issecrect + '\'' +
                ", accessories='" + accessories + '\'' +
                ", lastmodifiedtime='" + lastmodifiedtime + '\'' +
                ", lastmodifiedmanid=" + lastmodifiedmanid +
                ", lastmodifiedman='" + lastmodifiedman + '\'' +
                ", standarduuid='" + standarduuid + '\'' +
                ", approvestatus='" + approvestatus + '\'' +
                ", isrelease='" + isrelease + '\'' +
                ", personhelpregisterseqno=" + personhelpregisterseqno +
                ", istrans='" + istrans + '\'' +
                ", tempstate='" + tempstate + '\'' +
                ", iskcw='" + iskcw + '\'' +
                '}';
    }
}