package com.poi.controller;

import java.io.Serializable;
import java.util.Date;

public class TSpotCheckItem implements Serializable {
	 
	 /**
	 * 点检项目
	 */
	    private static final long serialVersionUID = 1L;

	    private Long fSpotcheckItemId;

	    private Long fOrganizationId;

	    private String fSpotcheckItemCode;

	    private String fSpotcheckItemName;

	    private Integer fSort;

	    private String fRemark;

	    private Integer fStatus;

	    private Integer fSysMark;

	    private String fCreator;

	    private Date fCreateTime;

	    private String fMender;

	    private Date fModifyTime;

	    private String fVer;
	    
	    public String getfOrganizationNumber() {
			return fOrganizationNumber;
		}

		public void setfOrganizationNumber(String fOrganizationNumber) {
			this.fOrganizationNumber = fOrganizationNumber;
		}

		public String getfOrganizationName() {
			return fOrganizationName;
		}

		public void setfOrganizationName(String fOrganizationName) {
			this.fOrganizationName = fOrganizationName;
		}

		public String getfStatusName() {
			return fStatusName;
		}

		public void setfStatusName(String fStatusName) {
			this.fStatusName = fStatusName;
		}

		public String getfSysMarkName() {
			return fSysMarkName;
		}

		public void setfSysMarkName(String fSysMarkName) {
			this.fSysMarkName = fSysMarkName;
		}

		private String fOrganizationNumber;
	    
	    private String fOrganizationName;  
	    
	    private String fStatusName;
	    
	    private String fSysMarkName;

	    public Long getfSpotcheckItemId() {
	        return fSpotcheckItemId;
	    }

	    public void setfSpotcheckItemId(Long fSpotcheckItemId) {
	        this.fSpotcheckItemId = fSpotcheckItemId;
	    }

	    public Long getfOrganizationId() {
	        return fOrganizationId;
	    }

	    public void setfOrganizationId(Long fOrganizationId) {
	        this.fOrganizationId = fOrganizationId;
	    }

	    public String getfSpotcheckItemCode() {
	        return fSpotcheckItemCode;
	    }

	    public void setfSpotcheckItemCode(String fSpotcheckItemCode) {
	        this.fSpotcheckItemCode = fSpotcheckItemCode == null ? null : fSpotcheckItemCode.trim();
	    }

	    public String getfSpotcheckItemName() {
	        return fSpotcheckItemName;
	    }

	    public void setfSpotcheckItemName(String fSpotcheckItemName) {
	        this.fSpotcheckItemName = fSpotcheckItemName == null ? null : fSpotcheckItemName.trim();
	    }

	    public Integer getfSort() {
	        return fSort;
	    }

	    public void setfSort(Integer fSort) {
	        this.fSort = fSort;
	    }

	    public String getfRemark() {
	        return fRemark;
	    }

	    public void setfRemark(String fRemark) {
	        this.fRemark = fRemark == null ? null : fRemark.trim();
	    }

	    public Integer getfStatus() {
	        return fStatus;
	    }

	    public void setfStatus(Integer fStatus) {
	        this.fStatus = fStatus;
	    }

	    public Integer getfSysMark() {
	        return fSysMark;
	    }

	    public void setfSysMark(Integer fSysMark) {
	        this.fSysMark = fSysMark;
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

}