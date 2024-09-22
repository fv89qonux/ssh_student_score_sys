package com.cms.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.cms.entity.Student;
import com.opensymphony.xwork2.ActionContext;

/**
 * 学生管理
 * 创建人：   admin'
 * 
 * email：xxxx@qq.com
 * 创建时间：2020-02-23
 */
public class StudentAction extends BaseAction{
	private static final long serialVersionUID = -1434032971101089077L;
	private static Logger logger = Logger.getLogger(StudentAction.class);
	private Student student;
	
	/**
	 * toList
	 * @return
	 */
	public String toList(){
		logger.info("-------toList-------------");
		String hql = " from Classs";
		session.put("s_class", baseService.findList(hql));
		return list();
	}
	/**
	 * list
	 * @return
	 */
	public String list(){
		logger.info("-------list-------------");
		String hql = " from Student where 1=1";
		if (student != null){
			int cid = student.getCid();
			if (cid > 0){
				hql += " and cid =" + cid;
			}
			String name = student.getName();
			if (!StringUtils.isEmpty(name)){
				hql += " and name like '%" + name + "%'";
			}
			String num = student.getNum();
			if (!StringUtils.isEmpty(num)){
				hql += " and num like '%" + num + "%'";
			}
			int sex = student.getSex();
			if (sex > 0){
				hql += " and sex =" + sex;
			}
		} else {
			student = new Student();
		}
		ActionContext.getContext().put("entity", student);
		ActionContext.getContext().put("pager", baseService.find(hql));
		ActionContext.getContext().put("url","web/student/list.jsp");
		return "url";
	}
	
	/**
	 * 
	 * 去添加页面
	 * @return
	 */
	public String toAdd(){
		logger.info("-------toAdd-------------");
		ActionContext.getContext().put("url","web/student/add.jsp");
		return "url";
	}
	
	/**
	 *	添加
	 * @return
	 */
	public String add(){
		logger.info("-------add-------------");
		baseService.save(student);
		ActionContext.getContext().put("msg","添加成功！");
		ActionContext.getContext().put("url","web/student/add.jsp");
		return "url";
	}
	
	/** 
	 *	删除
	 * @return
	 */
	public String delete(){
		logger.info("-------delete-------------");
		baseService.delete(student);
		ActionContext.getContext().put("msg", "删除成功！");
		ActionContext.getContext().put("url","web/common/msg.jsp");
		return "url";
	}
	
	/** 
	 *	去修改页面
	 * @return
	 */
	public String toUpdate(){
		logger.info("-------toUpdate-------------");
		ActionContext.getContext().put("entity",baseService.getById(Student.class,student.getId()));
		ActionContext.getContext().put("url","web/student/fetch.jsp");
		return "url";
	}
	
	/**
	 *	修改  
	 * @return
	 */
	public String update(){
		logger.info("-------update-------------");
		Student entity = (Student) baseService.getById(Student.class,student.getId());
		entity.setCid(student.getCid());
		entity.setName(student.getName());
		entity.setNum(student.getNum());
		entity.setSex(student.getSex());
		baseService.update(entity);
		ActionContext.getContext().put("entity",entity);
		ActionContext.getContext().put("msg", "修改成功！");
		ActionContext.getContext().put("url","web/student/fetch.jsp");
		return "url";
	}

	// get set -----------------------TODO--------------------------------
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
