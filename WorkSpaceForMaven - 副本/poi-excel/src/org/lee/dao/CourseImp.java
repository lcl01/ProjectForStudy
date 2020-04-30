package org.lee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.lee.model.Course;
import org.lee.util.DBUtil;

public class CourseImp{

	private static final String sql_findById = " SELECT * FROM courses WHERE id = ?";
	private static final String sql_save = " INSERT INTO courses(id,dept,course,credit,book_num,publish_date,book_name) VALUES(?,?,?,?,?,?,?)";
	
	public boolean Exist(Integer id) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		boolean exist = false;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql_findById);
			prep.setInt(1, id);
			rs  = prep.executeQuery();

			 if(rs.next() == true){
				
				exist = true;
			 }else{
				 exist = false;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.release( prep, conn);
		}
		return exist;
	}
	
	public Integer save(Course course) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
        int i = 0;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement(sql_save);
			prep.setInt(1, course.getId());
			prep.setString(2, course.getDept());
			prep.setString(3, course.getCourse());
			prep.setDouble(4, course.getCredit());
			prep.setString(5, course.getBook_num());
			prep.setString(6, String.valueOf(course.getPublish_date()));
			prep.setString(7, course.getBook_name());
			i  = prep.executeUpdate();

			 if(i>0){
				System.out.println("1 row affected...");
			 }else if(i==0){
				 System.out.println("insert failed...");
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.release( prep, conn);
		}
		return i;
	}

}
