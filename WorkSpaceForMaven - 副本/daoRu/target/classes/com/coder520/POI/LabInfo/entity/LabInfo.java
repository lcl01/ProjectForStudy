package com.coder520.POI.LabInfo.entity;

import java.util.Date;

public class LabInfo {
    private Long labseqno;

    private Long departmentseqno;

    private String labname;

    private String labno;

    private String labmajor;

    private String majorphone;

    private String majoremail;

    private String manager;

    private String managerphone;

    private String manageremail;

    private String labothername;

    private String labenglishname;

    private String englishiabbrname;

    private String jointdept;

    private String lablocation;

    private String labaddress;

    private String postcode;

    private String httpaddress;

    private String relatedfields;

    private String isjoint;

    private String leveloflab;

    private String typeoflab;

    private String approvaldept;

    private Date approvaltime;

    private Date accepttime;

    private String relieddept;

    private String approvalno;

    private String registingtime;

    private String lastassessedtime;

    private String classification1;

    private String classification2;

    private String researchfields;

    private String researchinterests;

    private String researchcontents;

    private String laboutline;

    private String labstate;

    private Long labotherid;

    private String classification3;

    private String buildinfo;

    private Date edittime;

    private String labtype;

    private String basetype;

    private String basetypesub;

    private String allieddept;

    private String regionname;

    private String govertype;

    private String fielddist;

    private String fielddistsub;

    private String subsattri;

    private String ispostdoctor;

    private String deptattri;

    private String incubident;

    private String isplatform;

    private String photo;

    private String superiordep;

    private String jointsuperiordept;

    private String areaoflab;

    private String areaofwork;

    private String latitude;

    private String longitude;

    private String issignmaps;

    private String formattedaddress;

    private String isopenbase;

    private String locationnooflab;

    private String orderbykcw;

    private String leveloflabremark;

    private Integer orderbytype;

    private String prodempol;

    private String labinfostate;

    private String relyondep;

    private String istemporary;

    private String isfull;

    private String address;

    private String labintro;

    public Long getLabseqno() {
        return labseqno;
    }

    public void setLabseqno(Long labseqno) {
        this.labseqno = labseqno;
    }

    public Long getDepartmentseqno() {
        return departmentseqno;
    }

    public void setDepartmentseqno(Long departmentseqno) {
        this.departmentseqno = departmentseqno;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname == null ? null : labname.trim();
    }

    public String getLabno() {
        return labno;
    }

    public void setLabno(String labno) {
        this.labno = labno == null ? null : labno.trim();
    }

    public String getLabmajor() {
        return labmajor;
    }

    public void setLabmajor(String labmajor) {
        this.labmajor = labmajor == null ? null : labmajor.trim();
    }

    public String getMajorphone() {
        return majorphone;
    }

    public void setMajorphone(String majorphone) {
        this.majorphone = majorphone == null ? null : majorphone.trim();
    }

    public String getMajoremail() {
        return majoremail;
    }

    public void setMajoremail(String majoremail) {
        this.majoremail = majoremail == null ? null : majoremail.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone == null ? null : managerphone.trim();
    }

    public String getManageremail() {
        return manageremail;
    }

    public void setManageremail(String manageremail) {
        this.manageremail = manageremail == null ? null : manageremail.trim();
    }

    public String getLabothername() {
        return labothername;
    }

    public void setLabothername(String labothername) {
        this.labothername = labothername;
    }

    public String getLabenglishname() {
        return labenglishname;
    }

    public void setLabenglishname(String labenglishname) {
        this.labenglishname = labenglishname == null ? null : labenglishname.trim();
    }

    public String getEnglishiabbrname() {
        return englishiabbrname;
    }

    public void setEnglishiabbrname(String englishiabbrname) {
        this.englishiabbrname = englishiabbrname == null ? null : englishiabbrname.trim();
    }

    public String getJointdept() {
        return jointdept;
    }

    public void setJointdept(String jointdept) {
        this.jointdept = jointdept;
    }

    public String getLablocation() {
        return lablocation;
    }

    public void setLablocation(String lablocation) {
        this.lablocation = lablocation == null ? null : lablocation.trim();
    }

