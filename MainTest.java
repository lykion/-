package com.lykion.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		Connection conn = DBConn.getConnection();
		System.out.println("conn:"+conn);
		
//		/**
//		 * 测试获取所有学生信息{多条查询}
//		 */
//		List<Student> stu = DBUtil.getAllStudentInfo();
//		Iterator<Student> it = stu.iterator();
//		while(it.hasNext()) {
//			Student st = it.next();
//			System.out.println(st.getSno() +","+ st.getSname() +","+ st.getDname() +","+ st.getSsex() +","+ st.getCno() +","+ st.getMark() +","+ st.getType());
//		}
		
//		/**
//		 * 测试根据Sno查询学生信息{单条查询}
//		 */
//		String sno = "9701";
//		Student stu = DBUtil.getStudentInfoBySno(sno);
//		System.out.println(stu.getSno() +","+ stu.getSname() +","+ stu.getDname() +","+ stu.getSsex() +","+ stu.getCno() +","+ stu.getMark() +","+ stu.getType());
		
//		/**
//		 * 测试添加学生信息{insert学生信息}
//		 */
//		Student stu = new Student("9805", "邓光", "工程造价", "男", 8, 85, "必修");
//		DBUtil.insertStuInfo(stu);
		
//		/**
//		 * 测试根据学号sno删除学生信息
//		 */
//		String sno = "9805";
//		DBUtil.deleteStuInfo(sno);
		
		/**
		 * 测试修改学生信息
		 */
		Student stu = new Student("9805" ,"董存瑞", "工程造价", "男", 8, 85, "必修");
			try {
				DBUtil.modifyStuInfo(stu);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
