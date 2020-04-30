package com.poi.entity.swai_wise;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.poi.imp.anno.ExcelColum;
import com.poi.imp.anno.ExcelDateColum;

/**
 * 	@SWAI_WISE
 * 
 * 	物联网系统设备台账
 * 
 * @author lijunjie
 * 
 * create 2019年11月14日
 */
public class TEquipmentInfo implements Serializable{

	//private static final long serialVersionUID = 1L;

	@ExcelColum("设备ID")
	private Long fEquipmentId;//设备ID

	@ExcelColum("设备分类ID")
    private Long fEquipmentCategoryId;//设备分类ID

	@ExcelColum("编号")
    private String fEquipmentNumber;//编号

	@ExcelColum("名称")
    private String fEquipmentName;//名称

	@ExcelColum("公司ID")
    private Long fOrganizationId;//公司ID
    
	@ExcelColum("保管部门ID")
    private Long fDepartmentId;//保管部门ID   update by lijunjie 2019年9月5日

	@ExcelColum("责任人ID")
    private Long fResponseManId;//责任人ID

	@ExcelColum("图片路径")
    private String fImageUrl;//图片路径

	@ExcelColum("规格型号")
    private String fType;//规格型号

	@ExcelColum("出厂编号")
    private String fFactoryNumber;//出厂编号

	@ExcelColum("供应商ID")
    private Long fSupplierId;//供应商ID
    
	@ExcelDateColum("生产日期")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fProductDate;//生产日期
    
	@ExcelColum("使用期限(天)")
    private Integer fLifeSpan;//使用期限(天)

	@ExcelColum("设备金额")
    private BigDecimal fMoney;//设备金额

	@ExcelColum("设备区域ID")
    private Long fAreaId;//设备区域ID

	@ExcelColum("设备地址")
    private String fAddress;//设备地址

	@ExcelColum("加工周期(小时)")
    private Integer fCycleTime;//加工周期(小时)

	@ExcelColum("额定功率")
    private Integer fRatedPower;//额定功率

	@ExcelColum("状态")
    private Integer fStatus;//状态 0 禁用 1 启用
    
