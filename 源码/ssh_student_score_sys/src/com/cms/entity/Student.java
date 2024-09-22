package com.cms.entity;

import java.io.Serializable;
/**
 * 学生管理
 * 创建人：   admin'
 * 
 * email：xxxx@qq.com
 * 创建时间：2020-02-23
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 252841811851125164L;
	private int id; // 主键
	private int cid; // 班级id
	private String name; // 姓名
	private String num; // 学号
	private int sex; // 性别
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
}