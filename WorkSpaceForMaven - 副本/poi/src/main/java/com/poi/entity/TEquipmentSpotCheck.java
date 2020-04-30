package com.poi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 点检任务
 * 
 * @author lijunjie
 * 
 * create 2019年9月12日
 */
public class TEquipmentSpotCheck implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long fSpotCheckId;//点检任务ID

    private String fBillCode;//单据编码

    private Long fBillTypeId;//单据类型ID

    private Long fEquipmentId;//设备ID

    private Long fOrganizationId;//组织ID

    private Long fDepartmentId;//部门ID

    private Long fSpotCheckerId;//点检员ID
    
    private Date fSpotCheckDate;//点检日期 
    
    private String fSpotCheckDateStr;
 
    private Integer fResult;//点检结果 0 初始   1 成功  2 失败

    private String fResultDescription;//结果描述

    private Integer fStatus;//任务状态 0 初始 1 点检中 2 点检完成 

    private Integer fAuditStatus;//审核状态 0 初始 1 审核中 254 审核成功 255 审核失败

    private Integer fIsCreateRepair;//是否形成维修单 0:否 1:是

    private String fRemark;

    private String fCreator;

    private Date fCreateTime;

    private String fMender;

    private Date fModifyTime;

    private String fVer;
    
    private String fResultName;//点检结果
    
    private String fStatusName;//任务状态
    
    private String fAuditStatusName;//审核状态
    
    private String fIsCreateRepairStr;//是否生成维修单
    
    private String fBillTypeName;//单据类型
    
    private String fEquipmentName;//设备名
    
    private String fOrganizationPath;//组织路径
    
    private String fOrganizationName;//组织名
    
    private String fSpotCheckerName;//点检人
    
    private String fDepartmentName;//部门
    
    private String spotcheckdetailadddetail;//任务明细增加数据
    
    private String spotcheckdetailupdatedetail;//任务明细修改数据
    
    private String spotcheckdetaildeletedetail;//任务明细删除数据

    public String getfAuditMan() {
		return fAuditMan;
	}

	public void setfAuditMan(String fAuditMan) {
		this.fAuditMan = fAuditMan;
	}

	public Date getfAuditTime() {
		return fAuditTime;
	}

	public void setfAuditTime(Date fAuditTime) {
		this.fAuditTime = fAuditTime;
	}

	private String fAuditMan;
    
    private Date fAuditTime;

    public Long getfSpotCheckId() {
        return fSpotCheckId;
    }

    public void setfSpotCheckId(Long fSpotCheckId) {
        this.fSpotCheckId = fSpotCheckId;
    }

    public String getfBillCode() {
        return fBillCode;
    }

    public void setfBillCode(String fBillCode) {
        this.fBillCode = fBillCode == null ? null : fBillCode.trim();
    }

    public Long getfBillTypeId() {
        return fBillTypeId;
    }

    public void setfBillTypeId(Long fBillTypeId) {
        this.fBillTypeId = fBillTypeId;
    }

    public Long getfEquipmentId() {
        return fEquipmentId;
    }

    public void setfEquipmentId(Long fEquipmentId) {
        this.fEquipmentId = fEquipmentId;
    }

    public Long getfOrganizationId() {
        return fOrganizationId;
    }

    public void setfOrganizationId(Long fOrganizationId) {
        this.fOrganizationId = fOrganizationId;
    }

    public Long getfDepartmentId() {
        return fDepartmentId;
    }

    public void setfDepartmentId(Long fDepartmentId) {
        this.fDepartmentId = fDepartmentId;
    }

    public Long getfSpotCheckerId() {
        return fSpotCheckerId;
    }

    public void setfSpotCheckerId(Long fSpotCheckerId) {
        this.fSpotCheckerId = fSpotCheckerId;
    } 

    public Integer getfResult() {
        return fResult;
    }

    public void setfResult(Integer fResult) {
        this.fResult = fResult;
    }

    public String getfResultDescription() {
        return fResultDescription;
    }

    public void setfResultDescription(String fResultDescription) {
        this.fResultDescription = fResultDescription == null ? null : fResultDescription.trim();
    }

    public Integer getfStatus() {
        return fStatus;
    }

    public void setfStatus(Integer fStatus) {
        this.fStatus = fStatus;
    }

    public Integer getfAuditStatus() {
        return fAuditStatus;
    }

    public void setfAuditStatus(Integer fAuditStatus) {
        this.fAuditStatus = fAuditStatus;
    }

    public Integer getfIsCreateRepair() {
        return fIsCreateRepair;
    }

    public void setfIsCreateRepair(Integer fIsCreateRepair) {
        this.fIsCreateRepair = fIsCreateRepair;
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
    }

    public String getfCreator() {
        return fCreator;
    }

    public void setfCreator(String fCreator) {
        this.fCreator = fCreator == null ? null : fCreator.trim();
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public String getfMender() {
        return fMender;
    }

    public void setfMender(String fMender) {
        this.fMender = fMender == null ? null : fMender.trim();
    }

    public Date getfModifyTime() {
        return fModifyTime;
    }

    public void setfModifyTime(Date fModifyTime) {
        this.fModifyTime = fModifyTime;
    }

    public String getfVer() {
        return fVer;
    }

    public void setfVer(String fVer) {
        this.fVer = fVer == null ? null : fVer.trim();
    }

	public String getfResultName() {
		return fResultName;
	}

	public void setfResultName(String fResultName) {
		this.fResultName = fResultName;
	}

	public String getfStatusName() {
		return fStatusName;
	}

	public void setfStatusName(String fStatusName) {
		this.fStatusName = fStatusName;
	}

	public String getfAuditStatusName() {
		return fAuditStatusName;
	}

	public void setfAuditStatusName(String fAuditStatusName) {
		this.fAuditStatusName = fAuditStatusName;
	}

	public String getfIsCreateRepairStr() {
		return fIsCreateRepairStr;
	}

	public void setfIsCreateRepairStr(String fIsCreateRepairStr) {
		this.fIsCreateRepairStr = fIsCreateRepairStr;
	}

	public String getfBillTypeName() {
		return fBillTypeName;
	}

	public void setfBillTypeName(String fBillTypeName) {
		this.fBillTypeName = fBillTypeName;
	}

	public String getfEquipmentName() {
		return fEquipmentName;
	}

	public void setfEquipmentName(String fEquipmentName) {
		this.fEquipmentName = fEquipmentName;
	}

	public String getfOrganizationPath() {
		return fOrganizationPath;
	}

	public void setfOrganizationPath(String fOrganizationPath) {
		this.fOrganizationPath = fOrganizationPath;
	}

	public String getfOrganizationName() {
		return fOrganizationName;
	}

	public void setfOrganizationName(String fOrganizationName) {
		this.fOrganizationName = fOrganizationName;
	}

	public String getfSpotCheckerName() {
		return fSpotCheckerName;
	}

	public void setfSpotCheckerName(String fSpotCheckerName) {
		this.fSpotCheckerName = fSpotCheckerName;
	}

	public String getfDepartmentName() {
		return fDepartmentName;
	}

	public void setfDepartmentName(String fDepartmentName) {
		this.fDepartmentName = fDepartmentName;
	}

	public String getSpotcheckdetailadddetail() {
		return spotcheckdetailadddetail;
	}

	public void setSpotcheckdetailadddetail(String spotcheckdetailadddetail) {
		this.spotcheckdetailadddetail = spotcheckdetailadddetail;
	}

	public String getSpotcheckdetailupdatedetail() {
		return spotcheckdetailupdatedetail;
	}

	public void setSpotcheckdetailupdatedetail(String spotcheckdetailupdatedetail) {
		this.spotcheckdetailupdatedetail = spotcheckdetailupdatedetail;
	}

	public String getSpotcheckdetaildeletedetail() {
		return spotcheckdetaildeletedetail;
	}

	public void setSpotcheckdetaildeletedetail(String spotcheckdetaildeletedetail) {
		this.spotcheckdetaildeletedetail = spotcheckdetaildeletedetail;
	}
	
	public Date getfSpotCheckDate() {
		return fSpotCheckDate;
	}

	public void setfSpotCheckDate(Date fSpotCheckDate) {
		this.fSpotCheckDate = fSpotCheckDate;
	}

	public String getfSpotCheckDateStr() {
		return fSpotCheckDateStr;
	}

	public void setfSpotCheckDateStr(String fSpotCheckDateStr) {
		this.fSpotCheckDateStr = fSpotCheckDateStr;
	}

}