	@ExcelDateColum("启用时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fStartTime;//启用时间
    
	@ExcelDateColum("停用时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fEndTime;//停用时间

	@ExcelColum("备注")
    private String fRemark;//备注

	@ExcelColum("建立人")
    private String fCreator;//建立人

	@ExcelDateColum("建立时间")
    private Date fCreateTime;//建立时间

	@ExcelColum("修改人")
    private String fMender;//修改人

	@ExcelDateColum("修改时间")
    private Date fModifyTime;//修改时间

    private String fVer;
    
    private String fStatusName;//设备状态名
    
    private String fEquipmentCategoryName;//设备分类名称
    
    private String fOrganizationNumber;//组织编码
    
    private String fOrganizationName;//组织名称
    
    private String fResponseManName;//责任人姓名
    
    private String fSupplierNumber;//供应商编码
    
    private String fSupplierName;//供应商名称
    
    private String fUnitName;//计量单位名称
    
    private String fDepartmentNumber;//部门编码
    
    private String fDepartmentName;//部门名

    public Long getFEquipmentId() {
        return fEquipmentId;
    }

    public void setFEquipmentId(Long fEquipmentId) {
        this.fEquipmentId = fEquipmentId;
    }

    public Long getFEquipmentCategoryId() {
        return fEquipmentCategoryId;
    }

    public void setFEquipmentCategoryId(Long fEquipmentCategoryId) {
        this.fEquipmentCategoryId = fEquipmentCategoryId;
    }

    public String getFEquipmentNumber() {
        return fEquipmentNumber;
    }

    public void setFEquipmentNumber(String fEquipmentNumber) {
        this.fEquipmentNumber = fEquipmentNumber == null ? null : fEquipmentNumber.trim();
    }

    public String getFEquipmentName() {
        return fEquipmentName;
    }

    public void setFEquipmentName(String fEquipmentName) {
        this.fEquipmentName = fEquipmentName == null ? null : fEquipmentName.trim();
    }

    public Long getFOrganizationId() {
        return fOrganizationId;
    }

    public void setFOrganizationId(Long fOrganizationId) {
        this.fOrganizationId = fOrganizationId;
    }

    public Long getFResponseManId() {
        return fResponseManId;
    }

    public void setFResponseManId(Long fResponseManId) {
        this.fResponseManId = fResponseManId;
    }

    public String getFImageUrl() {
        return fImageUrl;
    }

    public void setFImageUrl(String fImageUrl) {
        this.fImageUrl = fImageUrl == null ? null : fImageUrl.trim();
    }

    public String getFType() {
        return fType;
    }

    public void setFType(String fType) {
        this.fType = fType == null ? null : fType.trim();
    }

    public String getFFactoryNumber() {
        return fFactoryNumber;
    }

    public void setFFactoryNumber(String fFactoryNumber) {
        this.fFactoryNumber = fFactoryNumber == null ? null : fFactoryNumber.trim();
    }

    public Long getFSupplierId() {
        return fSupplierId;
    }

    public void setFSupplierId(Long fSupplierId) {
        this.fSupplierId = fSupplierId;
    }

    public Integer getFLifeSpan() {
        return fLifeSpan;
    }

    public void setFLifeSpan(Integer fLifeSpan) {
        this.fLifeSpan = fLifeSpan;
    }

    public BigDecimal getFMoney() {
        return fMoney;
    }

    public void setFMoney(BigDecimal fMoney) {
        this.fMoney = fMoney;
    }

    public Long getFAreaId() {
        return fAreaId;
    }

    public void setFAreaId(Long fAreaId) {
        this.fAreaId = fAreaId;
    }

    public String getFAddress() {
        return fAddress;
    }

    public void setFAddress(String fAddress) {
        this.fAddress = fAddress == null ? null : fAddress.trim();
    }

    public Integer getFCycleTime() {
        return fCycleTime;
    }

    public void setFCycleTime(Integer fCycleTime) {
        this.fCycleTime = fCycleTime;
    }
 
    public Integer getFRatedPower() {
        return fRatedPower;
    }

    public void setFRatedPower(Integer fRatedPower) {
        this.fRatedPower = fRatedPower;
    }

    public Integer getFStatus() {
        return fStatus;
    }

    public void setFStatus(Integer fStatus) {
        this.fStatus = fStatus;
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

	public String getFEquipmentCategoryName() {
		return fEquipmentCategoryName;
	}

	public void setFEquipmentCategoryName(String fEquipmentCategoryName) {
		this.fEquipmentCategoryName = fEquipmentCategoryName;
	}

	public String getFOrganizationNumber() {
		return fOrganizationNumber;
	}

	public void setFOrganizationNumber(String fOrganizationNumber) {
		this.fOrganizationNumber = fOrganizationNumber;
	}

	public String getFOrganizationName() {
		return fOrganizationName;
	}

	public void setFOrganizationName(String fOrganizationName) {
		this.fOrganizationName = fOrganizationName;
	}

	public String getFSupplierNumber() {
		return fSupplierNumber;
	}

	public void setFSupplierNumber(String fSupplierNumber) {
		this.fSupplierNumber = fSupplierNumber;
	}

	public String getFSupplierName() {
		return fSupplierName;
	}

	public void setFSupplierName(String fSupplierName) {
		this.fSupplierName = fSupplierName;
	}

	public String getFUnitName() {
		return fUnitName;
	}

	public void setFUnitName(String fUnitName) {
		this.fUnitName = fUnitName;
	}

	public String getFStatusName() {
		return fStatusName;
	}

	public void setFStatusName(String fStatusName) {
		this.fStatusName = fStatusName;
	}

	public Date getFProductDate() {
		return fProductDate;
	}

	public void setFProductDate(Date fProductDate) {
		this.fProductDate = fProductDate;
	}

	public Date getFStartTime() {
		return fStartTime;
	}

	public void setFStartTime(Date fStartTime) {
		this.fStartTime = fStartTime;
	}

	public Date getFEndTime() {
		return fEndTime;
	}

	public void setFEndTime(Date fEndTime) {
		this.fEndTime = fEndTime;
	}

	public String getFResponseManName() {
		return fResponseManName;
	}

	public void setFResponseManName(String fResponseManName) {
		this.fResponseManName = fResponseManName;
	}

	public Long getFDepartmentId() {
		return fDepartmentId;
	}

	public void setFDepartmentId(Long fDepartmentId) {
		this.fDepartmentId = fDepartmentId;
	}

	public String getFDepartmentNumber() {
		return fDepartmentNumber;
	}

	public void setFDepartmentNumber(String fDepartmentNumber) {
		this.fDepartmentNumber = fDepartmentNumber;
	}

	public String getFDepartmentName() {
		return fDepartmentName;
	}

	public void setFDepartmentName(String fDepartmentName) {
		this.fDepartmentName = fDepartmentName;
	}
}
