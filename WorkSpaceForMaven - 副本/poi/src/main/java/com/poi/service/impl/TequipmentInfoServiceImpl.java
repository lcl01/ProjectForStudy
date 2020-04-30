package com.poi.service.impl;

import java.io.InputStream;

import org.springframework.stereotype.Service;
import com.poi.entity.swai_wise.TEquipmentInfo;
import com.poi.imp.PoiImporter;
import com.poi.imp.vo.PoiGenericSheetVo;

/**
 * 	设备台账导入 服务
 * 
 * @author lijunjie
 * 
 * create 2019年11月14日
 */
@Service("equipmentInfoService")
public class TequipmentInfoServiceImpl implements ITequipmentInfoService{

	/**
	 * 	转换Excel 为 Model实体
	 * @param inputStream
	 * @return
	 * update by lijunjie
	 * 2019年11月14日
	 */
	@Override
	public PoiGenericSheetVo<TEquipmentInfo> transExcel2Model(InputStream inputStream) {
		
		return PoiImporter.importFirstSheetFrom(inputStream, TEquipmentInfo.class);
	}

}