    public String getLabaddress() {
        return labaddress;
    }

    public void setLabaddress(String labaddress) {
        this.labaddress = labaddress == null ? null : labaddress.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getHttpaddress() {
        return httpaddress;
    }

    public void setHttpaddress(String httpaddress) {
        this.httpaddress = httpaddress;
    }

    public String getRelatedfields() {
        return relatedfields;
    }

    public void setRelatedfields(String relatedfields) {
        this.relatedfields = relatedfields;
    }

    public String getIsjoint() {
        return isjoint;
    }

    public void setIsjoint(String isjoint) {
        this.isjoint = isjoint == null ? null : isjoint.trim();
    }

    public String getLeveloflab() {
        return leveloflab;
    }

    public void setLeveloflab(String leveloflab) {
        this.leveloflab = leveloflab == null ? null : leveloflab.trim();
    }

    public String getTypeoflab() {
        return typeoflab;
    }

    public void setTypeoflab(String typeoflab) {
        this.typeoflab = typeoflab == null ? null : typeoflab.trim();
    }

    public String getApprovaldept() {
        return approvaldept;
    }

    public void setApprovaldept(String approvaldept) {
        this.approvaldept = approvaldept;
    }

    public Date getApprovaltime() {
        return approvaltime;
    }

    public void setApprovaltime(Date approvaltime) {
        this.approvaltime = approvaltime;
    }

    public Date getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(Date accepttime) {
        this.accepttime = accepttime;
    }

    public String getRelieddept() {
        return relieddept;
    }

    public void setRelieddept(String relieddept) {
        this.relieddept = relieddept;
    }

    public String getApprovalno() {
        return approvalno;
    }

    public void setApprovalno(String approvalno) {
        this.approvalno = approvalno;
    }

    public String getRegistingtime() {
        return registingtime;
    }

    public void setRegistingtime(String registingtime) {
        this.registingtime = registingtime;
    }

    public String getLastassessedtime() {
        return lastassessedtime;
    }

    public void setLastassessedtime(String lastassessedtime) {
        this.lastassessedtime = lastassessedtime;
    }

    public String getClassification1() {
        return classification1;
    }

    public void setClassification1(String classification1) {
        this.classification1 = classification1;
    }

    public String getClassification2() {
        return classification2;
    }

    public void setClassification2(String classification2) {
        this.classification2 = classification2;
    }

    public String getResearchfields() {
        return researchfields;
    }

    public void setResearchfields(String researchfields) {
        this.researchfields = researchfields;
    }

    public String getResearchinterests() {
        return researchinterests;
    }

    public void setResearchinterests(String researchinterests) {
        this.researchinterests = researchinterests;
    }

    public String getResearchcontents() {
        return researchcontents;
    }

    public void setResearchcontents(String researchcontents) {
        this.researchcontents = researchcontents;
    }

    public String getLaboutline() {
        return laboutline;
    }

    public void setLaboutline(String laboutline) {
        this.laboutline = laboutline;
    }

    public String getLabstate() {
        return labstate;
    }

    public void setLabstate(String labstate) {
        this.labstate = labstate == null ? null : labstate.trim();
    }

    public Long getLabotherid() {
        return labotherid;
    }

    public void setLabotherid(Long labotherid) {
        this.labotherid = labotherid;
    }

    public String getClassification3() {
        return classification3;
    }

    public void setClassification3(String classification3) {
        this.classification3 = classification3 == null ? null : classification3.trim();
    }

    public String getBuildinfo() {
        return buildinfo;
    }

    public void setBuildinfo(String buildinfo) {
        this.buildinfo = buildinfo;
    }

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }

    public String getLabtype() {
        return labtype;
    }

    public void setLabtype(String labtype) {
        this.labtype = labtype == null ? null : labtype.trim();
    }

    public String getBasetype() {
        return basetype;
    }

    public void setBasetype(String basetype) {
        this.basetype = basetype == null ? null : basetype.trim();
    }

    public String getBasetypesub() {
        return basetypesub;
    }

    public void setBasetypesub(String basetypesub) {
        this.basetypesub = basetypesub == null ? null : basetypesub.trim();
    }

    public String getAllieddept() {
        return allieddept;
    }

