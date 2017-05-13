package com.gyq.sim.userServiceImpl;

import com.gyq.sim.dao.TeacherDao;
import com.gyq.sim.entity.SimStudent;
import com.gyq.sim.entity.SimTeacher;
import com.gyq.sim.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImp implements TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;

	/**
	 * 查询教师列表
	 */
	@Override
	public List<SimTeacher> showList(SimTeacher teacher) {
		List<SimTeacher> teachers=new ArrayList<SimTeacher>();
		teachers =teacherDao.getTeacherList(teacher);
		return teachers;
	}

	/**
	 * 添加教师信息
	 */
	@Override
	public void addTeacher(SimTeacher addTeacher) {
		teacherDao.addTeacher(addTeacher);
	}

	/**
	 * 删除教师信息
	 */
	@Override
	public void deleteTeacher(Integer id) {
		SimTeacher simTeacher=new SimTeacher();
		simTeacher.setId(id);
		teacherDao.deleteTeacher(simTeacher);
	}

	@Override
	public void editTeacher(SimTeacher editTeacher) {
		teacherDao.editTeacher(editTeacher);
	}
	
}
