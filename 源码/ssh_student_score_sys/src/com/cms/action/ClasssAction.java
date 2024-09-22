package com.cms.action;

import org.apache.log4j.Logger;

import com.cms.entity.Classs;
import com.opensymphony.xwork2.ActionContext;

/**
 * 班级管理
 * 创建人：   admin'
 * 
 * email：xxxx@qq.com
 * 创建时间：2020-02-23
 */
public class ClasssAction extends BaseAction{
	private static final long serialVersionUID = -1434032971101089077L;
	private static Logger logger = Logger.getLogger(ClasssAction.class);
	private Classs classs;
	
	/**
	 * list
	 * @return
	 */
	public String list(){
		logger.info("-------list-------------");
		String hql = " from Classs";
		ActionContext.getContext().put("entitys", baseService.findList(hql));
		ActionContext.getContext().put("url","web/classs/list.jsp");
		return "url";
	}
	
	/**
	 * 
	 * 去添加页面
	 * @return
	 */
	public String toAdd(){
		logger.info("-------toAdd-------------");
		ActionContext.getContext().put("url","web/classs/add.jsp");
		return "url";
	}
	
	/**
	 *	添加
	 * @return
	 */
	public String add(){
		logger.info("-------add-------------");
		baseService.save(classs);
		ActionContext.getContext().put("msg","添加成功！");
		ActionContext.getContext().put("url","web/classs/add.jsp");
		return "url";
	}
	
	/** 
	 *	删除
	 * @return
	 */
	public String delete(){
		logger.info("-------delete-------------");
		
		String hql = "select count(*) from Student where cid = " + classs.getId();
		long count = baseService.findCount(hql);
		String msg = null;
		if (count > 0){
			msg = "对不起，班级下面有学生，不能删除！";
		} else {
			baseService.delete(classs);
			msg = "删除成功！";
		}
		ActionContext.getContext().put("msg", msg);
		ActionContext.getContext().put("url","web/common/msg.jsp");
		return "url";
	}
	
	/** 
	 *	去修改页面
	 * @return
	 */
	public String toUpdate(){
		logger.info("-------toUpdate-------------");
		ActionContext.getContext().put("entity", baseService.getById(Classs.class,classs.getId()));
		ActionContext.getContext().put("url","web/classs/fetch.jsp");
		return "url";
	}
	
	/**
	 *	修改  
	 * @return
	 */
	public String update(){
		logger.info("-------update-------------");
		Classs entity = (Classs) baseService.getById(Classs.class,classs.getId());
		entity.setName(classs.getName());
		baseService.update(entity);
		ActionContext.getContext().put("entity",classs);
		ActionContext.getContext().put("msg","修改成功！");
		ActionContext.getContext().put("url","web/classs/fetch.jsp");
		return "url";
	}
	// get set -----------------------TODO--------------------------------
	public Classs getClasss() {
		return classs;
	}

	public void setClasss(Classs classs) {
		this.classs = classs;
	}
}