    public void setAllieddept(String allieddept) {
        this.allieddept = allieddept;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname == null ? null : regionname.trim();
    }

    public String getGovertype() {
        return govertype;
    }

    public void setGovertype(String govertype) {
        this.govertype = govertype == null ? null : govertype.trim();
    }

    public String getFielddist() {
        return fielddist;
    }

    public void setFielddist(String fielddist) {
        this.fielddist = fielddist == null ? null : fielddist.trim();
    }

    public String getFielddistsub() {
        return fielddistsub;
    }

    public void setFielddistsub(String fielddistsub) {
        this.fielddistsub = fielddistsub == null ? null : fielddistsub.trim();
    }

    public String getSubsattri() {
        return subsattri;
    }

    public void setSubsattri(String subsattri) {
        this.subsattri = subsattri == null ? null : subsattri.trim();
    }

    public String getIspostdoctor() {
        return ispostdoctor;
    }

    public void setIspostdoctor(String ispostdoctor) {
        this.ispostdoctor = ispostdoctor == null ? null : ispostdoctor.trim();
    }

    public String getDeptattri() {
        return deptattri;
    }

    public void setDeptattri(String deptattri) {
        this.deptattri = deptattri == null ? null : deptattri.trim();
    }

    public String getIncubident() {
        return incubident;
    }

    public void setIncubident(String incubident) {
        this.incubident = incubident == null ? null : incubident.trim();
    }

    public String getIsplatform() {
        return isplatform;
    }

