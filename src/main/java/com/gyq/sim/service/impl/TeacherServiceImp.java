package com.gyq.sim.service.impl;

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
	 * ��ѯ��ʦ�б�
	 */
	@Override
	public List<SimTeacher> showList(SimTeacher teacher) {
		List<SimTeacher> teachers=new ArrayList<SimTeacher>();
		teachers =teacherDao.getTeacherList(teacher);
		return teachers;
	}

	/**
	 * ��ӽ�ʦ��Ϣ
	 */
	@Override
	public void addTeacher(SimTeacher addTeacher) {
		teacherDao.addTeacher(addTeacher);
	}

	/**
	 * ɾ����ʦ��Ϣ
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
