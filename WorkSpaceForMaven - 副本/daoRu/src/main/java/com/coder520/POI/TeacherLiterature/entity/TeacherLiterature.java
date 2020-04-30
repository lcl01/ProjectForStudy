package com.coder520.POI.TeacherLiterature.entity;

import java.math.BigDecimal;

public class TeacherLiterature extends TeacherLiteratureKey {
    private String literaturename;

    private String firstauthor;

    private String otherauthor;

    private String literauretype;

    private String statisticstype;

    private BigDecimal totalwords;

    private String press;

    private String publicationdate;

    private String issn;

    private String literatureaccessories;

    private String issecrect;

    private String lastmodifiedtime;

    private String lastmodifiedman;

    private String status;

    private String literatureuuid;

    private Long majordeptseqno;

    private Long majorlabseqno;

    private Long majorseqno;

    private String otherauthoruuid;

    private String literatureothersnum;

    private String othersdeptseqno;

    private String otherslabseqno;

    private String lastmodifiedmanid;

    private Long personhelpregisterseqno;

    private String tempstate;

    private String iskcw;

    public String getLiteraturename() {
        return literaturename;
    }

    public void setLiteraturename(String literaturename) {
        this.literaturename = literaturename == null ? null : literaturename.trim();
    }

    public String getFirstauthor() {
        return firstauthor;
    }

    public void setFirstauthor(String firstauthor) {
        this.firstauthor = firstauthor == null ? null : firstauthor.trim();
    }

    public String getOtherauthor() {
        return otherauthor;
    }

    public void setOtherauthor(String otherauthor) {
        this.otherauthor = otherauthor == null ? null : otherauthor.trim();
    }

    public String getLiterauretype() {
        return literauretype;
    }

    public void setLiterauretype(String literauretype) {
        this.literauretype = literauretype == null ? null : literauretype.trim();
    }

    public String getStatisticstype() {
        return statisticstype;
    }

    public void setStatisticstype(String statisticstype) {
        this.statisticstype = statisticstype == null ? null : statisticstype.trim();
    }

    public BigDecimal getTotalwords() {
        return totalwords;
    }

    public void setTotalwords(BigDecimal totalwords) {
        this.totalwords = totalwords;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(String publicationdate) {
        this.publicationdate = publicationdate == null ? null : publicationdate.trim();
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn == null ? null : issn.trim();
    }

    public String getLiteratureaccessories() {
        return literatureaccessories;
    }

    public void setLiteratureaccessories(String literatureaccessories) {
        this.literatureaccessories = literatureaccessories;
    }

    public String getIssecrect() {
        return issecrect;
    }

    public void setIssecrect(String issecrect) {
        this.issecrect = issecrect == null ? null : issecrect.trim();
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

    public String getLiteratureuuid() {
        return literatureuuid;
    }

    public void setLiteratureuuid(String literatureuuid) {
        this.literatureuuid = literatureuuid == null ? null : literatureuuid.trim();
    }

    public Long getMajordeptseqno() {
        return majordeptseqno;
    }

    public void setMajordeptseqno(Long majordeptseqno) {
        this.majordeptseqno = majordeptseqno;
    }

    public Long getMajorlabseqno() {
        return majorlabseqno;
    }

    public void setMajorlabseqno(Long majorlabseqno) {
        this.majorlabseqno = majorlabseqno;
    }

    public Long getMajorseqno() {
        return majorseqno;
    }

    public void setMajorseqno(Long majorseqno) {
        this.majorseqno = majorseqno;
    }

    public String getOtherauthoruuid() {
        return otherauthoruuid;
    }

    public void setOtherauthoruuid(String otherauthoruuid) {
        this.otherauthoruuid = otherauthoruuid == null ? null : otherauthoruuid.trim();
    }

    public String getLiteratureothersnum() {
        return literatureothersnum;
    }

    public void setLiteratureothersnum(String literatureothersnum) {
        this.literatureothersnum = literatureothersnum == null ? null : literatureothersnum.trim();
    }

    public String getOthersdeptseqno() {
        return othersdeptseqno;
    }

    public void setOthersdeptseqno(String othersdeptseqno) {
        this.othersdeptseqno = othersdeptseqno == null ? null : othersdeptseqno.trim();
    }

    public String getOtherslabseqno() {
        return otherslabseqno;
    }

    public void setOtherslabseqno(String otherslabseqno) {
        this.otherslabseqno = otherslabseqno == null ? null : otherslabseqno.trim();
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
    public String  toString() {
        return "TeacherLiterature{" +
                "literaturename='" + literaturename + '\'' +
                ", firstauthor='" + firstauthor + '\'' +
                ", otherauthor='" + otherauthor + '\'' +
                ", literauretype='" + literauretype + '\'' +
                ", statisticstype='" + statisticstype + '\'' +
                ", totalwords=" + totalwords +
                ", press='" + press + '\'' +
                ", publicationdate='" + publicationdate + '\'' +
                ", issn='" + issn + '\'' +
                ", literatureaccessories='" + literatureaccessories + '\'' +
                ", issecrect='" + issecrect + '\'' +
                ", lastmodifiedtime='" + lastmodifiedtime + '\'' +
                ", lastmodifiedman='" + lastmodifiedman + '\'' +
                ", status='" + status + '\'' +
                ", literatureuuid='" + literatureuuid + '\'' +
                ", majordeptseqno=" + majordeptseqno +
                ", majorlabseqno=" + majorlabseqno +
                ", majorseqno=" + majorseqno +
                ", otherauthoruuid='" + otherauthoruuid + '\'' +
                ", literatureothersnum='" + literatureothersnum + '\'' +
                ", othersdeptseqno='" + othersdeptseqno + '\'' +
                ", otherslabseqno='" + otherslabseqno + '\'' +
                ", lastmodifiedmanid='" + lastmodifiedmanid + '\'' +
                ", personhelpregisterseqno=" + personhelpregisterseqno +
                ", tempstate='" + tempstate + '\'' +
                ", iskcw='" + iskcw + '\'' +
                '}';
    }
}