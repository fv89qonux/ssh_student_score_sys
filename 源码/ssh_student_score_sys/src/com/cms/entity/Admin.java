package com.cms.entity;

import java.io.Serializable;
/**
 * 管理员
 * 创建人：   admin'
 * 
 * email：xxxx@qq.com
 * 创建时间：2020-02-23
 */
public class Admin implements Serializable {

	private static final long serialVersionUID = 252841811851125164L;
	private int id; // 主键
	private String username; // 用户名
	private String password; // 密码
	private String old; // 旧密码
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
}