package com.gyq.sim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/BackManage")
public class BackManageController {
	
	/**
	 * 跳转到学生管理页面
	 * @return
	 */
	@RequestMapping("/goToStudentManage.do")
	public String goToStudentManage(){
		return "/studentManage/showStudentList";
	}
	/**
	 * 跳转到教师管理页面
	 * @return
	 */
	@RequestMapping("/goToTeacherManage.do")
	public String goToTeacherManage(){
		return "/teacherManage/showTeacherList";
	}
	/**
	 * 跳转到留言区管理页面
	 * @return
	 */
	@RequestMapping("/goToLeaveWordManage.do")
	public String goToLeaveWordManage(){
		return "/leaveWordManage/showLeaveWordList";
	}
	
	/**
	 * 跳转到后台管理页面
	 * @return
	 */
	@RequestMapping("/goTobackManage.do")
	public String goTobackManage(){
		return "/backManage/backManage";
	}
}
