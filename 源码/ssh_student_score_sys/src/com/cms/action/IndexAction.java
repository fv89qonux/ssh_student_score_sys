package com.cms.action;

import org.apache.log4j.Logger;

import com.cms.entity.Admin;
import com.opensymphony.xwork2.ActionContext;

/**
 * 后台控制类
 * 创建人：   admin'
 * 
 * email：xxxx@qq.com
 * 创建时间：2020-02-22
 */
public class IndexAction extends BaseAction {
	private static final long serialVersionUID = -1263585711814177272L;
	private static Logger logger = Logger.getLogger(IndexAction.class);
	private Admin user;
	private final static String S_ADMIN = "s_admin";
	
	/**
	 * 用户首页
	 * @return
	 */
	public String main(){
		logger.info("-------main-------------");
		if (session.get(S_ADMIN) != null){
			ActionContext.getContext().put("url","web/main.jsp");
		} else {
			ActionContext.getContext().put("url","web/login.jsp");
		}
		return "url";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		logger.info("-------login-------------");
		if (user != null){
			String username = user.getUsername();
			String password = user.getPassword();
			String hql = "From Admin where 1=1";
			hql += " and username = binary('" + username + "')";
			hql += " and password = binary('" + password + "')";
			user = (Admin) baseService.findFirst(hql);
			if (user != null){
				session.put(S_ADMIN, user);
				return "login";
			} else {
				ActionContext.getContext().put("msg","账号或密码错误！");
			}
		}
		return main();
	}
	
	/**
	 *用户退出
	 * @return
	 */
	public String logout(){
		logger.info("-------logout-------------");
		session.clear();
		return main();
	}
	
	/**
	 *用户详情
	 * @return
	 */
	public String info(){
		logger.info("-------info-------------");
		ActionContext.getContext().put("url","web/admin/info.jsp");
		return "url";
	}
	
	/**
	 * 去修改密码页面
	 * @return
	 */
	public String toPsw(){
		logger.info("-------toPsw-------------");
		ActionContext.getContext().put("url","web/admin/psw.jsp");
		return "url";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String updatePsw(){
		logger.info("-------updatePsw-------------");
		Admin aUser = (Admin) session.get(S_ADMIN);
		if (aUser.getPassword().equals(user.getOld())){
			// 旧密码对了，可以更新
			aUser.setPassword(user.getPassword());
			baseService.update(aUser);
			ActionContext.getContext().put("msg","修改成功！");
		} else {
			// 旧密码错误，不能更新
			ActionContext.getContext().put("msg","旧密码错误！");
		}
		ActionContext.getContext().put("url","web/admin/psw.jsp");
		return "url";
	}
	
	/**
	 * 工作台
	 * @return
	 */
	public String workbench(){
		logger.info("-------workbench-------------");
		ActionContext.getContext().put("url","web/workbench.jsp");
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
