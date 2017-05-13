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
	 * 显示学生列表
	 * @param student
	 * @param model
	 * @return
	 */
	@RequestMapping(value="showList.do")
	@ResponseBody
	public String showList(SimTeacher teacher){
		//从数据库中查询与student相似的所有学生
		List<SimTeacher> list=teacherService.showList(teacher);
		return JSON.toJSONString(list);
	}
	
	/**
	 * 删除教师信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteTeacher.do")
	public String deleteTeacher(Integer id,Model model){
		//从数据库中删除id为id的教师
		teacherService.deleteTeacher(id);
		return "redirect:/BackManage/goToTeacherManage.do";
	}
	/**
	 * 跳转到教师编辑页面
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
	 * 更新教师信息
	 * @param addStudent
	 * @param model
	 * @return
	 */
	@RequestMapping("/editTeacher.do")
	public String editTeacher(SimTeacher editTeacher,Model model){
		//更新数据库中的学生信息
		teacherService.editTeacher(editTeacher);
		return "redirect:/BackManage/goToTeacherManage.do";
	}
	
	/**
	 * 跳转到添加教师页面
	 * @return
	 */
	@RequestMapping("/goToAddTeacher.do")
	public String goToAddTeacher(){
		return "/teacherManage/addTeacher";
	}
	
	/**
	 * 添加教师信息到数据库
	 * @param addStudent
	 * @param model
	 * @return
	 */
	@RequestMapping("/addTeacher.do")
	public String addTeacher(SimTeacher addTeacher){
		//添加学生信息
		teacherService.addTeacher(addTeacher);
		return "redirect:/BackManage/goToTeacherManage.do";
	}
}
