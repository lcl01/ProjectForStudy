package com.coder520.POI.common.poiUtils;

import com.coder520.POI.LabDepartment.dao.LabDepartmentMapper;
import com.coder520.POI.LabEquipment.dao.LabEquipmentMapper;
import com.coder520.POI.LabEquipment.entity.LabEquipment;
import com.coder520.POI.LabEquipmentList.dao.LabEquipmentListMapper;
import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by yang on 2017/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cfg.xml")
public class labEquipment2Date {
    @Autowired
    private LabInfoMapper labInfoMapper;
    @Autowired
    private LabDepartmentMapper labDepartmentMapper;
    @Autowired
    private LabEquipmentMapper labEquipmentMapper;
    @Autowired
    private LabEquipmentListMapper labEquipmentListMapper;

    @Test
    public void creatLabEquipment() throws ParseException {
        int updateSum = 0;
        int insertSum = 0;
        int errorNum = 0;
        Map<String,String> idAndName = new Excel2Data("E:\\01_基本信息.xls").getLabName();
        List<LabEquipment> labEquipmentList = new Excel2Data("E:\\02_基础设施条件.xls").CreateLabEquipmentList();
        for (LabEquipment labEquipment: labEquipmentList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (labEquipment.getAttention().equals(entry.getKey())){
                    labEquipment.setWhichlab(entry.getValue());
                }
            }
        }
        try {
            for (LabEquipment labEquipment: labEquipmentList){
                List<LabEquipment>  labEquipment1 = labEquipmentMapper.selectByName(labEquipment.getChinesename(),labEquipment.getWhichlab(), labEquipment.getRawvalue());
                //根据设备名、实验室名、原值查询设备是否存在，若存在，则更新，若不存在，则插入
                if (labEquipment1.size()>0){
                    labEquipment.setLabseqno(labEquipment1.get(0).getLabseqno());
                    labEquipment.setEquipseqno(labEquipment1.get(0).getEquipseqno());
                    labEquipment.setEquipno(labEquipment1.get(0).getEquipno());
                    labEquipmentMapper.updateByPrimaryKeySelective(labEquipment);
                    updateSum++;
                }else {
                    //若查询结果为空，则先获取设备实验室编号和设备号后再插入
                    try {
                        List<LabInfo> labInfoList = labInfoMapper.findLabByName(labEquipment.getWhichlab());
                        if (labInfoList.size()>0){
                            labEquipment.setLabseqno(labInfoList.get(0).getLabseqno());
                            //分配设备号
                            Random random = new Random();
                            String sRand = "";
                            String setno = "";
                            for (int i = 0; i < 6; i++) {
                                String rand = String.valueOf(random.nextInt(10));
                                sRand += rand;
                            }
                            setno = "010101"+sRand;
                            labEquipment.setEquipno(setno);
                            //System.out.println(labEquipment.toString());
                            labEquipmentMapper.insertAddKey(labEquipment);
                            insertSum++;
                        }
                    } catch (Exception e) {
                        errorNum++;
                        e.printStackTrace();
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(updateSum);
        System.out.println(insertSum);

    }
}
