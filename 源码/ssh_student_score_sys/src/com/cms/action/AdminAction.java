package com.cms.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cms.entity.Admin;
import com.opensymphony.xwork2.ActionContext;

/**
 * 管理员管理
 * 创建人：   admin'
 * 
 * email：xxxx@qq.com
 * 创建时间：2020-02-23
 */
public class AdminAction extends BaseAction{
	private static final long serialVersionUID = -1434032971101089077L;
	private static Logger logger = Logger.getLogger(AdminAction.class);
	private Admin user;
	
	/**
	 * list
	 * @return
	 */
	public String list(){
		logger.info("-------list-------------");
		String hql = " from Admin where 1=1";
		if (user != null){
			String username = user.getUsername();
			if (!StringUtils.isEmpty(username)){
				hql += " and username like '%" + username + "%'";
			}
		}
		hql += " and username != 'admin'";
		ActionContext.getContext().put("entity", user);
		ActionContext.getContext().put("pager", baseService.find(hql));
		ActionContext.getContext().put("url","web/admin/list.jsp");
		return "url";
	}
	
	/**
	 * 
	 * 去添加页面
	 * @return
	 */
	public String toAdd(){
		logger.info("-------toAdd-------------");
		ActionContext.getContext().put("url","web/admin/add.jsp");
		return "url";
	}
	
	/**
	 *	添加
	 * @return
	 */
	public String add(){
		logger.info("-------add-------------");
		String msg = null;
		if (checkUser(user.getUsername())){
			// 可以注册
			baseService.save(user);
			msg = "添加成功！";
		} else {
			msg = "用户名已存在";
		}
		ActionContext.getContext().put("msg",msg);
		ActionContext.getContext().put("url","web/admin/add.jsp");
		return "url";
	}
	
	/**
	 * 检查用户名是否存在
	 * @param username
	 * @return
	 */
	private boolean checkUser(String username){
		String sql = "select count(*) from Admin where 1=1 and username = '" + username + "'";
		Long i = (Long) baseService.findFirst(sql);
		// 0 为可以注册
		return i == 0;
	}
	
	/** 
	 *	删除
	 * @return
	 */
	public String delete(){
		logger.info("-------delete-------------");
		return _delete(user);
	}
	
	/** 
	 *	去修改页面
	 * @return
	 */
	public String toUpdate(){
		logger.info("-------toUpdate-------------");
		ActionContext.getContext().put("entity", baseService.getById(Admin.class,user.getId()));
		ActionContext.getContext().put("url","web/admin/fetch.jsp");
		return "url";
	}
	
	/**
	 *	修改  
	 * @return
	 */
	public String update(){
		logger.info("-------update-------------");
		String msg = null;
		if (user.getOld().equals(user.getUsername()) || checkUser(user.getUsername())){
			// 可以注册
			baseService.update(user);
			msg = "修改成功！";
		} else {
			msg = "用户名已存在";
		}
		ActionContext.getContext().put("entity",user);
		ActionContext.getContext().put("msg",msg);
		ActionContext.getContext().put("url","web/admin/fetch.jsp");
		return "url";
	}

	// get set -----------------------TODO--------------------------------
	public Admin getUser() {
		return user;
	}
	public void setUser(Admin user) {
		this.user = user;
	}
}
