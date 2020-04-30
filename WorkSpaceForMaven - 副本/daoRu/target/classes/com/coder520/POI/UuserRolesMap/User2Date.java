package com.coder520.POI.UuserRolesMap;

import com.coder520.POI.LabDepartment.dao.LabDepartmentMapper;
import com.coder520.POI.LabDepartment.entity.LabDepartment;
import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.TeacherBaseInfo.dao.TeacherBaseInfoMapper;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import com.coder520.POI.UuserRolesMap.dao.UuserRolesMapMapper;
import com.coder520.POI.UuserRolesMap.entity.UuserRolesMap;
import com.coder520.POI.common.Utils.MD5;
import com.coder520.POI.common.poiUtils.Excel2Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2017/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cfg.xml")
public class User2Date {
    @Autowired
    TeacherBaseInfoMapper teacherBaseInfoMapper;
    @Autowired
    LabInfoMapper labInfoMapper;
    @Autowired
    UuserRolesMapMapper uuserRolesMapMapper;
    @Autowired
    LabDepartmentMapper labDepartmentMapper;

    @Test
    //@Transactional
    public void creatUuserRolesMapMapper(){
        List<TeacherBaseInfo> teacherBaseInfoList = teacherBaseInfoMapper.findNewTeacher();
        for (TeacherBaseInfo teacherBaseInfo: teacherBaseInfoList){
            //if (teacherBaseInfo.getTeacherlogonname()==null && teacherBaseInfo.getLoginpassword()==null){
            //    teacherBaseInfo.setTeacherlogonname("irshare"+teacherBaseInfo.getTeacherseqno());
            //    teacherBaseInfo.setLoginpassword(MD5.MD5Encode("111111"));
            //    teacherBaseInfoMapper.updateByPrimaryKeySelective(teacherBaseInfo);
            //}

            UuserRolesMap uuserRolesMap = new UuserRolesMap();
            uuserRolesMap.setUserseqno(teacherBaseInfo.getTeacherseqno());
            uuserRolesMap.setRoleseqno((long) 30);
            uuserRolesMap.setIsmanager("0");
            uuserRolesMap.setIsresearcher("1");
            uuserRolesMap.setModelitemrights("[{\"firstcode\":1,\"firstname\":\"项目管理\",\"secondMod\":[{\"secondcode\":141,\"secondname\":\"项目登记\",\"operate\":[]}]},{\"firstcode\":2,\"firstname\":\"成果管理\",\"secondMod\":[{\"secondcode\":3,\"secondname\":\"论文登记\",\"operate\":[]},{\"secondcode\":4,\"secondname\":\"获奖登记\",\"operate\":[]},{\"secondcode\":5,\"secondname\":\"著作登记\",\"operate\":[]},{\"secondcode\":6,\"secondname\":\"专利登记\",\"operate\":[]},{\"secondcode\":250,\"secondname\":\"其他成果登记\",\"operate\":[]},{\"secondcode\":255,\"secondname\":\"技术标准登记\",\"operate\":[]}]},{\"firstcode\":7,\"firstname\":\"学术交流管理\",\"secondMod\":[{\"secondcode\":142,\"secondname\":\"学术交流登记\",\"operate\":[]}]},{\"firstcode\":8,\"firstname\":\"人才培养管理\",\"secondMod\":[{\"secondcode\":143,\"secondname\":\"人才培养\",\"operate\":[]}]}]");

            List<LabInfo> labInfoList = new GetMap("E:\\01_基本信息.xls").getLabName();
            List<TeacherBaseInfo> teacherName = new GetMap("E:\\03_人员状况.xls").getTeacherName();
            for (TeacherBaseInfo teacherBaseInfo1: teacherName) {
                for (LabInfo labInfo: labInfoList){
                    if (teacherBaseInfo1.getTeachername().equals(teacherBaseInfo.getTeachername())){
                        if (teacherBaseInfo1.getBranchoflab().equals(labInfo.getLabaddress())){
                            String labInfoName = labInfo.getLabname();
                            String departmentName = (labInfo.getRelieddept()).trim();

                            List<LabInfo> labInfo1 = labInfoMapper.findLabByName(labInfoName);
                            uuserRolesMap.setLabseqno(labInfo1.get(0).getLabseqno());
                            List<LabDepartment> labDepartments = labDepartmentMapper.findNewByName(departmentName);
                            uuserRolesMap.setDeptseqno(labDepartments.get(0).getDepartmentseqno());
                            uuserRolesMap.setCreatetime(new Date());
                            uuserRolesMapMapper.insertSelective(uuserRolesMap);
                            //若为管理员，则增加管理员权限
                            if (teacherBaseInfo1.getTeachername().equals(labInfo.getManager())){
                                uuserRolesMap.setRoleseqno((long) 10);
                                uuserRolesMap.setIsmanager("1");
                                uuserRolesMap.setModelitemrights("[{\"firstcode\":15,\"firstname\":\"科研统计管理\",\"secondMod\":[{\"secondcode\":150,\"secondname\":\"项目管理\",\"operate\":[{\"operatecode\":80,\"operatename\":\"编辑\"},{\"operatecode\":81,\"operatename\":\"审批通过\"},{\"operatecode\":82,\"operatename\":\"退回修改\"}]},{\"secondcode\":41,\"secondname\":\"论文管理\",\"operate\":[{\"operatecode\":83,\"operatename\":\"编辑\"},{\"operatecode\":84,\"operatename\":\"审批通过\"},{\"operatecode\":85,\"operatename\":\"退回修改\"}]},{\"secondcode\":42,\"secondname\":\"获奖管理\",\"operate\":[{\"operatecode\":86,\"operatename\":\"编辑\"},{\"operatecode\":87,\"operatename\":\"审批通过\"},{\"operatecode\":88,\"operatename\":\"退回修改\"}]},{\"secondcode\":164,\"secondname\":\"著作管理\",\"operate\":[{\"operatecode\":89,\"operatename\":\"编辑\"},{\"operatecode\":90,\"operatename\":\"审批通过\"},{\"operatecode\":91,\"operatename\":\"退回修改\"}]},{\"secondcode\":43,\"secondname\":\"专利管理\",\"operate\":[{\"operatecode\":92,\"operatename\":\"编辑\"},{\"operatecode\":93,\"operatename\":\"审批通过\"},{\"operatecode\":94,\"operatename\":\"退回修改\"}]},{\"secondcode\":251,\"secondname\":\"其他成果管理\",\"operate\":[{\"operatecode\":124,\"operatename\":\"编辑\"},{\"operatecode\":125,\"operatename\":\"审批通过\"},{\"operatecode\":126,\"operatename\":\"退回修改\"}]},{\"secondcode\":256,\"secondname\":\"技术标准管理\",\"operate\":[{\"operatecode\":127,\"operatename\":\"编辑\"},{\"operatecode\":128,\"operatename\":\"审批通过\"},{\"operatecode\":129,\"operatename\":\"退回修改\"}]},{\"secondcode\":44,\"secondname\":\"学术交流管理\",\"operate\":[{\"operatecode\":95,\"operatename\":\"编辑\"},{\"operatecode\":96,\"operatename\":\"审批通过\"},{\"operatecode\":97,\"operatename\":\"退回修改\"}]},{\"secondcode\":152,\"secondname\":\"人才培养管理\",\"operate\":[{\"operatecode\":98,\"operatename\":\"编辑\"},{\"operatecode\":99,\"operatename\":\"审批通过\"},{\"operatecode\":100,\"operatename\":\"退回修改\"}]}]},{\"firstcode\":232,\"firstname\":\"实验预约管理\",\"secondMod\":[{\"secondcode\":288,\"secondname\":\"共享设备\",\"operate\":[]},{\"secondcode\":233,\"secondname\":\"共享设置\",\"operate\":[]},{\"secondcode\":234,\"secondname\":\"预约审核\",\"operate\":[]},{\"secondcode\":316,\"secondname\":\"实验刷卡\",\"operate\":[]},{\"secondcode\":287,\"secondname\":\"实验操作\",\"operate\":[]},{\"secondcode\":235,\"secondname\":\"实验统计\",\"operate\":[]},{\"secondcode\":289,\"secondname\":\"运行状态\",\"operate\":[]},{\"secondcode\":336,\"secondname\":\"设备需求\",\"operate\":[]}]},{\"firstcode\":46,\"firstname\":\"创新载体管理\",\"secondMod\":[{\"secondcode\":47,\"secondname\":\"创新载体信息\",\"operate\":[{\"operatecode\":101,\"operatename\":\"编辑\"}]},{\"secondcode\":247,\"secondname\":\"机构人员信息\",\"operate\":[]},{\"secondcode\":222,\"secondname\":\"实验设备登记\",\"operate\":[{\"operatecode\":120,\"operatename\":\"增加设备\"},{\"operatecode\":121,\"operatename\":\"编辑\"},{\"operatecode\":122,\"operatename\":\"删除\"},{\"operatecode\":123,\"operatename\":\"增加设备运行收支\"}]},{\"secondcode\":57,\"secondname\":\"创新载体年度总结\",\"operate\":[]},{\"secondcode\":345,\"secondname\":\"绩效考核\",\"operate\":[]},{\"secondcode\":999,\"secondname\":\"大型仪器延迟上报\",\"operate\":[]}]},{\"firstcode\":51,\"firstname\":\"国家基础资源统计\",\"secondMod\":[{\"secondcode\":48,\"secondname\":\"基础资源登记\",\"operate\":[{\"operatecode\":102,\"operatename\":\"编辑\"},{\"operatecode\":103,\"operatename\":\"删除\"},{\"operatecode\":105,\"operatename\":\"查看\"},{\"operatecode\":106,\"operatename\":\"增加建设与经费\"},{\"operatecode\":107,\"operatename\":\"增加经费使用情况\"},{\"operatecode\":108,\"operatename\":\"选择代表性成果\"}]},{\"secondcode\":59,\"secondname\":\"国家基础资源统计\",\"operate\":[]}]},{\"firstcode\":62,\"firstname\":\"创新载体用户管理\",\"secondMod\":[{\"secondcode\":149,\"secondname\":\"用户信息\",\"operate\":[]},{\"secondcode\":101,\"secondname\":\"用户添加\",\"operate\":[]},{\"secondcode\":329,\"secondname\":\"导入用户\",\"operate\":[]}]}]");
                                uuserRolesMapMapper.insertSelective(uuserRolesMap);
                            }
                        }
                    }
                }
            }

        }
    }

