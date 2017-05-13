package com.gyq.sim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/BackManage")
public class BackManageController {
	
	/**
	 * ��ת��ѧ������ҳ��
	 * @return
	 */
	@RequestMapping("/goToStudentManage.do")
	public String goToStudentManage(){
		return "/studentManage/showStudentList";
	}
	/**
	 * ��ת����ʦ����ҳ��
	 * @return
	 */
	@RequestMapping("/goToTeacherManage.do")
	public String goToTeacherManage(){
		return "/teacherManage/showTeacherList";
	}
	/**
	 * ��ת������������ҳ��
	 * @return
	 */
	@RequestMapping("/goToLeaveWordManage.do")
	public String goToLeaveWordManage(){
		return "/leaveWordManage/showLeaveWordList";
	}
	
	/**
	 * ��ת����̨����ҳ��
	 * @return
	 */
	@RequestMapping("/goTobackManage.do")
	public String goTobackManage(){
		return "/backManage/backManage";
	}
}
