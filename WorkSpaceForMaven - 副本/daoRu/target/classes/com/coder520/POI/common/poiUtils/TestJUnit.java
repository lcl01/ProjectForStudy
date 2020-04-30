package com.coder520.POI.common.poiUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.coder520.POI.LabDepartment.dao.LabDepartmentMapper;
import com.coder520.POI.LabDepartment.entity.LabDepartment;
import com.coder520.POI.LabEquipment.dao.LabEquipmentMapper;
import com.coder520.POI.LabEquipment.entity.LabEquipment;
import com.coder520.POI.LabEquipmentList.dao.LabEquipmentListMapper;
import com.coder520.POI.LabInfo.dao.LabInfoMapper;
import com.coder520.POI.LabInfo.entity.LabInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.coder520.POI.user.dao.UserMapper;
import com.coder520.POI.user.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-cfg.xml")
public class TestJUnit {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private LabInfoMapper labInfoMapper;
	@Autowired
	private LabDepartmentMapper labDepartmentMapper;
	@Autowired
	private LabEquipmentMapper labEquipmentMapper;
	@Autowired
	private LabEquipmentListMapper labEquipmentListMapper;

	@Test
	  public void f1(){
//		文件路径
		String filePath="F:\\r.xls";
//		第一行表格标题
		String title="用户统计表";
//		表头--根据数据表设置
		String[] titles={"id","用户名","注册日期","性别","地址"};
//		sql语句
		List<User> user=userMapper.findAllUser();
		new Data2Excel(user, filePath, title,titles);
	}

