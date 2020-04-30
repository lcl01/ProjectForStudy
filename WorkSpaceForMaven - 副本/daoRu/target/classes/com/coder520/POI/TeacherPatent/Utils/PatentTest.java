package com.coder520.POI.TeacherPatent.Utils;

import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.TeacherBaseInfo.dao.TeacherBaseInfoMapper;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import com.coder520.POI.TeacherPatent.dao.TeacherPatentMapper;
import com.coder520.POI.TeacherPatent.entity.TeacherPatent;
import com.coder520.POI.TeacherLiteraturerelated.dao.TeacherLiteraturerelatedMapper;
import com.coder520.POI.TeacherLiteraturerelated.entity.TeacherLiteraturerelated;
import com.coder520.POI.TeacherPatent.entity.TeacherPatent;
import com.coder520.POI.TeacherPatentrelated.dao.TeacherPatentrelatedMapper;
import com.coder520.POI.TeacherPatentrelated.entity.TeacherPatentrelated;
import com.coder520.POI.TeacherProject.Utils.Project2Date;
import com.coder520.POI.TeacherThesis.Utils.Thesisct2Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2017/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cfg.xml")
public class PatentTest {

    @Autowired
    LabInfoMapper labInfoMapper;
    @Autowired
    TeacherBaseInfoMapper teacherBaseInfoMapper;
    @Autowired
    TeacherPatentMapper teacherPatentMapper;
    @Autowired
    TeacherPatentrelatedMapper teacherPatentrelatedMapper;




    @Test
    //@Transactional
    public void creatLiterature() throws ParseException {
        int insertSum=0;
        int errorSum=0;
        List<TeacherPatent> patentList = new Patent2Date("E:\\09_专利.xls").CreateTeacherLiterature();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherPatent teacherPatent: patentList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (teacherPatent.getLastmodifiedmanid().equals(entry.getKey())){
                    teacherPatent.setLastmodifiedman(entry.getValue());
                }
            }
        }
        for (TeacherPatent teacherPatent: patentList){
            List<TeacherPatent> byName = teacherPatentMapper.findByName(teacherPatent.getPatentname());
            if (byName.size()==0 ){
                List<LabInfo> labByName = labInfoMapper.findLabByName(teacherPatent.getLastmodifiedman().trim());
                List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
                if (teacherByName.size()>0){
                    teacherPatent.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    teacherPatent.setLastmodifiedmanid("");
                    teacherPatent.setLastmodifiedman("");
                    teacherPatent.setTempstate("0");
                    teacherPatent.setIskcw("1");
                    teacherPatent.setIstrans("0");
                    teacherPatent.setIssecrect("1");
                    teacherPatent.setStatus("1");
                    teacherPatentMapper.insertAddKey(teacherPatent);
                    TeacherPatentrelated teacherPatentrelated = new TeacherPatentrelated();
                    teacherPatentrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    teacherPatentrelated.setPatentseqno(teacherPatent.getPatentseqno());
                    teacherPatentrelated.setLabseqno(labByName.get(0).getLabseqno());
                    teacherPatentrelatedMapper.insert(teacherPatentrelated);
                    insertSum++;
                }else {
                    errorSum++;
                }
            }
        }
        System.out.println(insertSum);
        System.out.println(errorSum);
    }

    @Test
    //@Transactional
    public void test() throws ParseException {
        List<TeacherPatent> patentList = new Patent2Date("E:\\09_专利.xls").CreateTeacherLiterature();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherPatent teacherPatent: patentList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (teacherPatent.getLastmodifiedmanid().equals(entry.getKey())){
                    teacherPatent.setLastmodifiedman(entry.getValue());
                }
            }
        }
        //System.out.println(projectList.get(0));
       TeacherPatent teacherPatent = patentList.get(0);
        List<TeacherPatent> byName = teacherPatentMapper.findByName(teacherPatent.getPatentname());
        if (byName.size()==0 ){
            List<LabInfo> labByName = labInfoMapper.findLabByName(teacherPatent.getLastmodifiedman());
            List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
            if (teacherByName.size()>0){
                teacherPatent.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherPatent.setLastmodifiedmanid("");
                teacherPatent.setLastmodifiedman("");
                teacherPatent.setTempstate("0");
                teacherPatent.setIskcw("1");
                teacherPatent.setIstrans("0");
                teacherPatent.setIssecrect("1");
                teacherPatent.setStatus("1");
                teacherPatentMapper.insertAddKey(teacherPatent);
                TeacherPatentrelated teacherPatentrelated = new TeacherPatentrelated();
                teacherPatentrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherPatentrelated.setPatentseqno(teacherPatent.getPatentseqno());
                teacherPatentrelated.setLabseqno(labByName.get(0).getLabseqno());
                teacherPatentrelatedMapper.insert(teacherPatentrelated);

            }
        }

    }


}
