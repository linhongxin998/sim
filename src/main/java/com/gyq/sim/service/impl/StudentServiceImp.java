package com.gyq.sim.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyq.sim.dao.StudentDao;
import com.gyq.sim.entity.SimStudent;
import com.gyq.sim.service.StudentService;

@Service
public class StudentServiceImp  implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	/**
	 * �����ݿ��в�ѯ��student���Ƶ�����ѧ��
	 */
	@Override
	public List<SimStudent> showList(SimStudent student) {
		List<SimStudent> students=new ArrayList<SimStudent>();
		students =studentDao.getStudentList(student);
		return students;
	}

	/**
	 * �����ݿ���ɾ��idΪid��ѧ��
	 */
	@Override
	public void deleteStudent(Integer id) {
		SimStudent student=new SimStudent();
		student.setId(id);
		studentDao.deleteStudent(student);
	}

	
	/**
	 * �����ݿ��б༭ѧ����Ϣ
	 */
	@Override
	public void editStudent(SimStudent student) {
		studentDao.editStudent(student);
	}

	/**
	 * �����ݿ������ѧ��
	 */
	@Override
	public void addStudent(SimStudent addStudent) {
		SimStudent student=new SimStudent();
		student.setUsername(addStudent.getUsername());
		List<SimStudent> students=new ArrayList<SimStudent>();
		students =studentDao.getStudentList(student);
		if (students.size()==0) {
			studentDao.addStudent(addStudent);
		}	
	}

}