    @Test
    //@Transactional
    public void creatTeacherAndUser() throws ParseException {
        int sum=0;
        int sum1=0;
        List<LabInfo> labInfoList = new Excel2Data("E:\\01_基本信息.xls").CreateLabInfoList();
        for (LabInfo labInfo: labInfoList){
            List<TeacherBaseInfo> newTeacherByName = teacherBaseInfoMapper.findTeacherByName(labInfo.getManager());
            if (newTeacherByName.size()==0){
                TeacherBaseInfo teacherBaseInfo = new TeacherBaseInfo();
                teacherBaseInfo.setTeachername(labInfo.getManager());
                teacherBaseInfo.setIsacademicboard("0");
                teacherBaseInfo.setIsbackbone("0");
                teacherBaseInfo.setIsoverseasreturnee("0");
                teacherBaseInfo.setIsresearcher("0");
                teacherBaseInfo.setIsteamcooperation("0");
                teacherBaseInfo.setIsbeacomeguide("0");
                teacherBaseInfo.setDeleteflag("0");
                teacherBaseInfo.setLoginpassword("96e79218965eb72c92a549dd5a330112");
                teacherBaseInfo.setTeacherlogonname(labInfo.getManagerphone());
                teacherBaseInfoMapper.insertAddKey(teacherBaseInfo);
                UuserRolesMap uuserRolesMap = new UuserRolesMap();
                uuserRolesMap.setUserseqno(teacherBaseInfo.getTeacherseqno());
                uuserRolesMap.setRoleseqno((long) 30);
                uuserRolesMap.setIsmanager("0");
                uuserRolesMap.setIsresearcher("1");
                uuserRolesMap.setModelitemrights("[{\"firstcode\":1,\"firstname\":\"项目管理\",\"secondMod\":[{\"secondcode\":141,\"secondname\":\"项目登记\",\"operate\":[]}]},{\"firstcode\":2,\"firstname\":\"成果管理\",\"secondMod\":[{\"secondcode\":3,\"secondname\":\"论文登记\",\"operate\":[]},{\"secondcode\":4,\"secondname\":\"获奖登记\",\"operate\":[]},{\"secondcode\":5,\"secondname\":\"著作登记\",\"operate\":[]},{\"secondcode\":6,\"secondname\":\"专利登记\",\"operate\":[]},{\"secondcode\":250,\"secondname\":\"其他成果登记\",\"operate\":[]},{\"secondcode\":255,\"secondname\":\"技术标准登记\",\"operate\":[]}]},{\"firstcode\":7,\"firstname\":\"学术交流管理\",\"secondMod\":[{\"secondcode\":142,\"secondname\":\"学术交流登记\",\"operate\":[]}]},{\"firstcode\":8,\"firstname\":\"人才培养管理\",\"secondMod\":[{\"secondcode\":143,\"secondname\":\"人才培养\",\"operate\":[]}]}]");
                List<LabInfo> labByName = labInfoMapper.findLabByName(labInfo.getLabname().trim());
                uuserRolesMap.setLabseqno(labByName.get(0).getLabseqno());
                uuserRolesMap.setDeptseqno(labByName.get(0).getDepartmentseqno());
                uuserRolesMap.setCreatetime(new Date());
                uuserRolesMapMapper.insertSelective(uuserRolesMap);
                sum++;
                //增加管理员权限
                uuserRolesMap.setRoleseqno((long) 10);
                uuserRolesMap.setIsmanager("1");
                uuserRolesMap.setModelitemrights("[{\"firstcode\":15,\"firstname\":\"科研统计管理\",\"secondMod\":[{\"secondcode\":150,\"secondname\":\"项目管理\",\"operate\":[{\"operatecode\":80,\"operatename\":\"编辑\"},{\"operatecode\":81,\"operatename\":\"审批通过\"},{\"operatecode\":82,\"operatename\":\"退回修改\"}]},{\"secondcode\":41,\"secondname\":\"论文管理\",\"operate\":[{\"operatecode\":83,\"operatename\":\"编辑\"},{\"operatecode\":84,\"operatename\":\"审批通过\"},{\"operatecode\":85,\"operatename\":\"退回修改\"}]},{\"secondcode\":42,\"secondname\":\"获奖管理\",\"operate\":[{\"operatecode\":86,\"operatename\":\"编辑\"},{\"operatecode\":87,\"operatename\":\"审批通过\"},{\"operatecode\":88,\"operatename\":\"退回修改\"}]},{\"secondcode\":164,\"secondname\":\"著作管理\",\"operate\":[{\"operatecode\":89,\"operatename\":\"编辑\"},{\"operatecode\":90,\"operatename\":\"审批通过\"},{\"operatecode\":91,\"operatename\":\"退回修改\"}]},{\"secondcode\":43,\"secondname\":\"专利管理\",\"operate\":[{\"operatecode\":92,\"operatename\":\"编辑\"},{\"operatecode\":93,\"operatename\":\"审批通过\"},{\"operatecode\":94,\"operatename\":\"退回修改\"}]},{\"secondcode\":251,\"secondname\":\"其他成果管理\",\"operate\":[{\"operatecode\":124,\"operatename\":\"编辑\"},{\"operatecode\":125,\"operatename\":\"审批通过\"},{\"operatecode\":126,\"operatename\":\"退回修改\"}]},{\"secondcode\":256,\"secondname\":\"技术标准管理\",\"operate\":[{\"operatecode\":127,\"operatename\":\"编辑\"},{\"operatecode\":128,\"operatename\":\"审批通过\"},{\"operatecode\":129,\"operatename\":\"退回修改\"}]},{\"secondcode\":44,\"secondname\":\"学术交流管理\",\"operate\":[{\"operatecode\":95,\"operatename\":\"编辑\"},{\"operatecode\":96,\"operatename\":\"审批通过\"},{\"operatecode\":97,\"operatename\":\"退回修改\"}]},{\"secondcode\":152,\"secondname\":\"人才培养管理\",\"operate\":[{\"operatecode\":98,\"operatename\":\"编辑\"},{\"operatecode\":99,\"operatename\":\"审批通过\"},{\"operatecode\":100,\"operatename\":\"退回修改\"}]}]},{\"firstcode\":232,\"firstname\":\"实验预约管理\",\"secondMod\":[{\"secondcode\":288,\"secondname\":\"共享设备\",\"operate\":[]},{\"secondcode\":233,\"secondname\":\"共享设置\",\"operate\":[]},{\"secondcode\":234,\"secondname\":\"预约审核\",\"operate\":[]},{\"secondcode\":316,\"secondname\":\"实验刷卡\",\"operate\":[]},{\"secondcode\":287,\"secondname\":\"实验操作\",\"operate\":[]},{\"secondcode\":235,\"secondname\":\"实验统计\",\"operate\":[]},{\"secondcode\":289,\"secondname\":\"运行状态\",\"operate\":[]},{\"secondcode\":336,\"secondname\":\"设备需求\",\"operate\":[]}]},{\"firstcode\":46,\"firstname\":\"创新载体管理\",\"secondMod\":[{\"secondcode\":47,\"secondname\":\"创新载体信息\",\"operate\":[{\"operatecode\":101,\"operatename\":\"编辑\"}]},{\"secondcode\":247,\"secondname\":\"机构人员信息\",\"operate\":[]},{\"secondcode\":222,\"secondname\":\"实验设备登记\",\"operate\":[{\"operatecode\":120,\"operatename\":\"增加设备\"},{\"operatecode\":121,\"operatename\":\"编辑\"},{\"operatecode\":122,\"operatename\":\"删除\"},{\"operatecode\":123,\"operatename\":\"增加设备运行收支\"}]},{\"secondcode\":57,\"secondname\":\"创新载体年度总结\",\"operate\":[]},{\"secondcode\":345,\"secondname\":\"绩效考核\",\"operate\":[]},{\"secondcode\":999,\"secondname\":\"大型仪器延迟上报\",\"operate\":[]}]},{\"firstcode\":51,\"firstname\":\"国家基础资源统计\",\"secondMod\":[{\"secondcode\":48,\"secondname\":\"基础资源登记\",\"operate\":[{\"operatecode\":102,\"operatename\":\"编辑\"},{\"operatecode\":103,\"operatename\":\"删除\"},{\"operatecode\":105,\"operatename\":\"查看\"},{\"operatecode\":106,\"operatename\":\"增加建设与经费\"},{\"operatecode\":107,\"operatename\":\"增加经费使用情况\"},{\"operatecode\":108,\"operatename\":\"选择代表性成果\"}]},{\"secondcode\":59,\"secondname\":\"国家基础资源统计\",\"operate\":[]}]},{\"firstcode\":62,\"firstname\":\"创新载体用户管理\",\"secondMod\":[{\"secondcode\":149,\"secondname\":\"用户信息\",\"operate\":[]},{\"secondcode\":101,\"secondname\":\"用户添加\",\"operate\":[]},{\"secondcode\":329,\"secondname\":\"导入用户\",\"operate\":[]}]}]");
                uuserRolesMapMapper.insertSelective(uuserRolesMap);
                sum1++;

            }
        }
        System.out.println(sum);
        System.out.println(sum1);
    }

}
