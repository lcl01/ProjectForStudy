package com.coder520.POI.common.poiUtils;

import com.coder520.POI.LabDepartment.dao.LabDepartmentMapper;
import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.user.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by yang on 2017/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cfg.xml")
public class Test2 {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LabInfoMapper labInfoMapper;
    @Autowired
    private LabDepartmentMapper labDepartmentMapper;

    @Test
    public void creatNewLabInfo(){
//		文件路径
        String filePath="F:\\新增单位信息.xls";
//		第一行表格标题
        String title="新增单位信息表";
//		表头--根据数据表设置
        String[] titles={"载体名称","负责人（创新载体负责人）","依托单位","联系人（管理员）" ,"联系电话（管理员联系电话）","邮箱（管理员的email）"};
//		sql语句
        List<LabInfo> infoList = labInfoMapper.findNewLabInfo();
        new labInfo2Excle(infoList, filePath, title,titles);
        //for (LabInfo labInfo: infoList){
        //	System.out.println(labInfo.toString());
        //}
    }
}
