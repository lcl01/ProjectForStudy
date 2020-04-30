package com.coder520.POI.TeacherBaseInfo.Utils;

import com.coder520.POI.TeacherBaseInfo.dao.TeacherBaseInfoMapper;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by yang on 2017/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cfg.xml")
public class TeacherTest {
    @Autowired
    TeacherBaseInfoMapper teacherBaseInfoMapper;

    @Test
    public void test() throws ParseException {
        List<TeacherBaseInfo> teacherBaseInfoList = new Teacher2Date("E:\\03_人员状况.xls").CreateTeacherBaseInfo();
        TeacherBaseInfo teacherBaseInfo = teacherBaseInfoList.get(0);
        List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(teacherBaseInfo.getTeachername());
        if (teacherByName.size()==0){
            if (teacherBaseInfo.getIsacademicboard() == null)
                teacherBaseInfo.setIsacademicboard("0");
            if (teacherBaseInfo.getIsbackbone() == null)
                teacherBaseInfo.setIsbackbone("0");
            if (teacherBaseInfo.getIsoverseasreturnee() == null)
                teacherBaseInfo.setIsoverseasreturnee("0");
            if (teacherBaseInfo.getIsresearcher() == null)
                teacherBaseInfo.setIsresearcher("0");
            if (teacherBaseInfo.getIsteamcooperation() == null)
                teacherBaseInfo.setIsteamcooperation("0");
            if(teacherBaseInfo.getIsbeacomeguide()==null){
                teacherBaseInfo.setIsbeacomeguide("0");
            }
            if(teacherBaseInfo.getBirthday()!=null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy", Locale.CHINA);//提取年份，计算年龄
                String[] birthday = teacherBaseInfo.getBirthday().split("-");
                int ages = Integer.valueOf(sdf.format(new Date())) - Integer.valueOf(birthday[0]);
                teacherBaseInfo.setAge(String.valueOf(ages));
            }
            teacherBaseInfoMapper.insertAddKey(teacherBaseInfo);
            //teacherBaseInfoMapper.insert(teacherBaseInfo);
        }
    }

    @Test
    public void creatTeacher() throws ParseException {
        List<TeacherBaseInfo> teacherBaseInfoList = new Teacher2Date("E:\\03_人员状况.xls").CreateTeacherBaseInfo();
        int insertNum = 0;
        for (TeacherBaseInfo teacherBaseInfo: teacherBaseInfoList){
            List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(teacherBaseInfo.getTeachername());
            if (teacherByName.size()==0){
                if (teacherBaseInfo.getIsacademicboard() == null)
                    teacherBaseInfo.setIsacademicboard("0");
                if (teacherBaseInfo.getIsbackbone() == null)
                    teacherBaseInfo.setIsbackbone("0");
                if (teacherBaseInfo.getIsoverseasreturnee() == null)
                    teacherBaseInfo.setIsoverseasreturnee("0");
                if (teacherBaseInfo.getIsresearcher() == null)
                    teacherBaseInfo.setIsresearcher("0");
                if (teacherBaseInfo.getIsteamcooperation() == null)
                    teacherBaseInfo.setIsteamcooperation("0");
                if(teacherBaseInfo.getIsbeacomeguide()==null){
                    teacherBaseInfo.setIsbeacomeguide("0");
                }
                if(teacherBaseInfo.getBirthday()!=null){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy", Locale.CHINA);//提取年份，计算年龄
                    String[] birthday = teacherBaseInfo.getBirthday().split("-");
                    int ages = Integer.valueOf(sdf.format(new Date())) - Integer.valueOf(birthday[0]);
                    teacherBaseInfo.setAge(String.valueOf(ages));
                }
                teacherBaseInfoMapper.insertAddKey(teacherBaseInfo);
                insertNum++;
            }
        }
        System.out.println(insertNum);

    }
}
