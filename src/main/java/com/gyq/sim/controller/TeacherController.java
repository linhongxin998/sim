package com.gyq.sim.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gyq.sim.entity.SimStudent;
import com.gyq.sim.entity.SimTeacher;
import com.gyq.sim.service.StudentService;
import com.gyq.sim.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * ��ʾѧ���б�
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value="showList.do")
	@ResponseBody
	public String showList(SimTeacher teacher){
		//�����ݿ��в�ѯ��student���Ƶ�����ѧ��
		List<SimTeacher> list=teacherService.showList(teacher);
		return JSON.toJSONString(list);
	}
	
	/**
	 * ɾ����ʦ��Ϣ
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteTeacher.do")
	public String deleteTeacher(Integer id,Model model){
		//�����ݿ���ɾ��idΪid�Ľ�ʦ
		teacherService.deleteTeacher(id);
		return "redirect:/BackManage/goToTeacherManage.do";
	}
	/**
	 * ��ת����ʦ�༭ҳ��
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/goToeditTeacher.do")
	public String goToeditTeacher(Integer id,Model model){
		SimTeacher teacher =new SimTeacher();
		teacher.setId(id);
		List<SimTeacher> teachers=new ArrayList<SimTeacher>();
		teachers=teacherService.showList(teacher);
		if (teachers.size()>0) {
			model.addAttribute("SimTeacher", teachers.get(0));
		}
		return "/teacherManage/editTeacher";
	}
	
	/**
	 * ���½�ʦ��Ϣ
	 * @param addStudent
	 * @param model
	 * @return
	 */
	@RequestMapping("/editTeacher.do")
	public String editTeacher(SimTeacher editTeacher,Model model){
		//�������ݿ��е�ѧ����Ϣ
		teacherService.editTeacher(editTeacher);
		return "redirect:/BackManage/goToTeacherManage.do";
	}
	
	/**
	 * ��ת����ӽ�ʦҳ��
	 * @return
	 */
	@RequestMapping("/goToAddTeacher.do")
	public String goToAddTeacher(){
		return "/teacherManage/addTeacher";
	}
	
	/**
	 * ��ӽ�ʦ��Ϣ�����ݿ�
	 * @param addStudent
	 * @param model
	 * @return
	 */
	@RequestMapping("/addTeacher.do")
	public String addTeacher(SimTeacher addTeacher){
		//���ѧ����Ϣ
		teacherService.addTeacher(addTeacher);
		return "redirect:/BackManage/goToTeacherManage.do";
	}
}
