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
//		 * ���Ի�ȡ����ѧ����Ϣ{������ѯ}
//		 */
//		List<Student> stu = DBUtil.getAllStudentInfo();
//		Iterator<Student> it = stu.iterator();
//		while(it.hasNext()) {
//			Student st = it.next();
//			System.out.println(st.getSno() +","+ st.getSname() +","+ st.getDname() +","+ st.getSsex() +","+ st.getCno() +","+ st.getMark() +","+ st.getType());
//		}
		
//		/**
//		 * ���Ը���Sno��ѯѧ����Ϣ{������ѯ}
//		 */
//		String sno = "9701";
//		Student stu = DBUtil.getStudentInfoBySno(sno);
//		System.out.println(stu.getSno() +","+ stu.getSname() +","+ stu.getDname() +","+ stu.getSsex() +","+ stu.getCno() +","+ stu.getMark() +","+ stu.getType());
		
//		/**
//		 * �������ѧ����Ϣ{insertѧ����Ϣ}
//		 */
//		Student stu = new Student("9805", "�˹�", "�������", "��", 8, 85, "����");
//		DBUtil.insertStuInfo(stu);
		
//		/**
//		 * ���Ը���ѧ��snoɾ��ѧ����Ϣ
//		 */
//		String sno = "9805";
//		DBUtil.deleteStuInfo(sno);
		
		/**
		 * �����޸�ѧ����Ϣ
		 */
		Student stu = new Student("9805" ,"������", "�������", "��", 8, 85, "����");
			try {
				DBUtil.modifyStuInfo(stu);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
