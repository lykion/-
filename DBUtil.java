package com.lykion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

	/**
	 * 查询所有学生信息{多条查询}
	 * @return
	 */
	public static List<Student> getAllStudentInfo(){
		Connection conn = null;
		PreparedStatement ps = null;
//		Statement stmt;
		ResultSet rs = null;
		
		List<Student> stu = new ArrayList<Student>();
		
		try {
			conn = DBConn.getConnection();
			String sql = "SELECT * FROM student01";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String dname = rs.getString("dname");
				String ssex = rs.getString("ssex");
				int cno = rs.getInt("cno");
				int mark = rs.getInt("mark");
				String type = rs.getString("type");
				Student st = new Student(sno, sname, dname, ssex, cno, mark, type);
				stu.add(st);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return stu;
	}
	
	/**
	 * 通过学号Sno查询{单条查询}
	 * @param sno
	 * @return
	 */
	public static Student getStudentInfoBySno(String sno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = DBConn.getConnection();
			String sql = "SELECT * FROM student01 WHERE sno=?";
			ps = conn.prepareStatement(sql);
			ps.setNString(1, sno);
			rs = ps.executeQuery();
			while(rs.next()) {
				String sno1 = rs.getString("sno");
				String sname = rs.getString("sname");
				String dname = rs.getString("dname");
				String ssex = rs.getString("ssex");
				int cno = rs.getInt("cno");
				int mark = rs.getInt("mark");
				String type = rs.getString("type");
				stu = new Student(sno1, sname, dname, ssex, cno, mark, type);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!= null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return stu;
	}
	
	/**
	 * 增加学生信息{插入学生信息}
	 * @param stu
	 */
	public static void insertStuInfo(Student stu) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			String sql = "INSERT INTO student01 (sno,sname,dname,ssex,cno,mark,type) VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getSno());
			ps.setString(2, stu.getSname());
			ps.setString(3, stu.getDname());
			ps.setString(4, stu.getSsex());
			ps.setInt(5, stu.getCno());
			ps.setInt(6, stu.getMark());
			ps.setString(7, stu.getType());
			int insertCount = ps.executeUpdate();
			System.out.println(isSuccess(insertCount));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 根据Sno删除学生信息
	 * @param sno
	 */
	public static void deleteStuInfo(String sno) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			String sql = "DELETE FROM student01 WHERE sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			int deleteCount = ps.executeUpdate();
			System.out.println(isSuccess(deleteCount));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 修改学生信息
	 * @param stu
	 * @throws SQLException
	 */
	public static void modifyStuInfo(Student stu) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			String sql = "UPDATE student01 SET sname=?, dname=? ssex=?, cno=?, mark=?, type=? WHERE sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(2, stu.getSname());
			ps.setString(3, stu.getDname());
			ps.setString(4, stu.getSsex());
			ps.setInt(5, stu.getCno());
			ps.setInt(6, stu.getMark());
			ps.setString(7, stu.getType());
			int count = ps.executeUpdate();
			System.out.println(isSuccess(count));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
	/**
	 * 判断操作是否成功
	 * @param count
	 * @return
	 */
	public static String isSuccess(int count) {
		if(count > 0) {
			return "操作成功！";
		}else {
			return "操作失败";
		}
	}
}
