package com.gyq.sim.dao;

import java.util.List;

import com.gyq.sim.entity.SimStudent;

/**
 * student dao²ã
 * @author qiqiangvae
 *
 */
public interface StudentDao {

	List<SimStudent> getStudentList(SimStudent student);

	void deleteStudent(SimStudent student);

	void editStudent(SimStudent student);

	void addStudent(SimStudent addStudent);

}
