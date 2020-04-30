package com.poi.controller;

import java.io.Serializable;
import java.util.Date;

import com.poi.imp.anno.ExcelColum;
import com.poi.imp.anno.ExcelDateColum;

public class TEquipmentSpotCheck implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@ExcelColum("点检任务ID")
	private Long fSpotCheckId;//点检任务ID

	@ExcelColum("单据编码")
    private String fBillCode;//单据编码

	@ExcelColum("单据类型ID")
    private Long fBillTypeId;//单据类型ID

    @ExcelColum("设备ID")
    private Long fEquipmentId;//设备ID

    @ExcelColum("公司ID")
    private Long fOrganizationId;//公司ID

    @ExcelColum("部门ID")
    private Long fDepartmentId;//部门ID

    @ExcelColum("点检员ID")
    private Long fSpotCheckerId;//点检员ID
    
    @ExcelDateColum("点检日期")
    private Date fSpotCheckDate;//点检日期 
    
//    private String fSpotCheckDateStr;
 
    @ExcelColum("点检结果")
    private Integer fResult;//点检结果 0 初始   1 成功  2 失败

    @ExcelColum("结果描述")
    private String fResultDescription;//结果描述

    @ExcelColum("任务状态")
    private Integer fStatus;//任务状态 0 初始 1 点检中 2 点检完成 

    @ExcelColum("审核状态")
    private Integer fAuditStatus;//审核状态 0 初始 1 审核中 254 审核成功 255 审核失败

    @ExcelColum("是否生成维修单")
    private Integer fIsCreateRepair;//是否形成维修单 0:否 1:是

    @ExcelColum("备注")
    private String fRemark;

    @ExcelColum("建立人")
    private String fCreator;

    @ExcelDateColum("建立时间")
    private Date fCreateTime;

    @ExcelColum("修改人")
    private String fMender;

    @ExcelDateColum("修改时间")
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

	public String getFAuditMan() {
		return fAuditMan;
	}

	public void setFAuditMan(String fAuditMan) {
		this.fAuditMan = fAuditMan;
	}

	public Date getFAuditTime() {
		return fAuditTime;
	}

	public void setFAuditTime(Date fAuditTime) {
		this.fAuditTime = fAuditTime;
	}

	private String fAuditMan;
    
    private Date fAuditTime;

    public Long getFSpotCheckId() {
        return fSpotCheckId;
    }

    public void setFSpotCheckId(Long fSpotCheckId) {
        this.fSpotCheckId = fSpotCheckId;
    }

    public String getFBillCode() {
        return fBillCode;
    }

    public void setFBillCode(String fBillCode) {
        this.fBillCode = fBillCode == null ? null : fBillCode.trim();
    }

    public Long getFBillTypeId() {
        return fBillTypeId;
    }

    public void setFBillTypeId(Long fBillTypeId) {
        this.fBillTypeId = fBillTypeId;
    }

    public Long getFEquipmentId() {
        return fEquipmentId;
    }

    public void setFEquipmentId(Long fEquipmentId) {
        this.fEquipmentId = fEquipmentId;
    }

    public Long getFOrganizationId() {
        return fOrganizationId;
    }

    public void setFOrganizationId(Long fOrganizationId) {
        this.fOrganizationId = fOrganizationId;
    }

    public Long getFDepartmentId() {
        return fDepartmentId;
    }

    public void setFDepartmentId(Long fDepartmentId) {
        this.fDepartmentId = fDepartmentId;
    }

    public Long getFSpotCheckerId() {
        return fSpotCheckerId;
    }

    public void setFSpotCheckerId(Long fSpotCheckerId) {
        this.fSpotCheckerId = fSpotCheckerId;
    } 

    public Integer getFResult() {
        return fResult;
    }

    public void setFResult(Integer fResult) {
        this.fResult = fResult;
    }

    public String getFResultDescription() {
        return fResultDescription;
    }

    public void setFResultDescription(String fResultDescription) {
        this.fResultDescription = fResultDescription == null ? null : fResultDescription.trim();
    }

    public Integer getFStatus() {
        return fStatus;
    }

    public void setFStatus(Integer fStatus) {
        this.fStatus = fStatus;
    }

    public Integer getFAuditStatus() {
        return fAuditStatus;
    }

    public void setFAuditStatus(Integer fAuditStatus) {
        this.fAuditStatus = fAuditStatus;
    }

    public Integer getFIsCreateRepair() {
        return fIsCreateRepair;
    }

    public void setFIsCreateRepair(Integer fIsCreateRepair) {
        this.fIsCreateRepair = fIsCreateRepair;
    }

    public String getFRemark() {
        return fRemark;
    }

    public void setFRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
    }

    public String getFCreator() {
        return fCreator;
    }

    public void setFCreator(String fCreator) {
        this.fCreator = fCreator == null ? null : fCreator.trim();
    }

    public Date getFCreateTime() {
        return fCreateTime;
    }

    public void setFCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public String getFMender() {
        return fMender;
    }

    public void setFMender(String fMender) {
        this.fMender = fMender == null ? null : fMender.trim();
    }

    public Date getFModifyTime() {
        return fModifyTime;
    }

    public void setFModifyTime(Date fModifyTime) {
        this.fModifyTime = fModifyTime;
    }

    public String getFVer() {
        return fVer;
    }

    public void setFVer(String fVer) {
        this.fVer = fVer == null ? null : fVer.trim();
    }

	public String getFResultName() {
		return fResultName;
	}

	public void setFResultName(String fResultName) {
		this.fResultName = fResultName;
	}

	public String getFStatusName() {
		return fStatusName;
	}

	public void setFStatusName(String fStatusName) {
		this.fStatusName = fStatusName;
	}

	public String getFAuditStatusName() {
		return fAuditStatusName;
	}

	public void setFAuditStatusName(String fAuditStatusName) {
		this.fAuditStatusName = fAuditStatusName;
	}

	public String getFIsCreateRepairStr() {
		return fIsCreateRepairStr;
	}

	public void setFIsCreateRepairStr(String fIsCreateRepairStr) {
		this.fIsCreateRepairStr = fIsCreateRepairStr;
	}

	public String getFBillTypeName() {
		return fBillTypeName;
	}

	public void setFBillTypeName(String fBillTypeName) {
		this.fBillTypeName = fBillTypeName;
	}

	public String getFEquipmentName() {
		return fEquipmentName;
	}

	public void setFEquipmentName(String fEquipmentName) {
		this.fEquipmentName = fEquipmentName;
	}

	public String getFOrganizationPath() {
		return fOrganizationPath;
	}

	public void setFOrganizationPath(String fOrganizationPath) {
		this.fOrganizationPath = fOrganizationPath;
	}

	public String getFOrganizationName() {
		return fOrganizationName;
	}

	public void setFOrganizationName(String fOrganizationName) {
		this.fOrganizationName = fOrganizationName;
	}

	public String getFSpotCheckerName() {
		return fSpotCheckerName;
	}

	public void setFSpotCheckerName(String fSpotCheckerName) {
		this.fSpotCheckerName = fSpotCheckerName;
	}

	public String getFDepartmentName() {
		return fDepartmentName;
	}

	public void setFDepartmentName(String fDepartmentName) {
		this.fDepartmentName = fDepartmentName;
	}

	public Date getFSpotCheckDate() {
		return fSpotCheckDate;
	}

	public void setFSpotCheckDate(Date fSpotCheckDate) {
		this.fSpotCheckDate = fSpotCheckDate;
	}

//	public String getFSpotCheckDateStr() {
//		return fSpotCheckDateStr;
//	}
//
//	public void setFSpotCheckDateStr(String fSpotCheckDateStr) {
//		this.fSpotCheckDateStr = fSpotCheckDateStr;
//	}

}