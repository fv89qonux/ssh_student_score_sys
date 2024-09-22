package com.cms.action;

import org.apache.log4j.Logger;

import com.cms.entity.Course;
import com.cms.entity.Student;
import com.opensymphony.xwork2.ActionContext;

/**
 * 成绩管理
 * 创建人：   admin'
 * 
 * email：xxxx@qq.com
 * 创建时间：2020-02-29
 */
public class CourseAction extends BaseAction{
	private static final long serialVersionUID = -1434032971101089077L;
	private static Logger logger = Logger.getLogger(CourseAction.class);
	private Course course;
	
	/**
	 * toList
	 * @return
	 */
	public String toList(){
		logger.info("-------toList-------------");
		session.put("s_student", course.getSid());
		session.put("student", baseService.getById(Student.class, course.getSid()));
		return list();
	}
	/**
	 * list
	 * @return
	 */
	public String list(){
		logger.info("-------list-------------");
		int sid = (Integer) session.get("s_student");
		String hql = " from Course where sid = " + sid;
		ActionContext.getContext().put("entitys", baseService.findList(hql));
		ActionContext.getContext().put("url","web/course/list.jsp");
		return "url";
	}
	
	/**
	 * 
	 * 去添加页面
	 * @return
	 */
	public String toAdd(){
		logger.info("-------toAdd-------------");
		ActionContext.getContext().put("url","web/course/add.jsp");
		return "url";
	}
	
	/**
	 *	添加
	 * @return
	 */
	public String add(){
		logger.info("-------add-------------");
		int sid = (Integer) session.get("s_student");
		course.setSid(sid);
		baseService.save(course);
		ActionContext.getContext().put("msg","添加成功！");
		ActionContext.getContext().put("url","web/course/add.jsp");
		return "url";
	}
	
	/** 
	 *	删除
	 * @return
	 */
	public String delete(){
		logger.info("-------delete-------------");
		baseService.delete(course);
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
		ActionContext.getContext().put("entity",baseService.getById(Course.class,course.getId()));
		ActionContext.getContext().put("url","web/course/fetch.jsp");
		return "url";
	}
	
	/**
	 *	修改  
	 * @return
	 */
	public String update(){
		logger.info("-------update-------------");
		Course entity = (Course) baseService.getById(Course.class,course.getId());
		entity.setNum1(course.getNum1());
		entity.setNum2(course.getNum2());
		entity.setNum3(course.getNum3());
		entity.setNum4(course.getNum4());
		entity.setNum5(course.getNum5());
		entity.setContent(course.getContent());
		baseService.update(entity);
		ActionContext.getContext().put("entity",entity);
		ActionContext.getContext().put("msg", "修改成功！");
		ActionContext.getContext().put("url","web/course/fetch.jsp");
		return "url";
	}
	// get set -----------------------TODO--------------------------------
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}
