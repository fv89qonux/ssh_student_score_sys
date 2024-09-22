package com.cms.entity;

/**
 * 课程
 * 创建人：   admin'
 * 
 * email：xxxx@qq.com
 * 创建时间：2020-02-28
 */
public class Course {

	private int id;// 主键
	private int sid;// 学生ID
	private int num1;// 数学
	private int num2;// 语文
	private int num3;// 英语
	private int num4;// 物理
	private int num5;// 化学
	private String content;// 说明
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getNum3() {
		return num3;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	public int getNum4() {
		return num4;
	}
	public void setNum4(int num4) {
		this.num4 = num4;
	}
	public int getNum5() {
		return num5;
	}
	public void setNum5(int num5) {
		this.num5 = num5;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}