package com.coder520.POI.TeacherStandard.Utils;

import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.TeacherBaseInfo.dao.TeacherBaseInfoMapper;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import com.coder520.POI.TeacherStandard.dao.TeacherStandardMapper;
import com.coder520.POI.TeacherStandard.entity.TeacherStandard;
import com.coder520.POI.TeacherPatentrelated.dao.TeacherPatentrelatedMapper;
import com.coder520.POI.TeacherPatentrelated.entity.TeacherPatentrelated;
import com.coder520.POI.TeacherStandard.entity.TeacherStandard;
import com.coder520.POI.TeacherStandardrelated.dao.TeacherStandardrelatedMapper;
import com.coder520.POI.TeacherStandardrelated.entity.TeacherStandardrelated;
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
public class StandardTest {

    @Autowired
    LabInfoMapper labInfoMapper;
    @Autowired
    TeacherBaseInfoMapper teacherBaseInfoMapper;
    @Autowired
    TeacherStandardMapper teacherStandardMapper;
    @Autowired
    TeacherStandardrelatedMapper teacherStandardrelatedMapper;




    @Test
    //@Transactional
    public void creatLiterature() throws ParseException {
        int insertSum=0;
        int errorSum=0;
        List<TeacherStandard> standardList = new Standard2Date("E:\\10_标准.xls").createTeacherStandard();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherStandard teacherStandard: standardList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (teacherStandard.getStandarduuid().equals(entry.getKey())){
                    teacherStandard.setAccessories(entry.getValue());
                }
            }
        }
        for (TeacherStandard teacherStandard: standardList){
            List<TeacherStandard> byName = teacherStandardMapper.findByName(teacherStandard.getStandardname());
            if (byName.size()==0 ){
                List<LabInfo> labByName = labInfoMapper.findLabByName(teacherStandard.getAccessories().trim());
                List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(teacherStandard.getLastmodifiedman());
                if (teacherByName.size()>0) {
                    teacherStandard.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    teacherStandard.setStandarduuid("");
                    teacherStandard.setLastmodifiedman("");
                    teacherStandard.setAccessories("");
                    teacherStandard.setTempstate("0");
                    teacherStandard.setIskcw("1");
                    teacherStandard.setIstrans("0");
                    teacherStandard.setIssecrect("1");
                    teacherStandard.setApprovestatus("1");
                    teacherStandard.setIsrelease("1");
                    teacherStandardMapper.insertAddKey(teacherStandard);
                    TeacherStandardrelated teacherStandardrelated = new TeacherStandardrelated();
                    teacherStandardrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                    teacherStandardrelated.setStandardseqno(teacherStandard.getStandardseqno());
                    teacherStandardrelated.setLabseqno(labByName.get(0).getLabseqno());
                    teacherStandardrelatedMapper.insert(teacherStandardrelated);
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
    @Transactional
    public void test() throws ParseException {
        List<TeacherStandard> standardList = new Standard2Date("E:\\10_标准.xls").createTeacherStandard();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherStandard teacherStandard: standardList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (teacherStandard.getStandarduuid().equals(entry.getKey())){
                    teacherStandard.setAccessories(entry.getValue());
                }
            }
        }
        //System.out.println(projectList.get(0));
       TeacherStandard teacherStandard = standardList.get(0);
        List<TeacherStandard> byName = teacherStandardMapper.findByName(teacherStandard.getStandardname());
        if (byName.size()==0 ){
            List<LabInfo> labByName = labInfoMapper.findLabByName(teacherStandard.getAccessories());
            List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(teacherStandard.getLastmodifiedman());
            if (teacherByName.size()>0){
                teacherStandard.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherStandard.setStandarduuid("");
                teacherStandard.setLastmodifiedman("");
                teacherStandard.setAccessories("");
                teacherStandard.setTempstate("0");
                teacherStandard.setIskcw("1");
                teacherStandard.setIstrans("0");
                teacherStandard.setIssecrect("1");
                teacherStandard.setApprovestatus("1");
                teacherStandard.setIsrelease("1");
                teacherStandardMapper.insertAddKey(teacherStandard);
                TeacherStandardrelated teacherStandardrelated = new TeacherStandardrelated();
                teacherStandardrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherStandardrelated.setStandardseqno(teacherStandard.getStandardseqno());
                teacherStandardrelated.setLabseqno(labByName.get(0).getLabseqno());
                teacherStandardrelatedMapper.insert(teacherStandardrelated);

            }
        }

    }


}
