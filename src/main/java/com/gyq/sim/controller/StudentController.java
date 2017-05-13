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
import com.gyq.sim.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * ��ʾѧ���б�
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value="showList.do")
	@ResponseBody
	public String showList(SimStudent student){
		//�����ݿ��в�ѯ��student���Ƶ�����ѧ��
		List<SimStudent> list=studentService.showList(student);
		return JSON.toJSONString(list);
	}
	
	/**
	 * ɾ��ѧ��
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteStudent.do")
	public String deleteStudent(Integer id,Model model){
		//�����ݿ���ɾ��idΪid��ѧ��
		studentService.deleteStudent(id);
		return "redirect:/BackManage//goToStudentManage.do";
	}
	/**
	 * ��ת��ѧ���༭ҳ��
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/goToeditStudent.do")
	public String goToeditStudent(Integer id,Model model){
		SimStudent student =new SimStudent();
		student.setId(id);
		List<SimStudent> students=new ArrayList<SimStudent>();
		students=studentService.showList(student);
		if (students.size()>0) {
			model.addAttribute("SimStudent", students.get(0));
		}
		return "/studentManage/editStudent";
	}
	
	/**
	 * ����ѧ����Ϣ
	 * @param addStudent
	 * @param model
	 * @return
	 */
	@RequestMapping("/editStudent.do")
	public String editStudent(SimStudent editStudent,Model model){
		//�������ݿ��е�ѧ����Ϣ
		studentService.editStudent(editStudent);
		return "redirect:/BackManage/goToStudentManage.do";
	}
	
	/**
	 * ��ת�����ѧ��ҳ��
	 * @return
	 */
	@RequestMapping("/goToAddStudent.do")
	public String goToAddStudent(){
		return "/studentManage/addStudent";
	}
	
	/**
	 * ���ѧ����Ϣ�����ݿ�
	 * @param addStudent
	 * @param model
	 * @return
	 */
	@RequestMapping("/addStudent.do")
	public String addStudent(SimStudent addStudent,Model model){
		//���ѧ����Ϣ
		studentService.addStudent(addStudent);
		return "redirect:/BackManage/goToStudentManage.do";
	}
}