    public void setIsplatform(String isplatform) {
        this.isplatform = isplatform == null ? null : isplatform.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getSuperiordep() {
        return superiordep;
    }

    public void setSuperiordep(String superiordep) {
        this.superiordep = superiordep;
    }

    public String getJointsuperiordept() {
        return jointsuperiordept;
    }

    public void setJointsuperiordept(String jointsuperiordept) {
        this.jointsuperiordept = jointsuperiordept;
    }

    public String getAreaoflab() {
        return areaoflab;
    }

    public void setAreaoflab(String areaoflab) {
        this.areaoflab = areaoflab == null ? null : areaoflab.trim();
    }

    public String getAreaofwork() {
        return areaofwork;
    }

    public void setAreaofwork(String areaofwork) {
        this.areaofwork = areaofwork == null ? null : areaofwork.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getIssignmaps() {
        return issignmaps;
    }

    public void setIssignmaps(String issignmaps) {
        this.issignmaps = issignmaps == null ? null : issignmaps.trim();
    }

    public String getFormattedaddress() {
        return formattedaddress;
    }

    public void setFormattedaddress(String formattedaddress) {
        this.formattedaddress = formattedaddress == null ? null : formattedaddress.trim();
    }

    public String getIsopenbase() {
        return isopenbase;
    }

    public void setIsopenbase(String isopenbase) {
        this.isopenbase = isopenbase == null ? null : isopenbase.trim();
    }

    public String getLocationnooflab() {
        return locationnooflab;
    }

    public void setLocationnooflab(String locationnooflab) {
        this.locationnooflab = locationnooflab == null ? null : locationnooflab.trim();
    }

    public String getOrderbykcw() {
        return orderbykcw;
    }

    public void setOrderbykcw(String orderbykcw) {
        this.orderbykcw = orderbykcw == null ? null : orderbykcw.trim();
    }

    public String getLeveloflabremark() {
        return leveloflabremark;
    }

    public void setLeveloflabremark(String leveloflabremark) {
        this.leveloflabremark = leveloflabremark == null ? null : leveloflabremark.trim();
    }

    public Integer getOrderbytype() {
        return orderbytype;
    }

    public void setOrderbytype(Integer orderbytype) {
        this.orderbytype = orderbytype;
    }

    public String getProdempol() {
        return prodempol;
    }

    public void setProdempol(String prodempol) {
        this.prodempol = prodempol;
    }

    public String getLabinfostate() {
        return labinfostate;
    }

    public void setLabinfostate(String labinfostate) {
        this.labinfostate = labinfostate == null ? null : labinfostate.trim();
    }

    public String getRelyondep() {
        return relyondep;
    }

    public void setRelyondep(String relyondep) {
        this.relyondep = relyondep == null ? null : relyondep.trim();
    }

    public String getIstemporary() {
        return istemporary;
    }

    public void setIstemporary(String istemporary) {
        this.istemporary = istemporary == null ? null : istemporary.trim();
    }

    public String getIsfull() {
        return isfull;
    }

    public void setIsfull(String isfull) {
        this.isfull = isfull == null ? null : isfull.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLabintro() {
        return labintro;
    }

    public void setLabintro(String labintro) {
        this.labintro = labintro == null ? null : labintro.trim();
    }

    @Override
    public String toString() {
        return "LabInfo{" +
                "labseqno=" + labseqno +
                ", departmentseqno=" + departmentseqno +
                ", labname='" + labname + '\'' +
                ", labno='" + labno + '\'' +
                ", labmajor='" + labmajor + '\'' +
                ", majorphone='" + majorphone + '\'' +
                ", majoremail='" + majoremail + '\'' +
                ", manager='" + manager + '\'' +
                ", managerphone='" + managerphone + '\'' +
                ", manageremail='" + manageremail + '\'' +
                ", labothername=" + labothername +
                ", labenglishname='" + labenglishname + '\'' +
                ", englishiabbrname='" + englishiabbrname + '\'' +
                ", jointdept=" + jointdept +
                ", lablocation='" + lablocation + '\'' +
                ", labaddress='" + labaddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", httpaddress=" + httpaddress +
                ", relatedfields=" + relatedfields +
                ", isjoint='" + isjoint + '\'' +
                ", leveloflab='" + leveloflab + '\'' +
                ", typeoflab='" + typeoflab + '\'' +
                ", approvaldept=" + approvaldept +
                ", approvaltime=" + approvaltime +
                ", accepttime=" + accepttime +
                ", relieddept=" + relieddept +
                ", approvalno=" + approvalno +
                ", registingtime=" + registingtime +
                ", lastassessedtime=" + lastassessedtime +
                ", classification1=" + classification1 +
                ", classification2=" + classification2 +
                ", researchfields=" + researchfields +
                ", researchinterests=" + researchinterests +
                ", researchcontents=" + researchcontents +
                ", laboutline=" + laboutline +
                ", labstate='" + labstate + '\'' +
                ", labotherid=" + labotherid +
                ", classification3='" + classification3 + '\'' +
                ", buildinfo=" + buildinfo +
                ", edittime=" + edittime +
                ", labtype='" + labtype + '\'' +
                ", basetype='" + basetype + '\'' +
                ", basetypesub='" + basetypesub + '\'' +
                ", allieddept=" + allieddept +
                ", regionname='" + regionname + '\'' +
                ", govertype='" + govertype + '\'' +
                ", fielddist='" + fielddist + '\'' +
                ", fielddistsub='" + fielddistsub + '\'' +
                ", subsattri='" + subsattri + '\'' +
                ", ispostdoctor='" + ispostdoctor + '\'' +
                ", deptattri='" + deptattri + '\'' +
                ", incubident='" + incubident + '\'' +
                ", isplatform='" + isplatform + '\'' +
                ", photo='" + photo + '\'' +
                ", superiordep=" + superiordep +
                ", jointsuperiordept=" + jointsuperiordept +
                ", areaoflab='" + areaoflab + '\'' +
                ", areaofwork='" + areaofwork + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", issignmaps='" + issignmaps + '\'' +
                ", formattedaddress='" + formattedaddress + '\'' +
                ", isopenbase='" + isopenbase + '\'' +
                ", locationnooflab='" + locationnooflab + '\'' +
                ", orderbykcw='" + orderbykcw + '\'' +
                ", leveloflabremark='" + leveloflabremark + '\'' +
                ", orderbytype=" + orderbytype +
                ", prodempol=" + prodempol +
                ", labinfostate='" + labinfostate + '\'' +
                ", relyondep='" + relyondep + '\'' +
                ", istemporary='" + istemporary + '\'' +
                ", isfull='" + isfull + '\'' +
                ", address='" + address + '\'' +
                ", labintro='" + labintro + '\'' +
                '}';
    }
    
    
}