package com.coder520.POI.TeacherThesis.Utils;

import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.TeacherBaseInfo.dao.TeacherBaseInfoMapper;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import com.coder520.POI.TeacherProject.Utils.Project2Date;
import com.coder520.POI.TeacherProject.dao.TeacherProjectMapper;
import com.coder520.POI.TeacherProject.entity.TeacherProject;
import com.coder520.POI.TeacherThesis.dao.TeacherThesisMapper;
import com.coder520.POI.TeacherThesis.entity.TeacherThesis;
import com.coder520.POI.TeacherThesisrrelated.dao.TeacherThesisrrelatedMapper;
import com.coder520.POI.TeacherThesisrrelated.entity.TeacherThesisrrelated;
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
public class ThesisTest {

    @Autowired
    LabInfoMapper labInfoMapper;
    @Autowired
    TeacherProjectMapper teacherProjectMapper;
    @Autowired
    TeacherBaseInfoMapper teacherBaseInfoMapper;
    @Autowired
    TeacherThesisMapper teacherThesisMapper;
    @Autowired
    TeacherThesisrrelatedMapper teacherThesisrrelatedMapper;



    @Test
    //@Transactional
    public void creatThesis() throws ParseException {
        int insertSum=0;
        int errorSum=0;
        List<TeacherThesis> thesisList = new Thesisct2Date("E:\\07_论文.xls").CreateThesis();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherThesis thesis: thesisList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (thesis.getThesisuuid().equals(entry.getKey())){
                    thesis.setOtherauthoruuid(entry.getValue());
                }
            }
        }
        for (TeacherThesis thesis: thesisList){
            List<TeacherThesis> thesisByName = teacherThesisMapper.findByName(thesis.getThesstname());
            if (thesisByName.size()==0 ){
                List<LabInfo> labByName = labInfoMapper.findLabByName(thesis.getOtherauthoruuid());
                List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
                if (teacherByName.size()>0){
                    //List<LabInfo> labByName = labInfoMapper.findLabByManagerName(teacherByName.get(0).getTeachername());
                    thesis.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    thesis.setOtherauthoruuid("");
                    thesis.setStatus("1");
                    thesis.setTempstate("0");
                    thesis.setIskcw("1");
                    thesis.setPublicationstatus("1");
                    thesis.setIssecrect("1");
                    teacherThesisMapper.insertAddKey(thesis);
                    insertSum++;
                    //System.out.println(thesis.getThesisseqno());
                    TeacherThesisrrelated teacherThesisrrelated = new TeacherThesisrrelated();
                    teacherThesisrrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    teacherThesisrrelated.setThesisseqno(thesis.getThesisseqno());
                    teacherThesisrrelated.setLabseqno(labByName.get(0).getLabseqno());
                    teacherThesisrrelatedMapper.insert(teacherThesisrrelated);
                }else {
                    errorSum++;
                    //System.out.println(labByName.get(0).toString());
                }
            }
        }
        System.out.println(insertSum);
        System.out.println(errorSum);



    }

    @Test
    @Transactional
    public void test() throws ParseException {
        List<TeacherThesis> thesisList = new Thesisct2Date("E:\\07_论文.xls").CreateThesis();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherThesis thesis: thesisList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (thesis.getThesisuuid().equals(entry.getKey())){
                    thesis.setOtherauthoruuid(entry.getValue());
                }
            }
        }
        //System.out.println(projectList.get(0));
        TeacherThesis thesis = thesisList.get(0);
        List<TeacherThesis> thesisByName = teacherThesisMapper.findByName(thesis.getThesstname());
        if (thesisByName.size()==0 ){
            List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(thesis.getOtherauthoruuid());
            List<LabInfo> labByName = labInfoMapper.findLabByManagerName(teacherByName.get(0).getTeachername());
            if (teacherByName.size()>0){
                thesis.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                thesis.setOtherauthoruuid("");
                thesis.setTempstate("0");
                thesis.setIskcw("1");
                thesis.setPublicationstatus("1");
                thesis.setIssecrect("1");
                teacherThesisMapper.insertAddKey(thesis);
                //System.out.println(thesis.getThesisseqno());
                TeacherThesisrrelated teacherThesisrrelated = new TeacherThesisrrelated();
                teacherThesisrrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherThesisrrelated.setThesisseqno(thesis.getThesisseqno());
                teacherThesisrrelated.setLabseqno(labByName.get(0).getLabseqno());
                teacherThesisrrelatedMapper.insert(teacherThesisrrelated);

            }
        }

    }


}
