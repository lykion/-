package com.lykion.dao;

public class Student {

	private String sno;
	private String sname;
	private String dname;
	private String ssex;
	private int cno;
	private int mark;
	private String type;
	
	public Student() {
		
	}
	
	public Student(String sno, String sname, String dname, String ssex, int cno, int mark, String type) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.dname = dname;
		this.ssex = ssex;
		this.cno = cno;
		this.mark = mark;
		this.type = type;
	}
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
