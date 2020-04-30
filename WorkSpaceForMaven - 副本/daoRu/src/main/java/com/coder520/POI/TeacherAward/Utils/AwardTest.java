package com.coder520.POI.TeacherAward.Utils;

import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.TeacherAward.dao.TeacherAwardMapper;
import com.coder520.POI.TeacherAward.entity.TeacherAward;
import com.coder520.POI.TeacherAwardrelated.dao.TeacherAwardrelatedMapper;
import com.coder520.POI.TeacherAwardrelated.entity.TeacherAwardrelated;
import com.coder520.POI.TeacherBaseInfo.dao.TeacherBaseInfoMapper;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;

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
public class AwardTest {

    @Autowired
    LabInfoMapper labInfoMapper;
    @Autowired
    TeacherBaseInfoMapper teacherBaseInfoMapper;
    @Autowired
    TeacherAwardMapper awardMapper;
    @Autowired
    TeacherAwardrelatedMapper awardrelatedMapper;




    @Test
    //@Transactional
    public void creatLiterature() throws ParseException {
        int insertSum=0;
        int errorSum=0;
        List<TeacherAward> teacherAwardList = new Award2Date("E:\\11_所获奖项.xls").createTeacherAward();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherAward teacherAward: teacherAwardList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (teacherAward.getLastmodifiedtime().equals(entry.getKey())){
                    teacherAward.setLastmodifiedman(entry.getValue());
                }
            }
        }
        for (TeacherAward teacherAward: teacherAwardList){
            List<TeacherAward> byName = awardMapper.findByName(teacherAward.getAwardname());
            if (byName.size()==0 ){
                List<LabInfo> labByName = labInfoMapper.findLabByName(teacherAward.getLastmodifiedman().trim());
                List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
                if (teacherByName.size()>0){
                    teacherAward.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    teacherAward.setLastmodifiedtime("");
                    teacherAward.setLastmodifiedman("");
                    teacherAward.setTempstate("0");
                    teacherAward.setIskcw("1");
                    teacherAward.setIssecrect("1");
                    teacherAward.setStatus("1");
                    awardMapper.insertAddKey(teacherAward);
                    TeacherAwardrelated teacherAwardrelated = new TeacherAwardrelated();
                    teacherAwardrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    teacherAwardrelated.setAwardseqno(teacherAward.getAwardseqno());
                    teacherAwardrelated.setLabseqno(labByName.get(0).getLabseqno());
                    awardrelatedMapper.insert(teacherAwardrelated);
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
        List<TeacherAward> teacherAwardList = new Award2Date("E:\\11_所获奖项.xls").createTeacherAward();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherAward teacherAward: teacherAwardList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (teacherAward.getLastmodifiedtime().equals(entry.getKey())){
                    teacherAward.setLastmodifiedman(entry.getValue());
                }
            }
        }
        //System.out.println(projectList.get(0));
       TeacherAward teacherAward = teacherAwardList.get(0);
        List<TeacherAward> byName = awardMapper.findByName(teacherAward.getAwardname());
        if (byName.size()==0 ){
            List<LabInfo> labByName = labInfoMapper.findLabByName(teacherAward.getLastmodifiedman().trim());
            List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
            if (teacherByName.size()>0){
                teacherAward.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherAward.setLastmodifiedtime("");
                teacherAward.setLastmodifiedman("");
                teacherAward.setTempstate("0");
                teacherAward.setIskcw("1");
                teacherAward.setIssecrect("1");
                teacherAward.setStatus("1");
                awardMapper.insertAddKey(teacherAward);
                TeacherAwardrelated teacherAwardrelated = new TeacherAwardrelated();
                teacherAwardrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherAwardrelated.setAwardseqno(teacherAward.getAwardseqno());
                teacherAwardrelated.setLabseqno(labByName.get(0).getLabseqno());
                awardrelatedMapper.insert(teacherAwardrelated);

            }
        }

    }


}
