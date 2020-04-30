package com.coder520.POI.TeacherLiterature.Utils;

import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.TeacherBaseInfo.dao.TeacherBaseInfoMapper;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import com.coder520.POI.TeacherLiterature.dao.TeacherLiteratureMapper;
import com.coder520.POI.TeacherLiterature.entity.TeacherLiterature;
import com.coder520.POI.TeacherLiteraturerelated.dao.TeacherLiteraturerelatedMapper;
import com.coder520.POI.TeacherLiteraturerelated.entity.TeacherLiteraturerelated;
import com.coder520.POI.TeacherProject.Utils.Project2Date;
import com.coder520.POI.TeacherProject.dao.TeacherProjectMapper;
import com.coder520.POI.TeacherThesis.Utils.Thesisct2Date;
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
public class LiteratureTest {

    @Autowired
    LabInfoMapper labInfoMapper;
    @Autowired
    TeacherBaseInfoMapper teacherBaseInfoMapper;
    @Autowired
    TeacherLiteratureMapper teacherLiteratureMapper;
    @Autowired
    TeacherLiteraturerelatedMapper teacherLiteraturerelatedMapper;




    @Test
    //@Transactional
    public void creatLiterature() throws ParseException {
        int insertSum=0;
        int errorSum=0;
        List<TeacherLiterature> literatureList = new Literature2Date("E:\\08_专著.xls").CreateTeacherLiterature();
        Map<String,String> idAndName = new Project2Date("E:\\01_基本信息.xls").getTeacherName();
        for (TeacherLiterature literature: literatureList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (literature.getLiteratureuuid().equals(entry.getKey())){
                    literature.setOtherauthoruuid(entry.getValue());
                }
            }
        }
        for (TeacherLiterature literature: literatureList){
            List<TeacherLiterature> byName = teacherLiteratureMapper.findByName(literature.getLiteraturename());
            if (byName.size()==0 ){
                List<LabInfo> labByName = labInfoMapper.findLabByManagerName(literature.getOtherauthoruuid());
                List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
                if (teacherByName.size()>0){
                    literature.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    literature.setOtherauthoruuid("");
                    literature.setTempstate("0");
                    literature.setIskcw("1");
                    literature.setStatisticstype("1");
                    literature.setIssecrect("1");
                    literature.setStatus("1");
                    teacherLiteratureMapper.insertAddKey(literature);
                    TeacherLiteraturerelated teacherLiteraturerelated = new TeacherLiteraturerelated();
                    teacherLiteraturerelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    teacherLiteraturerelated.setLiteratureseqno(literature.getLiteratureseqno());
                    teacherLiteraturerelated.setLabseqno(labByName.get(0).getLabseqno());
                    teacherLiteraturerelatedMapper.insert(teacherLiteraturerelated);
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
        List<TeacherLiterature> literatureList = new Literature2Date("E:\\08_专著.xls").CreateTeacherLiterature();
        Map<String,String> idAndName = new Project2Date("E:\\01_基本信息.xls").getTeacherName();
        for (TeacherLiterature literature: literatureList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (literature.getLiteratureuuid().equals(entry.getKey())){
                    literature.setOtherauthoruuid(entry.getValue());
                }
            }
        }
        //System.out.println(projectList.get(0));
       TeacherLiterature literature = literatureList.get(0);
        List<TeacherLiterature> byName = teacherLiteratureMapper.findByName(literature.getLiteraturename());
        if (byName.size()==0 ){
            List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(literature.getOtherauthoruuid());
            List<LabInfo> labByName = labInfoMapper.findLabByManagerName(teacherByName.get(0).getTeachername());
            if (teacherByName.size()>0){
                literature.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                literature.setOtherauthoruuid("");
                literature.setTempstate("0");
                literature.setIskcw("1");
                literature.setStatisticstype("1");
                literature.setIssecrect("1");
                literature.setStatus("1");
                teacherLiteratureMapper.insertAddKey(literature);
                TeacherLiteraturerelated teacherLiteraturerelated = new TeacherLiteraturerelated();
                teacherLiteraturerelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherLiteraturerelated.setLiteratureseqno(literature.getLiteratureseqno());
                teacherLiteraturerelated.setLabseqno(labByName.get(0).getLabseqno());
                teacherLiteraturerelatedMapper.insert(teacherLiteraturerelated);
                //TeacherThesisrrelated teacherThesisrrelated = new TeacherThesisrrelated();
                //teacherThesisrrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                //teacherThesisrrelated.setThesisseqno(thesis.getThesisseqno());
                //teacherThesisrrelated.setLabseqno(labByName.get(0).getLabseqno());
                //teacherThesisrrelatedMapper.insert(teacherThesisrrelated);

            }
        }

    }


}
