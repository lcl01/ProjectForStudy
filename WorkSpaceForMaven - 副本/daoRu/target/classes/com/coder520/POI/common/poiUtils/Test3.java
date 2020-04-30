package com.coder520.POI.common.poiUtils;

import com.coder520.POI.LabDepartment.dao.LabDepartmentMapper;
import com.coder520.POI.LabDepartment.entity.LabDepartment;
import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by yang on 2017/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cfg.xml")
public class Test3 {
    @Autowired
    private LabInfoMapper labInfoMapper;
    @Autowired
    private LabDepartmentMapper labDepartmentMapper;

    @Test
    //@Transactional
    public void creatLabInfo() throws FileNotFoundException, IOException, ParseException {
        String filePath="E:\\01_基本信息.xls";
        Excel2Data excel2Data=new Excel2Data(filePath);
        List<LabInfo> labInfoList = excel2Data.CreateLabInfoList();
        int sum =0;
        LabInfo labInfo = labInfoList.get(722);
            try {
                if (labInfo.getRelieddept()!=null){
                    LabDepartment labDepartment =null;
                    String departmentName = (String) labInfo.getRelieddept();
                    System.out.println(departmentName);
                    labDepartment = labDepartmentMapper.selectByDepartmentName(departmentName);
                    //根据依托单位名判断依托单位是否存在
                    if (labDepartment!=null){
                        //若依托单位存在，则判断实验室是否存在,存在则更新，不存在则插入
                        List<LabInfo>  labInfo1 = labInfoMapper.selectByLabNameAndId(labInfo.getLabname(),labDepartment.getDepartmentseqno());
                        if (labInfo1.size()>0){
                            labInfo.setDepartmentseqno(labDepartment.getDepartmentseqno());
                            labInfo.setOrderbykcw("1");
                            labInfo.setLabseqno(labInfo1.get(0).getLabseqno());
                            labInfoMapper.updateByPrimaryKeySelective(labInfo);

                        }else {
                            labInfo.setOrderbykcw("2");
                            labInfo.setDepartmentseqno(labDepartment.getDepartmentseqno());
                            labInfoMapper.insertAddKey(labInfo);

                        }
                    }else {
                        //若依托单位不存在，则新建依托单位并插入
                        LabDepartment labDepartment1 = new LabDepartment();
                        labDepartment1.setDepartmentname(departmentName);
                        labDepartmentMapper.insertAddKey(labDepartment1);
                        labInfo.setDepartmentseqno(labDepartment1.getDepartmentseqno());
                        labInfo.setOrderbykcw("2");
                        labInfoMapper.insertAddKey(labInfo);

                    }
                }else {
                    //判断以其以其载体名创建的是依托单位是否存在，若不存在则创建
                    LabDepartment labDepartment = labDepartmentMapper.selectByDepartmentName(labInfo.getLabname());
                    if (labDepartment == null){
                        LabDepartment labDepartment2 = new LabDepartment();
                        labDepartment2.setDepartmentname(labInfo.getLabname());
                        labDepartmentMapper.insertAddKey(labDepartment2);
                        labInfo.setDepartmentseqno(labDepartment2.getDepartmentseqno());
                        labInfo.setOrderbykcw("2");
                        labInfoMapper.insertAddKey(labInfo);
                    }else {
                        List<LabInfo>  labInfo1 = labInfoMapper.selectByLabNameAndId(labInfo.getLabname(),labDepartment.getDepartmentseqno());
                        if (labInfo1.size()>0){
                            labInfo.setDepartmentseqno(labDepartment.getDepartmentseqno());
                            labInfo.setOrderbykcw("1");
                            labInfo.setLabseqno(labInfo1.get(0).getLabseqno());
                            labInfoMapper.updateByPrimaryKeySelective(labInfo);
                        }else {
                            labInfo.setOrderbykcw("2");
                            labInfo.setDepartmentseqno(labDepartment.getDepartmentseqno());
                            labInfoMapper.insertAddKey(labInfo);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(labInfo.toString());
                sum++;
                System.out.println(sum);
                e.printStackTrace();
            }

    }
}
