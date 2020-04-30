package com.coder520.POI.TeacherProject.Utils;

import com.coder520.POI.DictDateInput.dao.DictDateInputMapper;
import com.coder520.POI.DictDateInput.entity.DictDateInput;
import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.TeacherBaseInfo.Utils.Teacher2Date;
import com.coder520.POI.TeacherBaseInfo.dao.TeacherBaseInfoMapper;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import com.coder520.POI.TeacherProject.dao.TeacherProjectMapper;
import com.coder520.POI.TeacherProject.entity.TeacherProject;
import com.coder520.POI.TeacherProjectrelated.dao.TeacherProjectrelatedMapper;
import com.coder520.POI.TeacherProjectrelated.entity.TeacherProjectrelated;
import com.coder520.POI.TeacherThesis.Utils.Thesisct2Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by yang on 2017/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cfg.xml")
public class ProjectTest {
    @Autowired
    LabInfoMapper labInfoMapper;
    @Autowired
    TeacherProjectMapper teacherProjectMapper;
    @Autowired
    TeacherBaseInfoMapper teacherBaseInfoMapper;
    @Autowired
    TeacherProjectrelatedMapper teacherProjectrelatedMapper;


    @Test
    @Transactional
    public void creatProject() throws ParseException {
        int insertSum=0;
        int errorSum=0;
        List<TeacherProject> projectList = new Project2Date("E:\\06_承载项目new.xls").CreateTeacherBaseInfo();
        Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherProject teacherProject: projectList){
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
               if (teacherProject.getLastmodifedmanid().equals(entry.getKey())){
                   teacherProject.setLastmodifedman(entry.getValue());
               }
            }
        }
        for (TeacherProject teacherProject: projectList){
                List<TeacherProject> byName = teacherProjectMapper.findByName(teacherProject.getProjectname());
                if (byName.size()==0 ){
                    List<LabInfo> labByName = labInfoMapper.findLabByName(teacherProject.getLastmodifedman().trim());
                    List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
                    if (teacherByName.size()>0){
                        teacherProject.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                        teacherProject.setLastmodifedmanid("");
                        teacherProject.setLastmodifedman("");
                        teacherProject.setStatus("1");
                        teacherProject.setTempstate("0");
                        teacherProject.setIskcw("1");
                        teacherProject.setIssecrect("1");
                        if (teacherProject.getProjectcategory() !=null){
                            teacherProject.setProjectclass("纵向");
                        }else {
                            teacherProject.setProjectclass("企业合作");
                            teacherProject.setProjectcategory("-1");
                        }
                        teacherProjectMapper.insertAddKey(teacherProject);
                        TeacherProjectrelated teacherProjectrelated = new TeacherProjectrelated();
                        teacherProjectrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                        teacherProjectrelated.setProjectseqno(teacherProject.getProjectseqno());
                        teacherProjectrelated.setLabseqno(labByName.get(0).getLabseqno());
                        teacherProjectrelatedMapper.insert(teacherProjectrelated);
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
        List<TeacherProject> projectList = new Project2Date("E:\\06_承载项目new.xls").CreateTeacherBaseInfo();
        Map<String, String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getlabName();
        for (TeacherProject teacherProject : projectList) {
            for (Map.Entry<String, String> entry : idAndName.entrySet()) {
                if (teacherProject.getLastmodifedmanid().equals(entry.getKey())) {
                    teacherProject.setLastmodifedman(entry.getValue());
                }
            }
        }
        //System.out.println(projectList.get(0));
        TeacherProject teacherProject = projectList.get(0);
        List<TeacherProject> byName = teacherProjectMapper.findByName(teacherProject.getProjectname());
        if (byName.size() == 0) {
            List<LabInfo> labByName = labInfoMapper.findLabByName(teacherProject.getLastmodifedman());
            List<TeacherBaseInfo> teacherByName = teacherBaseInfoMapper.findTeacherByName(labByName.get(0).getManager());
            if (teacherByName.size() > 0) {
                teacherProject.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherProject.setLastmodifedmanid("");
                teacherProject.setLastmodifedman("");
                teacherProject.setStatus("1");
                teacherProject.setTempstate("0");
                teacherProject.setIskcw("1");
                teacherProject.setIssecrect("1");
                if (teacherProject.getProjectcategory() != null) {
                    teacherProject.setProjectclass("纵向");
                } else {
                    teacherProject.setProjectclass("企业合作");
                    teacherProject.setProjectcategory("-1");
                }
                teacherProjectMapper.insertAddKey(teacherProject);
                TeacherProjectrelated teacherProjectrelated = new TeacherProjectrelated();
                teacherProjectrelated.setTeacherseqno(teacherByName.get(0).getTeacherseqno());
                teacherProjectrelated.setProjectseqno(teacherProject.getProjectseqno());
                teacherProjectrelated.setLabseqno(labByName.get(0).getLabseqno());
                teacherProjectrelatedMapper.insert(teacherProjectrelated);
            }

        }
    }

}
