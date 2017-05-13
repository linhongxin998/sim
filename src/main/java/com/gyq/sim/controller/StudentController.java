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
	 * 显示学生列表
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value="showList.do")
	@ResponseBody
	public String showList(SimStudent student){
		//从数据库中查询与student相似的所有学生
		List<SimStudent> list=studentService.showList(student);
		return JSON.toJSONString(list);
	}
	
	/**
	 * 删除学生
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteStudent.do")
	public String deleteStudent(Integer id,Model model){
		//从数据库中删除id为id的学生
		studentService.deleteStudent(id);
		return "redirect:/BackManage//goToStudentManage.do";
	}
	/**
	 * 跳转到学生编辑页面
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
	 * 更新学生信息
	 * @param addStudent
	 * @param model
	 * @return
	 */
	@RequestMapping("/editStudent.do")
	public String editStudent(SimStudent editStudent,Model model){
		//更新数据库中的学生信息
		studentService.editStudent(editStudent);
		return "redirect:/BackManage/goToStudentManage.do";
	}
	
	/**
	 * 跳转到添加学生页面
	 * @return
	 */
	@RequestMapping("/goToAddStudent.do")
	public String goToAddStudent(){
		return "/studentManage/addStudent";
	}
	
	/**
	 * 添加学生信息到数据库
	 * @param addStudent
	 * @param model
	 * @return
	 */
	@RequestMapping("/addStudent.do")
	public String addStudent(SimStudent addStudent,Model model){
		//添加学生信息
		studentService.addStudent(addStudent);
		return "redirect:/BackManage/goToStudentManage.do";
	}
}
