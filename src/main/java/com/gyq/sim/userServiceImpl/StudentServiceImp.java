package com.gyq.sim.userServiceImpl;

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
	 * 从数据库中查询与student相似的所有学生
	 */
	@Override
	public List<SimStudent> showList(SimStudent student) {
		List<SimStudent> students=new ArrayList<SimStudent>();
		students =studentDao.getStudentList(student);
		return students;
	}

	/**
	 * 从数据库中删除id为id的学生
	 */
	@Override
	public void deleteStudent(Integer id) {
		SimStudent student=new SimStudent();
		student.setId(id);
		studentDao.deleteStudent(student);
	}

	
	/**
	 * 从数据库中编辑学生信息
	 */
	@Override
	public void editStudent(SimStudent student) {
		studentDao.editStudent(student);
	}

	/**
	 * 向数据库中添加学生
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