	@Test
	public void f2() throws FileNotFoundException, IOException{
		//List<Integer> userIdList = userMapper.getUserId();
		String filePath="E:\\User.xls";
		Excel2Data excel2Data=new Excel2Data(filePath);
		List<User> users=excel2Data.CreateUserList();
		for(User user:users) {
			User user1 = null;
			user1 = userMapper.selectByPrimaryKey(user.getId());
			if (user1==null){
				userMapper.insertSelective(user);
			}else {
				userMapper.updateByPrimaryKey(user);
			}
			//System.out.println(user.getId());
			//if (userIdList.contains(user.getId())){
			//	userMapper.updateByPrimaryKey(user);
			//}else {
			//	userMapper.insert(user);
			//}

		}
	}
	@Test
	//@Transactional
	public void creatLabInfo() throws FileNotFoundException, IOException, ParseException {
		String filePath="E:\\01_基本信息.xls";
		Excel2Data excel2Data=new Excel2Data(filePath);
		List<LabInfo> labInfoList = excel2Data.CreateLabInfoList();
		int sum =0;
		for (LabInfo labInfo: labInfoList) {
				if (labInfo.getRelieddept()!=null){
                    LabDepartment labDepartment =null;
                    String departmentName = (String) labInfo.getRelieddept();
                    System.out.println(departmentName);
                    labDepartment = labDepartmentMapper.selectByDepartmentName(departmentName);
                    //根据依托单位名判断依托单位是否存在
                    if (labDepartment!=null){
                        //若依托单位存在，则判断实验室是否存在,存在则更新，不存在则插入
                       List<LabInfo>  labInfo1 = labInfoMapper.selectByLabNameAndId(labInfo.getLabname(),labDepartment.getDepartmentseqno());
                        if (labInfo1.size()>0){
                            labInfo.setDepartmentseqno(labDepartment.getDepartmentseqno());
                            labInfo.setOrderbykcw("1");
                            labInfo.setLabseqno(labInfo1.get(0).getLabseqno());
                            labInfoMapper.updateByPrimaryKeySelective(labInfo);

                        }else {
                            labInfo.setOrderbykcw("2");
                            labInfo.setDepartmentseqno(labDepartment.getDepartmentseqno());
                            labInfoMapper.insertAddKey(labInfo);

                        }
                    }else {
                        //若依托单位不存在，则新建依托单位并插入
                        LabDepartment labDepartment1 = new LabDepartment();
                        labDepartment1.setDepartmentname(departmentName);
                        labDepartmentMapper.insertAddKey(labDepartment1);
                        labInfo.setDepartmentseqno(labDepartment1.getDepartmentseqno());
                        labInfo.setOrderbykcw("2");
                        labInfoMapper.insertAddKey(labInfo);

                    }
                }else {
                    //判断以其以其载体名创建的是依托单位是否存在，若不存在则创建
                    LabDepartment labDepartment = labDepartmentMapper.selectByDepartmentName(labInfo.getLabname());
                    if (labDepartment == null){
                        LabDepartment labDepartment2 = new LabDepartment();
                        labDepartment2.setDepartmentname(labInfo.getLabname());
                        labDepartmentMapper.insertAddKey(labDepartment2);
                        labInfo.setDepartmentseqno(labDepartment2.getDepartmentseqno());
                        labInfo.setOrderbykcw("2");
                        labInfoMapper.insertAddKey(labInfo);
                    }else {
						List<LabInfo>  labInfo1 = labInfoMapper.selectByLabNameAndId(labInfo.getLabname(),labDepartment.getDepartmentseqno());
						if (labInfo1.size()>0){
							labInfo.setDepartmentseqno(labDepartment.getDepartmentseqno());
							labInfo.setOrderbykcw("1");
							labInfo.setLabseqno(labInfo1.get(0).getLabseqno());
							labInfoMapper.updateByPrimaryKeySelective(labInfo);

                        }else {
                            labInfo.setOrderbykcw("2");
                            labInfo.setDepartmentseqno(labDepartment.getDepartmentseqno());
                            labInfoMapper.insertAddKey(labInfo);
                        }
                    }
                }
		}

	}
	@Test
	public void test() throws ParseException {

		Map<String,String> idAndName = new Excel2Data("E:\\01_基本信息.xls").getLabName();
		List<LabEquipment> labEquipmentList = new Excel2Data("E:\\02_基础设施条件.xls").CreateLabEquipmentList();
		for (LabEquipment labEquipment: labEquipmentList){
			for (Map.Entry<String, String> entry : idAndName.entrySet()) {
					if (labEquipment.getAttention().equals(entry.getKey())){
						labEquipment.setWhichlab(entry.getValue());
					}
				}
		}
		LabEquipment labEquipment = labEquipmentList.get(2678 );
		System.out.println(labEquipment.toString());
		List<LabEquipment>  labEquipment1 = labEquipmentMapper.selectByName(labEquipment.getChinesename(),labEquipment.getWhichlab(), labEquipment.getRawvalue());
		//根据设备名、实验室名、原值查询设备是否存在，若存在，则更新，若不存在，则插入
		if (labEquipment1.size()>0){
			labEquipment.setLabseqno(labEquipment1.get(0).getLabseqno());
			labEquipment.setEquipseqno(labEquipment1.get(0).getEquipseqno());
			labEquipment.setEquipno(labEquipment1.get(0).getEquipno());
			labEquipmentMapper.updateByPrimaryKeySelective(labEquipment);
		}else {
			//若查询结果为空，则先获取设备实验室编号和设备号后再插入
			List<LabInfo> labInfoList = labInfoMapper.findLabByName(labEquipment.getWhichlab());
			if (labInfoList.size()>0){
				labEquipment.setLabseqno(labInfoList.get(0).getLabseqno());
			}else {
				labEquipment.setLabseqno(labInfoList.get(0).getLabseqno());
			}

			//分配设备号
			Random random = new Random();
			String sRand = "";
			String setno = "";
			for (int i = 0; i < 6; i++) {
				String rand = String.valueOf(random.nextInt(10));
				sRand += rand;
			}
			setno = "010101"+sRand;
			labEquipment.setEquipno(setno);
			//System.out.println(labEquipment.toString());
			//labEquipmentMapper.insertAddKey(labEquipment);
		}


	}
}
