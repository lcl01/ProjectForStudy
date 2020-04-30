package com.coder520.POI.TeacherConferences.Utils;

import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.TeacherBaseInfo.dao.TeacherBaseInfoMapper;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import com.coder520.POI.TeacherConferencerelated.dao.TeacherConferencerelatedMapper;
import com.coder520.POI.TeacherConferencerelated.entity.TeacherConferencerelated;
import com.coder520.POI.TeacherConferences.dao.TeacherConferencesMapper;
import com.coder520.POI.TeacherConferences.entity.TeacherConferences;
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
public class ConferencesTest {

    @Autowired
    LabInfoMapper labInfoMapper;
    @Autowired
    TeacherBaseInfoMapper teacherBaseInfoMapper;
    @Autowired
    TeacherConferencesMapper teacherConferencesMapper;
    @Autowired
    TeacherConferencerelatedMapper teacherConferencerelatedMapper;



    @Test
    @Transactional
    public void creatThesis() throws ParseException {
        int insertSum=0;
        int errorSum=0;
        List<TeacherConferences> conferencesList = new Conferences2Date("E:\\12_学术会议活动.xls").createConferences();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherConferences conferences: conferencesList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (conferences.getLastmodifiedmanid().equals(entry.getKey())){
                    conferences.setLastmodifiedman(entry.getValue());
                }
            }
        }
        for (TeacherConferences conferences: conferencesList){
            List<TeacherConferences> thesisByName = teacherConferencesMapper.findByName(conferences.getConferencename());
            if (thesisByName.size()==0 ){
                List<LabInfo> labByName = labInfoMapper.findLabByName(conferences.getLastmodifiedman().trim());
                List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
                if (teacherByName.size()>0){
                    //List<LabInfo> labByName = labInfoMapper.findLabByManagerName(teacherByName.get(0).getTeachername());
                    conferences.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    conferences.setLastmodifiedmanid("");
                    conferences.setLastmodifiedman("");
                    conferences.setStatus("1");
                    conferences.setTempstate("0");
                    conferences.setIskcw("1");
                    conferences.setType1("参加学术会议");
                    teacherConferencesMapper.insertAddKey(conferences);
                    insertSum++;
                    //System.out.println(thesis.getThesisseqno());
                    TeacherConferencerelated teacherConferencerelated = new TeacherConferencerelated();
                    teacherConferencerelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    teacherConferencerelated.setConferenceseqno(conferences.getConferenceseqno());
                    teacherConferencerelated.setLabseqno(labByName.get(0).getLabseqno());
                    teacherConferencerelatedMapper.insert(teacherConferencerelated);
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
    //@Transactional
    public void test() throws ParseException {
        List<TeacherConferences> conferencesList = new Conferences2Date("E:\\12_学术会议活动.xls").createConferences();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherConferences conferences: conferencesList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (conferences.getLastmodifiedmanid().equals(entry.getKey())){
                    conferences.setLastmodifiedman(entry.getValue());
                }
            }
        }
        //System.out.println(projectList.get(0));
        TeacherConferences conferences = conferencesList.get(0);
        List<TeacherConferences> thesisByName = teacherConferencesMapper.findByName(conferences.getConferencename());
        if (thesisByName.size()==0 ){
            List<LabInfo> labByName = labInfoMapper.findLabByName(conferences.getLastmodifiedman());
            List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
            if (teacherByName.size()>0){
                //List<LabInfo> labByName = labInfoMapper.findLabByManagerName(teacherByName.get(0).getTeachername());
                conferences.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                conferences.setLastmodifiedmanid("");
                conferences.setLastmodifiedman("");
                conferences.setStatus("1");
                conferences.setTempstate("0");
                conferences.setIskcw("1");
                conferences.setType1("参加学术会议");
                teacherConferencesMapper.insertAddKey(conferences);
                //System.out.println(thesis.getThesisseqno());
                TeacherConferencerelated teacherConferencerelated = new TeacherConferencerelated();
                teacherConferencerelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherConferencerelated.setConferenceseqno(conferences.getConferenceseqno());
                teacherConferencerelated.setLabseqno(labByName.get(0).getLabseqno());
                teacherConferencerelatedMapper.insert(teacherConferencerelated);

            }
        }

    }


}
