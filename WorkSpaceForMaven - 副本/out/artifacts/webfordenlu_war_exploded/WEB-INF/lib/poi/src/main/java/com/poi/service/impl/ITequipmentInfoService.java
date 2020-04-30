package com.poi.service.impl;

import java.io.InputStream;

import com.poi.entity.swai_wise.TEquipmentInfo;
import com.poi.imp.vo.PoiGenericSheetVo;

/**
 * 	设备台账导入服务
 * 
 * @author lijunjie
 * 
 * create 2019年11月14日
 */
public interface ITequipmentInfoService {

	public PoiGenericSheetVo<TEquipmentInfo> transExcel2Model(InputStream inputStream);
	
}
